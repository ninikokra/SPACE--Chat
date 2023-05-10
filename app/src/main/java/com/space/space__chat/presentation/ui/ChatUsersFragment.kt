package com.space.space__chat.presentation.ui

import com.space.space__chat.databinding.FragmentChatUsersBinding
import com.space.space__chat.presentation.base.BaseFragment
import com.space.space__chat.presentation.base.Inflate
import com.space.space__chat.presentation.ui.adapter.ChatAdapter
import com.space.space__chat.presentation.vm.ChatUsersViewModel
import com.space.space__chat.utils.extensions.isNetworkAvailable
import com.space.space__chat.utils.extensions.lifecycleScopeCollect
import kotlin.reflect.KClass


class ChatUsersFragment : BaseFragment<FragmentChatUsersBinding, ChatUsersViewModel>() {

    override val viewModelClass: KClass<ChatUsersViewModel>
        get() = ChatUsersViewModel::class

    private val adapter by lazy {
        ChatAdapter(adapterListener)
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
        with(viewModel) {
            sendMessage(binding.chatInputET.text.toString(), tag.toString(),requireContext().isNetworkAvailable())
            binding.chatInputET.text?.clear()
        }
    }
    private fun showMessages(viewModel: ChatUsersViewModel) {
        lifecycleScopeCollect(viewModel.showMessages()) { messages ->
            adapter.submitList(viewModel.filterMessages(messages,adapterListener))
        }
    }
}