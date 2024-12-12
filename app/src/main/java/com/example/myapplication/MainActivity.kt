package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.Home.CategoriesSection
import com.example.myapplication.ui.Home.CropFailure.CropFailureScreen
import com.example.myapplication.ui.Home.EdibleFood.EdibleFoodScreen
import com.example.myapplication.ui.Home.ExpiredFood.ExpiredFoodScreen
import com.example.myapplication.ui.Home.HomeScreen
import com.example.myapplication.ui.Login.LoginScreen
import com.example.myapplication.ui.Notification.Notification
import com.example.myapplication.ui.Posts.Postingan
import com.example.myapplication.ui.Profile.Profile
import com.example.myapplication.ui.Register.RegisterScreen
import com.example.myapplication.ui.Splashscreen.SplashScreen
import com.example.myapplication.ui.navigation.BottomBar
import com.example.myapplication.ui.navigation.BottomBarScreen
import com.example.myapplication.ui.navigation.CustomBottomBar
import com.example.myapplication.ui.orders.order
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance() // Inisialisasi FirebaseAuth

        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                val currentUser = auth.currentUser // Periksa pengguna yang sedang login

                // Pilih startDestination berdasarkan status login
                val startDestination = if (currentUser != null) "login" else "login"

                Scaffold(
                    bottomBar = {
                        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                        if (currentUser != null && currentRoute !in listOf("login", "register", "splash")) {
                            BottomBar(navController)
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = startDestination,
                        Modifier.padding(innerPadding)
                    ) {
                        composable("splash") {
                            SplashScreen(navController)
                        }
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("home") {
                            HomeScreen(navController)
                        }
                        composable("categories_screen") {
                            CategoriesScreen(navController) // Fungsi layar kategori
                        }
                        composable("edible_food_screen") {
                            EdibleFoodScreen(navController) // Fungsi layar edible food
                        }
                        composable("expired_food_screen") {
                            ExpiredFoodScreen(navController) // Fungsi layar expired food
                        }
                        composable("crop_failure_screen") {
                            CropFailureScreen(navController) // Fungsi layar crop failure
                        }
                        composable(BottomBarScreen.Order.route) {
                            order(navController)
                        }
                        composable(BottomBarScreen.Post.route) {
                            Postingan(navController)
                        }
                        composable(BottomBarScreen.Notification.route) {
                            Notification(navController)
                        }
                        composable(BottomBarScreen.Profile.route) {
                            Profile(navController)
                        }
                        composable("register") {
                            RegisterScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun CategoriesScreen(navController: NavController) {
    CategoriesSection(navController) // Pastikan ini adalah versi yang telah direvisi dengan navigasi
}


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        auth = FirebaseAuth.getInstance()
//
//        // Periksa status login
//        auth.signOut()
//
//        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            // Jika pengguna sudah login, arahkan ke HomeActivity
//            startActivity(Intent(this, HomeScreen::class.java))
//            finish() // Menutup MainActivity
//        } else {
//            // Jika belum login, arahkan ke LoginActivity
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }
//    }


@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Order,
        BottomBarScreen.Post,
        BottomBarScreen.Notification,
        BottomBarScreen.Profile
    )

//    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    CustomBottomBar(selectedRoute = currentRoute ?: BottomBarScreen.Home.route) { selectedRoute ->
        navController.navigate(selectedRoute) {
            popUpTo(navController.graph.startDestinationId) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }
}