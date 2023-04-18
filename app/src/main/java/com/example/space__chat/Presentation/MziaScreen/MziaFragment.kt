package com.example.space__chat.Presentation.MziaScreen


import androidx.fragment.app.viewModels
import com.example.space__chat.Presentation.BaseFragment
import com.example.space__chat.Presentation.Inflate
import com.example.space__chat.databinding.FragmentMziaBinding


class MziaFragment : BaseFragment<FragmentMziaBinding>() {
    private val viewModel: MziaViewModel by viewModels()

    override fun inflate(): Inflate<FragmentMziaBinding> {
        return FragmentMziaBinding::inflate
    }

    override fun onBind() {
    }
}