package com.fggc.lab03.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fggc.lab03.core.Constants.Companion.PLANTAS_TABLE

@Entity(tableName = PLANTAS_TABLE)
data class Planta(
    @PrimaryKey(autoGenerate = true)
    val plantaId: Int,
    val nombre: String,
    val especie: String,
    val sensorHumedad: String,
    val sensorTemperatura: String,
    val imagen: String,
    val estado: String,
    val userPlantaId: Int,
)
