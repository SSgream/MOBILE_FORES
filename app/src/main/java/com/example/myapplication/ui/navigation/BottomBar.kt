package com.example.myapplication.ui.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.R
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
fun CustomBottomBar(selectedRoute: String, onItemSelected: (String) -> Unit) {
    val items = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Order,
        BottomBarScreen.Post,
        BottomBarScreen.Notification,
        BottomBarScreen.Profile
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { screen ->
                val isSelected = screen.route == selectedRoute
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentSize(Alignment.Center)
                        .clickable { onItemSelected(screen.route) } // Menangani klik
                ) {
                    if (isSelected) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .background(
                                    color = colorResource(id = R.color.sigelap2),
                                    shape = CircleShape
                                )
                                .shadow(4.dp, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.label,
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        Text(
                            text = screen.label,
                            color = colorResource(id = R.color.sigelap1),
                            modifier = Modifier.align(Alignment.BottomCenter)
                        )
                    } else {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = screen.label,
                            tint = Color.Gray,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun CustomBottomBarPreview() {
//    CustomBottomBar(selectedRoute = "home") { }
//}