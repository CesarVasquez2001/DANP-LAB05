package com.fggc.lab03.domain.repository

import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.fggc.lab03.domain.model.SensorData
import com.fggc.lab03.domain.model.User
import com.fggc.lab03.domain.model.UserWithRegister
import kotlinx.coroutines.flow.Flow

typealias SensorDatas = List<SensorData>

interface SensorDataRepository {


    fun addSensorDatas(sensorDatas : List<SensorData>)

    fun addSensorData(sensorData: SensorData)

    fun getPagingSource(): PagingSource<Int, SensorData>

    fun getAll(): Flow<SensorDatas>

    fun deleteSensorDatas()



}