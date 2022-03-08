package com.example.cryptoapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.pojo.CoinPriceInfo

class CoinPriceInfoDiffCallback: DiffUtil.ItemCallback<CoinPriceInfo>() {

    override fun areItemsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo): Boolean {
        return oldItem == newItem
    }
}