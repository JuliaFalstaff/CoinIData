package com.jfalstaff.currencycryptoapp

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jfalstaff.currencycryptoapp.presentation.adapters.CoinInfoAdapter
import com.jfalstaff.currencycryptoapp.presentation.ui.CoinPriceListActivity
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoinPriceListActivityEspressoTest {
    private lateinit var scenario: ActivityScenario<CoinPriceListActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(CoinPriceListActivity::class.java)
    }

    @Test
    fun activity_AssertNotNull() {
        scenario.onActivity {
            TestCase.assertNotNull(it)
        }
    }

    @Test
    fun activity_IsResumed() {
        TestCase.assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    @Test
    fun activity_RecyclerViewIsDisplayed() {
        onView(withId(R.id.recyclerViewCoinPriceList)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun activity_RecyclerViewScrollTo() {
        onView(withId(R.id.recyclerViewCoinPriceList)).perform(
            RecyclerViewActions.scrollToPosition<CoinInfoAdapter.CoinInfoViewHolder>(
                TEST_RV_SCROLL_POSITION_ITEM
            )
        )
    }

    @Test
    fun activity_RecyclerViewActionOnItem() {
        onView(withId(R.id.recyclerViewCoinPriceList)).perform(
            RecyclerViewActions.actionOnItemAtPosition<CoinInfoAdapter.CoinInfoViewHolder>(
                TEST_RV_CLICK_POSITION_ITEM,
                ViewActions.click()
            )
        )
    }

    @After
    fun close() {
        scenario.close()
    }

    companion object {
        private const val TEST_RV_SCROLL_POSITION_ITEM = 10
        private const val TEST_RV_CLICK_POSITION_ITEM = 10
    }
}