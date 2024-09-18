package com.maestrovs.dvdremote.core

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maestrovs.dvdremote.ui.remote.CommandsViewModel

class CommandsViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommandsViewModel::class.java)) {
            return CommandsViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}