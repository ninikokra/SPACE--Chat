package com.example.space__chat.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int?,
    @ColumnInfo(name = "sender")
    val sender : String?,
    @ColumnInfo(name = "message")
    val message: String?,
    @ColumnInfo(name = "timeStamp")
    val timeStamp:String?
)