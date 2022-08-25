package com.example.currencycryptoapp.utils

import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun convertTimestampToTime(timestamp: Long?): String {
    if (timestamp == null) return ""
    val stampInMillis = Timestamp(timestamp * 1000)
    val date = Date(stampInMillis.time)
    val pattern = "HH:mm:ss"
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    simpleDateFormat.timeZone = TimeZone.getDefault()
    return simpleDateFormat.format(date)
}