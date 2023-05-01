package com.space.space__chat.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.space.space__chat.data.model.ChatEntity

@Database(
    entities = [ChatEntity::class],
    version = 2,
)
abstract class ChatDataBase : RoomDatabase() {

    abstract fun chatDao(): ChatDao
}