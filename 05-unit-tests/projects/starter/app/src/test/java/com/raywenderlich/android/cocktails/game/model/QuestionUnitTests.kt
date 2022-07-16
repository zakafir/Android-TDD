package com.raywenderlich.android.cocktails.game.model

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class QuestionUnitTests {
    
    private lateinit var question : Question
    
    @Before
    fun setup() {
        question = Question("CORRECT", "INCORRECT")
    }
    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption() {
        assertNull(question.answeredOption)
    }
    
    @Test
    fun whenAnswering_shouldHaveAnsweredOption() {
        question.answer("INCORRECT")
        assertNotNull(question.answeredOption)
    }
    
    @Test
    fun whenAnswering_withCorrectOption_shouldReturnTrue() {
        val result: Boolean = question.answer("CORRECT")
        assertTrue("result is $result", result)
    }
    
    @Test
    fun whenAnswering_withIncorrectOption_shouldReturnFalse() {
        val result: Boolean = question.answer("INCORRECT")
        assertFalse("result is $result", result)
    }
    
    @Test(expected = IllegalArgumentException::class)
    fun whenAnswering_withInvalidOption_shouldThrowException() {
        question.answer("INVALID")
    }
    
    @Test
    fun whenCreatingQuestion_shouldReturnOptionsWithCustomSort() {
        val options = question.getOptions { it.reversed() }
        assertEquals(listOf("INCORRECT", "CORRECT"), options)
    }
}