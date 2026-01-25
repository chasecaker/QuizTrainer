package ru.fefu.quiztrainerapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnswerFeedback(
    showResult: Boolean,
    isCorrect: Boolean?,
    correctAnswerText: String
) {
    if (showResult) {
        Text(
            text = if (isCorrect == true) {
                "You're right!"
            } else {
                "You're wrong! Correct answer: $correctAnswerText"
            },
            fontSize = 18.sp,
            color = if (isCorrect == true) Color.Companion.Green else Color.Companion.Red,
            fontWeight = FontWeight.Companion.Bold,
            modifier = Modifier.Companion.padding(bottom = 16.dp)
        )
    }
}