package com.kotlin.example.mypet.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.example.mypet.databinding.GridItemViewBinding
import coil.load
import com.kotlin.example.mypet.model.Pet

class PetAdapters(private val onItemClicked: (Pet) -> Unit) :
ListAdapter<Pet, PetAdapters.PetViewHolder>(DiffCallback){

    private lateinit var context : Context

    class PetViewHolder(private var binding: GridItemViewBinding):
    RecyclerView.ViewHolder(binding.root){

        fun bind(pet: Pet, context: Context){
            binding.petName.text = context.getString(pet.name)
            binding.petOld.text = context.getString(pet.yearOld)
            binding.petBreed.text =context.getString(pet.bread)
            binding.PetImage.load(pet.petImage)
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Pet>() {
            override fun areItemsTheSame(oldItem: Pet, newItem: Pet): Boolean {
                return (oldItem.id == newItem.id ||
                        oldItem.name == newItem.name ||
                        oldItem.bread == newItem.bread||
                        oldItem.yearOld == newItem.yearOld
                        )
            }

            override fun areContentsTheSame(oldItem: Pet, newItem: Pet): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): PetViewHolder {
        context = parent.context
        return PetViewHolder(
            GridItemViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: PetViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current, context)
    }
}

