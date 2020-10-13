package android.team.clandestine.posip.fragment

import android.os.Bundle
import android.team.clandestine.posip.R
import android.team.clandestine.posip.databinding.FragmentHomeBinding
import android.team.clandestine.posip.recyclerview.adapter.ActiveTutorAdapter
import android.team.clandestine.posip.sharedpreferences.PosipSharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import de.hdodenhof.circleimageview.CircleImageView

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        determineRole()

        (activity as AppCompatActivity).supportActionBar!!.title = resources.getString(R.string.app_name)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(false)
        (activity as AppCompatActivity).findViewById<CircleImageView>(R.id.profile_pic)
            .visibility = View.VISIBLE

        binding.searchFab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

        binding.signOutFab.setOnClickListener {
            PosipSharedPreferences.setLogin(0, context!!)
            findNavController().navigate(R.id.action_homeFragment_to_welcomeFragment)
        }

        return binding.root
    }

    private fun determineRole() {
        when (PosipSharedPreferences.getLogin(context!!)) {
            1 -> {
                binding.msg.text = resources.getString(R.string.no_tutor_msg)
                binding.searchFab.visibility = View.VISIBLE
            }
            2 -> {
                binding.msg.text = resources.getString(R.string.no_student_msg)
                binding.searchFab.visibility = View.GONE
            }
            3 -> {
                binding.noTutorMsg.visibility = View.GONE
                binding.searchFab.visibility = View.VISIBLE
                binding.recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
                binding.recyclerView.adapter = ActiveTutorAdapter(activity!!.applicationContext)
            }
            4 -> {
                binding.msg.text = resources.getString(R.string.no_student_msg)
                binding.searchFab.visibility = View.GONE
            }
            else -> {
                findNavController().navigate(R.id.action_homeFragment_to_welcomeFragment)
            }
        }
    }
}