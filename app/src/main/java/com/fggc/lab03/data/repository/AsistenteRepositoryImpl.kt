package com.fggc.lab03.data.repository

import com.fggc.lab03.data.network.AsistenteDao
import com.fggc.lab03.domain.model.Asistente
import com.fggc.lab03.domain.repository.AsistenteRepository

class AsistenteRepositoryImpl (
    private  val asistenteDao: AsistenteDao
        ): AsistenteRepository{
        override fun getAsistentesFromRoom() = asistenteDao.getAsistentes()
        override fun addAsistenteToRoom(asistente: Asistente) = asistenteDao.addAsistente(asistente)

    // getAsistente
    override fun getAsistenteFromRoom(id: Int) = asistenteDao.getAsistente(id)

    // updateAsistentes
    override fun updateAsistenteInRoom(asistente: Asistente) =
        asistenteDao.updateAsistente(asistente)

    // deleteAsistente
    override fun deleteAsistenteFromRoom(asistente: Asistente) =
        asistenteDao.deleteAsistente(asistente)


        }
