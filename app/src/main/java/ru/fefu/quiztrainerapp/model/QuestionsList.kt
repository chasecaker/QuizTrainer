package ru.fefu.quiztrainerapp.model

data class Question(
    val id: Int,
    val questionText: String,
    val options: List<String>,
    val correctAnswer: Int
)

val QuestionsList = listOf(
    Question(
        1,
        "What movie is the show mainly parodying?",
        listOf("The Fifth Element", "Back to the Future", "Kill Bill", "Breaking Bad"),
        1
    ),
    Question(
        2,
        "What's Rick's catchphrase?",
        listOf(
            "Wubba Lubba Wub-Lub", "Hubba Bubba Nub-Nub", "Wubba Lubba Dub-Dub", "Dubba Wubba Lub-Lub"
        ),
        2
    ),
    Question(
        3,
        "What's the name of Morty's sister?",
        listOf("Summer", "Winter", "Autumn", "Spring"),
        0
    ),
    Question(
        4,
        "How many seasons are there so far?",
        listOf("Nine", "Six", "Seven", "Eight"),
        3
    ),
    Question(
        5,
        "How many dimensions are there in the show?",
        listOf("About a hundred", "Just under a thousand", "An infinite number", " Nineteen"),
        2
    ),
    Question(
        6,
        "Rick's worst enemy is...",
        listOf("Rick Prime", "Evil Morty", "Mr. Poopybutthole", "The President"),
        0
    ),
    Question(
        7,
        "What's Jerry Smith's job?",
        listOf("Office worker", "He's unemployed", "Courier", "Call center operator"),
        1
    ),
    Question(
        8,
        "What does the President was turned into to track down Rick?",
        listOf("Ostrich", "Turkey", "Squirrel", "Beaver"),
        1
    ),
    Question(
        9,
        "Who destroyed the Citadel?",
        listOf("Rick", "Space Beth", "Squanchy", "Evil Morty"),
        3
    ),
    Question(
        10,
        "What sauce was Rick trying to get?",
        listOf("Caesar", "Béchamel", "Szechuan", "Sweet and sour"),
        2
    ),
)