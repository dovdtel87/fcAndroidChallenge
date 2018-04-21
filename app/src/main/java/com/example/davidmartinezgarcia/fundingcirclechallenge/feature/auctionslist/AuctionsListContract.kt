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
    }

    interface Presenter : com.example.davidmartinezgarcia.fundingcirclechallenge.feature.common.presenter.Presenter {
        fun retrieveAuctions()
    }
}