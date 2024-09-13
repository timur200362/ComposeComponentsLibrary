package com.example.appforlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appforlibrary.ui.theme.AppForLibraryTheme
import com.example.composelibrary.AddItemButton
import com.example.composelibrary.CardList
import com.example.composelibrary.ToggleSwitch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppForLibraryTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "main") {
                        composable("main") { MainScreen(navController) }
                        composable("description/{title}/{description}") { backStackEntry ->
                            val title = backStackEntry.arguments?.getString("title") ?: ""
                            val description = backStackEntry.arguments?.getString("description") ?: ""
                            DescriptionCardScreen(title = title, description = description) {
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    var cardItems1 by remember { mutableStateOf(
        listOf(
            "Item 1" to "Description of Item 1",
            "Item 2" to "Description of Item 2",
            "Item 3" to "Description of Item 3"
        )
    ) }

    var cardItems2 by remember { mutableStateOf(
        listOf(
            "Secret Item 1" to "Secret Description of Item 1"
        )
    ) }

    var isShowingCardItems1 by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        ToggleSwitch(isChecked = isShowingCardItems1) { isChecked ->
            isShowingCardItems1 = isChecked
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isShowingCardItems1) {
            CardList(items = cardItems1, backgroundColor = Color.LightGray) { title, description ->
                navController.navigate("description/$title/$description")
            }
        } else {
            CardList(items = cardItems2, backgroundColor = Color.LightGray) { title, description ->
                navController.navigate("description/$title/$description")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        AddItemButton { title, description ->
            if (isShowingCardItems1) {
                cardItems1 = cardItems1 + (title to description)
            } else {
                cardItems2 = cardItems2 + (title to description)
            }
        }
    }
}
