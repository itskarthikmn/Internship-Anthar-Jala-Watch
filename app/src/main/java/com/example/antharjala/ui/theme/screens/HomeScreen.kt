package com.example.antharjala.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),

            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Text(
                text = "Anthar-Jala",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Community Groundwater Monitoring",
                color = Color.Gray
            )

            FeatureCard("💧 Add Borewell Data") {
                navController.navigate("add")
            }

            FeatureCard("📍 Water Map") {
                navController.navigate("map")
            }

            FeatureCard("📊 Analytics") {
                navController.navigate("analytics")
            }

            FeatureCard("🔔 Water Alerts") {
                navController.navigate("alerts")
            }

            FeatureCard("📘 Recharge Guide") {
                navController.navigate("recharge")
            }

            FeatureCard("🔥 Heat Map") {
                navController.navigate("heatmap")
            }
        }
    }
}

@Composable
fun FeatureCard(
    title: String,
    onClick: () -> Unit
) {


    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E293B)
        ),

        onClick = onClick
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),

            contentAlignment = Alignment.CenterStart
        ) {

            Text(
                text = title,
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {

    val navController = rememberNavController()

    HomeScreen(navController)
}

