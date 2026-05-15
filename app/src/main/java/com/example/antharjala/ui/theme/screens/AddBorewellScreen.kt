package com.example.antharjala.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.*

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.core.content.ContextCompat

import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

@Composable
fun AddBorewellScreen() {

    val context = LocalContext.current

    val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)

    var currentLatitude by remember {
        mutableStateOf(0.0)
    }

    var currentLongitude by remember {
        mutableStateOf(0.0)
    }

    var depth by remember { mutableStateOf("") }
    var yieldValue by remember { mutableStateOf("") }
    var soilType by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }

    var locationName by remember {
        mutableStateOf("")
    }

    val locationPermissionLauncher =
        rememberLauncherForActivityResult(
            contract =
                ActivityResultContracts.RequestPermission()
        ) { isGranted ->

            if (isGranted) {

                fusedLocationClient.getCurrentLocation(
                    Priority.PRIORITY_HIGH_ACCURACY,
                    null
                ).addOnSuccessListener { location: Location? ->

                    if (location != null) {

                        currentLatitude = location.latitude
                        currentLongitude = location.longitude
                    }
                }
            }
        }

    LaunchedEffect(Unit) {

        if (
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            locationPermissionLauncher.launch(
                Manifest.permission.ACCESS_FINE_LOCATION
            )

        } else {

            fusedLocationClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                null
            ).addOnSuccessListener { location: Location? ->

                if (location != null) {

                    currentLatitude = location.latitude
                    currentLongitude = location.longitude
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .padding(20.dp)
    ) {

        Text(
            text = "Add Borewell Data",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = depth,
            onValueChange = { depth = it },

            label = {
                Text("Depth (ft)")
            },

            modifier = Modifier.fillMaxWidth(),

            colors = OutlinedTextFieldDefaults.colors(

                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,

                focusedBorderColor = Color(0xFF6366F1),
                unfocusedBorderColor = Color.Gray,

                focusedLabelColor = Color(0xFF818CF8),
                unfocusedLabelColor = Color.LightGray,

                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = yieldValue,
            onValueChange = { yieldValue = it },

            label = {
                Text("Yield (lph)")
            },

            modifier = Modifier.fillMaxWidth(),

            colors = OutlinedTextFieldDefaults.colors(

                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,

                focusedBorderColor = Color(0xFF6366F1),
                unfocusedBorderColor = Color.Gray,

                focusedLabelColor = Color(0xFF818CF8),
                unfocusedLabelColor = Color.LightGray,

                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = soilType,
            onValueChange = { soilType = it },

            label = {
                Text("Soil Type")
            },

            modifier = Modifier.fillMaxWidth(),

            colors = OutlinedTextFieldDefaults.colors(

                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,

                focusedBorderColor = Color(0xFF6366F1),
                unfocusedBorderColor = Color.Gray,

                focusedLabelColor = Color(0xFF818CF8),
                unfocusedLabelColor = Color.LightGray,

                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = year,
            onValueChange = { year = it },

            label = {
                Text("Digging Year")
            },

            modifier = Modifier.fillMaxWidth(),

            colors = OutlinedTextFieldDefaults.colors(

                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,

                focusedBorderColor = Color(0xFF6366F1),
                unfocusedBorderColor = Color.Gray,

                focusedLabelColor = Color(0xFF818CF8),
                unfocusedLabelColor = Color.LightGray,

                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = locationName,
            onValueChange = { locationName = it },

            label = {
                Text("Area / Village Name")
            },

            modifier = Modifier.fillMaxWidth(),

            colors = OutlinedTextFieldDefaults.colors(

                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,

                focusedBorderColor = Color(0xFF6366F1),
                unfocusedBorderColor = Color.Gray,

                focusedLabelColor = Color(0xFF818CF8),
                unfocusedLabelColor = Color.LightGray,

                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                BorewellRepository.borewellList.add(

                    BorewellData(
                        depth,
                        yieldValue,
                        soilType,
                        year,
                        locationName,
                        currentLatitude,
                        currentLongitude
                    )
                )

                depth = ""
                yieldValue = ""
                soilType = ""
                year = ""
                locationName = ""
            },

            modifier = Modifier.fillMaxWidth(),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6366F1)
            )
        ) {

            Text(
                text = "Save Borewell Data",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Lat: $currentLatitude | Lng: $currentLongitude",
            color = Color.Green
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Saved Entries",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {

            items(BorewellRepository.borewellList) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1E293B)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Area: ${item.locationName}",
                            color = Color.White
                        )

                        Text(
                            text = "Depth: ${item.depth} ft",
                            color = Color.White
                        )

                        Text(
                            text = "Yield: ${item.yieldValue} lph",
                            color = Color.White
                        )

                        Text(
                            text = "Soil: ${item.soilType}",
                            color = Color.White
                        )

                        Text(
                            text = "Year: ${item.year}",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddBorewellScreen() {
    AddBorewellScreen()
}
