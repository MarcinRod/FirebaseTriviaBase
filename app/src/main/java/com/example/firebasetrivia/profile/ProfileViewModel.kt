package com.example.firebasetrivia.profile

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasetrivia.R
import com.example.firebasetrivia.model.Ranking
import kotlin.random.Random

/**
 * This class will represent the view model for the user profile.
 * It will contain the user's profile information and ranking.
 */
class ProfileViewModel : ViewModel() {
    /**
     * A method to generate a random color for a given seed.
     */
    private fun randomColor(seed: Int = 0): Int {
        val random = Random(seed)
        return Color.argb(
            255,
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256)
        )
    }

    override fun onCleared() {
        super.onCleared()
    }
}

/**
 * A binding adapter to set the ranking list to the recycler view.
 */
@BindingAdapter("app:rankingList")
fun setRanking(recyclerView: RecyclerView, rankings: List<Ranking>?) {
    rankings ?: return
    if (recyclerView.adapter is RankingRecyclerViewAdapter) {
        // get the adapter from the recyclerView and submit the list of messages
        val adapter = recyclerView.adapter as RankingRecyclerViewAdapter
        adapter.submitList(rankings)
        val animation: LayoutAnimationController =
            AnimationUtils.loadLayoutAnimation(
                recyclerView.context,
                R.anim.layout_animation_fall_down
            )
        recyclerView.layoutAnimation = animation
        recyclerView.scheduleLayoutAnimation()
    }
}
/**
 * A binding adapter to set the background tint of a text view with initials.
 */
@BindingAdapter("android:myBackgroundTint")
fun setBackgroundTint(view: TextView, color: Int) {
    view.backgroundTintList = ColorStateList.valueOf(color)
    view.backgroundTintMode = android.graphics.PorterDuff.Mode.MULTIPLY
}