package com.example.firebasetrivia.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.firebasetrivia.databinding.FragmentQuestionBinding

/**
  * Fragment for displaying the question.
 * It will display the question and the possible answers.
 * The user can select an answer and submit it.
 */
class QuestionFragment : Fragment() {
    // Declare the binding and viewmodel variables
    private lateinit var binding: FragmentQuestionBinding
    private val viewModel: QuestionViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentQuestionBinding.inflate(layoutInflater, container, false)
        // Set the viewmodel and lifecycle owner
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }


}