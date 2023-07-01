package com.fggc.lab03.domain.model
import androidx.compose.runtime.MutableState
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fggc.lab03.core.Constants

@Entity (tableName = Constants.USER_TABLE)
data class User(
    @PrimaryKey (autoGenerate = true)
    val userId: Int,
    val email: String,
    val password: String,
)
