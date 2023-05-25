package com.fggc.lab03.domain.repository

import androidx.room.Query
import com.fggc.lab03.core.Constants
import com.fggc.lab03.domain.model.User
import com.fggc.lab03.domain.model.UserWithRegister
import kotlinx.coroutines.flow.Flow

typealias Users = List<User>
interface UserRepository {
    fun getUsersFromRoom() : Flow<Users>
    fun addUserToRoom(user: User)
    // getUserFromRoom
    fun getUserFromRoom(id: Int): User

    fun getUsersWithPosts(userRegistroId: Int): List<UserWithRegister>

    fun getUserConfirm(email: String,password: String): User


}