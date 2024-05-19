package com.example.firebasetrivia.profile

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasetrivia.databinding.FragmentProfileBinding

/**
 * This class will represent the fragment for the user profile.
 * It will display the user's profile information and ranking.
 */
class ProfileFragment : Fragment() {
    // Declare the binding and viewmodel variables
    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()
    // Declare the adapter for the ranking recycler view
    private val rankingsAdapter = RankingRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater,container,false)
        // Set the viewmodel and lifecycle owner
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        // Set the adapter for the ranking recycler view
        with(binding.ranking){
            layoutManager = LinearLayoutManager(context)
            adapter = rankingsAdapter
        }
        return binding.root
    }
}