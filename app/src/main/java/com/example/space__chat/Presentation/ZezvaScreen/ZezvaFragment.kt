package com.example.space__chat.Presentation.ZezvaScreen

import androidx.fragment.app.viewModels
import com.example.space__chat.Presentation.BaseFragment
import com.example.space__chat.Presentation.Inflate
import com.example.space__chat.databinding.FragmentZezvaBinding


class ZezvaFragment : BaseFragment<FragmentZezvaBinding>() {

    private val viewModel : ZezvaViewModel by viewModels()

    override fun inflate(): Inflate<FragmentZezvaBinding> {
        return FragmentZezvaBinding::inflate
    }

    override fun onBind() {
    }

}