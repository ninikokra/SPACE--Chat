package com.example.space__chat.Presentation.TopUserScreen

import androidx.fragment.app.viewModels
import com.example.space__chat.Presentation.BASE.BaseFragment
import com.example.space__chat.Presentation.BASE.Inflate
import com.example.space__chat.databinding.FragmentTopUserBinding


class TopUserFragment : BaseFragment<FragmentTopUserBinding>() {

    private val viewModel: TopUserViewModel by viewModels()

    override fun inflate(): Inflate<FragmentTopUserBinding> {
        return FragmentTopUserBinding::inflate
    }

    override fun onBind() {
    }

}