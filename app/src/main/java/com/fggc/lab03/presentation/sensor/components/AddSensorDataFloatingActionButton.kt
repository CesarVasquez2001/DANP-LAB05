package com.fggc.lab03.presentation.sensor.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.fggc.lab03.core.Constants

@Composable
fun AddSensorDataFloatingActionButton(
    openDialog: () -> Unit
){
    FloatingActionButton(
        onClick =  openDialog ,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = Constants.ADD_REPORTE
        )
    }
}