package com.fggc.lab03.domain.repository

import com.fggc.lab03.domain.model.Asistente
import kotlinx.coroutines.flow.Flow

typealias Asistentes = List<Asistente>
interface AsistenteRepository {
    fun getAsistentesFromRoom() : Flow<Asistentes>
    fun addAsistenteToRoom(asistente: Asistente)
    // getAsistenteFromRoom
    fun getAsistenteFromRoom(id: Int): Asistente
    //updateAsistenteInRoom
    fun updateAsistenteInRoom(asistente: Asistente)
    //deleteAsistenteFromRoom
    fun deleteAsistenteFromRoom(asistente: Asistente)


}