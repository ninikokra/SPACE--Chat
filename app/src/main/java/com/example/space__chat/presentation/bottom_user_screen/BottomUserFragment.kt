package com.example.space__chat.presentation.bottom_user_screen


import androidx.fragment.app.viewModels
import com.example.space__chat.presentation.base.BaseFragment
import com.example.space__chat.presentation.base.Inflate
import com.example.space__chat.databinding.FragmentBottomUserBinding


class BottomUserFragment : BaseFragment<FragmentBottomUserBinding>() {
    private val viewModel: BottomUserViewModel by viewModels()

    override fun inflate(): Inflate<FragmentBottomUserBinding> {
        return FragmentBottomUserBinding::inflate
    }

    override fun onBind() {
    }
}