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
fun AnalyticsScreen() {

    val borewells = BorewellRepository.borewellList

    val total = borewells.size

    val safe = borewells.count {
        (it.depth.toIntOrNull() ?: 0) < 200
    }

    val moderate = borewells.count {
        (it.depth.toIntOrNull() ?: 0) in 200..300
    }

    val critical = borewells.count {
        (it.depth.toIntOrNull() ?: 0) > 300
    }

    val averageDepth =
        if (borewells.isNotEmpty()) {

            borewells.map {
                it.depth.toIntOrNull() ?: 0
            }.average().toInt()

        } else 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "Water Analytics",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        AnalyticsCard(
            title = "Total Borewells",
            value = total.toString()
        )

        AnalyticsCard(
            title = "Safe Zones",
            value = safe.toString()
        )

        AnalyticsCard(
            title = "Moderate Zones",
            value = moderate.toString()
        )

        AnalyticsCard(
            title = "Critical Zones",
            value = critical.toString()
        )

        AnalyticsCard(
            title = "Average Depth",
            value = "$averageDepth ft"
        )
    }
}

@Composable
fun AnalyticsCard(
    title: String,
    value: String
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
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = value,
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAnalyticsScreen() {
    AnalyticsScreen()
}