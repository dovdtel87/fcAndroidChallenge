package com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.presenter

import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.AuctionsListContract
import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.repository.AuctionsListRepositoryInterface
import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.common.presenter.BasePresenter
import com.example.davidmartinezgarcia.fundingcirclechallenge.model.networkmodel.AuctionsEndPoint
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

/**
 * Created by david.martinezgarcia on 21/04/2018.
 */
class AuctionsListPresenter(private var view: AuctionsListContract.View,
                            private var auctionsListRepository: AuctionsListRepositoryInterface) : BasePresenter(), AuctionsListContract.Presenter {

    private var disposable: CompositeDisposable = CompositeDisposable()

    override fun retrieveAuctions() {
        view.showProgress()
        disposable.add(auctionsListRepository.retrieveAuctions()
                .subscribe(Consumer<AuctionsEndPoint> { auctionsResponse ->
                    view.hideProgress()
                    if (auctionsResponse != null) {
                        view.showAuctions(auctionsResponse.items)
                    }
                }, ApiErrorAction(view)))
    }

    override fun onViewDestroyed() {
        disposable.clear()
    }
}