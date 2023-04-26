package com.example.space__chat.utils

import java.text.SimpleDateFormat
import java.util.*

fun Long.convertTimeToString(): String {
    val calendar = Calendar.getInstance()
    val dayMonthFormat = SimpleDateFormat("dd/MM, HH:mm", Locale.getDefault())
    return dayMonthFormat.format(calendar.time)
}