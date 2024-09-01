package com.example.composelibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InputForm(
    formBackgroundColor: Color = Color(0xFFEFEFEF), // Цвет фона формы по умолчанию
    textFieldBackgroundColor: Color = Color(0xFFFFFFFF), // Цвет фона полей ввода по умолчанию
    labels: List<String> = listOf("Имя", "Фамилия"), // Метки для полей ввода
) {
    val fieldValues = remember { mutableStateListOf(*Array(labels.size) { "" }) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(formBackgroundColor, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        for (i in labels.indices) {
            TextField(
                value = fieldValues[i],
                onValueChange = { fieldValues[i] = it },
                label = { Text(labels[i]) }, // Используем переданный текст метки
                modifier = Modifier
                    .fillMaxWidth()
                    .background(textFieldBackgroundColor, shape = RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Handle submit */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}
