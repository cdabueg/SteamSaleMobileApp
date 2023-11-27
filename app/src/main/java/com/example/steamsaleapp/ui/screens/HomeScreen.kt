package com.example.steamsaleapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.steamsaleapp.R
import com.example.steamsaleapp.ui.theme.SteamSaleAppTheme

@Composable
fun HomeScreen(
    steamUiState: SteamUiState,
    modifier: Modifier = Modifier
) {
    when (steamUiState) {
        is SteamUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is SteamUiState.Success -> ResultScreen(
            steamUiState.games, modifier = modifier.fillMaxWidth()
        )

        is SteamUiState.Error -> ErrorScreen( modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}

/**
 * ResultScreen displaying number of games retrieved.
 */
@Composable
fun ResultScreen(games: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = games)
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    SteamSaleAppTheme {
        ResultScreen(stringResource(R.string.placeholder_result))
    }
}