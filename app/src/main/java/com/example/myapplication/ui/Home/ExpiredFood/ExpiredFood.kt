package com.example.myapplication.ui.Home.ExpiredFood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.Home.CropFailure.Product
import com.example.myapplication.ui.theme.MyApplicationTheme

//class ExpiredFood : ComponentActivity() {
//    private lateinit var navController: NavController
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApplicationTheme {
//                ExpiredFoodScreen(navController)
//            }
//        }
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpiredFoodScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.expiredfood), // Ganti dengan gambar yang sesuai
                            contentDescription = "Expired Food",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Edible Food",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) { // Navigasi ke layar sebelumnya
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            val productList = listOf(
                Product("Apple", "Rp 10.000/Box", R.drawable.ic_drink_foreground),
                Product("Banana", "Rp 5.000/Box", R.drawable.ic_bread_foreground),
                Product("Grapes", "Rp 7.000/Box", R.drawable.ic_burger_foreground),
                Product("Peach", "Rp 12.000/Box", R.drawable.ic_mie_foreground),
                Product("Watermelon", "Rp 15.000/Box", R.drawable.ic_drink_foreground),
                Product("Papaya", "Rp 6.000/Box", R.drawable.ic_bread_foreground),
                Product("Strawberry", "Rp 15.000/Box", R.drawable.ic_burger_foreground),
                Product("Rice", "Rp 6.000/Box", R.drawable.ic_mie_foreground),
                Product("Banana", "Rp 15.000/Box", R.drawable.ic_drink_foreground),
                Product("Papaya", "Rp 6.000/Box", R.drawable.ic_bread_foreground),
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(productList) { product ->
                    ProductItem(
                        name = product.name,
                        price = product.price,
                        imageResId = product.imageResId
                    )
                }
            }
        }
    }
}

@Composable
fun ProductItem(name: String, price: String, imageResId: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = name,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Text(
                text = price,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

data class Product(val name: String, val price: String, val imageResId: Int)

@Preview(showBackground = true)
@Composable
fun ExpiredFoodPreview() {
    MyApplicationTheme {
        ExpiredFoodScreen(navController = rememberNavController())
    }
}