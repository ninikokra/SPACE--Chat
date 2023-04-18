package com.example.space__chat.Presentation.BottomUserScreen


import androidx.fragment.app.viewModels
import com.example.space__chat.Presentation.BASE.BaseFragment
import com.example.space__chat.Presentation.BASE.Inflate
import com.example.space__chat.databinding.FragmentBottomUserBinding


class BottomUserFragment : BaseFragment<FragmentBottomUserBinding>() {
    private val viewModel: BottomUserViewModel by viewModels()

    override fun inflate(): Inflate<FragmentBottomUserBinding> {
        return FragmentBottomUserBinding::inflate
    }

    override fun onBind() {
    }
}