package com.example.steamsaleapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.steamsaleapp.model.App
import com.example.steamsaleapp.model.Applist
import com.example.steamsaleapp.model.SteamGamesList
import com.example.steamsaleapp.ui.screens.commonstates.Error
import com.example.steamsaleapp.ui.screens.commonstates.Loading
import com.example.steamsaleapp.ui.theme.SteamSaleAppTheme
import com.example.steamsaleapp.viewmodel.SteamUiState

/**
 * SteamMainContent displaying status or result.
 */
@Composable
fun SteamMainContent(
    steamUiState: SteamUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (steamUiState) {
        is SteamUiState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is SteamUiState.Error -> Error(retryAction, modifier = modifier.fillMaxSize())

//        is SteamUiState.Success -> ResultSteam(
//            steamUiState.gamesList, modifier = modifier.fillMaxWidth()
//        )
        is SteamUiState.Success -> SteamSaleTable(
            steamUiState.gamesList.applist,
            modifier
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

@Composable
fun SteamGameCard(
    game: App,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Text(text = game.appid.toString())
        Text(text = game.name)
    }
}

@Composable
fun SteamSaleTable(
    games: Applist,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(
            items = games.apps,
            key = { game -> game.appid }
        ) {
            game -> SteamGameCard(
            game,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .aspectRatio(1.5f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSteamMainContent() {
    SteamSaleAppTheme {

    }
}