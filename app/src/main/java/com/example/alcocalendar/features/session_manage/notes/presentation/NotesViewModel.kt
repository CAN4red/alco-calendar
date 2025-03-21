package com.example.alcocalendar.features.session_manage.notes.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.features.session_manage.SessionManageUtils.getDate
import com.example.alcocalendar.features.session_manage.notes.domain.use_case.get_initial_note.GetInitialNoteUseCase
import com.example.alcocalendar.features.session_manage.notes.domain.use_case.save_note.SaveNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getInitialNoteUseCase: GetInitialNoteUseCase,
    private val saveNoteUseCase: SaveNoteUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(NotesState())
    val state: StateFlow<NotesState> get() = _state

    init {
        loadData(savedStateHandle.getDate())
    }

    private fun loadData(date: LocalDate) {
        val noteFlow = getInitialNoteUseCase(date)
        viewModelScope.launch(Dispatchers.IO) {
            noteFlow.collect { note ->
                _state.update { currentState ->
                    currentState.copy(note = note)
                }
            }
        }
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.SetNoteContent -> {
                handleSetNoteContent(event.content)
            }

            is NotesEvent.SaveNote -> {
                handleSaveNote()
            }

            is NotesEvent.ExpandNote -> {
                handleExpandNote()
            }

            is NotesEvent.CollapseNote -> {
                handleCollapseNote()
            }
        }
    }

    private fun handleSetNoteContent(content: String) {
        _state.update { currentState ->
            val updatedNote = currentState.note.copy(content = content)
            currentState.copy(note = updatedNote)
        }
    }

    private fun handleSaveNote() {
        viewModelScope.launch {
            saveNoteUseCase(_state.value.note)
        }
    }

    private fun handleExpandNote() {
        _state.update { currentState ->
            currentState.copy(isExpanded = true)
        }
    }

    private fun handleCollapseNote() {
        _state.update { currentState ->
            currentState.copy(isExpanded = false)
        }
    }

    override fun onCleared() {
        handleSaveNote()
        super.onCleared()
    }
}