package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
               Column(
                   modifier = Modifier.fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally
               ){
                   OutlineButton()
                   FieldButton()
               }
            }
        }
    }
}

@Composable
fun OutlineButton(){
    OutlinedButton(
        onClick = { /* Handle click */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp), // Bentuk tombol
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 1.dp,
        )
    ) {
        Text(text = "Outline Button", color = Color.Blue)
    }
}

@Composable
fun FieldButton() {
    Button(
        onClick = { /* Handle click */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp), // Bentuk tombol
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue, // Warna latar belakang
            contentColor = Color.White   // Warna teks
        )
    ) {
        Text(text = "Field Button")
    }
}