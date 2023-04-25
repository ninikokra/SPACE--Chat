package com.example.space__chat.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MessageModel::class],
    version = 1,
    exportSchema = true
)
abstract class ChatDataBase : RoomDatabase() {

    abstract fun chatDao(): ChatDao

}