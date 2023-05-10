package com.space.space__chat.presentation.vm

import androidx.lifecycle.ViewModel
import com.space.space__chat.domain.ChatRepository
import com.space.space__chat.domain.model.MessageModel
import com.space.space__chat.utils.extensions.getTimeInMills
import com.space.space__chat.utils.extensions.viewModelScope
import kotlinx.coroutines.flow.Flow

class ChatUsersViewModel(private val chatRepository: ChatRepository) : ViewModel() {

    fun showMessages(): Flow<List<MessageModel>> = chatRepository.getMessages()

     fun filterMessages(messages: List<MessageModel>, adapterListener:() ->String) : List<MessageModel> {
        return messages.filter {
            it.sender == adapterListener.invoke() || it.isOnline
        }
    }

    private fun provideMessageModel(editTextInput: String, tag: String, isOnline: Boolean) =
        MessageModel(
            sender = tag,
            message = editTextInput,
            timeStamp = getTimeInMills(),
            isOnline = isOnline
        )
    fun sendMessage(messageInput: String, tag: String, isOnline: Boolean) {
        viewModelScope {
            chatRepository.insertMessages(provideMessageModel(messageInput, tag, isOnline))
        }
    }
}