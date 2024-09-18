package com.maestrovs.dvdremote.core.model

import kotlinx.serialization.Serializable


@Serializable
data class Command(
    val label: String,
    val hexcode: String,
    val protocol: String
)

@Serializable
data class CommandsResponse(
    val Link: String,
    val Keys: List<Command>
)