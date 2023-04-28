package com.example.space__chat.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.space__chat.data.model.ChatEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {
    @Query("SELECT * FROM messages")
    fun getAllMessages(): Flow<List<ChatEntity>>

    @Insert
    suspend fun insertMessages(vararg message : ChatEntity)
}