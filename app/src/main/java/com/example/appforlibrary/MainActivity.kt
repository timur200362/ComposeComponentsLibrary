package com.example.appforlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appforlibrary.ui.theme.AppForLibraryTheme
import com.example.composelibrary.CardList
import com.example.composelibrary.DescriptionCard
import com.example.composelibrary.ImageGallery
import com.example.composelibrary.InputForm
import com.example.composelibrary.ToggleSwitch
import com.example.composelibrary.RangeSlider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppForLibraryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    DescriptionCard(
//                        title = "Заголовок",
//                        description = "Maintainable and readable test code is crucial to establish a good test coverage which in turn enables implementing new features and performing refactorings without the fear of breaking something. This post contains many best practices that I collected over the years of writing unit tests and integration tests in Java. It involves modern technologies like JUnit5, AssertJ, Testcontainers, and Kotlin. Some recommendations might be obvious to you, but some might conflict with what you’ve read in books about software development and testing.",
//                        imageResId = R.drawable.baseline_all_inclusive_24,
//                        Color.Black,
//                        Color.Black
//                    )


//                    val cardItems = listOf(
//                        "Item 1" to "Description of Item 1",
//                        "Item 2" to "Description of Item 2",
//                        "Item 3" to "Description of Item 3"
//                    )
//                    CardList(
//                        items = cardItems,
//                        isHorizontal = false, // Укажите true для горизонтального списка
//                        backgroundColor = Color.LightGray // Укажите цвет фона
//                    )

//                    InputForm(
//                        formBackgroundColor = Color(0xFFE0F7FA), // Цвет фона формы
//                        textFieldBackgroundColor = Color(0xFFFFFFFF), // Цвет фона полей ввода
//                        labels = listOf("Введите имя", "Введите дату", "Введите адрес") // Метки для полей ввода
//                    )

//                    ToggleSwitch()

//                    val images = listOf("https://i.pinimg.com/originals/e4/f3/5a/e4f35a06554c10e0f41f8cfcb239f3f2.jpg", "https://get.wallhere.com/photo/landscape-mountains-lake-nature-reflection-grass-sky-river-national-park-valley-wilderness-Alps-tree-autumn-leaf-mountain-season-tarn-loch-mountainous-landforms-mountain-range-590185.jpg")
//                    ImageGallery(images)

                    RangeSlider(10f, 100f)
                }
            }
        }
    }
}
