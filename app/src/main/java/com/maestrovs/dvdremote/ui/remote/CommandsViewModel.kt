package com.maestrovs.dvdremote.ui.remote

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maestrovs.dvdremote.core.model.Command
import com.maestrovs.dvdremote.core.model.CommandsResponse
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.io.InputStreamReader

class CommandsViewModel(private val context: Context) : ViewModel() {
    private val _commands = MutableLiveData<List<Command>>()
    val commands: LiveData<List<Command>> get() = _commands

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    init {
        loadCommands()
    }

    private fun loadCommands() {
        viewModelScope.launch {
            try {
                val inputStream = context.assets.open("commands.json")
                val reader = InputStreamReader(inputStream)

                val json = reader.readText()
                val parsedData = Json.decodeFromString<CommandsResponse>(json)
                _commands.value = parsedData.Keys
            } catch (e: Exception) {
                _error.value = "Error loading commands: ${e.message}"
            }
        }
    }

    fun findCommandByLabel(label: String): Command? {
        return _commands.value?.find { it.label == label }
    }
}