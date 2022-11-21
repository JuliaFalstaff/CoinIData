package com.jfalstaff.currencycryptoapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jfalstaff.currencycryptoapp.R
import com.jfalstaff.currencycryptoapp.databinding.ItemCoinInfoBinding
import com.jfalstaff.currencycryptoapp.domain.CoinInfoEntity
import com.squareup.picasso.Picasso

class CoinInfoAdapter(
    private val context: Context
) : ListAdapter<CoinInfoEntity, CoinInfoAdapter.CoinInfoViewHolder>(CoinInfoDiffCallback) {

    var onClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        return CoinInfoViewHolder(
            ItemCoinInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CoinInfoViewHolder(val binding: ItemCoinInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: CoinInfoEntity) = with(binding) {
            with(coin) {
                val symbolsTemplate = context.resources.getString(R.string.symbols_template)
                val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
                textViewSymbols.text = String.format(symbolsTemplate, fromSymbol, toSymbol)
                coinCurrencyTextView.text = price
                updateTimeTextView.text =
                    String.format(lastUpdateTemplate, lastUpdate)
                Picasso.get().load(imageUrl).into(logoCoinImageView)
                itemView.setOnClickListener {
                    onClickListener?.onCoinClick(this)
                }
            }
        }
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinInfoEntity)
    }
}