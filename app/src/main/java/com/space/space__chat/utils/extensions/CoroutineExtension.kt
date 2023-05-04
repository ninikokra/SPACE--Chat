package com.space.space__chat.utils.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun ViewModel.viewModelScope(
    block: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch { block() }
}

fun <FL> Fragment.lifecycleScopeCollect(flow: Flow<FL>, block: suspend CoroutineScope.(FL) -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        flow.collect { item ->
            block(item)
        }
    }
}