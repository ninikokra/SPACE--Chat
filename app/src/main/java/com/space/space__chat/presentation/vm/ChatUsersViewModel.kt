package com.space.space__chat.presentation.vm

import androidx.lifecycle.ViewModel
import com.space.space__chat.domain.ChatRepository
import com.space.space__chat.domain.model.MessageModel
import com.space.space__chat.utils.extensions.getTimeInMills
import com.space.space__chat.utils.extensions.viewModelScope
import kotlinx.coroutines.flow.Flow

/**
 * [ChatUsersViewModel] is a ViewModel class that interacts with the ChatRepository to
 * handle chat message data and provide necessary functionality to the ChatUsersFragment.
 */

class ChatUsersViewModel(private val chatRepository: ChatRepository) : ViewModel() {

    /**
     * [showMessages]Retrieves and returns a flow of the list of [MessageModel] representing the messages to be shown.
     * @return A [Flow] emitting a list of [MessageModel] objects representing the messages.
     */
    fun showMessages(): Flow<List<MessageModel>> = chatRepository.getMessages()

    /**
     *[filterMessages] Filters the given list of [MessageModel] based on the provided listener.
     * @param messages The list of [MessageModel] to be filtered.
     * @param listener The listener's name used for filtering.
     * @return A new list of [MessageModel] that includes messages where the sender matches the listener or
     * the sender is online.
     */
    fun filterMessages(messages: List<MessageModel>, listener: String): List<MessageModel> {
        return messages.filter {
            it.sender == listener || it.isOnline
        }
    }

    /**
     * [provideMessageModel]Creates and returns a new [MessageModel] object based on the provided input parameters.
     * @param editTextInput The content of the message.
     * @param userId The ID of the user sending the message.
     * @param isOnline Flag indicating whether the sender is currently online.
     * @return A new [MessageModel] object representing the message with the provided input.
     */
    private fun provideMessageModel(editTextInput: String, userId: String, isOnline: Boolean) =
        MessageModel(
            sender = userId,
            message = editTextInput,
            timeStamp = getTimeInMills(),
            isOnline = isOnline
        )

    /**
     * [sendMessage]Sends a message with the provided input to a user identified by the user ID.
     * @param messageInput The content of the message to be sent.
     * @param userId The ID of the user who will receive the message.
     * @param isOnline Flag indicating whether the user is currently online.
     */

    fun sendMessage(messageInput: String, userId: String, isOnline: Boolean) {
        viewModelScope {
            chatRepository.insertMessages(provideMessageModel(messageInput, userId, isOnline))
        }
    }
}