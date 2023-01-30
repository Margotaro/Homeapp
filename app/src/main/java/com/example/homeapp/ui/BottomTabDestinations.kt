package com.example.homeapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.homeapp.R

interface BottomTabDestination {
    val iconId: Int
    val selectedIconId: Int
    val route: String
    val screen: @Composable () -> Unit
}

/**
 * Tab app navigation destinations
 */
object BooksTabDestination : BottomTabDestination {
    override val iconId = R.drawable.books
    override val selectedIconId = R.drawable.books_selected
    override val route = "My books"
    override val screen: @Composable () -> Unit = { SetHomeScreenLayout() }
}

object DiscoverTabDestination : BottomTabDestination {
    override val iconId = R.drawable.discover
    override val selectedIconId = R.drawable.discover_selected
    override val route = "Discover"
    override val screen: @Composable () -> Unit = { SetHomeScreenLayout() }
}

object ProfileTabDestination : BottomTabDestination {
    override val iconId = R.drawable.profile
    override val selectedIconId = R.drawable.profile_selected
    override val route = "Profile"
    override val screen: @Composable () -> Unit = { SetHomeScreenLayout() }
}

// Screens to be displayed in the top TabRow
val bottomTabRowScreens = listOf(BooksTabDestination, DiscoverTabDestination, ProfileTabDestination)

@Composable
fun SetHomeScreenLayout() {
    HomeScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255, 244, 243))
    )
}