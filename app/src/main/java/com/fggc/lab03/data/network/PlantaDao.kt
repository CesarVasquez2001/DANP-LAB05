package com.fggc.lab03.data.network

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
 import com.fggc.lab03.core.Constants.Companion.PLANTAS_TABLE
import com.fggc.lab03.domain.model.Planta
import com.fggc.lab03.domain.repository.Plantas
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantaDao {
    @Query("SELECT * FROM $PLANTAS_TABLE ORDER BY plantaId ASC")
    fun getPlantas(): Flow<Plantas>

    @Insert(onConflict = IGNORE)
    fun addPlanta(planta: Planta)

    @Query("SELECT * FROM $PLANTAS_TABLE WHERE plantaId = :id")
    fun getPlanta(id: Int): Planta

    @Update
    fun updatePlanta(planta: Planta)

    @Delete
    fun deletePlanta(planta: Planta)


    @Query("SELECT * FROM $PLANTAS_TABLE WHERE userPlantaId = :id")
    fun getUsersWithPlants(id: Int): Flow<Plantas>

}