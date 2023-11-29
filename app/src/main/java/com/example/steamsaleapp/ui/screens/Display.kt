package com.example.steamsaleapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.steamsaleapp.network.ScreenState

/**
 * Display displaying status or result.
 */
@Composable
fun Display(
    screenState: ScreenState,
    modifier: Modifier = Modifier
) {
    when (screenState) {
        is ScreenState.Error -> Error( modifier = modifier.fillMaxSize())
        is ScreenState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is ScreenState.Success -> Result(
            screenState.gamesList, modifier = modifier.fillMaxWidth()
        )

    }
}