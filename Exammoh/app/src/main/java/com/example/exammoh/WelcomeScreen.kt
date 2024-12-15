package com.example.exam

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Welcome") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(painter = painterResource(id = R.drawable.add_cart), contentDescription = "Cart Icon")
            Spacer(modifier = Modifier.height(16.dp))
            Text("Find food you love", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Discover the best menus from over 100 cuisines and restaurants.")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("main_screen") }, modifier = Modifier.fillMaxWidth(0.8f)) {
                Text("Go to Use")
            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(onClick = { navController.navigate("contact_screen") }, modifier = Modifier.fillMaxWidth(0.8f)) {
                Text("Contact")
            }
        }
    }
}