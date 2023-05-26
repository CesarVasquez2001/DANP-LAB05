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
import com.fggc.lab03.core.Constants.Companion.DISMISS
import com.fggc.lab03.core.Constants.Companion.NO_VALUE
import com.fggc.lab03.core.Constants.Companion.COMENTARIOS
import com.fggc.lab03.core.Constants.Companion.DESCRIPCION
import com.fggc.lab03.core.Constants.Companion.ESTADO
import com.fggc.lab03.core.Constants.Companion.LATITUD
import com.fggc.lab03.core.Constants.Companion.LONGITUD
import com.fggc.lab03.core.Constants.Companion.TITULO
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
                            Text(TITULO)
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
                            Text(DESCRIPCION)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = latitud,
                        onValueChange = { latitud = it },
                        placeholder = {
                            Text(LATITUD)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = longitud,
                        onValueChange = { longitud = it },
                        placeholder = {
                            Text(LONGITUD)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = estado,
                        onValueChange = { estado = it },
                        placeholder = {
                            Text(ESTADO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = comentarios,
                        onValueChange = { comentarios = it },
                        placeholder = {
                            Text(COMENTARIOS)
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