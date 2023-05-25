package com.fggc.lab03.presentation.reportes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fggc.lab03.core.Constants.Companion.NO_VALUE
import com.fggc.lab03.domain.model.Reporte
import com.fggc.lab03.domain.repository.ReporteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class
ReportesViewModel @Inject constructor(
    private val repo: ReporteRepository
) : ViewModel() {

    var reporte by mutableStateOf(
        Reporte(
            0,
            NO_VALUE,
            NO_VALUE,
            NO_VALUE,
            NO_VALUE,
            NO_VALUE,
            NO_VALUE,
            0
        )
    )
    var openDialog by mutableStateOf(false)
    val reportes = repo.getReportesFromRoom()


    var reportesUsers = repo.getUsersWithPosts(0)

    fun addReporte(reporte: Reporte) = viewModelScope.launch(Dispatchers.IO)
    {
        repo.addReporteToRoom(reporte)
    }

    fun closeDialog() {
        openDialog = false
    }

    fun openDialog() {
        openDialog = true
    }

    fun deleteReporte(reporte: Reporte) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteReporteFromRoom(reporte)
        }

    fun updateTitulo(titulo: String) {
        this.reporte = this.reporte.copy(
            titulo = titulo
        )
    }

    fun updateDescription(description: String) {
        reporte = reporte.copy(
            description = description
        )
    }

    fun updateLatitud(latitud: String) {
        reporte = reporte.copy(
            latitud = latitud
        )
    }

    fun updateLongitud(longitud: String) {
        reporte = reporte.copy(
            longitud = longitud
        )
    }

    fun updateEstado(estado: String) {
        reporte = reporte.copy(
            estado = estado
        )
    }

    fun updateComentarios(comentarios: String) {
        reporte = reporte.copy(
            comentarios = comentarios
        )
    }


    fun updateReporte(reporte: Reporte) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateReporteInRoom(reporte)
        }

    fun getReporte(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        reporte = repo.getReporteFromRoom(id)
    }

    fun getPostswithUser(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        reportesUsers = repo.getUsersWithPosts(id)
    }

}