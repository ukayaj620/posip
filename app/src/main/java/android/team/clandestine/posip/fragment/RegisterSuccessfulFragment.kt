package android.team.clandestine.posip.fragment

import android.os.Bundle
import android.team.clandestine.posip.R
import android.team.clandestine.posip.databinding.FragmentRegisterSuccessfulBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RegisterSuccessfulFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRegisterSuccessfulBinding>(
            inflater,
            R.layout.fragment_register_successful,
            container,
            false
        )

        (activity as AppCompatActivity).supportActionBar!!.title = ""
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(true)

        binding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_registerSuccessfulFragment_to_signInFragment)
        }

        return binding.root
    }
}