package com.maestrovs.dvdremote.ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maestrovs.dvdremote.R
import com.maestrovs.dvdremote.ui.theme.Pink40
import com.maestrovs.dvdremote.ui.theme.RedCarbon
import com.maestrovs.dvdremote.ui.widget.buttons.BarIconButton
import com.maestrovs.dvdremote.ui.widget.buttons.BarTextButton

@Composable
fun PlayPanel(onClick: (String) -> Unit) {

    val spc = 12.dp

    Row(
        modifier = Modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {


        BarIconButton(R.drawable.ic_fast_rewind, "FAST_REWIND", onClick = onClick)
        Spacer(modifier = Modifier.width(spc))
        BarIconButton(R.drawable.ic_skip_prev, "SKIP PREV.", onClick = onClick)
        Spacer(modifier = Modifier.width(spc))
        BarIconButton(R.drawable.ic_stop, "STOP", onClick = onClick)
        Spacer(modifier = Modifier.width(spc))
        BarIconButton(R.drawable.ic_play_pause, "PLAY_PAUSE", color = RedCarbon, onClick = onClick)
        Spacer(modifier = Modifier.width(spc))
        BarIconButton(R.drawable.ic_skip_next, "SKIP NEXT", onClick = onClick)
        Spacer(modifier = Modifier.width(spc))
        BarIconButton(R.drawable.ic_fast_forward, "FAST_FORWARD", onClick = onClick)
    }
}

@Preview
@Composable
fun PreviewPlayPanel() {
    PlayPanel() {}
}