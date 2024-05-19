package com.example.firebasetrivia.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasetrivia.model.Ranking
import androidx.recyclerview.widget.ListAdapter
import com.example.firebasetrivia.databinding.RankingViewHolderBinding

/**
 * The recycler view adapter for the ranking list.
 */
class RankingRecyclerViewAdapter :
    ListAdapter<Ranking, RankingRecyclerViewAdapter.ViewHolder>(RankingDiffCallback()) {
    inner class ViewHolder(val binding: RankingViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        /**
         * A method to bind the ranking and the position to the view holder.
         */
        fun bind(ranking: Ranking, position: Int) {
            binding.ranking = ranking
            binding.position = position
            binding.executePendingBindings()
        }
    }

    class RankingDiffCallback : DiffUtil.ItemCallback<Ranking>() {
        override fun areItemsTheSame(oldItem: Ranking, newItem: Ranking): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Ranking, newItem: Ranking): Boolean {
            return oldItem.score == newItem.score && oldItem.correctAnswers == newItem.correctAnswers
                    && oldItem.totalQuestions == newItem.totalQuestions
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RankingViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    /**
     * A method to bind the ranking to the view holder.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position + 1)
    }
}