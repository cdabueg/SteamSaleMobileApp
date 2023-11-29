package com.example.steamsaleapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Display displaying status or result.
 */
@Composable
fun Display(
    steamUiState: SteamUiState,
    modifier: Modifier = Modifier
) {
    when (steamUiState) {
        is SteamUiState.Error -> Error( modifier = modifier.fillMaxSize())
        is SteamUiState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is SteamUiState.Success -> Result(
            steamUiState.games, modifier = modifier.fillMaxWidth()
        )

    }
}