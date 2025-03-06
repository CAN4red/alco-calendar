package com.example.alcocalendar.features.session_manage.notes.di

import com.example.alcocalendar.core.data.local.DrinkingSessionDatabase
import com.example.alcocalendar.features.session_manage.notes.data.local.dao.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotesDaoModule {
    @Provides
    @Singleton
    fun provideNotesDao(db: DrinkingSessionDatabase): NotesDao {
        return db.notesDao
    }
}