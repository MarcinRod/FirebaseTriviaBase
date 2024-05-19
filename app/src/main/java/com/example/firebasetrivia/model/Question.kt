package com.example.firebasetrivia.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


/**
 * This class will represent the question model.
 * @param id The id of the question.
 * @param question The question.
 * @param answer The answer of the question.
 * @param options The list of answers for the question.
 */
@Parcelize
data class Question(val id: Int, val question: String, val answer: String, val options: List<String>) :
    Parcelable {
}