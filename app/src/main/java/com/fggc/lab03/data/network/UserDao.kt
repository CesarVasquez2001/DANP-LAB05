package com.fggc.lab03.data.network

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import com.fggc.lab03.core.Constants
import com.fggc.lab03.core.Constants.Companion.USER_TABLE
import com.fggc.lab03.domain.model.User
import com.fggc.lab03.domain.model.UserWithRegister
import com.fggc.lab03.domain.repository.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM $USER_TABLE ORDER BY userId ASC")
    fun getUsers(): Flow<Users>

    @Insert(onConflict = IGNORE)
    fun addUser(user: User)

    @Query("SELECT * FROM $USER_TABLE WHERE userId = :id")
    fun getUser(id: Int): User

    @Query("SELECT * FROM $USER_TABLE WHERE email = :email and password = :password")
    fun getUserConfirm(email: String,password: String): User

    @Transaction
    @Query("SELECT * FROM $USER_TABLE")
    fun getUsersWithPosts(): List<UserWithRegister>
}