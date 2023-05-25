package com.fggc.lab03.data.repository

import com.fggc.lab03.data.network.UserDao
import com.fggc.lab03.domain.model.User
import com.fggc.lab03.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {
    override fun getUsersFromRoom() = userDao.getUsers()
    override fun addUserToRoom(user: User) = userDao.addUser(user)

    // getUser
    override fun getUserFromRoom(id: Int) = userDao.getUser(id)

    override fun getUsersWithPosts(userRegistroId: Int)= userDao.getUsersWithPosts()



    override fun getUserConfirm(email: String, password: String) =
        userDao.getUserConfirm(email, password)


}
