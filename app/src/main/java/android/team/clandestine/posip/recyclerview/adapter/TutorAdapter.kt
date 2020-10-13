package android.team.clandestine.posip.recyclerview.adapter

import android.content.Context
import android.team.clandestine.posip.R
import android.team.clandestine.posip.databinding.ListItemTutorsBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class TutorHolder(
    val binding: ListItemTutorsBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        binding.container.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_findTutorFragment_to_tutorBackgroundFragment)
        }
    }
}

class TutorAdapter(private val context: Context) : RecyclerView.Adapter<TutorHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemTutorsBinding>(
            inflater,
            R.layout.list_item_tutors,
            parent,
            false
        )
        return TutorHolder(binding, context)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: TutorHolder, position: Int) {
        holder.bind()
    }
}
