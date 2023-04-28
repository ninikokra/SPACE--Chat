package com.example.space__chat.di

import com.example.space__chat.presentation.vm.ChatUsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        ChatUsersViewModel(get())
    }
}