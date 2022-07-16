package com.raywenderlich.android.cocktails.game.model

class Game(private val questions: List<Question> = emptyList(), highestScore: Int = 0) {
    var currentScore: Int = 0
    private set
    
    var highScore: Int = highestScore
    private set
    
    var questionIndex = 0
    private set
    
    fun incrementScore() {
        currentScore++
        if (highScore <= currentScore) {
            highScore = currentScore
        }
    }
    
    fun retrieveQuestions(): List<Question> {
        return questions
    }
    
    fun nextQuestion(): Question? {
        return if (questionIndex == questions.size) null
        else {
            questionIndex++
            val question = questions[questionIndex-1]
            question
        }
    }
}