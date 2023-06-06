package com.example.todoappcomposecourse.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoappcomposecourse.viewmodel.NoteViewModel

@Composable
fun NotesApp(
    noteViewModel: NoteViewModel = viewModel()
) {
    val notesList = noteViewModel.getAllNotest()

    NoteScreen(
        notes = notesList,
        onAddNote = {
            noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        }
    )
}