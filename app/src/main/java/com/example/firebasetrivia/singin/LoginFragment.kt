package com.example.firebasetrivia.singin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.firebasetrivia.R
import com.example.firebasetrivia.databinding.FragmentLoginBinding
import com.example.firebasetrivia.helpers.KeyboardHelper

/**
 * Fragment for the login screen.
 * It will display the login form and handle the login process.
 */
class LoginFragment : Fragment() {
    // Declare the binding and viewmodel variables
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        // Set the viewmodel and lifecycle owner
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // hide the form group initially - it will be shown when the user is not logged in
        binding.formGroup.visibility = View.INVISIBLE
        // Set up the buttons
        setupButtons()
    }


    // This function sets up the buttons in the login/register screen
    private fun setupButtons() {
        // Set a click listener to the login/register toggle button
        binding.loginRegisterToggle.setOnClickListener {
            // Toggle the screen to login or register mode
            toggleLoginRegister()
        }
        // Set a click listener to the login button
        binding.loginButton.setOnClickListener {
            // Hide the keyboard
            KeyboardHelper.hideSoftwareKeyboard(requireContext(), binding.root.windowToken)
            // Call the login function in the viewmodel to try to login
            viewModel.login()
        }

    }

    private fun toggleLoginRegister() {
        // go to the register screen
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private fun navigateToProfile() {
        // go to the profile screen
        findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
    }
    private fun navigateToQuestion() {
        // go to the question screen
        findNavController().navigate(R.id.action_loginFragment_to_questionFragment)
    }

}
