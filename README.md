# Anthar-Jala Watch 🌍💧  
### Community Groundwater Monitoring System

Anthar-Jala Watch is a smart Android application developed to monitor groundwater levels through community-driven borewell data collection and visualization. The application helps communities identify water-stress regions, analyze groundwater health, and promote sustainable recharge practices using interactive maps, heatmaps, analytics, and alerts.

---

# 📱 Features

- 📍 Live GPS-based borewell logging
- 🗺 Google Maps integration
- 🔥 Heatmap visualization for groundwater stress
- 🟢🟡🔴 Water health indicators (Safe / Moderate / Critical)
- 📊 Dynamic analytics dashboard
- 🔔 Groundwater alerts system
- 📘 Recharge guide with sustainability awareness
- 🌙 Modern cyber-dark UI using Jetpack Compose

---

# 🚀 Problem Statement

Groundwater levels are rapidly decreasing in many urban and rural areas. Most people realize borewell failure only after severe water scarcity occurs. There is currently no community-based platform to collectively monitor groundwater health or visualize water-stress regions.

Anthar-Jala Watch addresses this challenge by enabling users to crowdsource borewell data and generate a dynamic groundwater monitoring system.

---

# 🧠 Solution Overview

The application allows users to:
1. Enter borewell details such as depth, yield, soil type, and year.
2. Automatically capture GPS location using live location services.
3. Visualize groundwater health on Google Maps using colored markers and heatmaps.
4. Analyze safe, moderate, and critical groundwater zones.
5. Receive alerts for critical groundwater conditions.
6. Learn groundwater recharge methods through educational guides.

---

# 🏗 Tech Stack

| Technology | Usage |
|---|---|
| Kotlin | Android App Development |
| Jetpack Compose | UI Development |
| Android Studio | IDE |
| Google Maps API | Interactive Maps |
| Google Maps Compose | Compose Maps Integration |
| Android Maps Utils | Heatmap Visualization |
| GPS Location Services | Live Location Tracking |
| Material 3 | UI Components |

---

# 📂 Project Structure

```bash
AntharJala/
│
├── ui/
│   ├── screens/
│   │   ├── HomeScreen.kt
│   │   ├── AddBorewellScreen.kt
│   │   ├── MapScreen.kt
│   │   ├── HeatMapScreen.kt
│   │   ├── AnalyticsScreen.kt
│   │   ├── AlertsScreen.kt
│   │   └── RechargeGuideScreen.kt
│
├── data/
│   ├── BorewellData.kt
│   └── BorewellRepository.kt
│
├── MainActivity.kt
└── AndroidManifest.xml


📊 Water Health Logic
| Depth Level  | Status   | Indicator |
| ------------ | -------- | --------- |
| Below 200 ft | Safe     | 🟢 Green  |
| 200–300 ft   | Moderate | 🟡 Yellow |
| Above 300 ft | Critical | 🔴 Red    |


🔥 Heatmap Feature

The application dynamically updates groundwater heat intensity based on user-entered borewell data. Areas with severe groundwater stress appear as high-intensity regions on the map.

🔒 Privacy & Data Accuracy
Live GPS integration improves data accuracy.
Exact house numbers and sensitive personal information are hidden.
Community-level visualization ensures privacy protection


# ▶️ How to Run the Anthar-Jala Watch App

## 📌 Prerequisites

- Android Studio installed
- Android SDK API 26 or above
- Kotlin support enabled
- Google Maps API key
- Android phone or emulator

---

# 🚀 Step 1 — Open the Project

1. Open Android Studio
2. Click **Open**
3. Select the **AntharJala Project Folder**
4. Wait for Gradle Sync to complete

---

# 🚀 Step 2 — Add Google Maps API Key

Open:

```xml
AndroidManifest.xml

Add the following inside the <application> tag:

<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="YOUR_API_KEY"/>

Replace:

YOUR_API_KEY

with your actual Google Maps API key.

🚀 Step 3 — Enable Required APIs

Enable the following APIs in Google Cloud Console:

Maps SDK for Android
Places API (Optional)
🚀 Step 4 — Sync the Project

In Android Studio:

File → Sync Project with Gradle Files

Wait until:

BUILD SUCCESSFUL

appears.

🚀 Step 5 — Connect Android Device
Option 1 — Real Android Phone (Recommended)
Enable Developer Options
Enable USB Debugging
Connect phone using USB cable
Allow USB Debugging permission
Option 2 — Android Emulator
Open Device Manager
Create Virtual Device
Select API 26 or above
Start emulator
Set emulator GPS location manually if needed
🚀 Step 6 — Run the Application
Select connected device/emulator
Click:
▶ Run

Wait for application to install and launch.

📍 GPS Configuration

If latitude and longitude show:

0.0 | 0.0

then:
Enable device location
Allow precise location permission
Restart application

For emulator:
Extended Controls → Location → Set Location
🔥 Features to Test
Add Borewell Data
Open Water Map
View Heatmap
Check Analytics
View Alerts
Open Recharge Guide
🧪 Sample Test Data
Field	Sample Value
Depth	350
Yield	1200
Soil Type	Red Soil
Year	2020
Area	Bangalore
📦 Build APK

To generate APK:
Build → Build APK(s)

APK Location:
app/build/outputs/apk/debug/app-debug.apk
⚠ Common Issues & Solutions
Issue	Solution
Google Maps blank	Check API key
GPS showing 0.0	Enable location services
Markers not visible	Save new entries after GPS works
Emulator lag	Use real Android phone
Text not visible	Apply custom text colors
✅ Application Running Successfully

The application will now:
Capture live GPS location
Save borewell data
Display map markers
Generate groundwater analytics
Show alerts and heatmap visualization
