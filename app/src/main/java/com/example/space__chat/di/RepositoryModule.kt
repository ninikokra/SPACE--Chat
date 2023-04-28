package com.example.space__chat.di

import com.example.space__chat.data.repository.ChatRepositoryImpl
import com.example.space__chat.domain.ChatRepository
import org.koin.dsl.module

val repositoryModule = module{
    single<ChatRepository> { ChatRepositoryImpl(get()) }

}