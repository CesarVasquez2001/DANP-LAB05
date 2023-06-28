package com.fggc.lab03.data.repository

import com.fggc.lab03.data.network.SensorDataDao
import com.fggc.lab03.domain.model.SensorData
import com.fggc.lab03.domain.repository.SensorDataRepository
import kotlinx.coroutines.flow.Flow

class SensorDataRepositoryImpl(
    private val sensorDataDao: SensorDataDao
) : SensorDataRepository {

    override fun addSensorDatas(sensorDatas: List<SensorData>) =
        sensorDataDao.insertAll(sensorDatas)

    override fun addSensorData(sensorData: SensorData) = sensorDataDao.insert(sensorData)

    override fun getPagingSource() = sensorDataDao.pagingSource()
    override fun getAll() = sensorDataDao.getAll()
    override fun deleteSensorDatas() = sensorDataDao.clearAll()


}
