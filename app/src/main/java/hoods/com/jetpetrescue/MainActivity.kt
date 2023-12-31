package hoods.com.jetpetrescue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hoods.com.jetpetrescue.detail.DetailScreen
import hoods.com.jetpetrescue.home.Home
import hoods.com.jetpetrescue.ui.theme.JetPetTheme

enum class Screen {
    Home,
    Detail
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember {
                mutableStateOf(false)
            }
            var currentScreen by remember {
                mutableStateOf(Screen.Home)
            }
            var selectedIndex by remember {
                mutableStateOf(-1)
            }
            JetPetTheme(
                darkTheme = isDarkTheme
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Home(onSwitchClick = {}) {
//
//                    }
                    when (currentScreen) {
                        Screen.Home -> {
                            Home(
                                onSwitchClick = { isDarkTheme = !isDarkTheme },
                                onPetClick = { index ->
                                    currentScreen = Screen.Detail
                                    selectedIndex = index
                                },
                            )
                        }

                        Screen.Detail -> {
                            DetailScreen(index = selectedIndex) {
                                currentScreen = Screen.Home
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPetTheme {
        Home(onSwitchClick = {}) {

        }
    }
}