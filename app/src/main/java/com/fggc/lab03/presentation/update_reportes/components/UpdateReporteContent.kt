package com.fggc.lab03.presentation.update_reportes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fggc.lab03.core.Constants.Companion.NOMBRE
import com.fggc.lab03.core.Constants.Companion.APELLIDO
import com.fggc.lab03.core.Constants.Companion.CORREO
import com.fggc.lab03.core.Constants.Companion.FECHA_INSCRIPCION
import com.fggc.lab03.core.Constants.Companion.TELEFONO
import com.fggc.lab03.core.Constants.Companion.TIPO_SANGRE
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
                Text(NOMBRE)
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
                Text(APELLIDO)
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
                Text(FECHA_INSCRIPCION)
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
                Text(TIPO_SANGRE)
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
                Text(TELEFONO)
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
                Text(CORREO)
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






