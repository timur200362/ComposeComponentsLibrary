package com.example.composelibrary


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AddItemButton(
    onAdd: (String, String) -> Unit
) {
    // Состояние для хранения введенных значений
    val fieldValues = remember { mutableStateListOf("", "") }

    InputForm(
        labels = listOf("Название записи", "Описание записи"),
        formBackgroundColor = Color(0xFFEFEFEF),
        textFieldBackgroundColor = Color(0xFFFFFFFF),
        fieldValues = fieldValues
    )

    Button(
        onClick = {
            val title = fieldValues[0]
            val description = fieldValues[1]
            if (title.isNotBlank() && description.isNotBlank()) {
                onAdd(title, description)
                fieldValues[0] = ""
                fieldValues[1] = ""
            }
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Добавить запись")
    }
}