package com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.repository

import com.example.davidmartinezgarcia.fundingcirclechallenge.model.Auction
import com.example.davidmartinezgarcia.fundingcirclechallenge.model.networkmodel.AuctionsEndPoint
import com.example.davidmartinezgarcia.fundingcirclechallenge.network.FundingCircleClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by david.martinezgarcia on 21/04/2018.
 */
class AuctionsListRepository : AuctionsListRepositoryInterface {

    override fun retrieveAuctions(): Observable<AuctionsEndPoint> {
        return FundingCircleClient.getInstance()
                .getAuctions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}