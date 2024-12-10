package com.example.myapplication.ui.Login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var selectedCode by remember { mutableStateOf("+62") }

    val countryCodes = listOf("+62", "+1", "+91") // Contoh kode negara

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Login",
                color = (colorResource(R.color.sigelap2)),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(24.dp)
            )

            // Dropdown Kode Negara + Input Nomor Telepon
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, colorResource(R.color.sigelap2), RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = selectedCode)
                    Spacer(modifier = Modifier.width(8.dp))
                    TextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        label = { Text("00 0000 0000") },
                        modifier = Modifier.weight(1f),
                        colors = TextFieldDefaults.run {
                            textFieldColors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            )
                        }
                    )
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                    }
                }
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    countryCodes.forEach { code ->
                        DropdownMenuItem(onClick = {
                            selectedCode = code
                            expanded = false
                        }) {
                            Text(text = code) // Menampilkan teks kode negara
                        }
                    }
                }
            }
        }

        // Checkbox Remember Me
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it }
            )
            Text("Remember me")
        }

        Spacer(modifier = Modifier.height(350.dp))



        // Tombol Sign In
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)

        ) {
            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.sigelap2)
                ),
                shape = RoundedCornerShape(50) // Sudut bulat pada tombol
            ) {
                Text("Sign in", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Garis pembatas
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Divider(modifier = Modifier.weight(1f))
                Text("Or sign in with")
                Divider(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Login dengan akun media sosial
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                IconButton(onClick = { /* Handle Google Login */ }) {
                    Icon(painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Google")
                }
                IconButton(onClick = { /* Handle Facebook Login */ }) {
                    Icon(painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Facebook")
                }
                IconButton(onClick = { /* Handle Apple Login */ }) {
                    Icon(painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Apple")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Text Register
            TextButton(onClick = { navController.navigate("register") }) {
                Text(
                    text = "Don't have an account? Register",
                    color = Color(0xFF4CAF50)
                )
            }
        }
    }
}

@Composable
fun DropdownMenuItem(
    onClick: () -> Unit,
    content: @Composable () -> Unit // Parameter untuk konten yang akan ditampilkan
) {
    // Menggunakan Modifier untuk membuat item bisa diklik
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick) // Menangani klik
            .padding(16.dp) // Memberikan padding
    ) {
        content() // Menampilkan konten yang diberikan
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun TampilanLogin() {
//    LoginScreen(navController = rememberNavController())
//}