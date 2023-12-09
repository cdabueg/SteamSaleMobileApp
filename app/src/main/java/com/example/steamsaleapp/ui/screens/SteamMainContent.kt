package com.example.steamsaleapp.ui.screens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.steamsaleapp.model.App
import com.example.steamsaleapp.model.Applist
import com.example.steamsaleapp.model.Data
import com.example.steamsaleapp.ui.screens.commonstates.Empty
import com.example.steamsaleapp.ui.screens.commonstates.Error
import com.example.steamsaleapp.ui.screens.commonstates.Loading
import com.example.steamsaleapp.viewmodel.SteamUiState
import com.example.steamsaleapp.viewmodel.SteamViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

/** [SteamMainContent] displaying status or result. */
@Composable
fun SteamMainContent(
    modifier: Modifier = Modifier
) {
    val steamViewModel: SteamViewModel = viewModel(factory = SteamViewModel.Factory)
    val steamUiState = steamViewModel.steamUiState
//    val refreshAction = steamViewModel::getSteamGamesList
    val refreshAction = steamViewModel::getGameDetails

    when (steamUiState) {
        is SteamUiState.Empty -> Empty(modifier = modifier.fillMaxSize())
        is SteamUiState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is SteamUiState.Error -> Error(refreshAction, modifier = modifier.fillMaxSize())
        is SteamUiState.SuccessList -> SteamGamesListGrid(
            steamUiState.gamesList.applist,
            modifier
        )
        is SteamUiState.SuccessDetails -> SteamGameDetailsCard(
            steamUiState.gamesDetails.x1325200.data,
            modifier
        )
    }
}

/** [SteamGameDetailsCard] displaying game details. */
@Composable
fun SteamGameDetailsCard(
    gameDetails: Data,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Text(text = "Name: ${gameDetails.name}")
        Text(text = "Description: ${gameDetails.shortDescription}")
        Text(text = "LogoUrl: ${gameDetails.capsuleImagev5}")
        Text(text = "BackgroundUrl: ${gameDetails.background}")
        Text(text = "Release Date: ${gameDetails.releaseDate?.date}")
        Text(text = "Categories: ${gameDetails.categories?.map { "${it?.description}" }?.joinToString(separator = ", ")}")
        Text(text = "Genres: ${gameDetails.genres?.map { "${it?.description}" }?.joinToString(separator = ", ")}")
        Text(text = "Developers: ${gameDetails.developers?.joinToString(separator = ", ")}")
        Text(text = "Publishers: ${gameDetails.publishers?.joinToString(separator = ", ")}")
        val platforms = mutableListOf<String>()
        if (gameDetails.platforms?.windows == true) {
            platforms.add("Windows")
        }
        if (gameDetails.platforms?.mac == true) {
            platforms.add("Mac")
        }
        if (gameDetails.platforms?.linux == true) {
            platforms.add("Linux")
        }
        Text(text = "Platforms: ${platforms.joinToString(separator = ", ")}")
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


//Button(onClick = {
//    isIconChanged = !isIconChanged
//
//    val beerDocRef =
//        fsInstance.collection("favorites").document(beerItem.id.toString())
//
//    // adding a beer to firestore document collection
//    if (isIconChanged) {
//        beerDocRef.set(beerItem)
//            .addOnSuccessListener {
//                Log.d("MJB", "Inserted ${beerItem.name}")
//            }
//            .addOnFailureListener { e ->
//                Log.d("Error", "${e.message}")
//            }
//    }else{
//        beerDocRef.delete()
//            .addOnSuccessListener {
//                Log.d("MJB", "Deleted ${beerItem.name}")
//            }
//            .addOnFailureListener{ e->
//                Log.d("Error", "${e.message}")
//            }
//    }
//}
//) {
//    Icon(
//        modifier = Modifier
//            .size(24.dp)
//            .scale(2.5f),
//        imageVector = if (isIconChanged) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
//        contentDescription = "Add a farvoite"
//    )
//}

//// Create a new user with a first and last name
//val user = hashMapOf(
//    "first" to "Ada",
//    "last" to "Lovelace",
//    "born" to 1815
//)
//
//// Add a new document with a generated ID
//db.collection("users")
//.add(user)
//.addOnSuccessListener { documentReference ->
//    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//}
//.addOnFailureListener { e ->
//    Log.w(TAG, "Error adding document", e)
//}