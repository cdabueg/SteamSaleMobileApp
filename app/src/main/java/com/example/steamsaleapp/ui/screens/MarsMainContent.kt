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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.steamsaleapp.R
import com.example.steamsaleapp.model.MarsPhoto
import com.example.steamsaleapp.ui.screens.commonstates.Error
import com.example.steamsaleapp.ui.screens.commonstates.Loading
import com.example.steamsaleapp.ui.theme.SteamSaleAppTheme
import com.example.steamsaleapp.viewmodel.MarsUiState

/**
 * MarsMainContent displaying status or result.
 */
@Composable
fun MarsMainContent(
    marsUiState: MarsUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (marsUiState) {
        is MarsUiState.Loading -> Loading(modifier = modifier.fillMaxSize())
        is MarsUiState.Error -> Error(retryAction, modifier = modifier.fillMaxSize())

//        is MarsUiState.Success -> ResultMars(
//            marsUiState.photos, modifier = modifier.fillMaxWidth()
//        )
//        // Display the first photo
//        is MarsUiState.Success -> MarsPhotoCard(
//            photo = marsUiState.photos,
//            modifier = modifier
//        )
        // Display all photos
        is MarsUiState.Success -> PhotosGridScreen(
            marsUiState.photos,
            modifier)
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

/**
 * MarsPhotoCard displaying a single photo.
 */
@Composable
fun MarsPhotoCard(
    photo: MarsPhoto,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(photo.imgSrc)
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.mars_photo),
            // Fills the entire screen with the image
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PhotosGridScreen(
    photos: List<MarsPhoto>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(
            items = photos,
            key = { photo -> photo.id }
        ) {
            photo -> MarsPhotoCard(
            photo,
            modifier = modifier
                .padding(4.dp)
                .fillMaxWidth()
                .aspectRatio(1.5f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotosGridScreenPreview() {
    SteamSaleAppTheme {
        val mockData = List(10) { MarsPhoto("$it", "") }
        PhotosGridScreen(mockData)
    }
}