package com.fggc.lab03.domain.repository

import com.fggc.lab03.domain.model.Planta
import kotlinx.coroutines.flow.Flow

typealias Plantas = List<Planta>
interface PlantaRepository {
    fun getPlantasFromRoom() : Flow<Plantas>
    fun addPlantaToRoom(planta: Planta)
    fun getPlantaFromRoom(id: Int): Planta
    fun updatePlantaInRoom(planta: Planta)
    fun deletePlantaFromRoom(planta: Planta)
    fun getUsersWithPlants(id: Int): Flow<Plantas>

}