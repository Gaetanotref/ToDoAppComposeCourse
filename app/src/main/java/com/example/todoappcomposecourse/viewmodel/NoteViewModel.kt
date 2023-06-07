package com.example.todoappcomposecourse.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoappcomposecourse.data.NoteData
import com.example.todoappcomposecourse.model.Note
import com.example.todoappcomposecourse.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect { listOfNote ->
                    if (listOfNote.isNullOrEmpty()) {
                        Log.d("LIST NOTE", "EMPTY LIST")
                    } else {
                        _noteList.value = listOfNote
                    }
                }
        }
    }

     fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note = note) }

     fun update(note: Note) = viewModelScope.launch { repository.updateNote(note = note) }
     fun removeNote(note: Note) =
        viewModelScope.launch { repository.deleteNote(note = note) }

     fun removeAll() = viewModelScope.launch { repository.deleteAllNotes() }

}