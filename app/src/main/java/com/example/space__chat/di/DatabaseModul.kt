package com.example.space__chat.di

import android.content.Context
import androidx.room.Room
import com.example.space__chat.data.ChatDataBase

private fun provideChatDB(context: Context): ChatDataBase {
    return Room.databaseBuilder(context, ChatDataBase::class.java, "database_1")
        .fallbackToDestructiveMigration().build()
}
private fun provideDao(db: ChatDataBase) = db.chatDao()
