package com.example.antharjala.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.antharjala.R

@Composable
fun RechargeGuideScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .verticalScroll(rememberScrollState())
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "Recharge Guide",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Simple groundwater recharge methods",
            color = Color.Gray
        )

        RechargeCard(
            title = "Recharge Pit",
            description =
                "Dig a 4–6 ft pit filled with sand and gravel to help rainwater recharge groundwater.",
            imageRes = R.drawable.recharge_pit
        )

        RechargeCard(
            title = "Rooftop Rainwater Harvesting",
            description =
                "Collect rooftop rainwater using pipes and direct it into recharge wells.",
            imageRes = R.drawable.rainwater_harvesting
        )

        RechargeCard(
            title = "Percolation Tank",
            description =
                "Small water tanks improve groundwater absorption during rainy seasons.",
            imageRes = R.drawable.percolation_tank
        )
    }
}

@Composable
fun RechargeCard(
    title: String,
    description: String,
    imageRes: Int
) {

    Card(
        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E293B)
        )
    ) {

        Column {

            Image(
                painter = painterResource(id = imageRes),

                contentDescription = title,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),

                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(16.dp),

                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = description,
                    color = Color.LightGray,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRechargeGuideScreen() {
    RechargeGuideScreen()
}

