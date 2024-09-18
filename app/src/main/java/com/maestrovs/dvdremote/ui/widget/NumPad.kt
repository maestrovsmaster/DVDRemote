package com.maestrovs.dvdremote.ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maestrovs.dvdremote.R
import com.maestrovs.dvdremote.ui.theme.Purple40
import com.maestrovs.dvdremote.ui.widget.buttons.NumButton
import com.maestrovs.dvdremote.ui.widget.buttons.RoundButton
import com.maestrovs.dvdremote.ui.widget.buttons.RoundIconButton

@Composable
fun NumPad(onClick: (String) -> Unit){

val spc = 16.dp

    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumButton("1", onClick = onClick)
            Spacer(modifier = Modifier.width(spc))
            NumButton("2", onClick = onClick)
            Spacer(modifier = Modifier.width(spc))
            NumButton("3", onClick = onClick)
            Spacer(modifier = Modifier.width(spc))
            RoundIconButton(resId = R.drawable.ic_replay, tag = "REPEAT", onClick = onClick )

        }
        Spacer(modifier = Modifier.height(spc))
        Row(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumButton("4", onClick = onClick)
            Spacer(modifier = Modifier.width(spc))
            NumButton("5", onClick = onClick)
            Spacer(modifier = Modifier.width(spc))
            NumButton("6", onClick = onClick)
            Spacer(modifier = Modifier.width(spc))
            RoundIconButton(resId = R.drawable.ic_slow_motion, tag = "SLOW", onClick = onClick )
        }
        Spacer(modifier = Modifier.height(spc))
        Row(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumButton("7", onClick = onClick)
            Spacer(modifier = Modifier.width(spc))
            NumButton("8", onClick = onClick)
            Spacer(modifier = Modifier.width(spc))
            NumButton("9", onClick = onClick)
            Spacer(modifier = Modifier.width(spc))
            NumButton("0", onClick = onClick)
        }

    }
}

@Preview
@Composable
fun PreviewNumPad(){
    NumPad{}
}