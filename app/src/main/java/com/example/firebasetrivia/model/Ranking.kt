package com.example.firebasetrivia.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * This class will represent the ranking model.
 * @param username The username of the user.
 * @param score The score of the user.
 * @param totalQuestions The total number of questions answered by the user.
 * @param correctAnswers The number of correct answers of the user.
 */
@Parcelize
data class Ranking(
    val username: String = "",
    val score: Int = 0,
    val totalQuestions: Int = 0,
    val correctAnswers: Int = 0,
    ) : Parcelable {
}