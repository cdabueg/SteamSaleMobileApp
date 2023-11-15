package com.example.steamsaleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.steamsaleapp.API.API_Retrofit_Interface
import com.example.steamsaleapp.API.App
import com.example.steamsaleapp.API.RetrofitClient
import com.example.steamsaleapp.API.SteamApplistResponse


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    private val api: API_Retrofit_Interface = RetrofitClient.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var showDialog by remember { mutableStateOf(false) }
            var steamAppList by remember { mutableStateOf<List<App>>(emptyList()) }

            LaunchedEffect(Unit) {
                val response = api.getSteamApplist().execute()

                if (response.isSuccessful) {
                    val appListResponse = response.body()
                    appListResponse?.applist?.apps?.let {
                        steamAppList = it.take(5) // Limiting to 20 items for demonstration
                    }
                }
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Steam Games on Sale")
                            },
                            colors = TopAppBarDefaults.smallTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            modifier = Modifier,
                            actions = {
                                Spacer(Modifier.weight(1f))
                                IconButton(
                                    modifier = Modifier,
                                    onClick = { showDialog = true }
                                ) {
                                    Icon(
                                        Icons.Filled.Search,
                                        contentDescription = "Search List"
                                    )
                                }
                                Spacer(Modifier.weight(1f))
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
                                IconButton(
                                    modifier = Modifier,
                                    onClick = { /* do something */ }
                                ) {
                                    Icon(
                                        Icons.Filled.Build,
                                        contentDescription = "Build List",
                                    )
                                }
                                Spacer(Modifier.weight(1f))
                            },
                        )
                    },
                ) { values ->
                    LazyColumn(contentPadding = values, userScrollEnabled = true) {
                        items(steamAppList) { app ->
                            Text(
                                text = "App ID: ${app.appid}, App Name: ${app.name}",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}