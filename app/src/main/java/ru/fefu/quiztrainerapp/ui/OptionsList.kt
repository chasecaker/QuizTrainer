package ru.fefu.quiztrainerapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OptionsList(
    options: List<String>,
    selectedAnswer: Int?,
    correctAnswer: Int,
    showResult: Boolean,
    onOptionClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier.Companion.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        options.forEachIndexed { index, option ->
            OptionButton(
                text = option,
                onClick = { onOptionClick(index) },
                enabled = !showResult
            )
        }
    }
}
