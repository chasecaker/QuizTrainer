package ru.fefu.quiztrainerapp.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.fefu.quiztrainerapp.model.QuizUiState

@Composable
fun ActionButton(
    uiState: QuizUiState,
    onSubmitAnswer: () -> Unit,
    onNextQuestion: () -> Unit
) {
    val buttonText = when {
        !uiState.showAnswerResult -> "Check answer"
        !uiState.isLastQuestion -> "Next question"
        else -> "Finish Quiz"
    }

    Button(
        onClick = {
            if (!uiState.showAnswerResult) {
                onSubmitAnswer()
            } else {
                onNextQuestion()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(12.dp),
        enabled = if (!uiState.showAnswerResult) uiState.canSubmitAnswer else true,
    ) {
        Text(
            text = buttonText,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
