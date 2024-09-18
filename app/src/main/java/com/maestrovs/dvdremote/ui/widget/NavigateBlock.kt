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
import com.maestrovs.dvdremote.ui.theme.Pink40
import com.maestrovs.dvdremote.ui.widget.buttons.BarIconButton
import com.maestrovs.dvdremote.ui.widget.buttons.BarTextButton

@Composable
fun NavigateBlock(onClick: (String) -> Unit){

    val spc = 26.dp


    Row(
        modifier = Modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {

            BarIconButton(resId = R.drawable.ic_note, tag = "AUDIO", onClick = onClick)
            Spacer(modifier = Modifier.height(70.dp))
            BarIconButton(resId = R.drawable.ic_subtitles, tag = "SUBTITLE", onClick = onClick)

        }

        Spacer(modifier = Modifier.width(spc))
        NavigationRemote(onClick = onClick)
        Spacer(modifier = Modifier.width(spc))
        Column {
             BarTextButton("MENU", tag = "MENU", color = Pink40, onClick = onClick)
            Spacer(modifier = Modifier.height(70.dp))
            BarIconButton(resId = R.drawable.ic_settings, tag = "MODE", onClick = onClick)


        }
    }

}

@Preview
@Composable
fun PreviewNavigateBlock(){
    NavigateBlock(){

    }

    }