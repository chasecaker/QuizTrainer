package ru.fefu.quiztrainerapp.model

data class QuizStats(
    val correctAnswers: Int = 0,
    val totalQuestionsAnswered: Int = 0
) {
    val percentage: Int
        get() = if (totalQuestionsAnswered > 0) {
            (correctAnswers.toFloat() / totalQuestionsAnswered * 100).toInt()
        } else 0

    val grade: String
        get() = when (percentage) {
            in 80..100 -> "Excellent!"
            in 60..79 -> "Well done!"
            in 40..59 -> "Not bad!"
            else -> "Try again..."
        }
}