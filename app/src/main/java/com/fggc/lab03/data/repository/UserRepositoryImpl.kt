package com.fggc.lab03.data.repository

import com.fggc.lab03.data.network.AsistenteDao
import com.fggc.lab03.data.network.UserDao
import com.fggc.lab03.domain.model.Asistente
import com.fggc.lab03.domain.model.User
import com.fggc.lab03.domain.repository.AsistenteRepository
import com.fggc.lab03.domain.repository.UserRepository

class UserRepositoryImpl (
    private  val userDao: UserDao
        ): UserRepository {
        override fun getUsersFromRoom() = userDao.getUsers()
        override fun addUserToRoom(user: User) = userDao.addUser(user)

    // getUser
    override fun getUserFromRoom(id: Int) = userDao.getUser(id)



}
