package com.example.firebasetrivia.singin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.firebasetrivia.databinding.FragmentUsernameBinding

class UsernameFragment : Fragment() {
    // Declare the binding and viewmodel variables
    private lateinit var binding: FragmentUsernameBinding
    private val viewModel: UsernameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUsernameBinding.inflate(layoutInflater,container,false)
        // Set the viewmodel and lifecycle owner
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        // set up the buttons
        binding.submitUsernameButton.setOnClickListener {
            // Call the submitUsername function in the viewmodel to try to submit the username
            viewModel.submitUsername()
        }
        return binding.root
    }
}