package com.example.currencycryptoapp

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.currencycryptoapp.presentation.ui.CoinDetailFragment
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoinDetailedFragmentEspressoTest {
    private lateinit var scenario: FragmentScenario<CoinDetailFragment>

    @Before
    fun setup() {
        val fragmentArgs = bundleOf("fSym" to "BTC")
        scenario = launchFragmentInContainer<CoinDetailFragment>(
            fragmentArgs = fragmentArgs,
            themeResId = R.style.Theme_CurrencyCryptoApp
        )
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun fragment_AssertNotNull() {
        scenario.onFragment {
            TestCase.assertNotNull(it)
        }
    }

    @Test
    fun fragmentTextViewSymbol_HasText() {
        onView(withId(R.id.tvFromSymbol)).check(matches(withText("BTC")))
    }

    @Test
    fun fragmentCarViewTextViewInfo_HasTexts() {
        onView(withId(R.id.tvPrice)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMinPrice)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMaxPrice)).check(matches(isDisplayed()))
        onView(withId(R.id.tvLastMarket)).check(matches(isDisplayed()))
        onView(withId(R.id.tvLastUpdate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvChange24Hours)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOpen24Hours)).check(matches(isDisplayed()))
        onView(withId(R.id.tvHigh24Hours)).check(matches(isDisplayed()))
        onView(withId(R.id.tvLow24Hours)).check(matches(isDisplayed()))
    }

    @Test
    fun fragmentCardView_IsDisplayed() {
        onView(withId(R.id.carViewDetailedInfo)).check(matches(isDisplayed()))
    }

    @Test
    fun fragmentCardView_IsCompletelyDisplayed() {
        onView(withId(R.id.carViewDetailedInfo)).check(matches(isCompletelyDisplayed()))
    }
}