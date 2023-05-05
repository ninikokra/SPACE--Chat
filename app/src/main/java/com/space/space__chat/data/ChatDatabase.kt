package com.space.space__chat.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.space.space__chat.data.dao.ChatDao
import com.space.space__chat.data.entity.MessageEntity

@Database(
    entities = [MessageEntity::class],
    version = 3,
)
abstract class ChatDataBase : RoomDatabase() {

    abstract fun chatDao(): ChatDao
}