package com.space.space__chat.presentation.base

import com.space.space__chat.R
import com.space.space__chat.databinding.FragmentChatUsersBinding
import com.space.space__chat.presentation.ui.adapter.AdapterListener
import com.space.space__chat.presentation.ui.adapter.ChatAdapter
import com.space.space__chat.presentation.vm.ChatUsersViewModel
import com.space.space__chat.utils.extensions.isNetworkAvailable
import com.space.space__chat.utils.extensions.lifecycleScopeCollect
import com.space.space__chat.utils.extensions.viewBinding
import kotlin.reflect.KClass

open class BaseChatFragment : BaseFragment<ChatUsersViewModel>() {

    private val binding by viewBinding(FragmentChatUsersBinding::bind)

    override val viewModelClass: KClass<ChatUsersViewModel>
        get() = ChatUsersViewModel::class

    override val layout: Int
        get() = R.layout.fragment_chat_users

    private val listener = object : AdapterListener {
        override fun getUserId(): String = userId()
    }
    protected open fun userId(): String = userId()

    private val adapter by lazy {
        ChatAdapter(listener)
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
            sendMessage(
                binding.chatInputET.text.toString(),userId(),
                requireContext().isNetworkAvailable()
            )
            binding.chatInputET.text?.clear()
        }
    }
    private fun showMessages(viewModel: ChatUsersViewModel) {
        lifecycleScopeCollect(viewModel.showMessages()) { messages ->
            adapter.submitList(viewModel.filterMessages(messages, userId()))
        }
    }
}