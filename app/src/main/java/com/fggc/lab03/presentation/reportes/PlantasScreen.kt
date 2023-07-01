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
import com.fggc.lab03.core.Constants.Companion.PLANTAS_SCREEN
import com.fggc.lab03.domain.repository.Plantas
import com.fggc.lab03.paging.SensorDataViewModel
import com.fggc.lab03.presentation.reportes.components.AddPlantaAlertDialog
import com.fggc.lab03.presentation.reportes.components.AddPlantaFloatingActionButton
import com.fggc.lab03.presentation.reportes.components.ReportesContent
import com.fggc.lab03.presentation.sensor.components.SensorContent


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlantasScreen(
    viewModel: PlantasViewModel = hiltViewModel(),
    navigateToUpdatePlantaScreen: (plantaId: Int) -> Unit,
    loginId: Int,

    ) {
    LaunchedEffect(Unit) {
        viewModel.getPostswithUser(loginId)
    }
    val plantas by viewModel.plantasUsers.collectAsState(
        initial = emptyList(),
    )

    Log.d("Plantas", plantas.toString())


    val SensorDataViewModel = hiltViewModel<SensorDataViewModel>()
    val sensors = SensorDataViewModel.SensorPagingFlow.collectAsLazyPagingItems()


    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(PLANTAS_SCREEN)
            })
        },
        content = { padding ->
            ReportesContent(
                padding = padding,
                plantas = plantas as Plantas,
                deletePlanta = { planta ->
                    viewModel.deletePlanta(planta)
                },
                navigateToUpdatePlantaScreen =
                navigateToUpdatePlantaScreen
            )
//            SensorContent(sensor = sensors)
            AddPlantaAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addPlanta = { planta ->
                    viewModel.addPlanta(planta)
                },
                loginId = loginId
            )
        },
        floatingActionButton = {
            AddPlantaFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}

