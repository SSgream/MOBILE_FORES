package com.example.myapplication

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
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        auth = FirebaseAuth.getInstance() // Inisialisasi Firebase Auth
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.sigelap1)
                ) {
                    LoginScreen(
                        onSignIn = { email, password -> signIn(email, password) },
                        onSignUp = { email, password -> signUp(email, password) },
                        onGoogleSignIn = { /* Handle Google Sign-In */ }
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        // Periksa apakah pengguna sudah login (tidak null) dan perbarui UI sesuai dengan itu.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // Pengguna sudah login, navigasi ke layar baru atau perbarui UI
            updateUI(currentUser)
        }
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login berhasil, perbarui UI dengan informasi pengguna yang sudah login
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // Jika login gagal, tampilkan pesan kepada pengguna.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Autentikasi gagal.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }

    private fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Pendaftaran berhasil, perbarui UI dengan informasi pengguna yang sudah login
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // Jika pendaftaran gagal, tampilkan pesan kepada pengguna.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Autentikasi gagal.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        // Perbarui UI berdasarkan informasi pengguna
        if (user != null) {
            // Navigasi ke layar baru atau perbarui UI
        } else {
            // Tampilkan layar login atau UI yang sesuai
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}

@Composable
fun LoginScreen(
    onSignIn: (String, String) -> Unit,
    onSignUp: (String, String) -> Unit,
    onGoogleSignIn: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Input email
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // Input password
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            visualTransformation = PasswordVisualTransformation() // Menyembunyikan input password
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Baris untuk tombol Sign In dan Sign Up
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Tombol Sign Up
            OutlinedButton(
                onClick = { onSignUp(email, password) },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = colorResource(id = R.color.sigelap2)
                ),
                border = BorderStroke(1.dp, Color.White )
            ) {
                Text(text = "Sign Up", color = Color.White)
            }

            // Tombol Sign In
            Button(
                onClick = { onSignIn(email, password) },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.sigelap5),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Sign In")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Sign In dengan Google
        Button(
            onClick = { onGoogleSignIn() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.White
            )
        ) {
            Text(text = "Sign In with Google")
        }
    }
}
