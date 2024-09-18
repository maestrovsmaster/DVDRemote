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
import com.maestrovs.dvdremote.ui.theme.YellowCarbon
import com.maestrovs.dvdremote.ui.widget.vibro.performHapticFeedbackSafely

@Composable
fun MuteButton(onClick: (String) -> Unit) {
    val view = LocalView.current

    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(YellowCarbon)
            .clickable {
                performHapticFeedbackSafely(view)
                onClick("MUTE")
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.volume_mute_24dp_5f6368_fill0_wght400_grad0_opsz24),
            contentDescription = "mute",
            modifier = Modifier
                .size(64.dp),
            tint = Color.White
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMuteButton() {
    MuteButton(){}
}