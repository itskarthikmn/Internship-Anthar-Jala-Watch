package com.example.antharjala.ui.screens

import androidx.compose.runtime.mutableStateListOf
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

object BorewellRepository {

    private val database = FirebaseDatabase.getInstance("https://anthar-jala-watch-7c616-default-rtdb.firebaseio.com/")
    private val borewellRef = database.getReference("borewells")

    // SnapshotStateList allows the UI to automatically recompose when data changes in Firebase
    val borewellList = mutableStateListOf<BorewellData>()

    init {
        // Listen for data changes in Realtime Database
        borewellRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                borewellList.clear()
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val borewell = dataSnapshot.getValue(BorewellData::class.java)
                        if (borewell != null) {
                            borewellList.add(borewell)
                        }
                    }
                } else {
                    // Fallback to initial data if database is empty
                    borewellList.addAll(listOf(
                        BorewellData("150", "1000", "Red Soil", "2021", "Electronic City", 12.8391, 77.6778),
                        BorewellData("350", "800", "Clay", "2022", "Whitefield", 12.9698, 77.7500),
                        BorewellData("250", "1200", "Sandy", "2020", "Jayanagar", 12.9250, 77.5938)
                    ))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Log or handle database errors here
            }
        })
    }

    fun addBorewell(borewell: BorewellData) {
        // Push generates a unique ID for each entry
        borewellRef.push().setValue(borewell)
    }
}
