package com.example.composelibrary

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImageGallery(images: List<String>) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(images) { imageUrl ->
            Image(painter = rememberAsyncImagePainter(imageUrl), contentDescription = null)
        }
    }
}