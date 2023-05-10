package com.space.space__chat.presentation.ui

import com.space.space__chat.presentation.base.BaseChatFragment


class ChatUsersFragmentFirst : BaseChatFragment(){
    override fun userId(): String = "First"
}
class ChatUsersFragmentSecond : BaseChatFragment() {
    override fun userId(): String = "Second"
}