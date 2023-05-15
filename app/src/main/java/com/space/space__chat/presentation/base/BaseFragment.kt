package com.space.space__chat.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModelForClass
import kotlin.reflect.KClass

/**
 * [BaseFragment] is an abstract class and provides a base implementation for creating fragments with a ViewModel.
 * It contains a few lifecycle methods that can be overridden in the child classes,
 * and a few abstract properties and methods that need to be implemented in the child classes.
 */

abstract class BaseFragment<VM : ViewModel> : Fragment() {

    protected abstract val layout: Int

    val viewModel: VM by viewModelForClass(clazz = viewModelClass)
    abstract val viewModelClass: KClass<VM>

    abstract fun onBind(viewModel: VM)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBind(viewModel)
    }
}