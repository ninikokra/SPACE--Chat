package com.example.space__chat.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val sender: String?,
    val message: String?,
    val timeStamp: Long?
)