package com.fggc.lab03.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fggc.lab03.domain.model.Asistente

@Database(entities = [Asistente::class], version = 3, exportSchema = false)
abstract  class AsistenteDB: RoomDatabase() {
    abstract fun asistenteDao(): AsistenteDao
}