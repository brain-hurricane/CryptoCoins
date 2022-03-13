package com.example.cryptoapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.data.network.model.CoinInfoDto

@Dao
interface CoinInfoDao {
    @Query("SELECT * FROM full_price_list ORDER BY priceDouble DESC")
    fun getCoinList(): LiveData<List<CoinInfoDbModel>>

    @Query("SELECT * FROM full_price_list WHERE fromSymbol == :fSym LIMIT 1")
    fun getCoinInfo(fSym: String): LiveData<CoinInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoinList(listDto: List<CoinInfoDbModel>)
}
