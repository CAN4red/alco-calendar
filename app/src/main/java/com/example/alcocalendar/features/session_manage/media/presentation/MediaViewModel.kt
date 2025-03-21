package com.example.alcocalendar.features.session_manage.media.presentation

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.features.session_manage.SessionManageUtils.getDate
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.use_case.delete_media.DeleteMediaUseCase
import com.example.alcocalendar.features.session_manage.media.domain.use_case.get_media.GetMediaUseCase
import com.example.alcocalendar.features.session_manage.media.domain.use_case.save_media.SaveMediaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MediaViewModel @Inject constructor(
    private val getMediaUseCase: GetMediaUseCase,
    private val saveMediaUseCase: SaveMediaUseCase,
    private val deleteMediaUseCase: DeleteMediaUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(MediaState())
    val state: StateFlow<MediaState> get() = _state

    init {
        loadData(savedStateHandle.getDate())
    }

    private fun loadData(date: LocalDate) {
        val mediaFlow = getMediaUseCase(date)
        viewModelScope.launch(Dispatchers.IO) {
            mediaFlow.collect { media ->
                _state.update { currentState ->
                    currentState.copy(
                        date = date,
                        mediaItems = media
                    )
                }
            }
        }
    }

    fun onEvent(event: MediaEvent) {
        when (event) {
            is MediaEvent.ExpandMedia -> handleExpansion(shouldExpand = true)
            is MediaEvent.CollapseMedia -> handleExpansion(shouldExpand = false)
            is MediaEvent.EnterSelectionMode -> handleSelectionMode(shouldEnterSelectionMode = true)
            is MediaEvent.ExitSelectionMode -> handleSelectionMode(shouldEnterSelectionMode = false)
            is MediaEvent.SelectMedia -> handleSelection(
                mediaItem = event.mediaItem,
                shouldAdd = true
            )

            is MediaEvent.UnselectMedia -> handleSelection(
                mediaItem = event.mediaItem,
                shouldAdd = false
            )

            is MediaEvent.SaveMedia -> handleSave(uris = event.uris)
            is MediaEvent.DeleteMedia -> handleDelete(mediaItem = event.mediaItem)
        }
    }

    private fun handleExpansion(shouldExpand: Boolean) {
        _state.update { it.copy(isExpanded = shouldExpand) }
    }

    private fun handleSelectionMode(shouldEnterSelectionMode: Boolean) {
        _state.update { it.copy(isInSelectionMode = shouldEnterSelectionMode) }
    }

    private fun handleSelection(mediaItem: MediaItem, shouldAdd: Boolean) {
        _state.update { current ->
            val updatedSelection = if (shouldAdd) {
                current.selectedMedia + mediaItem
            } else {
                current.selectedMedia.filter { it != mediaItem }
            }
            current.copy(selectedMedia = updatedSelection)
        }
    }

    private fun handleSave(uris: List<Uri>) {
        viewModelScope.launch(Dispatchers.IO) {
            uris.map { externalUri ->
                async { saveMediaUseCase(externalUri.toString(), _state.value.date) }
            }.awaitAll()
        }
        clearSelection()
        loadData(_state.value.date)
    }

    private fun handleDelete(mediaItem: MediaItem) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteMediaUseCase(mediaItem.name)
        }
    }

    private fun clearSelection() {
        _state.update { it.copy(selectedMedia = emptyList()) }
    }
}
