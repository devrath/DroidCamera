package com.istudio.feature_camera.presentation.emums

import androidx.annotation.StringRes
import com.istudio.feature_camera.R
enum class Tabs(@StringRes val rawValue : Int) {
    CAMERA(rawValue = R.string.str_photo),
    STORY(rawValue = R.string.str_video),
    SCANNER(rawValue = R.string.str_scanner)
}