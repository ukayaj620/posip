package android.team.clandestine.posip.recyclerview.adapter

import android.content.Context
import android.team.clandestine.posip.R
import android.team.clandestine.posip.databinding.ListItemTutorsBinding
import android.team.clandestine.posip.databinding.ListItemsActiveTutorBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ActiveTutorHolder(
    val binding: ListItemsActiveTutorBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        binding.container.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_homeFragment_to_activeTutorDetailsFragment)
        }
    }
}

class ActiveTutorAdapter(private val context: Context) : RecyclerView.Adapter<ActiveTutorHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveTutorHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemsActiveTutorBinding>(
            inflater,
            R.layout.list_items_active_tutor,
            parent,
            false
        )
        return ActiveTutorHolder(binding, context)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ActiveTutorHolder, position: Int) {
        holder.bind()
    }
}
