package com.fggc.lab03.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fggc.lab03.domain.model.Reporte
import com.fggc.lab03.domain.model.SensorData
import com.fggc.lab03.domain.model.User

@Database(entities = [SensorData::class], version = 4, exportSchema = false)
abstract class SensorDataDB : RoomDatabase() {
    abstract fun sensorDataDao(): SensorDataDao
}