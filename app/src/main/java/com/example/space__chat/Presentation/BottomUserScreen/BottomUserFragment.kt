package com.example.space__chat.Presentation.BottomUserScreen


import androidx.fragment.app.viewModels
import com.example.space__chat.Presentation.BaseFragment
import com.example.space__chat.Presentation.Inflate
import com.example.space__chat.databinding.BottomUserItemBinding


class BottomUserFragment : BaseFragment<BottomUserItemBinding>() {
    private val viewModel: BottomUserViewModel by viewModels()

    override fun inflate(): Inflate<BottomUserItemBinding> {
        return BottomUserItemBinding::inflate
    }

    override fun onBind() {
    }
}