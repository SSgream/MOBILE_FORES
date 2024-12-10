package com.example.myapplication.ui.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R

@Composable
fun Profile(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar()
        ProfileInfo()
        MenuOptions()
    }
}

@Composable
fun TopBar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { /* Back action */ }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
        Text(
            text = "Profile",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
        IconButton(onClick = { /* More action */ }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More",
                tint = Color.Black
            )
        }
    }
}

@Composable
fun ProfileInfo() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground), // Replace with your avatar resource
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.Gray, shape = CircleShape)
            )
            FloatingActionButton(
                onClick = { /* Edit profile picture */ },
                containerColor = Color.Green,
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Profile",
                    tint = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Hasanah Putra AlQadri",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "(+62) 801 1315 1704",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "pdf.beta@gmail.com",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Logout action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEFF6EE)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Logout",
                tint = Color.Green
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Logout", color = Color.Green)
        }
    }
}

@Composable
fun MenuOptions() {
    Column(Modifier.padding(16.dp)) {
        MenuItem(icon = Icons.Default.LocationOn, text = "My Locations")
        MenuItem(icon = Icons.Default.Check, text = "My Promotions")
        MenuItem(icon = Icons.Default.Check, text = "Payment Methods")
        MenuItem(icon = Icons.Default.Check, text = "Messages")
        MenuItem(icon = Icons.Default.Lock, text = "Security")
        MenuItem(icon = Icons.Default.Refresh, text = "Help Center")
        Spacer(modifier = Modifier.height(16.dp))
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
        SettingItem(text = "Language", value = "English")
        ToggleOption(text = "Push Notification")
        ToggleOption(text = "Dark Mode")
        ToggleOption(text = "Sound")
        ToggleOption(text = "Automatically Updated")
    }
}

@Composable
fun MenuItem(icon: ImageVector, text: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Next",
            tint = Color.Gray
        )
    }
}

@Composable
fun SettingItem(text: String, value: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = value, fontSize = 16.sp, color = Color.Gray)
    }
}

@Composable
fun ToggleOption(text: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = false,
            onCheckedChange = { /* Handle toggle */ },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Green,
                uncheckedThumbColor = Color.Gray
            )
        )
    }
}
//@Preview(showBackground = true)
//@Composable
//fun ProfilePreview() {
//    Profile(navController = rememberNavController())
//}