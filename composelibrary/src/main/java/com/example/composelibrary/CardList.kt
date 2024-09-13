package com.example.composelibrary

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardList(items: List<Pair<String, String>>, backgroundColor: Color, onItemClick: (String, String) -> Unit) {
    LazyColumn {
        itemsIndexed(items) { index, item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onItemClick(item.first, item.second) }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = item.first, style = MaterialTheme.typography.titleLarge)
                    Text(text = item.second, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}
