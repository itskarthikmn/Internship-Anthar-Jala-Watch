package com.example.antharjala.ui.screens

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.TileOverlayOptions
import com.google.maps.android.heatmaps.HeatmapTileProvider

@Composable
fun HeatMapScreen() {
    val context = LocalContext.current
    val borewells = BorewellRepository.borewellList
    
    // 1. Create and remember the MapView
    val mapView = remember { MapView(context) }

    // 2. Manage MapView Lifecycle
    val lifecycleObserver = rememberMapLifecycleObserver(mapView)
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifecycle) {
        lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycle.removeObserver(lifecycleObserver)
        }
    }

    AndroidView(
        factory = { mapView }
    ) { mv ->
        mv.getMapAsync { googleMap ->
            if (borewells.isNotEmpty()) {
                val heatMapPoints = borewells.map { LatLng(it.latitude, it.longitude) }
                
                val provider = HeatmapTileProvider.Builder()
                    .data(heatMapPoints)
                    .build()

                googleMap.clear() // Clear existing overlays
                googleMap.addTileOverlay(TileOverlayOptions().tileProvider(provider))

                // Center on the first point or a default location
                val target = heatMapPoints.first()
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(target, 10f))
            } else {
                // Default view if no data
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(12.9716, 77.5946), 10f))
            }
        }
    }
}

@Composable
fun rememberMapLifecycleObserver(mapView: MapView): LifecycleEventObserver =
    remember(mapView) {
        LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
                Lifecycle.Event.ON_START -> mapView.onStart()
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                Lifecycle.Event.ON_STOP -> mapView.onStop()
                Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                else -> throw IllegalStateException()
            }
        }
    }
