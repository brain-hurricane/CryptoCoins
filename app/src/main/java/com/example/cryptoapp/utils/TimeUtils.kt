package com.example.cryptoapp.utils

import android.content.Context
import com.example.cryptoapp.Currency
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.util.*

fun convertTimestampToTime(timestamp: Long?): String {
    if (timestamp == null) return ""
    val stamp = Timestamp(timestamp * 1000)
    val date = Date(stamp.time)
    val pattern = "HH:mm:ss"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    sdf.timeZone = TimeZone.getTimeZone("Europe/Moscow")
    return sdf.format(date)
}
