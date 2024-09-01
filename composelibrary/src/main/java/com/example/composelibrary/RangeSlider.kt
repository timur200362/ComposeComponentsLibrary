package com.example.composelibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material.RangeSlider
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RangeSlider(valueFirst: Float, valueSecond: Float) {
    var range by remember { mutableStateOf(valueFirst..valueSecond) }

    // Обновляем состояние при изменении входных значений
    LaunchedEffect(valueFirst, valueSecond) {
        range = valueFirst..valueSecond
    }

    Box(modifier = Modifier.padding(16.dp)) {
        // Отображение RangeSlider
        RangeSlider(
            value = range,
            onValueChange = { range = it },
            valueRange = 0f..100f,
            modifier = Modifier.fillMaxWidth()
        )

        // Отображение значений над точками
        val firstValue = range.start
        val secondValue = range.endInclusive

        // Значение первого ползунка
        Text(
            text = firstValue.toString(),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = (firstValue / 100 * LocalDensity.current.density).dp - 20.dp) // смещение по X
                .background(Color.White)
                .padding(4.dp)
        )

        // Значение второго ползунка
        Text(
            text = secondValue.toString(),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = (secondValue / 100 * LocalDensity.current.density).dp - 20.dp) // смещение по X
                .background(Color.White)
                .padding(4.dp)
        )
    }
}
