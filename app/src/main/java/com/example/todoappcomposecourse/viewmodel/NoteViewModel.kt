package com.example.todoappcomposecourse.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.todoappcomposecourse.data.NoteData
import com.example.todoappcomposecourse.model.Note

class NoteViewModel : ViewModel() {
    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteData().loadNotes())
    }

    fun addNote(note:Note){
        noteList.add(note)
    }

    fun removeNote(note:Note){
        noteList.remove(note)
    }

    fun getAllNotest(): List<Note>{
        return noteList
    }
}