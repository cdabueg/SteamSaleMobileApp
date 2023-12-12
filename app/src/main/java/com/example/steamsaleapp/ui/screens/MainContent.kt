package com.example.steamsaleapp.ui.screens

import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.steamsaleapp.model.App
import com.example.steamsaleapp.model.Applist
import com.example.steamsaleapp.model.Data
import com.example.steamsaleapp.model.GameData
import com.example.steamsaleapp.ui.screens.commonstates.Empty
import com.example.steamsaleapp.ui.screens.commonstates.Error
import com.example.steamsaleapp.ui.screens.commonstates.Loading
import com.example.steamsaleapp.viewmodel.SteamUiState
import com.example.steamsaleapp.viewmodel.MainViewModel

/** [MainContent] displaying status or result. */
@Composable
fun MainContent(
    modifier: Modifier = Modifier
) {
    val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
    val steamUiState = mainViewModel.steamUiState
    val refreshAction = mainViewModel::getGameDetails

    when (steamUiState) {
        is SteamUiState.Empty -> Empty(modifier = modifier.fillMaxSize())
        is SteamUiState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is SteamUiState.Error -> Error(refreshAction, modifier = modifier.fillMaxSize())
        is SteamUiState.SuccessList -> SteamGamesListGrid(
            steamUiState.gamesList.applist,
            modifier
        )
        is SteamUiState.SuccessDetails -> SteamGameDetailsCard(
            steamUiState.gamesDetails,
            modifier
        )
    }
}

/** [SteamGameDetailsCard] displaying game details. */
@Composable
fun SteamGameDetailsCard(
    gameDetails: HashMap<String, GameData>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Name: ${gameDetails[gameDetails.keys.first()]?.data?.name}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Description: ${gameDetails[gameDetails.keys.first()]?.data?.shortDescription}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "LogoUrl: ${gameDetails[gameDetails.keys.first()]?.data?.capsuleImagev5}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "BackgroundUrl: ${gameDetails[gameDetails.keys.first()]?.data?.background}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Release Date: ${gameDetails[gameDetails.keys.first()]?.data?.releaseDate?.date}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(
                text = "Categories: ${
                    gameDetails[gameDetails.keys.first()]?.data?.categories?.map { "${it?.description}" }
                        ?.joinToString(separator = ", ")
                }"
            )
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(
                text = "Genres: ${
                    gameDetails[gameDetails.keys.first()]?.data?.genres?.map { "${it?.description}" }?.joinToString(separator = ", ")
                }"
            )
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Developers: ${gameDetails[gameDetails.keys.first()]?.data?.developers?.joinToString(separator = ", ")}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Publishers: ${gameDetails[gameDetails.keys.first()]?.data?.publishers?.joinToString(separator = ", ")}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
        }
    }
}

/** [SteamGamesListCard] displaying game details. */
@Composable
fun SteamGamesListCard(
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

/** [SteamGamesListGrid] displaying list of games. */
@Composable
fun SteamGamesListGrid(
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
            game -> SteamGamesListCard(
            game,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .aspectRatio(1.5f)
            )
        }
    }
}