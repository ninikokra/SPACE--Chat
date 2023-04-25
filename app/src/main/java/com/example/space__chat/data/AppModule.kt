package com.example.space__chat.data

import android.content.Context
import androidx.room.Room

private fun chatDbProvider(context: Context): ChatDataBase {
    return Room.databaseBuilder(context, ChatDataBase::class.java, "database_1")
        .fallbackToDestructiveMigration().build()
}
private fun provideDao(db: ChatDataBase) = db.chatDao()
