package com.example.steamsaleapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.steamsaleapp.model.GamesList

/**
 * Result displaying number of games retrieved.
 */
@Composable
fun Result(games: GamesList, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = "Retrieved ${games.apps?.size} Steam Games")
    }
}