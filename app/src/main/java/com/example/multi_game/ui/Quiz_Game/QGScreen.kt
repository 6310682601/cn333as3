package com.example.multi_game.ui

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//import androidx.lifecycle.viewmodel.compose.viewModel




@Composable
fun Quiz_Game(
    name: String,
    modifier: Modifier = Modifier,
    QGViewModel: QGViewModel,
    navController: NavHostController,
) {
    val QGUiState by QGViewModel.uiState.collectAsState()
    val question = QGUiState.currentQuestion
    val choice = QGUiState.choice
    val score = QGUiState.score
    val count = QGUiState.quizIndex


    Column(
        Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF4A148C))
        ) {
            Text(
                text = "$name",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row() {
            Text(
                text = "$count out of 10",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.width(150.dp))
            Text(
                text = "Score: $score",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            text = question.question,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {
                QGViewModel.checkAnswer(choice[0])
                QGViewModel.getQuestion()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = choice[0],
                fontSize = 20.sp
            )
        }
        Button(
            onClick = {
                QGViewModel.checkAnswer(choice[1])
                QGViewModel.getQuestion()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = choice[1],
                fontSize = 20.sp
            )
        }
        Button(
            onClick = {
                QGViewModel.checkAnswer(choice[2])
                QGViewModel.getQuestion()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = choice[2],
                fontSize = 20.sp
            )
        }
        Button(
            onClick = {
                QGViewModel.checkAnswer(choice[3])
                QGViewModel.getQuestion()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = choice[3],
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(45.dp))

        Row {
            Button(onClick = { QGViewModel.reset(true) }) {
                Text(
                    text = "RESET",
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text(
                    text = "Go Back",
                    fontSize = 20.sp
                )
            }


            if (QGUiState.quizIndex == 11) {
                FinalScoreDialog(
                    score = QGUiState.score,
                    onPlayAgain = { QGViewModel.reset(true) }
                )
            }

        }
    }
}

@Composable
fun FinalScoreDialog(
    score: Int,
    onPlayAgain: () -> Unit,
) {
    val activity = (LocalContext.current as Activity)

    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = "Congratulations!") },
        text = { Text(text = "Your Score: $score") },
        dismissButton = {
            TextButton(onClick = {activity.finish()}) {
                Text(text = "Exit")
            }},
        confirmButton = {
            TextButton(onClick = onPlayAgain) {
                Text(text = "Reset")
            }
        }
    )
}
