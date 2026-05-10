package com.atvl.launcher.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atvl.launcher.data.AppInfo
import com.atvl.launcher.data.LauncherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LauncherViewModel(private val repository: LauncherRepository) : ViewModel() {

    private val _apps = MutableStateFlow<List<AppInfo>>(emptyList())
    val apps: StateFlow<List<AppInfo>> = _apps.asStateFlow()

    private val _favorites = MutableStateFlow<List<AppInfo>>(emptyList())
    val favorites: StateFlow<List<AppInfo>> = _favorites.asStateFlow()

    init {
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            val installedApps = repository.getInstalledApps()
            _apps.value = installedApps
            // For now, let's just make the first 5 apps favorites for demonstration
            _favorites.value = installedApps.take(5)
        }
    }
}
