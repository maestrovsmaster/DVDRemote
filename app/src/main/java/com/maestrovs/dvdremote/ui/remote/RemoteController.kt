package com.maestrovs.dvdremote.ui.remote

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maestrovs.dvdremote.R
import com.maestrovs.dvdremote.ui.theme.Purple40
import com.maestrovs.dvdremote.ui.widget.IRDiodeWidget
import com.maestrovs.dvdremote.ui.widget.NavigateBlock
import com.maestrovs.dvdremote.ui.widget.NumPad
import com.maestrovs.dvdremote.ui.widget.PlayPanel
import com.maestrovs.dvdremote.ui.widget.VolumeBar
import com.maestrovs.dvdremote.ui.widget.buttons.BarIconButton
import com.maestrovs.dvdremote.ui.widget.buttons.BarTextButton
import com.maestrovs.dvdremote.ui.widget.buttons.MuteButton
import com.maestrovs.dvdremote.ui.widget.buttons.PowerButton
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RemoteController(onClickButton: (String) -> Unit) {

    var shouldBlink by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()



    val onClick: (String) -> Unit = { str ->
        onClickButton(str)

        shouldBlink = true
        coroutineScope.launch {
            delay(150)
            shouldBlink = false
        }
    }


    val vertSpc = 20.dp

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(modifier = Modifier
            .align(Alignment.TopCenter)
            .matchParentSize()) {
            IRDiodeWidget(shouldBlink)
        }




        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.Black)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Row(modifier = Modifier.align(Alignment.Start)) {
                PowerButton(onClick)
                Spacer(modifier = Modifier.weight(1f))



                    Image(
                        painter = painterResource(id = R.drawable.logo_bush),
                        contentDescription = "mute",
                        modifier = Modifier
                            .height(40.dp),
                    )



                Spacer(modifier = Modifier.weight(1f))



                BarIconButton(resId = R.drawable.ic_eject, tag = "EJECT", onClick = onClick)


            }
            Spacer(modifier = Modifier.height(vertSpc))


            NumPad(onClick)

            Spacer(modifier = Modifier.height(vertSpc))

            PlayPanel(onClick)

            Spacer(modifier = Modifier.height(vertSpc))


            NavigateBlock(onClick)




            Spacer(modifier = Modifier.height(vertSpc))

            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {


                MuteButton(onClick)
                Spacer(modifier = Modifier.width(40.dp))
                VolumeBar(onClick)
                // Spacer(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(80.dp))
            }

            Spacer(modifier = Modifier.height(vertSpc))



            Spacer(modifier = Modifier.height(vertSpc))

            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .wrapContentSize()
            ) {

                BarTextButton("AV", "AV_SOURCE", color = Purple40, onClick = onClick)
                Spacer(modifier = Modifier.width(16.dp))
                BarIconButton(resId = R.drawable.ic_zoom, tag = "ZOOM", onClick = onClick)
                Spacer(modifier = Modifier.width(16.dp))
                BarIconButton(resId = R.drawable.ic_info, tag = "DISP", onClick = onClick)
                Spacer(modifier = Modifier.width(16.dp))
                BarIconButton(resId = R.drawable.ic_data_info, tag = "TEXT", onClick = onClick)

            }



        }

        Text(
            "© by Vasyl Horodetskyi",
            style = MaterialTheme.typography.labelSmall, color = Color.DarkGray,
            modifier = Modifier
                .align(Alignment.BottomCenter).padding(bottom = 16.dp)
        )
    }
}

@Preview
@Composable
fun RemoteControllerPreview() {
    RemoteController() {

    }

}