package com.fggc.lab03.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fggc.lab03.domain.model.Planta
import com.fggc.lab03.domain.model.User

@Database(entities = [Planta::class, User::class], version = 2, exportSchema = false)
abstract  class PlantaDB: RoomDatabase() {
    abstract fun plantaDao(): PlantaDao
}