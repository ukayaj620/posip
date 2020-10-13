package android.team.clandestine.posip.fragment

import android.os.Bundle
import android.team.clandestine.posip.R
import android.team.clandestine.posip.databinding.FragmentTutorBackgroundBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import de.hdodenhof.circleimageview.CircleImageView

class TutorBackgroundFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTutorBackgroundBinding>(
            inflater,
            R.layout.fragment_tutor_background,
            container,
            false
        )

        (activity as AppCompatActivity).supportActionBar!!.title = resources.getString(R.string.app_name)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).findViewById<CircleImageView>(R.id.profile_pic)
            .visibility = View.GONE

        binding.enrollChemistryButton.setOnClickListener {

        }

        binding.enrollMathsButton.setOnClickListener {

        }

        return binding.root
    }
}