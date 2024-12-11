package com.example.myapplication.ui.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R

class BottomBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            val currentRoute = navController.currentBackStackEntry?.destination?.route ?: BottomBarScreen.Home.route

            CustomBottomBar(
                selectedRoute = currentRoute,
                onItemSelected = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )

        }
    }
}

enum class BottomBarScreen(val route: String, val icon: Int) {
    Home("home", R.drawable.ic_home_foreground),
    Order("order", R.drawable.ic_order_foreground),
    Post("post", R.drawable.ic_post_foreground),
    Notification("notification", R.drawable.ic_notif_foreground),
    Profile("profile", R.drawable.ic_profil_foreground)
}


@Composable
fun CustomBottomBar(
    selectedRoute: String,  // Menambahkan parameter selectedRoute
    onItemSelected: (String) -> Unit
) {
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
//                        .clickable { onItemSelected(screen.route) }
                        .clickable{
                            onItemSelected(screen.route)
                        }
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
//                                imageVector = screen.icon,
                                painter = androidx.compose.ui.res.painterResource(id = screen.icon),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    } else {
                        Icon(
                            painter = androidx.compose.ui.res.painterResource(id = screen.icon),
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(50.dp)
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