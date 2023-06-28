package com.fggc.lab03.paging.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.fggc.lab03.data.network.SensorDataDB
import com.fggc.lab03.domain.model.SensorData
import com.fggc.lab03.raw.lista
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class SensorRemoteMediator(
    private val db: SensorDataDB,
): RemoteMediator<Int, SensorData>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, SensorData>
    ): MediatorResult {
        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null) {
                        1
                    } else {
                        (lastItem.sensorDataId / state.config.pageSize) + 1
                    }
                }
            }



            db.withTransaction {
                if(loadType == LoadType.REFRESH) {
                    db.sensorDataDao().clearAll()
                }
                val beerEntities = lista
                db.sensorDataDao().insertAll(beerEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = lista.isEmpty()
            )
        } catch(e: IOException) {
            MediatorResult.Error(e)
        } catch(e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}