package android.team.clandestine.posip.fragment

import android.os.Bundle
import android.team.clandestine.posip.R
import android.team.clandestine.posip.databinding.FragmentFindTutorBinding
import android.team.clandestine.posip.recyclerview.adapter.TutorAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import de.hdodenhof.circleimageview.CircleImageView

class FindTutorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFindTutorBinding>(
            inflater,
            R.layout.fragment_find_tutor,
            container,
            false
        )

        (activity as AppCompatActivity).supportActionBar!!.title = resources.getString(R.string.app_name)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).findViewById<CircleImageView>(R.id.profile_pic)
            .visibility = View.GONE


        val adapter = TutorAdapter(activity!!.applicationContext)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        binding.recyclerView.adapter = adapter

        return binding.root
    }
}