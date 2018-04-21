package com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
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
import kotlinx.android.synthetic.main.content_main.*

class AuctionsListActivity : AppCompatActivity(), AuctionsListContract.View, AuctionsListAdapter.AuctionClickListener {

    companion object {
        const val STATE_AUCTIONS = "state.auctions.list"
    }

    private lateinit var mPresenter: AuctionsListContract.Presenter
    private lateinit var mProgressBar: ProgressBar
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        mRecyclerView = recycler_view
        mProgressBar = progress_bar

        mPresenter = AuctionsListPresenter(this, AuctionsListRepository())

        initNetworkCalls()
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
        val adapter = AuctionsListAdapter(this, this)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = adapter
        adapter.setAuctions(auctions)
    }

    override fun onAuctionClicked(auction: Auction) {

    }

    override fun onApiError(exception: Throwable) {
    }

    override fun onDestroy() {
        mPresenter.onViewDestroyed()
        super.onDestroy()
    }
}
