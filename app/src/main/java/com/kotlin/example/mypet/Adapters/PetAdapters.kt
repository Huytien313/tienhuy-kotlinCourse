package com.kotlin.example.mypet.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.example.mypet.databinding.GridItemViewBinding
import coil.load
import com.kotlin.example.mypet.model.Pet
import com.kotlin.example.mypet.ui.FragmentDetailPet
import com.kotlin.example.mypet.ui.FragmentHome

class PetAdapters(private val onItemClicked: (Pet) -> Unit) :
ListAdapter<Pet, PetAdapters.PetViewHolder>(DiffCallback){

    private lateinit var context : Context
//    val differ = AsyncListDiffer(this, DiffCallback)

    class PetViewHolder(private var binding : GridItemViewBinding):
    RecyclerView.ViewHolder(binding.root){

        fun bind(pet : Pet, context: Context){
            binding.petName.text = context.getString(pet.name)
            binding.petOld.text = context.getString(pet.yearOld)
            binding.petBreed.text =context.getString(pet.breed)
            binding.PetImage.load(pet.petImage)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): PetViewHolder {
//        không có dòng này không inflate được sang HomeFragment
        context = parent.context
        return PetViewHolder(
            GridItemViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    override fun onBindViewHolder(
        holder: PetViewHolder, position: Int) {
        val currentPet = getItem(position)

        // không có dòng này list pet không hiện đúng với từng pet
        holder.bind(currentPet, context)
        holder.itemView.setOnClickListener {
            onItemClicked(currentPet)

            println("currentPet: " + currentPet)
        }
    }
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Pet>() {
            override fun areItemsTheSame(oldItem: Pet, newItem: Pet): Boolean {
                return (oldItem.id == newItem.id ||
                        oldItem.name == newItem.name ||
                        oldItem.breed == newItem.breed||
                        oldItem.yearOld == newItem.yearOld
                        )
            }

            override fun areContentsTheSame(oldItem: Pet, newItem: Pet): Boolean {
                return oldItem == newItem
            }
        }
    }




}

