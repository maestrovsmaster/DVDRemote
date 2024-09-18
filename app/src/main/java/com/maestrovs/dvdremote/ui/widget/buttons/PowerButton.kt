package com.maestrovs.dvdremote.ui.widget.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maestrovs.dvdremote.R
import com.maestrovs.dvdremote.ui.theme.RedCarbon
import com.maestrovs.dvdremote.ui.widget.vibro.performHapticFeedbackSafely

@Composable
fun PowerButton(onClick: (String) -> Unit) {
    val view = LocalView.current

    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(RedCarbon)
            .clickable {
                performHapticFeedbackSafely(view)
                onClick("POWER")
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_power),
            contentDescription = "power",
            modifier = Modifier
                .size(64.dp),
            tint = Color.White
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewPowerButton() {
    PowerButton(){}
}