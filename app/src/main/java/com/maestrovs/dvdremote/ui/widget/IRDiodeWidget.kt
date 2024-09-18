package com.maestrovs.dvdremote.ui.widget

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maestrovs.dvdremote.ui.theme.BlackGray
import kotlinx.coroutines.delay

@Composable
fun IRDiodeWidget(shouldBlink: Boolean) {
    // Анімація зміни кольору діода
    val diodeColor by animateColorAsState(
        targetValue = if (shouldBlink) Color.Red else BlackGray,
        label = "diodeColor"
    )

    // Круглий ІЧ-діод
    Box(
        modifier = Modifier
            .height(20.dp).width(10.dp)
            .background(diodeColor, shape = CircleShape)
    )
}

@Preview
@Composable
fun IRDiodeWidgetPreview() {
    IRDiodeWidget(shouldBlink = true)
}