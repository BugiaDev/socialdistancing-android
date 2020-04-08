package com.accenture.socialdistancing.model

data class Contact (
    val risk: Int,
    val deviceName: String,
    val deviceMac: String,
    val timestamp: String
)