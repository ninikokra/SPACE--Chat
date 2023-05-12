package com.space.space__chat.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.space.space__chat.data.entity.MessageEntity
import kotlinx.coroutines.flow.Flow

/**
 * This class is an interface that provides methods to interact with a database table named "messages".
 * It contains two methods, one to retrieve all messages from the table and another to insert a new message.
 */

@Dao
interface ChatDao {
    @Query("SELECT * FROM messages")
    fun getAllMessages(): Flow<List<MessageEntity>>

    @Insert
    suspend fun insertMessages(message : MessageEntity)
}