package com.example.myapplication.ui.orders

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.Login.LoginScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun order(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = { Text(text = "Orders") },
                actions = {
                    IconButton(onClick = { /* Handle more action */ }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        OrderContent(Modifier.padding(paddingValues))
    }
}

@Composable
fun OrderContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        // Search bar
        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle search */ },
            placeholder = { Text("Search") },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            },
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Filter buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FilterButton(label = "All", selected = true, modifier = Modifier.weight(1f))
            FilterButton(label = "Active", selected = false, modifier = Modifier.weight(1f))
            FilterButton(label = "Completed", selected = false, modifier = Modifier.weight(1f))
            FilterButton(label = "Cancelled", selected = false, modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Order cards
        OrderCard(
            orderId = "XF 001200524",
            price = "Rp 49.000",
            status = "Active",
            imageRes = R.drawable.ic_kopi_foreground
        )
        Spacer(modifier = Modifier.height(8.dp))
        OrderCard(
            orderId = "CF 002210124",
            price = "Rp 96.000",
            status = "Completed",
            imageRes = R.drawable.ic_atom_foreground
        )
        Spacer(modifier = Modifier.height(8.dp))
        OrderCard(
            orderId = "EF 008240724",
            price = "Rp 135.000",
            status = "Cancelled",
            imageRes = R.drawable.ic_flower_foreground
        )
    }
}

//@Composable
//fun FilterButton(label: String, selected: Boolean, modifier: Modifier = Modifier) {
//    Button(
//        onClick = { /* Handle filter click */ },
//        colors = ButtonDefaults.buttonColors(
//            containerColor = if (selected) Color.Green else Color.LightGray
//        ),
//        modifier = modifier.padding(horizontal = 4.dp)
//    ) {
//        Text(text = label, color = if (selected) Color.White else Color.Black)
//    }
//}
@Composable
fun FilterButton(label: String, selected: Boolean, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = { /* Handle filter click */ },
        shape = RoundedCornerShape(8.dp), // Ujung tombol sedikit melengkung
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 1.dp,
//            color = if (selected) Color.Green else Color.Gray
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (selected) colorResource(id = R.color.sigelap1) else Color.Transparent,
            contentColor = if (selected) Color.White else Color.Black
        ),
        modifier = modifier
            .padding(horizontal = 4.dp) // Mengatur jarak antar tombol
            .height(30.dp) // Menjaga tinggi tombol tetap konsisten
    ) {
        // Menampilkan ikon ceklis jika tombol dipilih
        if (selected) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Ikon ceklis (sesuaikan dengan drawable Anda)
                contentDescription = "Selected",
                modifier = Modifier.size(16.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp)) // Memberikan ruang setelah ikon
        }

        // Menampilkan teks label
        Text(
            text = label,
            fontSize = 15.sp, // Ukuran font lebih kecil agar sesuai
            fontWeight = FontWeight.Normal
        )
    }
}



@Composable
fun OrderCard(orderId: String, price: String, status: String, imageRes: Int) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = imageRes),
                contentDescription = "Order Image",
                modifier = Modifier.size(56.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Order ID: $orderId", fontWeight = FontWeight.Bold)
                Text(text = price, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = status,
                color = when (status) {
                    "Active" -> colorResource(id = R.color.sigelap1)
                    "Completed" -> Color.Blue
                    "Cancelled" -> Color.Red
                    else -> Color.Gray
                },
                fontWeight = FontWeight.Bold
            )
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun Previeworder() {
//    order(navController = rememberNavController())
//}