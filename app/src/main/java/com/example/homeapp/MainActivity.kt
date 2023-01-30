package com.example.homeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.example.homeapp.ui.*
import com.example.homeapp.ui.components.BottomTabRow
import com.example.homeapp.ui.theme.HomeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SetBottomTabRow()
                }
            }
        }
    }
}


@Composable
fun SetBottomTabRow() {
    var currentScreen: BottomTabDestination by remember { mutableStateOf(BooksTabDestination) }
    Box{
        currentScreen.screen()
        Box(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            BottomTabRow(
                allScreens = bottomTabRowScreens,
                onTabSelected = { screen -> currentScreen = screen },
                currentScreen = currentScreen
            )
        }
    }
}

