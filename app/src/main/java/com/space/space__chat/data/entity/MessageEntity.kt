package com.space.space__chat.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * [MessageEntity] is a data class that represents a message entity in the database.
 *  @param id The unique identifier of the message entity. It is auto-generated by the database.
 * @param sender The sender of the message.
 * @param message The content of the message.
 * @param timeStamp The timestamp when the message was sent.
 * @param isOnline Flag indicating whether the sender is currently online.
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