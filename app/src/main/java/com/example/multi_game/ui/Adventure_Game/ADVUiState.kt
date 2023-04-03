package com.example.adventure_game.ui

import com.example.multi_game.data.Storys

data class ADVUiState(
    val currentStorys: Storys,
    val choice: List<String>,
    val index: Int,
    val ending: Int
)