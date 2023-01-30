package com.example.homeapp.data

import androidx.compose.ui.graphics.Color
import com.example.homeapp.model.Book
import com.example.homeapp.model.BookPage
import com.example.homeapp.model.Difficulty

val pink = Color(255,244,243)
val yellow = Color(254,244,223)
val blue = Color(16,32,90)
val allWords: List<BookPage> = listOf(
    BookPage(Book("Margo1", "Margo", Difficulty()), pink),
    BookPage(Book("Margo2", "Margo", Difficulty()), yellow),
    BookPage(Book("Margo3", "Margo", Difficulty()), blue),
    BookPage(Book("Margo4", "Margo", Difficulty()), pink)

)

