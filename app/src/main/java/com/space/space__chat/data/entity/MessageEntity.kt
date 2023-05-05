package com.space.space__chat.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? =null,
    val sender: String?,
    val message: String?,
    val timeStamp: Long?
)