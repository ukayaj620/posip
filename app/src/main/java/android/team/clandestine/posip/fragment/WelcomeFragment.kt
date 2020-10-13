package android.team.clandestine.posip.fragment

import android.os.Bundle
import android.team.clandestine.posip.R
import android.team.clandestine.posip.databinding.FragmentWelcomeBinding
import android.team.clandestine.posip.sharedpreferences.PosipSharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import de.hdodenhof.circleimageview.CircleImageView

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        determineLoginState()

        (activity as AppCompatActivity).supportActionBar!!.title = resources.getString(R.string.app_name)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(false)
        (activity as AppCompatActivity).findViewById<CircleImageView>(R.id.profile_pic)
            .visibility = View.GONE

        binding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_signInFragment)
        }

        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_roleFragment2)
        }

        return binding.root
    }

    private fun determineLoginState() {
        if (PosipSharedPreferences.getLogin(context!!) != 0) {
            findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
        }
    }
}