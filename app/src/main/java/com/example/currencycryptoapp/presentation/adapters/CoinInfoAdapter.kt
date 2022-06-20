package com.example.currencycryptoapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencycryptoapp.data.CoinPriceInfo
import com.example.currencycryptoapp.databinding.ItemCoinInfoBinding
import com.squareup.picasso.Picasso

class CoinInfoAdapter : RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        return CoinInfoViewHolder(
            ItemCoinInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        holder.bind(coinInfoList[position])
    }

    override fun getItemCount(): Int = coinInfoList.size

    inner class CoinInfoViewHolder(val binding: ItemCoinInfoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: CoinPriceInfo) = with(binding) {
            with(coin) {
                textViewSymbols.text = fromSymbol + "/" + toSymbol
                coinCurrencyTextView.text = price
                updateTimeTextView.text = getFormattedTime()
                Picasso.get().load(getFullImageURL()).into(logoCoinImageView)
            }
        }
    }
}