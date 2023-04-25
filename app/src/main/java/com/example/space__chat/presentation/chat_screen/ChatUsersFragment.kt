package com.example.space__chat.Presentation.chat_screen

import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.space__chat.Presentation.adapter.ChatRVAdapter
import com.example.space__chat.Presentation.utils.UserTypeEnum
import com.example.space__chat.databinding.FragmentChatUsersBinding
import com.example.space__chat.presentation.base.BaseFragment
import com.example.space__chat.presentation.base.Inflate
import com.example.space__chat.presentation.top_user_screen.ChatUsersViewModel


class ChatUsersFragment : BaseFragment<FragmentChatUsersBinding, ChatUsersViewModel>() {

    override val viewModel by viewModels<ChatUsersViewModel>()

    private val adapter by lazy {
        ChatRVAdapter(UserTypeEnum.valueOf(tag!!))

    }

    override fun inflate(): Inflate<FragmentChatUsersBinding> {
        return FragmentChatUsersBinding::inflate
    }

    override fun onBind(viewModel: ChatUsersViewModel) {
        with(viewModel) {
            initRV(this)
        }
    }

    private fun initRV(viewModel: ChatUsersViewModel) {
        binding.chatFragmentRV.adapter = adapter

    }

    fun updateTextColor(colorResId: Int) {
        binding.chatInputET.setTextColor(ContextCompat.getColor(requireContext(), colorResId))
    }

}