package com.example.myapplication.ui.Home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import androidx.compose.ui.res.painterResource


@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 32.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(text = "Deliver to", fontSize = 16.sp)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Select Your Location", fontSize = 16.sp, color = Color.Gray)
            IconButton(onClick = { /* Aksi keranjang */ }) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Cart")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OfferCard()

        Spacer(modifier = Modifier.height(16.dp))

        SearchBar()

        Spacer(modifier = Modifier.height(16.dp))

        CategoriesSection(navController)

        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.bg), shape = RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray)
        Spacer(modifier = Modifier.width(8.dp))
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text("Search") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun OfferCard() {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "WORLD FOOD DAY",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "GRAB NUTRITIOUS MEALS",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "40% OFF",
                fontSize = 16.sp,
                color = Color(0xFFFF9800)
            )
        }
    }
}

@Composable
fun CategoriesSection(navController: NavController) {
    Column {
        CategoryItem(
            title = "Edible Food",
            imageRes = R.drawable.ediblefood,
            onClick = { navController.navigate("edible_food_screen")
                Log.d("CategoryItem", "Edible Food clicked")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CategoryItem(
            title = "Expired Food",
            imageRes = R.drawable.expiredfood,
            onClick = { navController.navigate("expired_food_screen") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CategoryItem(
            title = "Crop Failure",
            imageRes = R.drawable.cropfailure,
            onClick = { navController.navigate("crop_failure_screen") }
        )
    }
}

@Composable
fun CategoryItem(title: String, imageRes: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, colorResource(R.color.sigelap2), RoundedCornerShape(8.dp))
            .padding(vertical = 16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (imageRes != 0) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = title,
                    modifier = Modifier.size(50.dp)
                )
            } else {
                Text("Image not available", color = Color.Red)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title, fontSize = 18.sp, color = colorResource(R.color.sigelap2))
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun PreviewHomeScreen() {
//    HomeScreen(navController = rememberNavController())
//}
