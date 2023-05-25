package com.fggc.lab03.presentation.reportes.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
 import com.fggc.lab03.core.Constants.Companion.DELETE_REPORTE

@Composable
fun DeleteIcon(
    deleteReporte: () -> Unit
){
    IconButton(onClick =  deleteReporte ) {
        Icon(imageVector = Icons.Default.Delete,
            contentDescription = DELETE_REPORTE)
    }
}