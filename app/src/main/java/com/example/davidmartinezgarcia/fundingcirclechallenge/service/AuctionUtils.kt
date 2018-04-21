package com.example.davidmartinezgarcia.fundingcirclechallenge.service

import android.support.annotation.ColorRes
import com.example.davidmartinezgarcia.fundingcirclechallenge.R

/**
 * Created by david.martinezgarcia on 21/04/2018.
 */
class AuctionUtils() {

    companion object {
        @ColorRes val COLOR_GREEN = R.color.green
        @ColorRes val COLOR_YELLOW = R.color.yellow
        @ColorRes val COLOR_PURPLE = R.color.purple
        @ColorRes val COLOR_ORANGE = R.color.orange
        @ColorRes val COLOR_RED = R.color.red

        fun getColorByRiskBand(riskBand : String) : Int {
            var colorInt : Int = COLOR_RED
            when(riskBand) {
                "A+" -> colorInt = COLOR_GREEN
                "A" -> colorInt = COLOR_YELLOW
                "B" -> colorInt = COLOR_PURPLE
                "C" -> colorInt = COLOR_ORANGE
                "C-" -> colorInt = COLOR_RED
            }
            return colorInt
        }
    }
}