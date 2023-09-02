package com.example.androidrikmastertest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrikmastertest.R
import com.example.androidrikmastertest.databinding.ItemRvDoorBinding
import com.example.androidrikmastertest.dto.DoorsDto
import com.example.androidrikmastertest.utils.visibleIf

class DoorAdapter : RecyclerView.Adapter<DoorAdapter.DoorViewHolder>() {

    private lateinit var listener: DoorActionListener
    var isLocked : Boolean = true

    fun setOnActionListener(listener: DoorActionListener) {
        this.listener = listener
    }

    interface DoorActionListener {
        fun addToFavorite(doorsDto: DoorsDto, favorite: ImageView)
        fun lockOrUnlock(doorsDto: DoorsDto, locked: ImageView, isLocked: Boolean)
        fun editName(doorsDto: DoorsDto)
    }

    private var list : List<DoorsDto> = emptyList()

    fun submitList(doorList: List<DoorsDto>){
        list = doorList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorViewHolder {
        return DoorViewHolder(
            ItemRvDoorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DoorViewHolder, position: Int) {
        holder.bindView(
            list[holder.adapterPosition]
        )
    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class DoorViewHolder(private val binding: ItemRvDoorBinding): RecyclerView.ViewHolder(binding.root){
            fun bindView(doorsDto: DoorsDto){

               binding.tvDoorName.text = doorsDto.name
                binding.ivFavorite.visibleIf(doorsDto.favorites)

                binding.root.setOnClickListener {
                    if (isLocked){
                        isLocked = false
                        binding.ivLockedOrNot.setImageResource(R.drawable.ic_unlocked)
                    } else {
                        isLocked = true
                        binding.ivLockedOrNot.setImageResource(R.drawable.ic_locked)
                    }
                }

                binding.ivAddFavorite.setOnClickListener {
                    if (binding.ivFavorite.visibility == View.VISIBLE){
                        binding.ivFavorite.visibility = View.GONE
                    } else {
                        binding.ivFavorite.visibility = View.VISIBLE
                    }
                    binding.ivFavorite.let { view -> listener.addToFavorite(doorsDto, view) }
                }

                binding.ivEdit.setOnClickListener {
                    listener.editName(doorsDto)
                }
            }
    }
}