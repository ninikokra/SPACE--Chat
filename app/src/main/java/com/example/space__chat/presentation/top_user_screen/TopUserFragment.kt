package com.example.space__chat.presentation.top_user_screen

import androidx.fragment.app.viewModels
import com.example.space__chat.presentation.base.BaseFragment
import com.example.space__chat.presentation.base.Inflate
import com.example.space__chat.databinding.FragmentTopUserBinding


class TopUserFragment : BaseFragment<FragmentTopUserBinding>() {

    private val viewModel: TopUserViewModel by viewModels()

    override fun inflate(): Inflate<FragmentTopUserBinding> {
        return FragmentTopUserBinding::inflate
    }

    override fun onBind() {
    }

}