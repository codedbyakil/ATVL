# ATVL - Android TV Launcher

A modern Android TV launcher application built with Jetpack Compose for Android TV.

## Features

- 📱 Clean, modern TV interface
- 🎯 App grid with focus animations
- ⭐ Favorites row for quick access
- 🔍 Search integration
- ⚙️ Settings access
- 🕒 Real-time clock display
- 📺 Leanback launcher support

## Building the APK

### Option 1: GitHub Actions (Recommended)

1. Push your code to the `main` branch
2. Go to **Actions** tab in your GitHub repository
3. Click on the latest "Build Android APK" workflow
4. Download the APK from the **Artifacts** section

The workflow will automatically:
- ✅ Build debug APK
- ✅ Build release APK (if signing configured)
- ✅ Upload artifacts for download

### Option 2: Local Build

1. **Prerequisites:**
   - Android Studio (latest version)
   - Android SDK (API 34+)

2. **Build Steps:**
   ```bash
   # Clone the repository
   git clone https://github.com/codedbyakil/ATVL.git
   cd ATVL

   # Open in Android Studio or build via command line
   ./gradlew assembleDebug
   ```

3. **Find APK:**
   - Debug APK: `app/build/outputs/apk/debug/app-debug.apk`
   - Release APK: `app/build/outputs/apk/release/app-release.apk`

### Option 3: Using Build Script

```bash
# Make sure Android SDK is configured
export ANDROID_SDK_ROOT=/path/to/android/sdk

# Run the build script
./build-apk.sh
```

## Installation

1. Transfer the APK to your Android TV device
2. Enable "Unknown sources" in Android TV settings
3. Install the APK
4. Set as default launcher (if desired)

## Project Structure

```
app/
├── src/main/
│   ├── kotlin/com/atvl/launcher/
│   │   ├── data/          # Data models and repository
│   │   ├── ui/            # UI components and themes
│   │   └── viewmodel/     # ViewModels
│   ├── res/               # Resources (layouts, values, drawables)
│   └── AndroidManifest.xml
├── build.gradle.kts       # App-level build configuration
└── proguard-rules.pro     # ProGuard rules for release builds

.github/workflows/         # GitHub Actions workflows
build.gradle.kts          # Project-level build configuration
```

## Technologies Used

- **Kotlin** - Primary programming language
- **Jetpack Compose** - Modern UI toolkit
- **Android TV Material 3** - TV-specific UI components
- **Coil** - Image loading library
- **ViewModel & LiveData** - Architecture components
- **Gradle** - Build system

## Permissions

- `android.permission.QUERY_ALL_PACKAGES` - Required for app discovery on Android TV

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Push to GitHub
5. Create a Pull Request

The GitHub Actions workflow will automatically build and test your changes.