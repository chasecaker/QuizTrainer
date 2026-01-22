package ru.fefu.quiztrainerapp.model

data class QuizUiState(
    val currentQuestionIndex: Int = 0,
    val selectedAnswer: Int? = null,
    val showAnswerResult: Boolean = false,
    val isCurrentAnswerCorrect: Boolean? = null,
    val showResults: Boolean = false,
    val isLastQuestion: Boolean = false,
    val stats: QuizStats = QuizStats(),
    val showStartScreen: Boolean = true
) {
    val canSubmitAnswer = selectedAnswer != null && !showAnswerResult
    val canProceed = showAnswerResult
}
