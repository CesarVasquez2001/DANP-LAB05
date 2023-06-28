package com.fggc.lab03.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SensorData")
data class SensorData(
    @PrimaryKey(autoGenerate = true)
    val sensorDataId: Int,
    val date: String,
    val medicion: String,
    val comentario: String
)