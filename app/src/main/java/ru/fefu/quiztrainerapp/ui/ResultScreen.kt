package ru.fefu.quiztrainerapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.fefu.quiztrainerapp.model.QuizStats

@Composable
fun ResultsScreen(
    stats: QuizStats,
    onRestart: () -> Unit
) {
    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Results:",
            fontSize = 32.sp,
            fontWeight = FontWeight.Companion.Bold,
            modifier = Modifier.Companion.padding(bottom = 24.dp)
        )

        Card(
            modifier = Modifier.Companion.padding(16.dp),
        ) {
            Column(
                modifier = Modifier.Companion.padding(24.dp),
                horizontalAlignment = Alignment.Companion.CenterHorizontally
            ) {
                Text(
                    text = "${stats.correctAnswers} out of ${stats.totalQuestionsAnswered}",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Companion.Bold,
                )

                Text(
                    text = "correct answers",
                    fontSize = 18.sp,
                )

                Text(
                    text = "${stats.percentage}%",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Companion.Bold,
                    modifier = Modifier.Companion.padding(top = 16.dp)
                )

                Text(
                    text = stats.grade,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Companion.Bold,
                    modifier = Modifier.Companion.padding(top = 24.dp)
                )
            }
        }

        Button(
            onClick = onRestart,
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(top = 32.dp)
                .height(56.dp)
        ) {
            Text(text = "Start over", fontSize = 18.sp)
        }
    }
}