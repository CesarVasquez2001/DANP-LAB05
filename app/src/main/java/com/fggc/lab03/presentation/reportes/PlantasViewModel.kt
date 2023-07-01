package com.fggc.lab03.presentation.reportes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fggc.lab03.core.Constants.Companion.NO_VALUE
import com.fggc.lab03.domain.model.Planta
import com.fggc.lab03.domain.repository.PlantaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class
PlantasViewModel @Inject constructor(
    private val repo: PlantaRepository
) : ViewModel() {

    var planta by mutableStateOf(
        Planta(
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
    val plantas = repo.getPlantasFromRoom()


    var plantasUsers = repo.getUsersWithPlants(0)

    fun addPlanta(planta: Planta) = viewModelScope.launch(Dispatchers.IO)
    {
        repo.addPlantaToRoom(planta)
    }

    fun closeDialog() {
        openDialog = false
    }

    fun openDialog() {
        openDialog = true
    }

    fun deletePlanta(planta: Planta) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.deletePlantaFromRoom(planta)
        }

    fun updateTitulo(nombre: String) {
        this.planta = this.planta.copy(
            nombre = nombre
        )
    }

    fun updateDescription(especie: String) {
        planta = planta.copy(
            especie = especie
        )
    }

    fun updateLatitud(sensorHumedad: String) {
        planta = planta.copy(
            sensorHumedad = sensorHumedad
        )
    }

    fun updateLongitud(sensorTemperatura: String) {
        planta = planta.copy(
            sensorTemperatura = sensorTemperatura
        )
    }

    fun updateEstado(imagen: String) {
        planta = planta.copy(
            imagen = imagen
        )
    }

    fun updateComentarios(estado: String) {
        planta = planta.copy(
            estado = estado
        )
    }


    fun updatePlanta(planta: Planta) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.updatePlantaInRoom(planta)
        }

    fun getPlanta(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        planta = repo.getPlantaFromRoom(id)
    }

    fun getPostswithUser(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        plantasUsers = repo.getUsersWithPlants(id)
    }

}