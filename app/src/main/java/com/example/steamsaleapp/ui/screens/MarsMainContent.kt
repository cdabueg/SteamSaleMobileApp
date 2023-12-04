package com.example.steamsaleapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.steamsaleapp.R
import com.example.steamsaleapp.model.MarsPhoto
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
//        is MarsUiState.Success -> ResultMars(
//            marsUiState.photos, modifier = modifier.fillMaxWidth()
//        )
        is MarsUiState.Success -> MarsPhotoCard(
            photo = marsUiState.photos,
            modifier = modifier
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

@Composable
fun MarsPhotoCard(photo: MarsPhoto, modifier: Modifier = Modifier) {
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

