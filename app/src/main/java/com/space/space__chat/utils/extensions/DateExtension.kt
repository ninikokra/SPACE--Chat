package com.space.space__chat.utils.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Long.convertTimeToString(): String {
    val georgianLocale = Locale("ka", "GE")
    val dateFormat = SimpleDateFormat("MMM d", georgianLocale)
    val timeFormat = SimpleDateFormat("HH:mm", georgianLocale)
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    val date = dateFormat.format(calendar.time)
    val time = timeFormat.format(calendar.time)
    return "$date $time"
}
fun getTimeInMills(): Long{
    return System.currentTimeMillis()
}