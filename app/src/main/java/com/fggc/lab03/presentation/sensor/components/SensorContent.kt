package com.fggc.lab03.presentation.sensor.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.fggc.lab03.domain.Sensor

@Composable
fun SensorContent(
    sensor: LazyPagingItems<Sensor>
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = sensor.loadState) {
        if(sensor.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (sensor.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if(sensor.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(sensor) { sensor ->
                    if(sensor != null) {
                        SensorItem(
                            sensor = sensor,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                item {
                    if(sensor.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}