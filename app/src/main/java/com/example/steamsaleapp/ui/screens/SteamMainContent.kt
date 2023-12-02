package com.example.steamsaleapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.steamsaleapp.model.SteamGamesList
import com.example.steamsaleapp.ui.screens.commonstates.Error
import com.example.steamsaleapp.ui.screens.commonstates.Loading
import com.example.steamsaleapp.viewmodel.SteamUiState

/**
 * SteamMainContent displaying status or result.
 */
@Composable
fun SteamMainContent(
    steamUiState: SteamUiState,
    modifier: Modifier = Modifier
) {
    when (steamUiState) {
        is SteamUiState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is SteamUiState.Error -> Error( modifier = modifier.fillMaxSize())
        is SteamUiState.Success -> ResultSteam(
            steamUiState.gamesList, modifier = modifier.fillMaxWidth()
        )
    }
}

/**
 * Result displaying number of games retrieved.
 */
@Composable
fun ResultSteam(gamesList: SteamGamesList, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = gamesList.toString())
    }
}