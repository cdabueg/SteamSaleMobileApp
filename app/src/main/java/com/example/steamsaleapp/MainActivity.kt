package com.example.steamsaleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.steamsaleapp.ui.SteamGamesApp
import com.example.steamsaleapp.ui.theme.SteamSaleAppTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SteamSaleAppTheme {
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

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Scaffold(
//                        topBar = {
//                            TopAppBar(
//                                title = {
//                                    Text(text = "Steam Games on Sale")
//                                },
//                                colors = TopAppBarDefaults.smallTopAppBarColors(
//                                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
//                                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
//                                )
//                            )
//                        },
//                        bottomBar = {
//                            BottomAppBar(
//                                modifier = Modifier,
//                                actions = {
//                                    Spacer(Modifier.weight(1f))
//                                    IconButton(
//                                        modifier = Modifier,
//                                        onClick = { showDialog.value = true }
//                                    ) {
//                                        Icon(
//                                            Icons.Filled.Search,
//                                            contentDescription = "Search List"
//                                        )
//                                    }
//                                    Spacer(Modifier.weight(1f))
//                                    IconButton(
//                                        modifier = Modifier,
//                                        onClick = { /* do something */ }
//                                    ) {
//                                        Icon(
//                                            Icons.Filled.Refresh,
//                                            contentDescription = "Reset List",
//                                        )
//                                    }
//                                    Spacer(Modifier.weight(1f))
//                                    IconButton(
//                                        modifier = Modifier,
//                                        onClick = { /* do something */ }
//                                    ) {
//                                        Icon(
//                                            Icons.Filled.Build,
//                                            contentDescription = "Build List",
//                                        )
//                                    }
//                                    Spacer(Modifier.weight(1f))
//                                },
//                            )
//                        },
//                    ) { values ->
//                        LazyColumn(contentPadding = values, userScrollEnabled = true) {
//                            items(20) {
//
//                            }
//                        }
//                    }
                    SteamGamesApp()
                }
            }
        }
    }
}

