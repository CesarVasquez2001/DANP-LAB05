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
    // val nombre: String,
    // val apellido: String,
    // val fechaInscripcion: String,
    // val tipoSangre: String,
    //    val telefono: String,
    //    val correo: String,
    //    val montoPagado: String,
    val userReporteId: Int,
)
// MVVM