package com.example.exammoh

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val cartItems = listOf("Michelin Corn", "Michelin Corn", "Michelin Corn", "Michelin Corn")

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {

                    IconButton(onClick = { navController.navigate("welcome_screen") }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White
                            )
                    }
                },
                title = {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Cart",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "5 items",
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                },                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF007F6A))

            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cartItems) { item ->
                    CartItemRow(itemName = item)
                }
            }


            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(56.dp)
                    .padding(bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007F6A)),
                shape = RectangleShape,
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
            ) {
                Text(
                    text = "Check Out (25 SR)",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}

@Composable
fun CartItemRow(itemName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.rectangle),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .weight(0.2f)
        )

        Column(
            modifier = Modifier
                .weight(0.6f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = itemName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "2x items | 5Kg",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "29.5 SR",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF007F6A)
            )
        }
    }
}
