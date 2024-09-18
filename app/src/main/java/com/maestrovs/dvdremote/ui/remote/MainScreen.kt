package com.maestrovs.dvdremote.ui.remote

import android.hardware.ConsumerIrManager
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import com.maestrovs.dvdremote.R
import com.maestrovs.dvdremote.core.FREQUENCY
import com.maestrovs.dvdremote.core.irHexComToSig
import com.maestrovs.dvdremote.ui.widget.vibro.performHapticFeedbackSafely

@Composable
fun MainScreen(viewModel: CommandsViewModel, irManager: ConsumerIrManager?) {


    val commands by viewModel.commands.observeAsState(emptyList())
    val error by viewModel.error.observeAsState(null)

    var someText by remember { mutableStateOf("") }

    commands.forEach { command ->
        Log.d("MainScreen", "Command: ${command}")
    }
    error?.let {
        Log.e("MainScreen", "Error: $it")
    }




    val context = LocalContext.current
    val mediaPlayer = MediaPlayer.create(context, R.raw.click)

    DisposableEffect(context) {
        onDispose {
            mediaPlayer.release()
        }
    }

    if (irManager?.hasIrEmitter() == true) {
       RemoteController(){ str ->
           mediaPlayer.start()

           viewModel.findCommandByLabel(str)?.let { command ->
               irManager?.transmit(FREQUENCY, irHexComToSig(command.hexcode).toIntArray())


           }
       }

    } else {
        // No IR
        someText = "NO IR"
        val view = LocalView.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("IR emitter not available.")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                performHapticFeedbackSafely(view)

            }) {
                Text("Exit")
            }
        }
    }

    Text(someText, modifier = Modifier.padding(16.dp), color = Color.Red)
}

