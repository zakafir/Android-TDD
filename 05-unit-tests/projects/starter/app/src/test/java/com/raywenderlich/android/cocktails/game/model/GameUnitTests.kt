package com.raywenderlich.android.cocktails.game.model

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import junit.framework.Assert.assertSame
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
        val game = Game(highestScore = 10)
        game.incrementScore()
        assertEquals("highScore should stay at 10.\n",10, game.highScore)
    }
    
    @Test
    fun whenTheGameIsInstantiated_itShouldContainsListOfQuestions() {
        val game = Game()
        val questions = game.retrieveQuestions()
        assertNotNull("the list of questions should not be null", questions)
    }
    
    @Test
    fun whenAskForQuestions_itShouldSendTheNextQuestion() {
        val game = Game(questions = listOf(Question("CORRECT", "INCORRECT")))
        val nextQuestion: Question? = game.nextQuestion()
        assertNotNull(nextQuestion)
    }
    
    @Test
    fun whenGettingNextQuestion_shouldReturnIt() {
        val question1 = Question("CORRECT", "INCORRECT")
        val questions = listOf(question1)
        val game = Game(questions)
        val nextQuestion = game.nextQuestion()
        assertSame(question1, nextQuestion)
    }
    
    @Test
    fun whenGettingNextQuestion_withoutMoreQuestions_shouldReturnNull() {
        val question1 = Question("CORRECT", "INCORRECT")
        val questions = listOf(question1)
        val game = Game(questions)
        game.nextQuestion()
        val nextQuestion = game.nextQuestion()
        assertNull(nextQuestion)
    }
}