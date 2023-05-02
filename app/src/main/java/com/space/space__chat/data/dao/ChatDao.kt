package com.space.space__chat.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.space.space__chat.data.entity.ChatEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {
    @Query("SELECT * FROM messages")
    fun getAllMessages(): Flow<List<ChatEntity>>

    @Insert
    suspend fun insertMessages(message : ChatEntity)
}