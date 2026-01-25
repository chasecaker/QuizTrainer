package ru.fefu.quiztrainerapp.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private val questions = QuestionsList

    private val _uiState = mutableStateOf(
        QuizUiState(
            isLastQuestion = questions.size == 1,
            showStartScreen = true
        )
    )
    val uiState: State<QuizUiState> = _uiState

    fun onStartQuiz() {
        _uiState.value = _uiState.value.copy(
            showStartScreen = false,
            currentQuestionIndex = 0
        )
    }

    fun onAnswerSelected(answerIndex: Int) {
        _uiState.value = _uiState.value.copy(
            selectedAnswer = answerIndex
        )
    }

    fun onSubmitAnswer() {
        val currentState = _uiState.value
        val currentQuestion = questions[currentState.currentQuestionIndex]
        val isCorrect = currentState.selectedAnswer == currentQuestion.correctAnswer

        _uiState.value = currentState.copy(
            showAnswerResult = true,
            isCurrentAnswerCorrect = isCorrect,
            stats = currentState.stats.copy(
                correctAnswers = currentState.stats.correctAnswers + if (isCorrect) 1 else 0,
                totalQuestionsAnswered = currentState.stats.totalQuestionsAnswered + 1
            )
        )
    }

    fun onNextQuestion() {
        val currentState = _uiState.value

        if (currentState.isLastQuestion) {
            _uiState.value = currentState.copy(
                showResults = true
            )
        } else {
            val nextIndex = currentState.currentQuestionIndex + 1
            val isLast = nextIndex == questions.lastIndex

            _uiState.value = currentState.copy(
                currentQuestionIndex = nextIndex,
                selectedAnswer = null,
                showAnswerResult = false,
                isCurrentAnswerCorrect = null,
                isLastQuestion = isLast
            )
        }
    }

    fun onRestartQuiz() {
        _uiState.value = QuizUiState(
            isLastQuestion = questions.size == 1,
            showStartScreen = true
        )
    }
}
