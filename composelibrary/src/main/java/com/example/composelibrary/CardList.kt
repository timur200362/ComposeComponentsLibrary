package com.example.composelibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CardList(
    items: List<Pair<String, String>>, // Список пар (название, описание)
    isHorizontal: Boolean = false, // Параметр для указания расположения
    backgroundColor: Color = Color.White // Цвет заднего фона
) {
    // Используем LazyColumn или LazyRow в зависимости от параметра isHorizontal
    if (isHorizontal) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
        ) {
            items(items.size) { index ->
                val (title, description) = items[index]
                Card(
                    modifier = Modifier.padding(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = title, fontWeight = FontWeight.Bold)
                        Text(text = description)
                    }
                }
            }
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
        ) {
            items(items.size) { index ->
                val (title, description) = items[index]
                Card(
                    modifier = Modifier.padding(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = title, fontWeight = FontWeight.Bold)
                        Text(text = description)
                    }
                }
            }
        }
    }
}
