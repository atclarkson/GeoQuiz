package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    var currentIndex = 1u

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex.toInt()].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex.toInt()].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1u) % questionBank.size.toUInt()
    }

    fun moveToPrev() {
        if (currentIndex == 1u) currentIndex = questionBank.size.toUInt()    // Check if number is going to go to negative, if it will just put it one above the last element.
        currentIndex = (currentIndex - 1u) % questionBank.size.toUInt()
    }

}