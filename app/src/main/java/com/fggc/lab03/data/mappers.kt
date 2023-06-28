package com.fggc.lab03.data

import com.fggc.lab03.domain.Sensor
import com.fggc.lab03.domain.model.SensorData

fun SensorData.toSensor(): Sensor {
    return Sensor(
        sensorDataId = sensorDataId,
        date = date,
        medicion = medicion,
        comentario = comentario,
    )
}