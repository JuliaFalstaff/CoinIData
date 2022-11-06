//package com.example.currencycryptoapp
//
//import androidx.lifecycle.Lifecycle
//import androidx.test.core.app.ActivityScenario
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.example.currencycryptoapp.presentation.ui.CoinDetailActivity
//import junit.framework.TestCase
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class CoinDetailActivityEspressoTest {
//
//    private lateinit var scenario: ActivityScenario<CoinDetailActivity>
//
//    @Before
//    fun setUp() {
//        scenario = ActivityScenario.launch(CoinDetailActivity::class.java)
//    }
//
//    @Test
//    fun activity_assertNotNull() {
//        scenario.onActivity {
//            TestCase.assertNotNull(it)
//        }
//    }
//
//    @Test
//    fun activity_isResumed() {
//        TestCase.assertEquals(Lifecycle.State.RESUMED, scenario.state)
//    }
//
//    @Test
//    fun activity_hasExtra() {
//        scenario.onActivity {
//            TestCase.assertNotNull(it.intent.hasExtra("fSym"))
//        }
//    }
//
//
//
//    @After
//    fun close() {
//        scenario.close()
//    }
//}