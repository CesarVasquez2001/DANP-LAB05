package com.fggc.lab03.presentation.update_asistentes.components

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
import com.fggc.lab03.core.Constants.Companion.MONTO_PAGADO
import com.fggc.lab03.core.Constants.Companion.TELEFONO
import com.fggc.lab03.core.Constants.Companion.TIPO_SANGRE
import com.fggc.lab03.core.Constants.Companion.UPDATE
import com.fggc.lab03.domain.model.Asistente

@Composable
fun UpdateAsistenteContent(
    padding: PaddingValues,
    asistente: Asistente,
    updateNombre: (nombre: String) -> Unit,
    updateApellido: (apellido: String) -> Unit,
    updateFechaInscripcion: (fecha_inscripcion: String) -> Unit,
    updateTipoSangre: (tipo_sangre: String) -> Unit,
    updateTelefono: (telefono: String) -> Unit,
    updateCorreo: (correo: String) -> Unit,
    updateMontoPagado: (monto_pagado: String) -> Unit,
    updateAsistente: (asistente: Asistente) -> Unit,

    navigateBack: () -> Unit,

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = asistente.nombre,
            onValueChange = {nombre->
                updateNombre(nombre)
            },
            placeholder = {
                Text(NOMBRE)
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = asistente.apellido,
            onValueChange = {apellido->
                updateApellido(apellido)
            },
            placeholder = {
                Text(APELLIDO)
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = asistente.fechaInscripcion,
            onValueChange = {fecha_inscripcion->
                updateFechaInscripcion(fecha_inscripcion)
            },
            placeholder = {
                Text(FECHA_INSCRIPCION)
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = asistente.tipoSangre,
            onValueChange = {tipo_sangre->
                updateTipoSangre(tipo_sangre)
            },
            placeholder = {
                Text(TIPO_SANGRE)
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = asistente.telefono,
            onValueChange = {telefono->
                updateTelefono(telefono)
            },
            placeholder = {
                Text(TELEFONO)
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = asistente.correo,
            onValueChange = {correo->
                updateCorreo(correo)
            },
            placeholder = {
                Text(CORREO)
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = asistente.montoPagado,
            onValueChange = {monto_pagado->
                updateMontoPagado(monto_pagado)
            },
            placeholder = {
                Text(MONTO_PAGADO)
            }
        )
        Button(
            onClick = {
                updateAsistente(asistente)
                navigateBack()
            }
        ){
            Text(UPDATE)
        }
    }
}






