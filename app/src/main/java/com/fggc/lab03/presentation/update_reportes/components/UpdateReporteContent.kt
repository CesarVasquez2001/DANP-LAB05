package com.fggc.lab03.presentation.update_reportes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fggc.lab03.core.Constants.Companion.COMENTARIOS
import com.fggc.lab03.core.Constants.Companion.DESCRIPCION
import com.fggc.lab03.core.Constants.Companion.ESTADO
import com.fggc.lab03.core.Constants.Companion.LATITUD
import com.fggc.lab03.core.Constants.Companion.LONGITUD
import com.fggc.lab03.core.Constants.Companion.TITULO
import com.fggc.lab03.core.Constants.Companion.UPDATE
import com.fggc.lab03.domain.model.Reporte

@Composable
fun UpdateReporteContext(
    padding: PaddingValues,
    reporte: Reporte,
    updateTitulo: (titulo: String) -> Unit,
    updateDescription: (description: String) -> Unit,
    updateLatitud: (latitud: String) -> Unit,
    updateLongitud: (longitud: String) -> Unit,
    updateEstado: (estado: String) -> Unit,
    updateComentarios: (comentarios: String) -> Unit,
    updateReporte: (reporte: Reporte) -> Unit,

    navigateBack: () -> Unit,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = reporte.titulo,
            onValueChange = { titulo ->
                updateTitulo(titulo)
            },
            placeholder = {
                Text(TITULO)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = reporte.description,
            onValueChange = { description ->
                updateDescription(description)
            },
            placeholder = {
                Text(DESCRIPCION)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = reporte.latitud,
            onValueChange = { latitud ->
                updateLatitud(latitud)
            },
            placeholder = {
                Text(LATITUD)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = reporte.longitud,
            onValueChange = { longitud ->
                updateLongitud(longitud)
            },
            placeholder = {
                Text(LONGITUD)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = reporte.estado,
            onValueChange = { estado ->
                updateEstado(estado)
            },
            placeholder = {
                Text(ESTADO)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = reporte.comentarios,
            onValueChange = { comentarios ->
                updateComentarios(comentarios)
            },
            placeholder = {
                Text(COMENTARIOS)
            }
        )

        Button(
            onClick = {
                updateReporte(reporte)
                navigateBack()
            }
        ) {
            Text(UPDATE)
        }
    }
}






