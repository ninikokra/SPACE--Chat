package com.example.space__chat.presentation.top_user_screen

import androidx.fragment.app.viewModels
import com.example.space__chat.presentation.base.BaseFragment
import com.example.space__chat.presentation.base.Inflate
import com.example.space__chat.databinding.FragmentTopUserBinding


class TopUserFragment : BaseFragment<FragmentTopUserBinding,TopUserViewModel>() {

    override val viewModel by viewModels<TopUserViewModel>()

    override fun inflate(): Inflate<FragmentTopUserBinding> {
        return FragmentTopUserBinding::inflate
    }

    override fun onBind(viewModel: TopUserViewModel) {
    }

}