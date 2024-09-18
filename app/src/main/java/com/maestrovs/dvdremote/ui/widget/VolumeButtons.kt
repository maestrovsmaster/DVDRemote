package com.maestrovs.dvdremote.ui.widget

import android.media.MediaPlayer
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maestrovs.dvdremote.R
import com.maestrovs.dvdremote.ui.theme.ButtonCarbon
import com.maestrovs.dvdremote.ui.widget.vibro.performHapticFeedbackSafely

@Composable
fun VolumeBar(onClick: (String) -> Unit) {
    val view = LocalView.current

    val icSize = 30.dp

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .wrapContentSize()
            .background(Color.Black)
    ) {
        // Стрілка вгору
        // DirectionButton("↑")

        OutlinedButton(
            onClick = {
                performHapticFeedbackSafely(view)
                onClick("VOL+")
            },

            modifier = Modifier
                .width(70.dp)
                .height(60.dp)
                .padding(0.dp)
                /*.pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            performHapticFeedbackSafely(view)
                            onClick("VOL+")
                        }
                    )
                }*/,
            shape = RoundedCornerShape(
                topStart = 40.dp, topEnd = 40.dp,
                bottomStart = 6.dp, bottomEnd = 6.dp
            ),
            colors = ButtonDefaults.buttonColors(containerColor = ButtonCarbon),
            contentPadding = PaddingValues(0.dp),
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "up")
        }

        Text(text = "VOL", color = Color.White, modifier = Modifier.padding(3.dp))



        OutlinedButton(
            onClick = {




                performHapticFeedbackSafely(view)
                onClick("VOL-")
            },
            modifier = Modifier
                .width(70.dp)
                .height(60.dp)
                .padding(0.dp),
            border = BorderStroke(1.dp, ButtonCarbon),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = ButtonCarbon
            ),
            shape = RoundedCornerShape(
                bottomStart = 40.dp, bottomEnd = 40.dp,
                topStart = 6.dp, topEnd = 6.dp
            ),
            contentPadding = PaddingValues(0.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "down",
                tint = Color.White,
                modifier = Modifier
                    .size(icSize)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewVolumeBar() {
    VolumeBar() {

    }
}