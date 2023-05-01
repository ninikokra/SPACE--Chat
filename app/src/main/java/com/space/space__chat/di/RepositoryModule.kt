package com.space.space__chat.di

import com.space.space__chat.data.repository.ChatRepositoryImpl
import com.space.space__chat.domain.ChatRepository
import org.koin.dsl.module

val repositoryModule = module{
    single<ChatRepository> { ChatRepositoryImpl(get()) }

}