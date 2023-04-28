package com.example.space__chat

import android.app.Application
import com.example.space__chat.di.dbModule
import com.example.space__chat.di.repositoryModule
import com.example.space__chat.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                dbModule, repositoryModule, viewModelModule
            )
        }
    }
}