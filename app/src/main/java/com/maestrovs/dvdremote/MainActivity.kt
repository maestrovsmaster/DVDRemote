package com.maestrovs.dvdremote

import android.content.Context
import android.hardware.ConsumerIrManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import com.maestrovs.dvdremote.core.CommandsViewModelFactory
import com.maestrovs.dvdremote.ui.remote.CommandsViewModel
import com.maestrovs.dvdremote.ui.remote.MainScreen
import com.maestrovs.dvdremote.ui.theme.DVDRemoteTheme

class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val irManager  = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager?

         val commandsViewModel = ViewModelProvider(
            this,
            CommandsViewModelFactory(applicationContext)
        )[CommandsViewModel::class.java]

        setContent {
            DVDRemoteTheme {
                MainScreen(commandsViewModel, irManager)
            }
        }
    }
}

