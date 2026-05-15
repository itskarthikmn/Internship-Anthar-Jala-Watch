package com.example.antharjala.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen() {

    val borewells = BorewellRepository.borewellList

    val cameraPositionState =
        rememberCameraPositionState {

            position = CameraPosition.fromLatLngZoom(
                LatLng(12.9716, 77.5946),
                10f
            )
        }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),

        cameraPositionState = cameraPositionState
    ) {

        borewells.forEach { borewell ->

            val latitude = borewell.latitude
            val longitude = borewell.longitude

            if (latitude != 0.0 && longitude != 0.0) {

                val depth =
                    borewell.depth.toIntOrNull() ?: 0

                val markerColor = when {

                    depth < 200 ->
                        BitmapDescriptorFactory.HUE_GREEN

                    depth in 200..300 ->
                        BitmapDescriptorFactory.HUE_YELLOW

                    else ->
                        BitmapDescriptorFactory.HUE_RED
                }

                Marker(
                    state = MarkerState(
                        position = LatLng(
                            latitude,
                            longitude
                        )
                    ),

                    title = borewell.locationName,

                    snippet =
                        "Depth: ${borewell.depth} ft",

                    icon = BitmapDescriptorFactory.defaultMarker(
                        markerColor
                    )
                )
            }
        }
    }
}