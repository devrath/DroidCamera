package com.istudio.snapvision.presentation.view.view_navigation

data class BottomNavItem(val title : String){
    companion object{
        const val initialPosition = 0
        const val CaptureImage = "CaptureImage"
        const val RecordVideo = "RecordVideo"
    }
}
