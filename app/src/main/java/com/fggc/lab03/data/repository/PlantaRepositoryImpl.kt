package com.fggc.lab03.data.repository

import com.fggc.lab03.data.network.PlantaDao
import com.fggc.lab03.domain.model.Planta
import com.fggc.lab03.domain.repository.PlantaRepository

class PlantaRepositoryImpl(
    private val plantaDao: PlantaDao
) : PlantaRepository {
    override fun getPlantasFromRoom() = plantaDao.getPlantas()
    override fun addPlantaToRoom(planta: Planta) = plantaDao.addPlanta(planta)

    // getAsistente
    override fun getPlantaFromRoom(id: Int) = plantaDao.getPlanta(id)

    // updateAsistentes
    override fun updatePlantaInRoom(planta: Planta) =
        plantaDao.updatePlanta(planta)

    // deleteAsistente
    override fun deletePlantaFromRoom(planta: Planta) =
        plantaDao.deletePlanta(planta)

    override fun getUsersWithPlants(id: Int) = plantaDao.getUsersWithPlants(id)

}
