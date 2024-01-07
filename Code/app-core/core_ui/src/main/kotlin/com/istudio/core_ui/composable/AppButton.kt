package com.istudio.core_ui.composable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Shape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.istudio.core_ui.theme.fontFamily

@Composable
fun AppButton(
    modifier : Modifier = Modifier,
    buttonText : String,
    style : TextStyle = MaterialTheme.typography.labelLarge,
    shape : Shape = ButtonDefaults.shape,
    height : Dp = 44.dp,
    containerColor : Color = MaterialTheme.colorScheme.primary,
    isEnabled : Boolean = true,
    onClick : () -> Unit
){
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier.height(height),
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
        ),
        enabled = isEnabled
    ) {
        Text(
            text = buttonText,
            style = style,
            fontFamily = fontFamily
        )
    }
}