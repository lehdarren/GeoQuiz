package com.example.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {
    init {
        Log.d(TAG, "ViewModel instance: created")
    }

    private var questionBank = listOf(
            Question(R.string.question_australia, true, false),
            Question(R.string.question_oceans, true, false),
            Question(R.string.question_mideast, false, false),
            Question(R.string.question_africa, false, false),
            Question(R.string.question_americas, true, false),
            Question(R.string.question_asia, true, false)
    )

    var currentIndex = 0
    var isCheater = false

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    val currentQuestionCheated: Boolean
        get() = questionBank[currentIndex].cheater

    fun Cheater(cheater: Boolean) {
        questionBank[currentIndex].cheater = cheater
    }
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        currentIndex = (currentIndex + questionBank.size - 1) % questionBank.size
    }
}