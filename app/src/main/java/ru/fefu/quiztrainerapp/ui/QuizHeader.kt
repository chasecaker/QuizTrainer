package ru.fefu.quiztrainerapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun QuizHeader(
    currentQuestion: Int,
    totalQuestions: Int,
    correctAnswers: Int
) {
    Row(
        modifier = Modifier.Companion.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Question $currentQuestion/10",
            fontSize = 16.sp,
        )
        Text(
            text = "Correct answers: $correctAnswers",
            fontSize = 16.sp,
            fontWeight = FontWeight.Companion.Bold
        )
    }
}