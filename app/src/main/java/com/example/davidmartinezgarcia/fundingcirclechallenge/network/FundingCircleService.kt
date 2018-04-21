package com.example.davidmartinezgarcia.fundingcirclechallenge.network

import com.example.davidmartinezgarcia.fundingcirclechallenge.model.networkmodel.AuctionsEndPoint
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by david.martinezgarcia on 21/04/2018.
 */
interface FundingCircleService {
    @GET("auctions")
    fun getAuctions(): Observable<AuctionsEndPoint>
}