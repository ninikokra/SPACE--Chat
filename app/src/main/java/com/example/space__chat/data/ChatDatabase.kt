package com.example.space__chat.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Entity::class],
    version = 1,
)
abstract class ChatDataBase : RoomDatabase() {

    abstract fun chatDao(): ChatDao
}