package com.example.alcocalendar.features.session_manage.notes.di

import com.example.alcocalendar.features.session_manage.notes.data.local.dao.NotesDao
import com.example.alcocalendar.features.session_manage.notes.data.repository.NotesRepositoryImpl
import com.example.alcocalendar.features.session_manage.notes.domain.repository.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotesRepositoryModule {
    @Provides
    @Singleton
    fun provideNotesRepository(notesDao: NotesDao): NotesRepository {
        return NotesRepositoryImpl(notesDao)
    }
}