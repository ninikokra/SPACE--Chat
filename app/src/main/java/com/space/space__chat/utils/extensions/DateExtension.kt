package com.space.space__chat.utils.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Long.convertTimeToString(): String {
    val georgianLocale = Locale("ka", "GE")
    val dateFormat = SimpleDateFormat("MMM d HH:mm", georgianLocale)
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return dateFormat.format(calendar.time)
}
fun getTimeInMills(): Long{
    return System.currentTimeMillis()
}