package com.fggc.lab03.data.network

import androidx.paging.PagingSource
import androidx.room.*
import com.fggc.lab03.domain.model.SensorData
import com.fggc.lab03.domain.repository.SensorDatas
import kotlinx.coroutines.flow.Flow

@Dao
interface SensorDataDao {
    @Upsert
    fun insertAll(sensorDatas: List<SensorData>)

    @Upsert
    fun insert(sensorData: SensorData)

    @Query("SELECT * FROM SensorData")
    fun pagingSource(): PagingSource<Int, SensorData>


    @Query("SELECT * FROM SensorData")
    fun getAll(): Flow<SensorDatas>


    @Query("DELETE FROM SensorData")
    fun clearAll()
}