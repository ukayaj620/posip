package android.team.clandestine.posip.fragment

import android.os.Bundle
import android.team.clandestine.posip.R
import android.team.clandestine.posip.databinding.FragmentSigninBinding
import android.team.clandestine.posip.sharedpreferences.PosipSharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSigninBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_signin,
            container,
            false
        )

        (activity as AppCompatActivity).supportActionBar!!.title = ""
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(true)

        binding.signInButton.setOnClickListener {
            if (validateInputs()) {
                findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
            }
        }

        return binding.root
    }

    private fun validateInputs(): Boolean {
        var validated = true

        if (binding.usernameEditText.text.toString() == "studentisi" &&
                binding.passwordEditText.text.toString() == "studentisi") {
            PosipSharedPreferences.setLogin(3, context!!)
            return true
        }

        if (binding.usernameEditText.text.toString() == "tutorisi" &&
            binding.passwordEditText.text.toString() == "tutorisi") {
            PosipSharedPreferences.setLogin(4, context!!)
            return true
        }

        binding.passwordInputLayout.error = null
        binding.usernameInputLayout.error = null

        if (binding.passwordEditText.text.isNullOrEmpty()) {
            binding.passwordInputLayout.error = "Can't be empty"
            validated = false
        }

        if (binding.usernameEditText.text.isNullOrEmpty()) {
            binding.usernameInputLayout.error = "Can't be empty"
            validated = false
        }

        if (validated && !PosipSharedPreferences.signIn(
                binding.usernameEditText.text.toString(),
                binding.passwordEditText.text.toString(),
                context!!
            )) {
            binding.usernameInputLayout.error = "Wrong credentials"
            validated = false
        }

        return validated
    }
}