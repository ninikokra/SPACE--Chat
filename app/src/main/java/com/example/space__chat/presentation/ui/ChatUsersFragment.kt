package com.example.space__chat.Presentation.ui

import androidx.fragment.app.viewModels
import com.example.space__chat.Presentation.ui.adapter.ChatRVAdapter
import com.example.space__chat.Presentation.model.UserType
import com.example.space__chat.databinding.FragmentChatUsersBinding
import com.example.space__chat.presentation.base.BaseFragment
import com.example.space__chat.presentation.base.Inflate
import com.example.space__chat.Presentation.vm.ChatUsersViewModel


class ChatUsersFragment : BaseFragment<FragmentChatUsersBinding, ChatUsersViewModel>() {

    override val viewModel by viewModels<ChatUsersViewModel>()

    private val adapter by lazy {
        ChatRVAdapter(UserType.valueOf(tag!!))
    }

    override fun inflate(): Inflate<FragmentChatUsersBinding> {
        return FragmentChatUsersBinding::inflate
    }

    override fun onBind(viewModel: ChatUsersViewModel) {
        with(viewModel) {
            initRecyclerView(this)
        }
    }

    private fun initRecyclerView(viewModel: ChatUsersViewModel) {
        binding.chatFragmentRV.adapter = adapter
    }
}