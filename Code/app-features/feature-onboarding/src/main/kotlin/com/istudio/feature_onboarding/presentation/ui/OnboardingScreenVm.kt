package com.istudio.feature_onboarding.presentation.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.runtime.mutableStateListOf
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class OnboardingScreenVm @Inject constructor( ) : ViewModel() {

    val permissionsToRequest = arrayOf(Manifest.permission.CAMERA)
    val visiblePermissionDialogQueue = mutableStateListOf<String>()

    fun dismissDialog() {
        visiblePermissionDialogQueue.removeFirst()
    }

    fun onPermissionResult(permission: String, isGranted: Boolean) {
        if(!isGranted && !visiblePermissionDialogQueue.contains(permission)) {
            visiblePermissionDialogQueue.add(permission)
        }
    }


    fun isCameraPermissionGranted(activity : Context): Boolean {
        return ContextCompat.checkSelfPermission(
            activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

}