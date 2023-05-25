package com.fggc.lab03.data.network

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import com.fggc.lab03.core.Constants.Companion.ASISTENTE_TABLE
import com.fggc.lab03.domain.model.Asistente
import com.fggc.lab03.domain.repository.Asistentes
import kotlinx.coroutines.flow.Flow

@Dao
interface AsistenteDao {
    @Query("SELECT * FROM $ASISTENTE_TABLE ORDER BY id ASC")
    fun getAsistentes(): Flow<Asistentes>

    @Insert(onConflict = IGNORE)
    fun addAsistente(asistente: Asistente)

    @Query("SELECT * FROM $ASISTENTE_TABLE WHERE id = :id")
    fun getAsistente(id: Int): Asistente

    @Update
    fun updateAsistente(asistente: Asistente)

    @Delete
    fun deleteAsistente(asistente: Asistente)

}