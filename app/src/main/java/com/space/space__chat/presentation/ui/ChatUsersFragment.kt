package com.space.space__chat.presentation.ui

import com.space.space__chat.databinding.FragmentChatUsersBinding
import com.space.space__chat.presentation.base.BaseFragment
import com.space.space__chat.presentation.base.Inflate
import com.space.space__chat.presentation.ui.adapter.ChatRVAdapter
import com.space.space__chat.presentation.vm.ChatUsersViewModel
import com.space.space__chat.utils.extensions.lifecycleScope
import kotlin.reflect.KClass


class ChatUsersFragment : BaseFragment<FragmentChatUsersBinding, ChatUsersViewModel>() {

    override val viewModelClass: KClass<ChatUsersViewModel>
        get() = ChatUsersViewModel::class

    private val adapter by lazy {
        ChatRVAdapter(listener)
    }

    override fun userId(): String {
        return tag.toString()
    }
    override fun inflate(): Inflate<FragmentChatUsersBinding> {
        return FragmentChatUsersBinding::inflate
    }

    override fun onBind(viewModel: ChatUsersViewModel) {
        with(viewModel) {
            initRecyclerView(this)
            binding.chatSendBTN.setOnClickListener {
                sendMessage(viewModel)

            }
        }
    }
    private fun initRecyclerView(viewModel: ChatUsersViewModel) {
        binding.chatFragmentRV.adapter = adapter
        showMessages(viewModel)

    }
    private fun sendMessage(viewModel: ChatUsersViewModel) {
        viewModel.sendMessage(binding.chatInputET.text.toString(), tag.toString())
        binding.chatInputET.text?.clear()
    }
    private fun showMessages(viewModel: ChatUsersViewModel) {
        lifecycleScope {
            viewModel.showMessages().collect {
                adapter.submitList(it)
            }
        }
    }
}