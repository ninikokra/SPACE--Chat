package com.space.space__chat.di

import android.content.Context
import androidx.room.Room
import com.space.space__chat.data.ChatDataBase
import org.koin.dsl.module

private fun provideChatDB(context: Context): ChatDataBase {
    return Room.databaseBuilder(context, ChatDataBase::class.java, "database_1")
        .fallbackToDestructiveMigration().build()
}
private fun provideDao(db: ChatDataBase) = db.chatDao()

val dbModule = module {
    single { provideChatDB(get()) }
    single { provideDao(get()) }
}