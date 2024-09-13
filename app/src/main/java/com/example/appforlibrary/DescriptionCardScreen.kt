package com.example.appforlibrary

import androidx.compose.runtime.Composable
import com.example.composelibrary.DescriptionCard

@Composable
fun DescriptionCardScreen(title: String, description: String, onBack: () -> Unit) {
    DescriptionCard(
        title = title,
        description = description,
        onBack = onBack
    )
}