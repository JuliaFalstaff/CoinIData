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
        val fragmentArgs = bundleOf(EXTRA_FROM_SYMBOL to TEST_EXTRA_SYMBOL)
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
        onView(withId(R.id.textViewFromSymbol)).check(matches(withText(TEST_EXTRA_SYMBOL)))
    }

    @Test
    fun fragmentCarViewTextViewInfo_HasTexts() {
        onView(withId(R.id.textViewPrice)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewMinPrice)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewMaxPrice)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewLastMarket)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewLastUpdate)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewChange24Hours)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewOpen24Hours)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewHigh24Hours)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewLow24Hours)).check(matches(isDisplayed()))
    }

    @Test
    fun fragmentCardView_IsDisplayed() {
        onView(withId(R.id.carViewDetailedInfo)).check(matches(isDisplayed()))
    }

    @Test
    fun fragmentCardView_IsCompletelyDisplayed() {
        onView(withId(R.id.carViewDetailedInfo)).check(matches(isCompletelyDisplayed()))
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"
        private const val TEST_EXTRA_SYMBOL = "BTC"
    }
}