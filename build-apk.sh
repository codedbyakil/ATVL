#!/bin/bash
# ATVL APK Build Script
# This script builds the Android TV Launcher APK

echo "🚀 Building ATVL APK..."

# Check if Android SDK is available
if [ -z "$ANDROID_SDK_ROOT" ] && [ -z "$ANDROID_HOME" ]; then
    echo "❌ Android SDK not found. Please set ANDROID_SDK_ROOT or ANDROID_HOME environment variable."
    echo "Example: export ANDROID_SDK_ROOT=/path/to/android/sdk"
    exit 1
fi

# Set SDK path
SDK_PATH=${ANDROID_SDK_ROOT:-$ANDROID_HOME}

# Check if required tools exist
if ! command -v gradle &> /dev/null && [ ! -f "./gradlew" ]; then
    echo "❌ Gradle not found. Installing gradle wrapper..."
    gradle wrapper --gradle-version 8.2
fi

# Create gradle wrapper if it doesn't exist
if [ ! -f "./gradlew" ]; then
    echo "📦 Creating Gradle wrapper..."
    gradle wrapper --gradle-version 8.2
fi

# Make gradlew executable
chmod +x ./gradlew

# Clean and build
echo "🧹 Cleaning previous builds..."
./gradlew clean

echo "🔨 Building debug APK..."
./gradlew assembleDebug

# Check if build was successful
if [ $? -eq 0 ]; then
    echo "✅ Build successful!"

    # Find the APK
    APK_PATH=$(find . -name "*.apk" -path "*/debug/*" | head -1)

    if [ -n "$APK_PATH" ]; then
        echo "📱 APK created at: $APK_PATH"
        echo "📏 APK size: $(du -h "$APK_PATH" | cut -f1)"
        echo ""
        echo "🎉 Your ATVL APK is ready!"
        echo "You can install it on your Android TV device."
    else
        echo "⚠️  APK not found in expected location. Check build outputs manually."
    fi
else
    echo "❌ Build failed. Check the error messages above."
    exit 1
fi