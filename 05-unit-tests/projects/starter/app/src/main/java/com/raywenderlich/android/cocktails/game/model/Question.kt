package com.raywenderlich.android.cocktails.game.model

class Question(
    private val correctOption: String,
    private val incorrectOption: String
) {
    
    var answeredOption: String? = null
        private set
    
    private val isAnsweredCorrectly: Boolean
        get() = correctOption == answeredOption
    
    fun answer(userAnswer: String): Boolean {
        answeredOption = userAnswer
        if (answeredOption != correctOption && answeredOption != incorrectOption) throw IllegalArgumentException(
            "$userAnswer is different from $correctOption and $incorrectOption"
        )
        return isAnsweredCorrectly
    }
    
    fun getOptions(sort: (List<String>) -> List<String>): List<String> {
        return sort(listOf(correctOption, incorrectOption))
    }
}
