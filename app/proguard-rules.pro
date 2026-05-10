# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html

# For more details, see
#    http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep Kotlin metadata
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }

# Keep Compose
-keep class androidx.compose.** { *; }
-keep interface androidx.compose.** { *; }

# Keep TV Material
-keep class androidx.tv.** { *; }
-keep interface androidx.tv.** { *; }

# Keep Coil
-keep class coil.** { *; }
-keep interface coil.** { *; }

# Keep data classes
-keep class com.atvl.launcher.data.** { *; }
-keep interface com.atvl.launcher.data.** { *; }

# Keep view models
-keep class com.atvl.launcher.viewmodel.** { *; }
-keep interface com.atvl.launcher.viewmodel.** { *; }

# Keep Serializable classes
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Keep main activity
-keep class com.atvl.launcher.MainActivity { *; }

# Check if Kotlin compiler version is compatible
-dontwarn java.lang.invoke.StringConcatFactory
