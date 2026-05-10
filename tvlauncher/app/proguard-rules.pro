# ATVL ProGuard Rules

# Keep data classes
-keep class com.atvl.launcher.data.** { *; }

# Keep ViewModel classes
-keep class com.atvl.launcher.viewmodel.** { *; }

# Keep Compose classes
-keep class com.atvl.launcher.ui.** { *; }

# Coil (image loading library)
-keep class coil.** { *; }
