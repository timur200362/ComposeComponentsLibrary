package com.example.composelibrary

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ToggleSwitch(isChecked: Boolean, onToggle: (Boolean) -> Unit) {
    Switch(
        checked = isChecked,
        onCheckedChange = {
            onToggle(it) // Вызываем обратный вызов при изменении состояния
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            uncheckedThumbColor = Color.Red
        )
    )
}

