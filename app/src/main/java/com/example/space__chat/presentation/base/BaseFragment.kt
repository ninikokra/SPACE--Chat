package com.example.space__chat.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModelForClass
import kotlin.reflect.KClass

typealias Inflate<VB> = (LayoutInflater, ViewGroup, Boolean) -> VB

abstract class BaseFragment<VB : ViewBinding, VM :ViewModel> : Fragment() {

    abstract val viewModelClass: KClass<VM>
    private val viewModel: VM by viewModelForClass(clazz = viewModelClass)

    private var _binding: VB? = null
    protected val binding get() = _binding!!
    abstract fun inflate(): Inflate<VB>
    abstract fun onBind(viewmodel: VM)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = container?.let { this.inflate().invoke(inflater, it, false) }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBind(viewModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}