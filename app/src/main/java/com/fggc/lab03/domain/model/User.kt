package com.fggc.lab03.domain.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fggc.lab03.core.Constants

@Entity (tableName = Constants.USER_TABLE)
data class User(
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val email: String,
    val password: String,
)
