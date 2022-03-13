package com.example.cryptoapp.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.data.network.model.CoinInfoDto
import com.example.cryptoapp.domain.CoinInfo

class CoinPriceInfoDiffCallback: DiffUtil.ItemCallback<CoinInfo>() {

    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}