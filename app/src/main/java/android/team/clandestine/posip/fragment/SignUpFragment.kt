package android.team.clandestine.posip.fragment

import android.os.Bundle
import android.team.clandestine.posip.R
import android.team.clandestine.posip.databinding.FragmentSignupBinding
import android.team.clandestine.posip.sharedpreferences.PosipSharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_signup,
            container,
            false
        )

        (activity as AppCompatActivity).supportActionBar!!.title = ""
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(true)

        binding.signUpButton.setOnClickListener {
            if (validateInputs()) {
                PosipSharedPreferences.signUp(
                    binding.usernameEditText.text.toString(),
                    binding.passwordEditText.text.toString(),
                    arguments!!.getInt("role"),
                    context!!
                )
                findNavController().navigate(R.id.action_signUpFragment_to_registerSuccessfulFragment)
            }
        }

        return binding.root
    }

    private fun validateInputs(): Boolean {
        var validated = true

        binding.confirmPasswordInputLayout.error = null
        binding.passwordInputLayout.error = null
        binding.usernameInputLayout.error = null
        binding.nameInputLayout.error = null

        if (binding.confirmPasswordEditText.text.isNullOrEmpty()) {
            binding.confirmPasswordInputLayout.error = "Can't be empty"
            validated = false
        }

        if (binding.passwordEditText.text.isNullOrEmpty()) {
            binding.passwordInputLayout.error = "Can't be empty"
            validated = false
        }

        if (binding.usernameEditText.text.isNullOrEmpty()) {
            binding.usernameInputLayout.error = "Can't be empty"
            validated = false
        }

        if (binding.nameEditText.text.isNullOrEmpty()) {
            binding.nameInputLayout.error = "Can't be empty"
            validated = false
        }

        return validated
    }
}