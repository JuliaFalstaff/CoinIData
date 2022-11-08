package com.example.currencycryptoapp

import android.content.Intent
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.currencycryptoapp.presentation.ui.CoinDetailActivity
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoinDetailActivityEspressoTest {

    private lateinit var scenario: ActivityScenario<CoinDetailActivity>

    @Before
    fun setup() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), CoinDetailActivity::class.java)
        intent.putExtra("fSym", "BTC")
        scenario = ActivityScenario.launch<CoinDetailActivity>(intent)
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