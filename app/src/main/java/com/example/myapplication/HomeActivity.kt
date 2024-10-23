package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                Surface {

                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Location Selector
        Text(
            text = "Select Your Location",
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )

        // Offer Card
        OfferCard()

        // Search Bar
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar()

        Column(
            modifier = Modifier

                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Deliver to")
            Button(onClick = { navController.navigate("kerangjang") }) {
                Text("ke")
            }

            Button(onClick = { navController.navigate("edible") }) {
                Text("Edible Food")
            }

            Button(onClick = { navController.navigate("expired") }) {
                Text("Expired Food")
            }

            Button(onClick = { navController.navigate("crop_failure") }) {
                Text("Crop Failure")
            }
        }


        ProductList()


        // Categories List
        Spacer(modifier = Modifier.height(16.dp))
        CategoriesList()

        // Special Offers (if needed)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Special Offers", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        // Bottom Navigation (optional)
    }
}

//@Composable
//fun OfferCard() {
//    Card(
//        shape = RoundedCornerShape(12.dp),
//        modifier = Modifier.fillMaxWidth(),
////        elevation = 8.dp
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth()
//        ) {
//            Text(
//                text = "WORLD FOOD DAY",
//                fontWeight = FontWeight.Bold,
//                fontSize = 14.sp,
//                color = Color.Gray
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "GRAB NUTRITIOUS MEALS",
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = "40% OFF",
//                fontSize = 16.sp,
//                color = Color(0xFFFF9800)
//            )
//        }
//    }
//}

//@Composable
//fun SearchBar() {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp))
//            .padding(horizontal = 16.dp, vertical = 12.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
////        Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray)
//        Spacer(modifier = Modifier.width(8.dp))
//        TextField(
//            value = "",
//            onValueChange = {},
//            placeholder = { Text("Search") },
////            colors = TextFieldDefaults.colors(
////                backgroundColor = Color.Transparent,
////                unfocusedIndicatorColor = Color.Transparent,
////                focusedIndicatorColor = Color.Transparent
////            )
//        )
//    }
//}

@Composable
fun CategoriesList() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Edible Food
//        CategoryItem(
//            title = "Edible Food"
////            icon = R.drawable.ic_edible_food
//        )
//
//        // Expired Food
//        CategoryItem(
//            title = "Expired Food",
//            icon = R.drawable.ic_expired_food
//        )
//
//        // Crop Failure
//        CategoryItem(
//            title = "Crop Failure",
//            icon = R.drawable.ic_crop_failure
//        )
    }
}

@Composable
fun ProductList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Left Item
                ProductCard(
                    imageRes = R.drawable.contoh,
                    productName = "Strawberry",
                    price = "Rp 10.000/Box",
                    rating = 4.9
                )

                // Right Item
                ProductCard(
                    imageRes = R.drawable.contoh,
                    productName = "Apple",
                    price = "Rp 8.000/Box",
                    rating = 4.9
                )
            }
        }

        // Tambahkan item berikutnya dalam Row yang sama
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Left Item
                ProductCard(
                    imageRes = R.drawable.contoh,
                    productName = "Rice",
                    price = "Rp 13.000/Ltr",
                    rating = 4.9
                )

                // Right Item
                ProductCard(
                    imageRes = R.drawable.contoh,
                    productName = "Chicken Claw",
                    price = "Rp 75.000/Bks",
                    rating = 4.9
                )
            }
        }
    }
}

@Composable
fun ProductCard(
    imageRes: Int,
    productName: String,
    price: String,
    rating: Double
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
//            .weight(1f) // Membuat card dengan lebar yang sama dalam row
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = productName,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = productName, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = "⭐ $rating", fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = price, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color(0xFF4CAF50))
        }
    }
}

//@Composable
//fun CategoryItem(title: String, icon: Int) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Image(
//            painter = painterResource(id = icon),
//            contentDescription = title,
//            modifier = Modifier.size(40.dp),
//            contentScale = ContentScale.Crop
//        )
//        Spacer(modifier = Modifier.width(12.dp))
//        Text(
//            text = title,
//            fontSize = 18.sp,
//            modifier = Modifier.fillMaxWidth(),
//            textAlign = TextAlign.Start
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    MyApplicationTheme {
        HomeScreen(navController = navController)
    }
}