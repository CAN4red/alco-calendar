package com.example.alcocalendar.features.session_manage.media.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.alcocalendar.features.session_manage.media.data.local.entity.MediaItemEntity
import com.example.alcocalendar.features.session_manage.media.data.local.entity.relations.DrinkingSessionWithMediaItems
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface MediaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMediaItem(mediaItem: MediaItemEntity)

    @Query("DELETE FROM media_item WHERE name = :fileName")
    suspend fun deleteMediaItemByName(fileName: String)

    @Transaction
    @Query("SELECT * FROM drinking_session WHERE date = :date")
    fun getDrinkingSessionWithMediaItems(date: LocalDate): Flow<DrinkingSessionWithMediaItems>
}