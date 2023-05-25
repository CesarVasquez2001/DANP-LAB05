package com.fggc.lab03.presentation.reportes

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.fggc.lab03.core.Constants.Companion.REPORTES_SCREEN
import com.fggc.lab03.domain.repository.Reportes
import com.fggc.lab03.presentation.reportes.components.AddReporteAlertDialog
import com.fggc.lab03.presentation.reportes.components.AddReporteFloatingActionButton
import com.fggc.lab03.presentation.reportes.components.ReportesContent


@Composable
fun ReportesScreen(
    viewModel: ReportesViewModel = hiltViewModel(),
    navigateToUpdateReporteScreen: (reporteId: Int) -> Unit,
    loginId: Int,

    ) {
    LaunchedEffect(Unit) {
        viewModel.getPostswithUser(loginId)
    }
    val reportes by viewModel.reportesUsers.collectAsState(
        initial = emptyList(),
    )

    Log.d("REPORTES", reportes.toString())

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(REPORTES_SCREEN + " - " + loginId)
            })
        },
        content = { padding ->
            ReportesContent(
                padding = padding,
                reportes = reportes as Reportes,
                deleteReporte = { reporte ->
                    viewModel.deleteReporte(reporte)
                },
                navigateToUpdateReporteScreen =
                navigateToUpdateReporteScreen
            )
            AddReporteAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addReporte = { reporte ->
                    viewModel.addReporte(reporte)
                },
                loginId = loginId
            )
        },
        floatingActionButton = {
            AddReporteFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}

