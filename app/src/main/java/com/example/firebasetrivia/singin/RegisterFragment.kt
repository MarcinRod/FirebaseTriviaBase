package com.example.firebasetrivia.singin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.firebasetrivia.R
import com.example.firebasetrivia.databinding.FragmentRegisterBinding
import com.example.firebasetrivia.helpers.KeyboardHelper
/**
 * Fragment for the register screen.
 * It will display the register form and handle the register process.
 */
class RegisterFragment : Fragment() {
    // Declare the binding and viewmodel variables
    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        // Set the viewmodel and lifecycle owner
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // set up the buttons
        setupButtons()

    }

    // This function sets up the buttons in the login/register screen
    private fun setupButtons() {
        // Set a click listener to the login/register toggle button
        binding.loginRegisterToggle.setOnClickListener {
            // Toggle the screen to login mode
            toggleLoginRegister()
        }
        binding.registerButton.setOnClickListener {
            // Hide the keyboard
            KeyboardHelper.hideSoftwareKeyboard(requireContext(), binding.root.windowToken)
            // Call the register function in the viewmodel to try to register
            viewModel.register()
        }
    }



    private fun toggleLoginRegister() {
        // Navigate to the login screen
        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }

    private fun navigateToUsernameForm() {
        // Navigate to the username input form
        findNavController().navigate(R.id.action_registerFragment_to_usernameFragment)
    }

}
