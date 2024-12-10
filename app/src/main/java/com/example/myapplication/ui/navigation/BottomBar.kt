package com.example.myapplication.ui.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.ui.theme.MyApplicationTheme

class BottomBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


        }
    }
}

enum class BottomBarScreen(val route: String, val label: String, val icon: ImageVector) {
    Home("home", "Home", Icons.Default.Home),
    Order("order", "Order", Icons.Default.Warning),
    Post("post", "Post", Icons.Default.CheckCircle),
    Notification("notification", "Notification", Icons.Default.Warning),
    Profile("profile", "Profile", Icons.Default.Warning)
}


@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Order,
        BottomBarScreen.Post,
        BottomBarScreen.Notification,
        BottomBarScreen.Profile
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = screen.label) },
                label = { Text(screen.label) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        // Avoid multiple copies of the same destination on the stack
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Prevent multiple copies of the same route
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
