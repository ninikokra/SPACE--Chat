package com.space.space__chat.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.space.space__chat.data.dao.ChatDao
import com.space.space__chat.data.entity.ChatEntity

@Database(
    entities = [ChatEntity::class],
    version = 10,
)
abstract class ChatDataBase : RoomDatabase() {

    abstract fun chatDao(): ChatDao
}