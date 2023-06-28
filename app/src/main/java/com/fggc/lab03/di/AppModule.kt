package com.fggc.lab03.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
 import com.fggc.lab03.core.Constants.Companion.REPORTE_TABLE
import com.fggc.lab03.core.Constants.Companion.USER_TABLE
import com.fggc.lab03.data.network.ReporteDB
import com.fggc.lab03.data.network.ReporteDao
import com.fggc.lab03.data.network.SensorDataDB
import com.fggc.lab03.data.network.SensorDataDao
import com.fggc.lab03.data.network.UserDB
import com.fggc.lab03.data.network.UserDao
import com.fggc.lab03.data.repository.ReporteRepositoryImpl
import com.fggc.lab03.data.repository.SensorDataRepositoryImpl
import com.fggc.lab03.data.repository.UserRepositoryImpl
import com.fggc.lab03.domain.model.SensorData
import com.fggc.lab03.domain.repository.ReporteRepository
import com.fggc.lab03.domain.repository.SensorDataRepository
import com.fggc.lab03.domain.repository.UserRepository
import com.fggc.lab03.paging.remote.SensorRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
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


    @Provides
    @Singleton
    fun provideSensorDatabase(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
        SensorDataDB::class.java,
        "SensorData"
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideSensorDao(
        reporteDB: SensorDataDB
    ) = reporteDB.sensorDataDao()

    @Provides
    fun provideSensorRepository(
        reporteDao: SensorDataDao
    ): SensorDataRepository = SensorDataRepositoryImpl(
        sensorDataDao = reporteDao
    )

    @Provides
    @Singleton
    fun provideBeerPager(beerDb: SensorDataDB): Pager<Int, SensorData> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = SensorRemoteMediator(
                db = beerDb,
            ),
            pagingSourceFactory = {
                beerDb.sensorDataDao().pagingSource()
            }
        )
    }


}

