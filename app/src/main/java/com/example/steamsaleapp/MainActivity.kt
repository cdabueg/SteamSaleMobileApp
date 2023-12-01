package com.example.steamsaleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.steamsaleapp.ui.components.BottomBar
import com.example.steamsaleapp.ui.components.TopBar
import com.example.steamsaleapp.ui.screens.MarsMainContent
import com.example.steamsaleapp.ui.screens.SteamMainContent
import com.example.steamsaleapp.viewmodel.MarsViewModel
import com.example.steamsaleapp.ui.theme.SteamSaleAppTheme
import com.example.steamsaleapp.viewmodel.SteamViewModel

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SteamSaleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = { TopBar()},
                        bottomBar = { BottomBar()},
                    ) {
                        innerPadding ->
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier
                                .padding(innerPadding),
                        ) {
//                            val steamViewModel: SteamViewModel = viewModel(factory = SteamViewModel.Factory)
//                            SteamMainContent(steamUiState = steamViewModel.steamUiState)
                            val marsViewModel: MarsViewModel = viewModel(factory = MarsViewModel.Factory)
                            MarsMainContent(marsUiState = marsViewModel.marsUiState)

                        }
                    }
                }
            }
        }
    }
}