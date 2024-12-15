package com.example.exam

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val cartItems = listOf("Michelin Corn", "Michelin Corn","Michelin Corn", "Michelin Corn")
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cart") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("welcome_screen") }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text("5 items", modifier = Modifier.padding(16.dp), fontSize = 18.sp)
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cartItems) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp)
                        )
                        Column(modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)) {
                            Text(item, fontSize = 16.sp)
                            Text("2x items | 5Kg", fontSize = 12.sp)
                        }
                        Text("29.5 SR", fontSize = 16.sp)
                    }
                }
            }
            Button(onClick = { /* Checkout Action */ }, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Text("Check Out (25 SR)")
            }
        }
    }
}