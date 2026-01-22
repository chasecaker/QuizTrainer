package ru.fefu.quiztrainerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import ru.fefu.quiztrainerapp.model.QuestionsList
import ru.fefu.quiztrainerapp.model.QuizViewModel
import ru.fefu.quiztrainerapp.ui.QuestionScreen
import ru.fefu.quiztrainerapp.ui.ResultsScreen
import ru.fefu.quiztrainerapp.ui.StartScreen

class MainActivity : ComponentActivity() {

    private val viewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val uiState = viewModel.uiState.value
                val questions = QuestionsList

                when {
                    uiState.showStartScreen -> {
                        StartScreen(
                            stats = uiState.stats,
                            onRestart = viewModel::onStartQuiz
                        )
                    }
                    uiState.showResults -> {
                        ResultsScreen(
                            stats = uiState.stats,
                            onRestart = viewModel::onRestartQuiz
                        )
                    }
                    else -> {
                        val currentQuestion = questions.getOrNull(uiState.currentQuestionIndex)
                        if (currentQuestion != null) {
                            QuestionScreen(
                                question = currentQuestion,
                                uiState = uiState,
                                onAnswerSelected = viewModel::onAnswerSelected,
                                onSubmitAnswer = viewModel::onSubmitAnswer,
                                onNextQuestion = viewModel::onNextQuestion
                            )
                        } else {
                            Text("No questions")
                        }
                    }
                }
            }
        }
    }
}
