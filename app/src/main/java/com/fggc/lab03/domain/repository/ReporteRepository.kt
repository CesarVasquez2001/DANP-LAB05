package com.fggc.lab03.domain.repository

import com.fggc.lab03.domain.model.Reporte
import kotlinx.coroutines.flow.Flow

typealias Reportes = List<Reporte>
interface ReporteRepository {
    fun getReportesFromRoom() : Flow<Reportes>
    fun addReporteToRoom(asistente: Reporte)
    // getAsistenteFromRoom
    fun getReporteFromRoom(id: Int): Reporte
    //updateAsistenteInRoom
    fun updateReporteInRoom(asistente: Reporte)
    //deleteAsistenteFromRoom
    fun deleteReporteFromRoom(asistente: Reporte)

    fun getUsersWithPosts(id: Int): Flow<Reportes>

}