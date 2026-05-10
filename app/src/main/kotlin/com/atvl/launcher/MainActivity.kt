package com.atvl.launcher

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.atvl.launcher.data.AppInfo
import com.atvl.launcher.data.LauncherRepository
import com.atvl.launcher.ui.components.AppGrid
import com.atvl.launcher.ui.components.FavoritesRow
import com.atvl.launcher.ui.components.TopBar
import com.atvl.launcher.ui.theme.ATVLTheme
import com.atvl.launcher.viewmodel.LauncherViewModel
import com.atvl.launcher.viewmodel.LauncherViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val repository = LauncherRepository(this)
        
        setContent {
            ATVLTheme {
                val viewModel: LauncherViewModel = viewModel(
                    factory = LauncherViewModelFactory(repository)
                )
                LauncherScreen(
                    viewModel = viewModel,
                    onAppClick = { app ->
                        app.intent?.let { startActivity(it) }
                    },
                    onSearchClick = {
                        val intent = Intent(Intent.ACTION_ASSIST)
                        startActivity(intent)
                    },
                    onSettingsClick = {
                        startActivity(Intent(Settings.ACTION_SETTINGS))
                    }
                )
            }
        }
    }
}

@Composable
fun LauncherScreen(
    viewModel: LauncherViewModel,
    onAppClick: (AppInfo) -> Unit,
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val apps by viewModel.apps.collectAsState()
    val favorites by viewModel.favorites.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            onSearchClick = onSearchClick,
            onSettingsClick = onSettingsClick
        )
        FavoritesRow(
            apps = favorites,
            onAppClick = onAppClick
        )
        AppGrid(
            apps = apps,
            onAppClick = onAppClick
        )
    }
}
