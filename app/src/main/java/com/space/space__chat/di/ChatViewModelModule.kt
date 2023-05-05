package com.space.space__chat.di

import com.space.space__chat.presentation.vm.ChatUsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ChatUsersViewModel(get())
    }
}