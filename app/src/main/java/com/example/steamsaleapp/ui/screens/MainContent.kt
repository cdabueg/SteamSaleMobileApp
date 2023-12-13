package com.example.steamsaleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.steamsaleapp.model.FirestoreGame
import com.example.steamsaleapp.model.FirestoreGameslist
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
    val retryAction = mainViewModel::getFirestoreGamesList

    when (steamUiState) {
        is SteamUiState.Empty -> Empty(modifier = modifier.fillMaxSize())
        is SteamUiState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is SteamUiState.Error -> Error(retryAction, modifier = modifier.fillMaxSize())
        is SteamUiState.SuccessList -> FirestoreGamesListGrid(
            steamUiState.gamesList,
            modifier
        )
        is SteamUiState.SuccessDetails -> FirestoreGameDetailsCard(
            steamUiState.gamesDetails,
            modifier
        )
    }
}

@Composable
fun FirestoreGamesListGrid(
    games: FirestoreGameslist,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1), // Set to 1 to make each item fill the entire row
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(
            items = games.firestoreGamesList,
            key = { game -> game.gameId.toString() }
        ) { game ->
            FirestoreGamesListCard(
                game,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(4f)
            )
        }
    }
}


@Composable
fun FirestoreGamesListCard(
    game: FirestoreGame,
    modifier: Modifier = Modifier,
) {
    // State variable to control the visibility of the details dialog
    var isDetailsDialogVisible by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = { isDetailsDialogVisible = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)
                    .height(40.dp)
            ) {
                Text(
                    text = "Name: ${game.name}",
                    modifier = Modifier
                        .padding(vertical = 0.dp, horizontal = 0.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Discount: ${game.discountPercent.toString()}%")
                Text(text = "Final Price: $${game.finalPrice?.times(0.01)}")
            }
        }
    }

    // Display the details dialog when the state variable is true
    if (isDetailsDialogVisible) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog
                isDetailsDialogVisible = false
            },
            title = { Text("Game Details") },
            text = {
                // Display the FirestoreGameDetailsCard in the dialog
                FirestoreGameDetailsCard(game)
            },
            confirmButton = {
                // Dismiss the dialog when the user clicks the confirm button
                Button(onClick = { isDetailsDialogVisible = false }) {
                    Text("Close")
                }
            }
        )
    }
}

/** [FirestoreGameDetailsCard] displaying game details. */
@Composable
fun FirestoreGameDetailsCard(
    gameDetails: FirestoreGame,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = gameDetails.logoUrl),
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .size(250.dp).clip(RoundedCornerShape(16.dp))
//                        .aspectRatio(16f/9f)
                )
            }
            Text(
                text = "${gameDetails.name}",
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 0.dp),
                fontSize = 20.sp, // Adjust the fontSize as needed
                textAlign = TextAlign.Center
            )
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Discount: ${gameDetails.discountPercent}%")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Final Price: $${String.format("%.2f", gameDetails.finalPrice?.times(0.01))}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Description: ${gameDetails.shortDescription}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Release Date: ${gameDetails.releaseDate}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Developers: ${gameDetails.developers?.joinToString(separator = ", ")}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
            Text(text = "Publishers: ${gameDetails.publishers?.joinToString(separator = ", ")}")
            Divider(modifier = Modifier.padding(vertical = 1.dp))
//            Text(text = "BackgroundUrl: ${gameDetails.background}")
//            Divider(modifier = Modifier.padding(vertical = 1.dp))
        }
    }
}