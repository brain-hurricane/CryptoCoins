package com.example.cryptoapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityCoinPrceListBinding
import com.example.cryptoapp.presentation.adapters.CoinInfoAdapter

class CoinPriceListActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[CoinViewModel::class.java]
    }

    private val binding by lazy {
        ActivityCoinPrceListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = {
            if (binding.coinInfoContainer == null) {
                startActivity(CoinDetailInfoActivity.newInstance(it.fromSymbol, this))
            } else {
                val coinInfoFragment = CoinDetailFragment.newInstance(it.fromSymbol)
                supportFragmentManager.popBackStack()
                supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.coin_info_container, coinInfoFragment)
                    .commit()
            }
        }

        viewModel.coinInfoList.observe(this, Observer {
            adapter.submitList(it)
        })

        with(binding) {
            rvCoinPriceList.adapter = adapter
            fabSettings.setOnClickListener {
                startActivity(AppSettingsActivity.newInstance(this@CoinPriceListActivity))
            }
            fabUpdate.setOnClickListener {
                viewModel.loadData()
            }
        }
        Log.d("TAG", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
        Log.d("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy")
    }
}
