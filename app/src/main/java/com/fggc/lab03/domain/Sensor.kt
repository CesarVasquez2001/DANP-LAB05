package com.fggc.lab03.domain


data class Sensor(
    val sensorDataId: Int,
    val date: String,
    val medicion: String,
    val comentario: String
)