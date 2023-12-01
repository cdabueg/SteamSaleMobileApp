package com.example.steamsaleapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.steamsaleapp.ui.screens.commonstates.Error
import com.example.steamsaleapp.ui.screens.commonstates.Loading
import com.example.steamsaleapp.viewmodel.MarsUiState
import com.example.steamsaleapp.viewmodel.MarsViewModel

/**
 * MarsMainContent displaying status or result.
 */
@Composable
fun MarsMainContent(
    marsUiState: MarsUiState,
    modifier: Modifier = Modifier
) {
    when (marsUiState) {
        is MarsUiState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is MarsUiState.Error -> Error( modifier = modifier.fillMaxSize())
        is MarsUiState.Success -> ResultMars(
            marsUiState.photos, modifier = modifier.fillMaxWidth()
        )
    }
}

/**
 * ResultMars displaying number of photos retrieved.
 */
@Composable
fun ResultMars(photos: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = photos)
    }
}

