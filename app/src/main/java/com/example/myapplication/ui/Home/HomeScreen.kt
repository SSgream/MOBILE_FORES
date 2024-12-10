package com.example.myapplication.ui.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())  // Agar layout bisa digulir ke bawah
            .padding(top = 32.dp)
            .padding(horizontal = 16.dp)
    ) {

        Text(text = "Deliver to", fontSize = 16.sp)
        // Bagian header (lokasi dan ikon keranjang)
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

        // Banner Carousel
        OfferCard()

        Spacer(modifier = Modifier.height(16.dp))

        // Search Bar
        SearchBar()

        Spacer(modifier = Modifier.height(16.dp))

        // Kategori Produk
        CategoriesSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Penawaran Spesial
        SpecialOffersSection()
    }
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = "Home Screen", fontSize = 24.sp, color = Color.Black)
//    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.bg), shape = RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray)
        Spacer(modifier = Modifier.width(8.dp))
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search") },

            )
    }
}

@Composable
fun OfferCard() {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .width(200.dp)
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
fun CategoriesSection() {
    Column {
        CategoryItem("Edible Food", R.drawable.ediblefood)
        Spacer(modifier = Modifier.height(16.dp))
        CategoryItem("Expired Food", R.drawable.expiredfood)
        Spacer(modifier = Modifier.height(16.dp))
        CategoryItem("Crop Failure", R.drawable.cropfailure)
    }
}

@Composable
fun CategoryItem(title: String, imageRes: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, colorResource(R.color.sigelap2), RoundedCornerShape(8.dp))
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(32.dp))
        Text(text = title, fontSize = 18.sp)
    }
}

@Composable
fun SpecialOffersSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Special Offers", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = "View All", color = Color.Green, fontSize = 16.sp)
    }

    Spacer(modifier = Modifier.height(16.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            SpecialOfferItem("Strawberry", "Rp 10.000/Box", R.drawable.strowbery)
        }
        item {
            SpecialOfferItem("Corn", "Rp 5.000/Buah", R.drawable.padi)
        }
        item {
            SpecialOfferItem("Corn", "Rp 5.000/Buah", R.drawable.padi)
        }
        item {
            SpecialOfferItem("Corn", "Rp 5.000/Buah", R.drawable.padi)
        }
        // Tambahkan lebih banyak item sesuai kebutuhan
    }
}

@Composable
fun SpecialOfferItem(productName: String, price: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .size(150.dp)
            .height(180.dp)

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = productName,
                modifier = Modifier.size(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = productName, fontSize = 16.sp)
            Text(text = price, fontSize = 14.sp, color = Color.Green)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun TampilanHomeScreen() {
//    HomeScreen(navController = rememberNavController())
//}