package com.space.space__chat.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.space.space__chat.data.dao.ChatDao
import com.space.space__chat.data.entity.MessageEntity

/**
 * This class is an abstract class that represents the database for the chat application.
 * It extends the RoomDatabase class, which is an Android library for database management.
 * It contains an abstract method that returns a ChatDao object, which is used to interact with the database.
 */
@Database(
    entities = [MessageEntity::class],
    version = 5,
)
abstract class ChatDataBase : RoomDatabase() {

    abstract fun chatDao(): ChatDao
}