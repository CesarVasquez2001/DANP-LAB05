package com.fggc.lab03.presentation.reportes

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.fggc.lab03.core.Constants.Companion.REPORTES_SCREEN
import com.fggc.lab03.paging.SensorDataViewModel
import com.fggc.lab03.presentation.sensor.SensorViewModel
import com.fggc.lab03.presentation.sensor.components.AddSensorData
import com.fggc.lab03.presentation.sensor.components.AddSensorDataFloatingActionButton
import com.fggc.lab03.presentation.sensor.components.BeerScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SensorScreen(
    viewModel: SensorViewModel = hiltViewModel(),
    navigateToUpdateReporteScreen: (reporteId: Int) -> Unit,
    loginId: Int,

    ) {
    LaunchedEffect(Unit) {
        viewModel.getPostswithUser(loginId)
        viewModel.querySensorData()
    }
    val reportes by viewModel.reportesUsers.collectAsState(
        initial = emptyList(),
    )

    Log.d("REPORTES", reportes.toString())


    val SensorDataViewModel = hiltViewModel<SensorDataViewModel>()
    val beers = SensorDataViewModel.SensorPagingFlow.collectAsLazyPagingItems()


    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(REPORTES_SCREEN + " - " + loginId)
            })
        },
        content = {
            BeerScreen(beers = beers)
            AddSensorData(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                }
            ) {
                viewModel.addTodo()
            }
        },
        floatingActionButton = {
            AddSensorDataFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}

