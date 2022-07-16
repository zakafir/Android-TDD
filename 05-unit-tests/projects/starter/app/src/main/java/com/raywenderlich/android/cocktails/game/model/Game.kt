package com.raywenderlich.android.cocktails.game.model

class Game(highestScore: Int = 0) {
    var currentScore: Int = 0
    private set
    
    var highScore: Int = highestScore
    private set
    
    fun incrementScore() {
        currentScore++
        if (highScore <= currentScore) {
            highScore = currentScore
        }
    }
}