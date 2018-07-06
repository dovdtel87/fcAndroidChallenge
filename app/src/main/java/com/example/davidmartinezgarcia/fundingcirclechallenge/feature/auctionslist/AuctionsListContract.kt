package com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist

import com.example.davidmartinezgarcia.fundingcirclechallenge.model.Auction


/**
 * Created by david.martinezgarcia on 21/04/2018.
 */
interface AuctionsListContract {
    interface View : com.example.davidmartinezgarcia.fundingcirclechallenge.feature.common.view.View {
        fun showAuctions(value: List<Auction>)
        fun showProgress()
        fun hideProgress()
        fun openAuctionDetailsRiskBandA(auction : Auction)
        fun openAuctionDetailsRiskBandB(auction : Auction)
        fun openAuctionDetailsRiskBandC(auction : Auction)
        fun openAuctionDetailsRiskBandD(auction : Auction)
        fun openAuctionDetailsRiskBandE(auction : Auction)
        fun openAuctionDetails(auction : Auction)
    }

    interface Presenter : com.example.davidmartinezgarcia.fundingcirclechallenge.feature.common.presenter.Presenter {
        fun retrieveAuctions()
        fun decideAuctionDetailToOpen(auction: Auction)
    }
}