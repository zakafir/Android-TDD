package com.raywenderlich.android.cocktails.game.model

import junit.framework.Assert.assertEquals
import org.junit.Test

class GameUnitTests {
    
    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {
        val game = Game()
        game.incrementScore()
        assertEquals("Current score should be one.\n",1, game.currentScore)
    }
    
    @Test
    fun whenIncrementCurrentScore_aboveHighScore_shouldAlsoIncrementHighScore() {
        val game = Game()
        game.incrementScore()
        assertEquals("High score should be one.\n",1, game.highScore)
    }
    
    @Test
    fun whenIncrementCurrentScore_belowHighScore_shouldNotIncrementHighScore() {
        val game = Game(10)
        game.incrementScore()
        assertEquals("highScore should stay at 10.\n",10, game.highScore)
    }
}