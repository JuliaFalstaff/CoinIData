package com.example.currencycryptoapp

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.currencycryptoapp.presentation.ui.CoinPriceListActivity
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

    @After
    fun close() {
        scenario.close()
    }
}