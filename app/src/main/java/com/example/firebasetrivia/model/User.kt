package com.example.firebasetrivia.model

import android.icu.text.DateFormat
import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import java.util.Locale

/**
 * This class will represent the user model.
 * @param username The username of the user.
 * @param ranking The ranking of the user.
 * @param lastSeen The last time the user was seen.
 * @param answeredQuestions The list containing ids of questions answered by the user.
 */
@Parcelize
data class User(
    val username: String = "",
    val ranking: Ranking = Ranking(),
    val lastSeen: Long = System.currentTimeMillis(),
    val answeredQuestions: List<Int> = emptyList()
) : Parcelable {
    @IgnoredOnParcel
    val lastSeenString: String =
        DateFormat.getDateTimeInstance(
            DateFormat.SHORT,
            DateFormat.SHORT, Locale.getDefault()
        ).format(lastSeen)
    }

