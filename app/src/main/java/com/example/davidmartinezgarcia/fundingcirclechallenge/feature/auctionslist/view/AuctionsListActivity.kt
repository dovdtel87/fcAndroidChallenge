package com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import com.example.davidmartinezgarcia.fundingcirclechallenge.R
import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.AuctionsListContract
import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.adapter.AuctionsListAdapter
import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.presenter.AuctionsListPresenter
import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.repository.AuctionsListRepository
import com.example.davidmartinezgarcia.fundingcirclechallenge.model.Auction
import com.example.davidmartinezgarcia.fundingcirclechallenge.service.GsonFactory
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class AuctionsListActivity : AppCompatActivity(), AuctionsListContract.View, AuctionsListAdapter.AuctionClickListener {

    companion object {
        const val STATE_AUCTIONS = "state.auctions.list"
    }

    private lateinit var mPresenter: AuctionsListContract.Presenter
    private lateinit var mProgressBar: ProgressBar
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAuctions: List<Auction>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        mRecyclerView = recycler_view
        mProgressBar = progress_bar

        //mPresenter = AuctionsListPresenter(this, AuctionsListRepository())

        if (savedInstanceState?.getString(STATE_AUCTIONS) != null) {
            mAuctions = GsonFactory.getInstance().fromJson(savedInstanceState.getString(STATE_AUCTIONS), object : TypeToken<ArrayList<Auction>>() {}.type)
        }

        if (this::mAuctions.isInitialized) {
            showAuctions(mAuctions)
        } else {
            initNetworkCalls()
        }
    }

    private fun initNetworkCalls() {
        mPresenter.retrieveAuctions()
    }

    override fun showProgress() {
        mProgressBar.visibility = VISIBLE
    }

    override fun hideProgress() {
        mProgressBar.visibility = GONE
    }

    override fun showAuctions(auctions: List<Auction>) {
        mAuctions = auctions
        val adapter = AuctionsListAdapter(this, this)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = adapter
        adapter.setAuctions(auctions)
    }

    override fun onAuctionClicked(auction: Auction) {
       mPresenter.decideAuctionDetailToOpen(auction)
    }

    override fun onApiError(exception: Throwable) {
        hideProgress()
        val errorText = error_text
        errorText.text = getString(R.string.api_error)
        mRecyclerView.visibility = GONE
        errorText.visibility = VISIBLE
    }

    override fun openAuctionDetails(auction : Auction) {
        Log.d("LOG AuctionListActivity", "Detail Normal")
        val dialogFragment = EraDialogFragment.newInstance(auction.title, auction.rate, auction.riskBand)
        dialogFragment.show(supportFragmentManager, "Dialog")
    }

    override fun openAuctionDetailsRiskBandA(auction : Auction) {
        Log.d("LOG AuctionListActivity", "Detail RiskBand A")
        val dialogFragment = EraDialogFragment.newInstance(auction.title, auction.rate, auction.riskBand)
        dialogFragment.show(supportFragmentManager, "Dialog")
    }

    override fun openAuctionDetailsRiskBandB(auction : Auction) {
        Log.d("LOG AuctionListActivity", "Detail RiskBand B")
        val dialogFragment = EraDialogFragment.newInstance(auction.title, auction.rate, auction.riskBand)
        dialogFragment.show(supportFragmentManager, "Dialog")
    }

    override fun openAuctionDetailsRiskBandC(auction : Auction) {
        Log.d("LOG AuctionListActivity", "Detail RiskBand C")
        val dialogFragment = EraDialogFragment.newInstance(auction.title, auction.rate, auction.riskBand)
        dialogFragment.show(supportFragmentManager, "Dialog")
    }

    override fun openAuctionDetailsRiskBandD(auction : Auction) {
        Log.d("LOG AuctionListActivity", "Detail RiskBand D")
        val dialogFragment = EraDialogFragment.newInstance(auction.title, auction.rate, auction.riskBand)
        dialogFragment.show(supportFragmentManager, "Dialog")
    }

    override fun openAuctionDetailsRiskBandE(auction : Auction) {
        Log.d("LOG AuctionListActivity", "Detail RiskBand E")
        val dialogFragment = EraDialogFragment.newInstance(auction.title, auction.rate, auction.riskBand)
        dialogFragment.show(supportFragmentManager, "Dialog")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (this::mAuctions.isInitialized) {
            outState.putString(STATE_AUCTIONS, GsonFactory.getInstance().toJson(mAuctions))
        }
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        mPresenter.onViewDestroyed()
        super.onDestroy()
    }
}
