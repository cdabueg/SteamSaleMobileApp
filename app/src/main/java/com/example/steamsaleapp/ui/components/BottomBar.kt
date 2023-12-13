package com.example.steamsaleapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.steamsaleapp.ui.screens.SearchForm
import com.example.steamsaleapp.viewmodel.MainViewModel

@Composable
fun BottomBar(){
    var search by rememberSaveable { mutableStateOf("") }
    val showDialog = remember { mutableStateOf(false) }
    val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
    val refreshAction = mainViewModel::getFirestoreGamesList
    val updateDb = mainViewModel::updateDb
    // Dialog box for search form
    if (showDialog.value) {
        Dialog(onDismissRequest = {showDialog.value = false}) {
            SearchForm(
                search = search,
                onSearchChange = {search = it},
                onCancel = {showDialog.value = false},
                onSubmit = {
                    showDialog.value = false
                }
            )
        }
    }
    BottomAppBar(
        modifier = Modifier,
        actions = {
            Spacer(Modifier.weight(1f))
            // Search button
            IconButton(
                modifier = Modifier,
                onClick = {
                    showDialog.value = true
                }
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search List"
                )
            }
            Spacer(Modifier.weight(1f))
            // Refresh button
            IconButton(
                modifier = Modifier,
                onClick = {
                    refreshAction()
                }
            ) {
                Icon(
                    Icons.Filled.Refresh,
                    contentDescription = "Refresh List",
                )
            }
            Spacer(Modifier.weight(1f))
            // Update database button
            IconButton(
                modifier = Modifier,
                onClick = {
                    updateDb()
                }
            ) {
                Icon(
                    Icons.Filled.Build,
                    contentDescription = "Build List",
                )
            }
            Spacer(Modifier.weight(1f))
        },
    )
}

