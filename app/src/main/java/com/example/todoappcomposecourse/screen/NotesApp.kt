package com.example.todoappcomposecourse.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoappcomposecourse.viewmodel.NoteViewModel

@Composable
fun NotesApp(
    noteViewModel: NoteViewModel = viewModel()
) {
    val notesList = noteViewModel.noteList.collectAsState().value

    NoteScreen(
        notes = notesList,
        onAddNote = {
            noteViewModel.addNote(note = it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(note = it)
        }
    )
}