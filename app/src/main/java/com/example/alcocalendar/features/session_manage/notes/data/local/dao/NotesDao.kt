package com.example.alcocalendar.features.session_manage.notes.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.alcocalendar.features.session_manage.notes.data.local.entity.NoteEntity
import com.example.alcocalendar.features.session_manage.notes.data.local.entity.relations.DrinkingSessionAndNote
import java.time.LocalDate

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Query("DELETE FROM note WHERE date = :date")
    suspend fun deleteNotesByDate(date: LocalDate)

    @Transaction
    @Query("SELECT * FROM drinking_session WHERE date = :date")
    suspend fun getDrinkingSessionAndNote(date: LocalDate): DrinkingSessionAndNote?
}