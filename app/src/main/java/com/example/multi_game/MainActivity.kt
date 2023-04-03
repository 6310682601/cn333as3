package com.example.multi_game

import Adventure_Game
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adventure_game.ui.ADVViewModel
//import com.example.multi_game.ui.NGGViewModel
import com.example.multi_game.ui.QGViewModel
import com.example.multi_game.ui.Quiz_Game
//import com.example.multi_game.ui.Number_Guessing_Game
import com.example.multi_game.ui.theme.MultiGameTheme

enum class Screen {
    Home, Number_Guessing_Game, Quiz_Game
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val QGViewModel: QGViewModel by viewModels()
        setContent {
            MultiGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = Screen.Home.name) {
                        composable(Screen.Home.name) {
                            HomeScreen(navController = navController)
                        }
                        composable("Number Guessing Game") {
                            Number_Guessing_Game(name = "Number Guessing Game", navController = navController)
                        }
                        composable("Quiz Game") {
                            Quiz_Game(name = "Quiz Game", QGViewModel = QGViewModel, navController = navController)
                        }
                        composable("Adventure Game") {
                            Adventure_Game(name = "Adventure Game", ADVViewModel = ADVViewModel, navController = navController)
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = { navController.navigate("Number Guessing Game") },
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
            ) {
            Text(
                "Number Guessing Game",
                fontSize = 20.sp
            )
        }
        Button(onClick = { navController.navigate("Quiz Game") },
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                "Quiz Game",
                fontSize = 20.sp)
        }
        Button(onClick = { navController.navigate("Game 3") },
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                "Game 3",
                fontSize = 20.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultiGameTheme {
        val navController = rememberNavController()
        HomeScreen(navController, modifier = Modifier)
    }
}