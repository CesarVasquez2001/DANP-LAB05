package com.fggc.lab03.domain.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithRegister(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userReporteId"
    )
    val registers: List<Reporte>
)