package com.example.multi_game.ui

import com.example.multi_game.data.Question

data class QGUiState(
    val currentQuestion: Question,
    val choice: List<String>,
    val score: Int,
    val quizIndex: Int,
    val isGameFinished: Boolean,
)