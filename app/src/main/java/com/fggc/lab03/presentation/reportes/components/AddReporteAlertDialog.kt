package com.fggc.lab03.presentation.reportes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.fggc.lab03.core.Constants.Companion.ADD
import com.fggc.lab03.core.Constants.Companion.ADD_REPORTE
import com.fggc.lab03.core.Constants.Companion.NOMBRE
import com.fggc.lab03.core.Constants.Companion.DISMISS
import com.fggc.lab03.core.Constants.Companion.NO_VALUE
import com.fggc.lab03.core.Constants.Companion.APELLIDO
import com.fggc.lab03.core.Constants.Companion.CORREO
import com.fggc.lab03.core.Constants.Companion.FECHA_INSCRIPCION
import com.fggc.lab03.core.Constants.Companion.MONTO_PAGADO
import com.fggc.lab03.core.Constants.Companion.TELEFONO
import com.fggc.lab03.core.Constants.Companion.TIPO_SANGRE
import com.fggc.lab03.domain.model.Reporte
import kotlinx.coroutines.job

@Composable
fun AddReporteAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addReporte: (reporte: Reporte) -> Unit,
    loginId: Int
) {
    if (openDialog) {
        var titulo by remember { mutableStateOf(NO_VALUE) }
        var description by remember { mutableStateOf(NO_VALUE) }
        var latitud by remember { mutableStateOf(NO_VALUE) }
        var longitud by remember { mutableStateOf(NO_VALUE) }
        var estado by remember { mutableStateOf(NO_VALUE) }
        var comentarios by remember { mutableStateOf(NO_VALUE) }
        var user_registro_id by remember {
            mutableStateOf(loginId)
        }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(ADD_REPORTE)
            },
            text = {
                Column() {
                    TextField(
                        value = titulo,
                        onValueChange = { titulo = it },
                        placeholder = {
                            Text(NOMBRE)
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = description,
                        onValueChange = { description = it },
                        placeholder = {
                            Text(APELLIDO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = latitud,
                        onValueChange = { latitud = it },
                        placeholder = {
                            Text(FECHA_INSCRIPCION)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = longitud,
                        onValueChange = { longitud = it },
                        placeholder = {
                            Text(TIPO_SANGRE)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = estado,
                        onValueChange = { estado = it },
                        placeholder = {
                            Text(TELEFONO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = comentarios,
                        onValueChange = { comentarios = it },
                        placeholder = {
                            Text(CORREO)
                        }
                    )


                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val reporte = Reporte(
                            0,
                            titulo,
                            description,
                            latitud,
                            longitud,
                            estado,
                            comentarios,
                            user_registro_id
                        )
                        addReporte(reporte)
                    }) {
                    Text(ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(DISMISS)
                }
            }

        )
    }
}