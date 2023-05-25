package com.fggc.lab03.data.network

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
 import com.fggc.lab03.core.Constants.Companion.REPORTE_TABLE
import com.fggc.lab03.domain.model.Reporte
import com.fggc.lab03.domain.repository.Reportes
import kotlinx.coroutines.flow.Flow

@Dao
interface ReporteDao {
    @Query("SELECT * FROM $REPORTE_TABLE ORDER BY reporteId ASC")
    fun getReportes(): Flow<Reportes>

    @Insert(onConflict = IGNORE)
    fun addReporte(reporte: Reporte)

    @Query("SELECT * FROM $REPORTE_TABLE WHERE reporteId = :id")
    fun getReporte(id: Int): Reporte

    @Update
    fun updateReporte(reporte: Reporte)

    @Delete
    fun deleteReporte(reporte: Reporte)


    @Query("SELECT * FROM $REPORTE_TABLE WHERE userReporteId = :id")
    fun getUsersWithPosts(id: Int): Flow<Reportes>

}