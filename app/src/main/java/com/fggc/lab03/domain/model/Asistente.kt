package com.fggc.lab03.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fggc.lab03.core.Constants.Companion.ASISTENTE_TABLE

@Entity (tableName = ASISTENTE_TABLE)
data class Asistente(
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val nombre: String,
    val apellido: String,
    val fechaInscripcion: String,
    val tipoSangre: String,
    val telefono: String,
    val correo: String,
    val montoPagado: String,
)
