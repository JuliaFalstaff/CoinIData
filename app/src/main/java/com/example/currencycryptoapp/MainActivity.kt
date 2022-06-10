package com.example.currencycryptoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.currencycryptoapp.api.ApiFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private  val compositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val disposable = ApiFactory.apiService.getFullPriceList(fsyms = "BTC, ETH")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("TAG", it.toString())
                },
                {
                    Log.d("TAG", it.message.toString())
                }
            )
        compositeDisposable.add(disposable)

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}