package com.example.davidmartinezgarcia.fundingcirclechallenge.feature.common.presenter

import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.common.view.View
import io.reactivex.functions.Consumer

/**
 * Created by david.martinezgarcia on 21/04/2018.
 */
abstract class BasePresenter() : Presenter {
    class ApiErrorAction(internal var view: View) : Consumer<Throwable> {

        override fun accept(throwable: Throwable) {
            view.onApiError(throwable)

            //TODO with a documentation of the API I can manage here the different errors that could be returned
            //i.e insufficent permisions, to many request, connection error
        }
    }
}