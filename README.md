# Anthar-Jala Watch 🌍💧  
### Community Groundwater Monitoring System

Anthar-Jala Watch is a smart Android application developed to monitor groundwater levels through community-driven borewell data collection and visualization. The application helps communities identify water-stress regions, analyze groundwater health, and promote sustainable recharge practices using interactive maps, heatmaps, analytics, and alerts.

---

# 📱 Features

- 📍 **Live GPS-based borewell logging:** Automatically capture location coordinates.
- ☁️ **Cloud Storage & Sync:** Real-time data synchronization using **Firebase Realtime Database**.
- 🗺 **Google Maps integration:** Visualize all community-contributed borewell data on a map.
- 🔥 **Heatmap visualization:** Identify groundwater stress zones dynamically.
- 🟢🟡🔴 **Water health indicators:** Instant status (Safe / Moderate / Critical) based on borewell depth.
- 📊 **Dynamic analytics dashboard:** Real-time metrics of community groundwater health.
- 📘 **Recharge guide:** Sustainability awareness and educational methods.
- 🌙 **Modern UI:** Built with Jetpack Compose following Material 3 design principles with a cyber-dark theme.

---

# 🚀 Problem Statement

Groundwater levels are rapidly decreasing in many urban and rural areas. Most people realize borewell failure only after severe water scarcity occurs. There is currently no community-based platform to collectively monitor groundwater health or visualize water-stress regions.

Anthar-Jala Watch addresses this challenge by enabling users to crowdsource borewell data and generate a dynamic, cloud-backed groundwater monitoring system.

---

# 🏗 Tech Stack

| Technology | Usage |
|---|---|
| Kotlin | Android App Development |
| Jetpack Compose | UI Development |
| **Firebase Realtime DB** | **Cloud Data Storage & Real-time Sync** |
| Google Maps API | Interactive Maps |
| Android Maps Utils | Heatmap Visualization |
| GPS Location Services | Live Location Tracking |
| Material 3 | UI Components |

---

# 📂 Project Structure

```bash
AntharJala/
│
├── app/src/main/java/com/example/antharjala/
│   ├── ui/theme/screens/
│   │   ├── HomeScreen.kt
│   │   ├── AddBorewellScreen.kt (Cloud Connected)
│   │   ├── MapScreen.kt
│   │   ├── HeatMapScreen.kt
│   │   └── BorewellRepository.kt (Firebase Integration Logic)
│
├── data/ (Models)
│   └── BorewellData.kt
│
├── MainActivity.kt
└── AndroidManifest.xml
```

📊 Water Health Logic
| Depth Level  | Status   | Indicator |
| ------------ | -------- | --------- |
| Below 200 ft | Safe     | 🟢 Green  |
| 200–300 ft   | Moderate | 🟡 Yellow |
| Above 300 ft | Critical | 🔴 Red    |

---

# ▶️ How to Run the App

## 📌 Prerequisites

- Android Studio installed.
- Google Maps API key.
- **Firebase Project Setup:**
  - Project ID: `anthar-jala-watch-7c616`
  - Database URL: `https://anthar-jala-watch-7c616-default-rtdb.firebaseio.com/`
  - `google-services.json` file.

---

# 🚀 Step 1 — Firebase & Maps Configuration

### 1. Firebase Setup
1. Go to the [Firebase Console](https://console.firebase.google.com/project/anthar-jala-watch-7c616/overview).
2. Download the `google-services.json` file.
3. Place it in the `app/` directory of the project.
4. Ensure **Realtime Database** is enabled in the Firebase Console.
5. **Rules:** Set database rules to allow read/write access (for development):
```json
{
  "rules": {
    ".read": true,
    ".write": true
  }
}
```

### 2. Google Maps API Key
Open `AndroidManifest.xml` and add your actual Google Maps key:
```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="YOUR_API_KEY"/>
```

---

# 🚀 Step 2 — Sync and Run

1. **File → Sync Project with Gradle Files** in Android Studio.
2. Select your device/emulator.
3. Click **▶ Run**.

🔥 Features to Test (Cloud Sync)
- **Add Borewell Data:** Enter details and click **Save**. Data will sync instantly to the [Firebase Data Console](https://console.firebase.google.com/project/anthar-jala-watch-7c616/database/anthar-jala-watch-7c616-default-rtdb/data/~2F).
- **Verify Cloud Sync:** Check the console to see the entries appearing in real-time.
- **Real-time Map:** Observe how data added by one user immediately becomes visible to all users.

✅ **Application successfully migrated to Firebase Cloud for centralized storage.**
