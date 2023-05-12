package com.space.space__chat.presentation.vm

import androidx.lifecycle.ViewModel
import com.space.space__chat.domain.ChatRepository
import com.space.space__chat.domain.model.MessageModel
import com.space.space__chat.utils.extensions.getTimeInMills
import com.space.space__chat.utils.extensions.viewModelScope
import kotlinx.coroutines.flow.Flow

/**
 * The ChatUsersViewModel class is a ViewModel class that interacts with the ChatRepository to
 * handle chat message data and provide necessary functionality to the ChatUsersFragment.
 */

class ChatUsersViewModel(private val chatRepository: ChatRepository) : ViewModel() {

    fun showMessages(): Flow<List<MessageModel>> = chatRepository.getMessages()

    fun filterMessages(messages: List<MessageModel>, listener: String): List<MessageModel> {
        return messages.filter {
            it.sender == listener || it.isOnline
        }
    }

    private fun provideMessageModel(editTextInput: String, userId: String, isOnline: Boolean) =
        MessageModel(
            sender = userId,
            message = editTextInput,
            timeStamp = getTimeInMills(),
            isOnline = isOnline
        )

    fun sendMessage(messageInput: String, userId: String, isOnline: Boolean) {
        viewModelScope {
            chatRepository.insertMessages(provideMessageModel(messageInput, userId, isOnline))
        }
    }
}