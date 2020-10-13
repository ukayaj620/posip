package android.team.clandestine.posip.fragment

import android.os.Bundle
import android.team.clandestine.posip.R
import android.team.clandestine.posip.databinding.FragmentRoleBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RoleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRoleBinding>(
            inflater,
            R.layout.fragment_role,
            container,
            false
        )

        (activity as AppCompatActivity).supportActionBar!!.title = ""
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(true)

        binding.studentButton.setOnClickListener {
            findNavController().navigate(R.id.action_roleFragment_to_signUpFragment, bundleOf("role" to 1))
        }

        binding.teacherButton.setOnClickListener {
            findNavController().navigate(R.id.action_roleFragment_to_signUpFragment, bundleOf("role" to 2))
        }

        return binding.root
    }
}