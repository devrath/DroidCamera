package com.istudio.feature_onboarding.presentation.ui

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.istudio.core_common.platform.extensions.openAppSettings
import com.istudio.core_ui.composable.AppButton
import com.istudio.feature_onboarding.presentation.composables.CameraPermissionTextProvider
import com.istudio.feature_onboarding.presentation.composables.PermissionDialog
import com.istudio.feature_onboarding.presentation.composables.SplashAnimation

@Composable
fun OnboardingScreen(navController: NavHostController) {

    val viewModel: OnboardingScreenVm = hiltViewModel()
    val dialogQueue = viewModel.visiblePermissionDialogQueue
    val permissionsToRequest = OnboardingScreenVm.permissionsToRequest
    val activity = LocalContext.current as Activity

    val multiplePermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { perms ->
            permissionsToRequest.forEach { permission ->
                viewModel.onPermissionResult(
                    permission = permission,
                    isGranted = perms[permission] == true
                )
            }
        }
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // Camera Animation
        SplashAnimation(
            modifier = Modifier.weight(3f)
        )

        // Action
        Column(
            modifier = Modifier
                .weight(1f).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppButton(buttonText = "Next") {
                if (viewModel.isCameraPermissionGranted(activity)) {
                    // Permission is already granted
                    //openCamera();
                } else {
                    multiplePermissionResultLauncher.launch(permissionsToRequest)
                }
            }
        }

        dialogQueue
            .reversed()
            .forEach { permission ->
                PermissionDialog(
                    permissionTextProvider = when (permission) {
                        Manifest.permission.CAMERA -> {
                            CameraPermissionTextProvider()
                        }

                        else -> return@forEach
                    },
                    isPermanentlyDeclined = !shouldShowRequestPermissionRationale(
                        activity, permission
                    ),
                    onDismiss = viewModel::dismissDialog,
                    onOkClick = {
                        viewModel.dismissDialog()
                        multiplePermissionResultLauncher.launch(
                            arrayOf(permission)
                        )
                    },
                    onGoToAppSettingsClick = {
                        activity.openAppSettings()
                    }
                )
            }
    }
}

@Composable
@Preview
private fun CurrentScreen() {
    OnboardingScreen(navController = NavHostController(LocalContext.current))
}