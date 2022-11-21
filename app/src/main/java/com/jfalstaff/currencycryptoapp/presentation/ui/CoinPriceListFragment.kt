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
import com.jfalstaff.currencycryptoapp.databinding.FragmentCoinPriceListBinding
import com.jfalstaff.currencycryptoapp.domain.CoinInfoEntity
import com.jfalstaff.currencycryptoapp.presentation.adapters.CoinInfoAdapter
import javax.inject.Inject

class CoinPriceListFragment : Fragment() {

    private val component by lazy {
        (requireActivity().application as CryptoApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: CoinViewModel
    private var _binding: FragmentCoinPriceListBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("BINDING_ERROR_IS_NULL")
    private var adapter: CoinInfoAdapter? = null

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinPriceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CoinInfoAdapter(requireContext())
        adapter?.onClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinInfoEntity) {
                if (isOnePaneMode()) {
                    launchDetailActivity(coinPriceInfo.fromSymbol)
                } else {
                    launchDetailFragment(coinPriceInfo.fromSymbol)
                }
            }
        }
        binding.recyclerViewCoinPriceList?.adapter = adapter
        binding.recyclerViewCoinPriceList?.itemAnimator = null
        viewModel = ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
        viewModel.coinInfoList.observe(viewLifecycleOwner, Observer {
            adapter?.submitList(it)
        })
    }


    private fun launchDetailActivity(fromSymbol: String) {
        requireActivity().supportFragmentManager.popBackStack()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainerView, CoinDetailFragment.newInstance(fromSymbol))
            .addToBackStack(null)
            .commit()
    }

    private fun launchDetailFragment(fromSymbol: String) {
        requireActivity().supportFragmentManager.popBackStack()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentDetailContainer, CoinDetailFragment.newInstance(fromSymbol))
            .addToBackStack(null)
            .commit()
    }

    private fun isOnePaneMode() = binding.fragmentDetailContainer == null

    companion object {
        fun newInstance() = CoinPriceListFragment()
    }
}