package com.space.space__chat.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * [MessageEntity] is a data class that represents a message entity in the database.
 */
@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? =null,
    val sender: String?,
    val message: String?,
    val timeStamp: Long?,
    val isOnline:Boolean = true
)