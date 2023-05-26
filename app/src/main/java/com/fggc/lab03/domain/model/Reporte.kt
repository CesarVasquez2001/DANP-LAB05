package com.fggc.lab03.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fggc.lab03.core.Constants.Companion.REPORTE_TABLE

@Entity(tableName = REPORTE_TABLE)
data class Reporte(
    @PrimaryKey(autoGenerate = true)
    val reporteId: Int,
    val titulo: String,
    // val date: Date,
    val description: String,
    // val image: Image,
    val latitud: String,
    val longitud: String,
    val estado: String,
    val comentarios: String,

    val userReporteId: Int,
)
