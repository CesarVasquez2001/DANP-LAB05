package com.fggc.lab03.presentation.reportes.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fggc.lab03.domain.model.Reporte
import com.fggc.lab03.domain.repository.Reportes


@Composable
fun ReportesContent(
    padding: PaddingValues,
    reportes: Reportes,
    deleteReporte: (reporte: Reporte) -> Unit,
    navigateToUpdateReporteScreen: (reporteId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(reportes) { reporte ->
            ReporteCard(
                reporte = reporte,
                deleteReporte = {
                    deleteReporte(reporte)
                },
                navigateToUpdateReporteScreen =
                navigateToUpdateReporteScreen
            )
        }
    }
}