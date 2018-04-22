package com.example.davidmartinezgarcia.fundingcirclechallenge

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.davidmartinezgarcia.fundingcirclechallenge.feature.auctionslist.view.AuctionsListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by david.martinezgarcia on 22/04/2018.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class AuctionsListActivityTest {

    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<AuctionsListActivity> = ActivityTestRule(AuctionsListActivity::class.java)


    @Test
    fun checkRecyclerViewIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}