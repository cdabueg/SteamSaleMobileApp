package com.example.steamsaleapp.ui.screens.commonstates

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Empty displaying empty screen.
 */
@Composable
fun Empty(modifier: Modifier = Modifier) {
    Text(text = "Click the refresh button to fetch data.", modifier = modifier.fillMaxSize())
}