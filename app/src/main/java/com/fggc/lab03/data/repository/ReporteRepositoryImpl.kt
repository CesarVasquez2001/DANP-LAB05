package com.fggc.lab03.data.repository

import com.fggc.lab03.data.network.ReporteDao
import com.fggc.lab03.domain.model.Reporte
import com.fggc.lab03.domain.repository.ReporteRepository

class ReporteRepositoryImpl(
    private val reporteDao: ReporteDao
) : ReporteRepository {
    override fun getReportesFromRoom() = reporteDao.getReportes()
    override fun addReporteToRoom(asistente: Reporte) = reporteDao.addReporte(asistente)

    // getAsistente
    override fun getReporteFromRoom(id: Int) = reporteDao.getReporte(id)

    // updateAsistentes
    override fun updateReporteInRoom(asistente: Reporte) =
        reporteDao.updateReporte(asistente)

    // deleteAsistente
    override fun deleteReporteFromRoom(asistente: Reporte) =
        reporteDao.deleteReporte(asistente)

    override fun getUsersWithPosts(id: Int) = reporteDao.getUsersWithPosts(id)

}
