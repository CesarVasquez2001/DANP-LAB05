package com.fggc.lab03.domain.repository

import com.fggc.lab03.domain.model.User
import kotlinx.coroutines.flow.Flow

typealias Users = List<User>
interface UserRepository {
    fun getUsersFromRoom() : Flow<Users>
    fun addUserToRoom(user: User)
    // getUserFromRoom
    fun getUserFromRoom(id: Int): User


}