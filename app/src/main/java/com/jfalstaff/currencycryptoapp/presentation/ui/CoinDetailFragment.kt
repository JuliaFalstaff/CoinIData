package com.jfalstaff.currencycryptoapp.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jfalstaff.currencycryptoapp.CryptoApp
import com.jfalstaff.currencycryptoapp.R
import com.jfalstaff.currencycryptoapp.databinding.FragmentCoinDetailBinding
import com.squareup.picasso.Picasso
import javax.inject.Inject

class CoinDetailFragment : Fragment() {

    private val component by lazy {
        (requireActivity().application as CryptoApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: CoinViewModel
    private var _binding: FragmentCoinDetailBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException(BINDING_ERROR_IS_NULL)

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fromSymbol = getSymbol()
        viewModel = ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(viewLifecycleOwner, Observer { coin ->
            with(binding) {
                textViewPrice.text = coin.price
                textViewMinPrice.text = coin.lowDay
                textViewMaxPrice.text = coin.highDay
                textViewLastMarket.text = coin.lastMarket
                textViewLastUpdate.text = coin.lastUpdate
                textViewFromSymbol.text = coin.fromSymbol
                textViewToSymbol.text = coin.toSymbol
                textViewChange24Hours.text = String.format(
                    getString(R.string.symbols_change_template),
                    coin.change24Hour
                )
                textViewOpen24Hours.text = coin.open24Hour
                textViewHigh24Hours.text = coin.high24Hour
                textViewLow24Hours.text = coin.low24Hour
                Picasso.get().load(coin.imageUrl).into(imageViewLogoCoin)
            }
        })
    }

    private fun getSymbol(): String {
        return requireArguments().getString(EXTRA_FROM_SYMBOL, EMPTY_SYMBOL)
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"
        private const val EMPTY_SYMBOL = ""
        private const val BINDING_ERROR_IS_NULL = "FragmentCoinDetailBinding == null"
        fun newInstance(fSymbol: String): Fragment {
            return CoinDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FROM_SYMBOL, fSymbol)
                }
            }
        }
    }
}