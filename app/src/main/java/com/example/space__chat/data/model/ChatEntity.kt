package com.example.space__chat.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.space__chat.presentation.model.UserType

@Entity(tableName = "messages")
data class ChatEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? =null,
    val sender: UserType?,
    val message: String?,
    val timeStamp: Long?
)