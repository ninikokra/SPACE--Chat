package com.example.space__chat.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflate<VB> = (LayoutInflater, ViewGroup, Boolean) -> VB

abstract class BaseFragment<VB : ViewBinding, VM> : Fragment() {

    protected abstract val viewModel: VM

    private var _binding: VB? = null
    abstract fun inflate(): Inflate<VB>
    protected val binding get() = _binding!!

    abstract fun onBind()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = this.inflate().invoke(inflater, container!!, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBind()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}