package com.space.space__chat.presentation.ui

import com.space.space__chat.presentation.base.BaseChatFragment

/**
 *
 * [ChatUsersFragmentFirst][ChatUsersFragmentSecond] are two concrete implementations of the BaseChatFragment class.
 * They override the userId() function to provide a specific user ID for each fragment.
 */
class ChatUsersFragmentFirst : BaseChatFragment() {
    override fun userId(): String = "First"
}
class ChatUsersFragmentSecond : BaseChatFragment() {
    override fun userId(): String = "Second"
}

