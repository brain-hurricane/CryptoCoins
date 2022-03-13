package com.example.cryptoapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ItemCoinInfoBinding
import com.example.cryptoapp.domain.CoinInfo
import com.example.cryptoapp.presentation.CoinPriceInfoDiffCallback
import com.squareup.picasso.Picasso

class CoinInfoAdapter(private val context: Context) : ListAdapter<CoinInfo, CoinInfoAdapter.CoinInfoViewHolder>(
    CoinPriceInfoDiffCallback()
) {

    var onCoinClickListener: ((CoinInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {

        val binding = ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        with(holder.binding) {
            val count = position + 1
            val symbolsTemplate = context.resources.getString(R.string.symbols_template)
            val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
            tvCount.text = count.toString()
            tvSymbols.text = String.format(symbolsTemplate, coin.fromSymbol, coin.toSymbol)
            tvPrice.text = coin.price
            tvLastUpdate.text = String.format(lastUpdateTemplate, coin.formattedTime)
            Picasso.get().load(coin.fullImageUrl).into(ivLogoCoin)
            root.setOnClickListener {
                onCoinClickListener?.invoke(coin)
            }
        }
    }

    class CoinInfoViewHolder(val binding: ItemCoinInfoBinding) : RecyclerView.ViewHolder(binding.root)
}