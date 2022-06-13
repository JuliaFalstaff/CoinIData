package com.example.currencycryptoapp.presentation.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.currencycryptoapp.api.ApiFactory
import com.example.currencycryptoapp.room.AppDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CoinViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    val priceList = db.coinPriceInfoDao().getPriceList()
    private val compositeDisposable = CompositeDisposable()

    fun loadData() {
        val disposable = ApiFactory.apiService.getTopCoinsInfo()
                .map { it.data?.map {it.coinInfo?.name}?.joinToString(",") }
                .flatMap {
                    it?.let {ApiFactory.apiService.getFullPriceList(fsyms = it)}
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {

                            Log.d("TAG", it.toString())
                        }, {
                    Log.d("TAG", it.message.toString())
                }
                )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}