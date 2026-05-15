package com.example.antharjala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import com.example.antharjala.ui.screens.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "home"
            ) {

                composable("home") {
                    HomeScreen(navController)
                }

                composable("add") {
                    AddBorewellScreen()
                }

                composable("map") {
                    MapScreen()
                }

                composable("analytics") {
                    AnalyticsScreen()
                }

                composable("alerts") {
                    AlertsScreen()
                }

                composable("recharge") {
                    RechargeGuideScreen()
                }

                composable("heatmap") {
                    HeatMapScreen()
                }
            }
        }
    }
}