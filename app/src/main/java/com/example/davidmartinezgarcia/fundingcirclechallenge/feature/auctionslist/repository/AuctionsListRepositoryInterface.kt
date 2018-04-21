package com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.repository

import com.example.davidmartinezgarcia.fundingcirclechallenge.model.networkmodel.AuctionsEndPoint
import io.reactivex.Observable

/**
 * Created by david.martinezgarcia on 21/04/2018.
 */
interface AuctionsListRepositoryInterface {
    fun retrieveAuctions(): Observable<AuctionsEndPoint>
}