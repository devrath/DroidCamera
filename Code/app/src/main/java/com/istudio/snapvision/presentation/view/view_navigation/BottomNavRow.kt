package com.istudio.snapvision.presentation.view.view_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavRow(
    updatePositionOnClick :(Int) -> Unit
) {

    // List of items/screens for bottom tab
    val items = listOf(
        BottomNavItem(
            title = BottomNavItem.CaptureImageTitle,
            image = BottomNavItem.CaptureImageIcon
        ),
        BottomNavItem(
            title = BottomNavItem.RecordVideoTitle,
            image = BottomNavItem.RecordVideoIcon
        )
    )

    BottomAppBar(
        tonalElevation = 3.dp
    ) {
        val weight = 1f / items.size
        items.forEachIndexed { index, content ->
            IconButton(
                onClick = { updatePositionOnClick.invoke(index) },
                modifier = Modifier.weight(weight)
            ) {
                Icon(
                    imageVector = if (index == 0) {
                        BottomNavItem.CaptureImageIcon
                    } else {
                        BottomNavItem.RecordVideoIcon
                    },
                    contentDescription = content.title
                )
            }
        }
    }
}