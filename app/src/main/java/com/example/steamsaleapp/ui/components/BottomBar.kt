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
import com.example.steamsaleapp.ui.screens.SearchForm

@Composable
fun BottomBar(){
    var search by rememberSaveable { mutableStateOf("") }
    val showDialog = remember { mutableStateOf(false) }

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
                onClick = { showDialog.value = true }
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search List"
                )
            }
            Spacer(Modifier.weight(1f))
            // Reset button
            IconButton(
                modifier = Modifier,
                onClick = { /* do something */ }
            ) {
                Icon(
                    Icons.Filled.Refresh,
                    contentDescription = "Reset List",
                )
            }
            Spacer(Modifier.weight(1f))
            // Update database button
            IconButton(
                modifier = Modifier,
                onClick = {

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