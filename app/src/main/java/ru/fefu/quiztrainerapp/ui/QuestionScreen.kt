package ru.fefu.quiztrainerapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.fefu.quiztrainerapp.model.Question
import ru.fefu.quiztrainerapp.model.QuizUiState

@Composable
fun QuestionScreen(
    question: Question,
    uiState: QuizUiState,
    onAnswerSelected: (Int) -> Unit,
    onSubmitAnswer: () -> Unit,
    onNextQuestion: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        QuizHeader(
            currentQuestion = uiState.currentQuestionIndex + 1,
            totalQuestions = uiState.stats.totalQuestionsAnswered +
                    if (!uiState.showAnswerResult) 1 else 0,
            correctAnswers = uiState.stats.correctAnswers
        )

        Spacer(modifier = Modifier.height(24.dp))

        QuestionCard(text = question.questionText)

        Spacer(modifier = Modifier.height(32.dp))

        OptionsList(
            options = question.options,
            selectedAnswer = uiState.selectedAnswer,
            correctAnswer = question.correctAnswer,
            showResult = uiState.showAnswerResult,
            onOptionClick = onAnswerSelected
        )

        Spacer(modifier = Modifier.weight(1f))

        AnswerFeedback(
            showResult = uiState.showAnswerResult,
            isCorrect = uiState.isCurrentAnswerCorrect,
            correctAnswerText = if (uiState.showAnswerResult)
                question.options[question.correctAnswer]
            else ""
        )

        ActionButton(
            uiState = uiState,
            onSubmitAnswer = onSubmitAnswer,
            onNextQuestion = onNextQuestion
        )
    }
}
