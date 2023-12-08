package com.example.steamsaleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

data class Item(val name: String, val discount: String?, val price: Double)

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
                            Table(itemList = createItemList())
                        }
                    }
                }
            }
        }
    }
}

fun createItemList(): List<Item>{
    return listOf(
        Item("Product 1", "10% Off", 25.99),
        Item("Product 2", null, 19.99)
    )
}

@Composable
fun Table (itemList: List<Item>) {
    Column {
        for (item in itemList) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                // Table header
                Text(
                    text = "Name",
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
                Text(
                    text = "Discount",
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
                Text(
                    text = "Price",
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }
            // Divider after the header row
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
            )

            // Table rows
            itemList.forEach{item ->
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                Text(text = item.name, modifier = Modifier.weight(2f))
                Text(text = item.discount ?:"No Discount", modifier = Modifier.weight(1f))
                Text(text = "$${item.price}", modifier = Modifier.weight(1f))
                }
            }
        }
    }
}