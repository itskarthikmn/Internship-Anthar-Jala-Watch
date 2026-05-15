package com.example.antharjala.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AlertsScreen() {

    val criticalZones =
        BorewellRepository.borewellList.filter {

            (it.depth.toIntOrNull() ?: 0) > 300
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "Water Alerts",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        if (criticalZones.isEmpty()) {

            Text(
                text = "No critical groundwater alerts.",
                color = Color.Green,
                fontSize = 18.sp
            )
        }

        criticalZones.forEach {

            AlertCard(
                title = "Critical Water Level",

                message =
                    "${it.locationName} groundwater depth is critically high.",

                alertColor = Color.Red
            )
        }
    }
}

@Composable
fun AlertCard(
    title: String,
    message: String,
    alertColor: Color
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E293B)
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = title,
                color = alertColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = message,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAlertsScreen() {
    AlertsScreen()
}