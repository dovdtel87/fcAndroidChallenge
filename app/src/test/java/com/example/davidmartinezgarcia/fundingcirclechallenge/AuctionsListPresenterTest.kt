package com.example.davidmartinezgarcia.fundingcirclechallenge

import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.AuctionsListContract
import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.presenter.AuctionsListPresenter
import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.repository.AuctionsListRepositoryInterface
import com.example.davidmartinezgarcia.fundingcirclechallenge.model.Auction
import com.example.davidmartinezgarcia.fundingcirclechallenge.model.networkmodel.AuctionsEndPoint
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by david.martinezgarcia on 22/04/2018.
 */
class AuctionsListPresenterTest {

    @Mock
    private lateinit var view: AuctionsListContract.View
    @Mock private lateinit var auctionsListRepository: AuctionsListRepositoryInterface

    private lateinit var presenter: AuctionsListContract.Presenter

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = AuctionsListPresenter(view, auctionsListRepository)
    }

    @Test
    fun shouldRetrieveAuctionsList() {
        val auctions : ArrayList<Auction> = ArrayList()
        val auction1 = Auction("1", "Sainsbury", 0.19f, "A+")
        val auction2 = Auction("2", "Tesco", 0.21f, "C")
        auctions.add(auction1)
        auctions.add(auction2)
        val auctionsEndPoint = AuctionsEndPoint(auctions)

        `when`(auctionsListRepository.retrieveAuctions()).thenReturn(Observable.just(auctionsEndPoint))

        presenter.retrieveAuctions()

        val inOrder = inOrder(view)
        inOrder.verify<AuctionsListContract.View>(view).showProgress()
        inOrder.verify<AuctionsListContract.View>(view).hideProgress()
        inOrder.verify<AuctionsListContract.View>(view).showAuctions(auctions)
        inOrder.verifyNoMoreInteractions()
    }

    @Test
    fun shouldThrowApiException() {
        val exception = Throwable("Api error")
        `when`(auctionsListRepository.retrieveAuctions()).thenReturn(Observable.error(exception))

        presenter.retrieveAuctions()

        val inOrder = inOrder(view)
        inOrder.verify<AuctionsListContract.View>(view).showProgress()
        inOrder.verify<AuctionsListContract.View>(view).onApiError(exception)
        inOrder.verifyNoMoreInteractions()
    }
}