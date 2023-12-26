package com.istudio.core_ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class BottomTabs(
    @StringRes
    val title: Int,
    @DrawableRes
    val icon: Int,
    val route: String
) {
    SCREEN_CAPTURE_IMAGE(R.string.str_capture_image, R.drawable.ic_camera, "home"),
    SCREEN_CAPTURE_VIDEO(R.string.str_record_video, R.drawable.ic_video, "settings")
}