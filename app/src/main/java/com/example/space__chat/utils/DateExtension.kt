package com.example.space__chat.utils

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDateTime(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
    return dateFormat.format(Date())
}