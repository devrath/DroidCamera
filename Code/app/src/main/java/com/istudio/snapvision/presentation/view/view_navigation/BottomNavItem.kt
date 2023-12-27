package com.istudio.snapvision.presentation.view.view_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title : String,val image : ImageVector
){
    companion object{
        const val initialPosition = 0
        const val CaptureImageScreenPosition = 0
        const val RecordVideoScreenPosition = 0

        const val CaptureImageTitle = "CaptureImage"
        const val RecordVideoTitle = "RecordVideo"

        val CaptureImageIcon = Icons.Default.PhotoCamera
        val RecordVideoIcon = Icons.Default.Videocam
    }
}
