package com.maestrovs.dvdremote.ui.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maestrovs.dvdremote.ui.theme.ButtonCarbon
import com.maestrovs.dvdremote.ui.widget.vibro.performHapticFeedbackSafely

@Composable
fun NavigationRemote(onClick: (String) -> Unit) {
    val view = LocalView.current

    val icSize = 30.dp

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.wrapContentSize()
    ) {
        // Стрілка вгору
        // DirectionButton("↑")

        OutlinedButton(
            onClick = {
                onClick("UP")
            },
            modifier = Modifier
                .width(70.dp)
                .height(40.dp)
                .padding(0.dp),
            shape = RoundedCornerShape(
                topStart = 40.dp, topEnd = 40.dp,
                bottomStart = 6.dp, bottomEnd = 6.dp
            ),
            colors = ButtonDefaults.buttonColors(containerColor = ButtonCarbon),
            contentPadding = PaddingValues(0.dp),
        ) {
            Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "top")
        }

        Row {


            OutlinedButton(
                modifier = Modifier
                    .width(40.dp)
                    .height(70.dp)
                    .padding(0.dp),
                onClick = {
                    onClick("LEFT")
                },
                shape = RoundedCornerShape(
                    topStart = 30.dp, bottomStart = 30.dp,
                    topEnd = 6.dp, bottomEnd = 6.dp
                ),
                colors = ButtonDefaults.buttonColors(containerColor = ButtonCarbon),
                contentPadding = PaddingValues(0.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "top",
                    modifier = Modifier
                        .size(icSize)
                )
            }
            OKButton(onClick)


            OutlinedButton(
                onClick = {
                    performHapticFeedbackSafely(view)
                    onClick("RIGHT")
                },
                modifier = Modifier
                    .width(40.dp)
                    .height(70.dp)
                    .padding(0.dp),
                border = BorderStroke(1.dp, ButtonCarbon),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = ButtonCarbon
                ),
                shape = RoundedCornerShape(
                    topEnd = 30.dp, bottomEnd = 30.dp,
                    topStart = 6.dp, bottomStart = 6.dp
                ),
                contentPadding = PaddingValues(0.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "right",
                    tint = Color.White,
                    modifier = Modifier
                        .size(icSize)
                )
            }
        }


        OutlinedButton(
            onClick = {
                performHapticFeedbackSafely(view)
                onClick("DOWN")
            },
            modifier = Modifier
                .width(70.dp)
                .height(40.dp)
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
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "DOWN",
                tint = Color.White,
                modifier = Modifier
                    .size(icSize)
            )
        }
    }
}


@Composable
fun OKButton(onClick: (String) -> Unit) {
    val view = LocalView.current
    OutlinedButton(
        onClick = {
            performHapticFeedbackSafely(view)
            onClick("OK")
        },
        modifier = Modifier
            .size(70.dp)
            .padding(6.dp),
        shape = RoundedCornerShape(
            bottomStart = 6.dp, bottomEnd = 6.dp,
            topStart = 6.dp, topEnd = 6.dp
        ),
        colors = ButtonDefaults.buttonColors(containerColor = ButtonCarbon),
        contentPadding = PaddingValues(0.dp),
    ) {
        Text(
            "OK", style = MaterialTheme.typography.labelSmall, color = Color.White,
            modifier = Modifier.padding(0.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewNavigationRemote() {
    NavigationRemote() {

    }
}