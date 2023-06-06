package com.example.todoappcomposecourse.data

import com.example.todoappcomposecourse.model.Note

class NoteData{
    fun loadNotes() : List<Note>{
        return listOf(
            Note(title = "A good day", description = "We went on a vacation by the last week"),
            Note(title = "A good day", description = "We went on a vacation by the last week"),
            Note(title = "A good day", description = "We went on a vacation by the last week"),
            Note(title = "A good day", description = "We went on a vacation by the last week"),
            Note(title = "A good day", description = "We went on a vacation by the last week"),
            Note(title = "A good day", description = "We went on a vacation by the last week"),
            Note(title = "A good day", description = "We went on a vacation by the last week"),
            Note(title = "A good day", description = "We went on a vacation by the last week"),
            Note(title = "A good day", description = "We went on a vacation by the last week"),
        )
    }
}