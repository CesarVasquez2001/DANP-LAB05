package com.fggc.lab03.di

import android.content.Context
import androidx.room.Room
 import com.fggc.lab03.core.Constants.Companion.REPORTE_TABLE
import com.fggc.lab03.core.Constants.Companion.USER_TABLE
import com.fggc.lab03.data.network.ReporteDB
import com.fggc.lab03.data.network.ReporteDao
import com.fggc.lab03.data.network.UserDB
import com.fggc.lab03.data.network.UserDao
import com.fggc.lab03.data.repository.ReporteRepositoryImpl
import com.fggc.lab03.data.repository.UserRepositoryImpl
 import com.fggc.lab03.domain.repository.ReporteRepository
import com.fggc.lab03.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideReporteDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
    ReporteDB::class.java,
        REPORTE_TABLE
        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideReporteDao(
        reporteDB: ReporteDB
    ) = reporteDB.reporteDao()

    @Provides
    fun provideReporteeRepository(
        reporteDao: ReporteDao
    ): ReporteRepository = ReporteRepositoryImpl(
        reporteDao = reporteDao
    )


    @Provides
    fun provideUserDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
        UserDB::class.java,
        USER_TABLE
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideUserDao(
        userDB: UserDB
    ) = userDB.userDao()

    @Provides
    fun provideUserRepository(
        userDao: UserDao
    ): UserRepository = UserRepositoryImpl(
        userDao = userDao
    )

}

