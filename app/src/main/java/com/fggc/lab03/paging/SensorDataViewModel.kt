package com.fggc.lab03.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.fggc.lab03.data.toSensor
import com.fggc.lab03.domain.model.SensorData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class SensorDataViewModel @Inject constructor(
    pager: Pager<Int, SensorData>
): ViewModel() {

    val SensorPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toSensor() }
        }
        .cachedIn(viewModelScope)
}