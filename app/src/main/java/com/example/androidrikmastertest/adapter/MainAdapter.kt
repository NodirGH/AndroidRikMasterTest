package com.example.androidrikmastertest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrikmastertest.CameraDto
import com.example.androidrikmastertest.databinding.ItemRvCameraBinding
import com.example.androidrikmastertest.visibleIf

class MainAdapter : RecyclerView.Adapter<MainAdapter.CameraViewHolder>() {

    var isCameraFragment = true
    var isDoorFragment = false

    private lateinit var listener: CameraActionListener

    fun setOnActionListener(listener: CameraActionListener) {
        this.listener = listener
    }

    interface CameraActionListener {
        fun addToFavorite(cameraDto: CameraDto, favorite: ImageView)
        fun addGuarded(cameraDto: CameraDto, guarded: ImageView)
    }

    private var list = mutableListOf<CameraDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        return CameraViewHolder(
            ItemRvCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
//        holder.index = list[position]
//        holder.updateView()
//        holder.onDeleteClick = {
//            removeItem(it)
//        }
        holder.bindView(
            list[holder.adapterPosition]
        )
    }

    fun reload(list: List<CameraDto>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class CameraViewHolder(private val binding: ItemRvCameraBinding): RecyclerView.ViewHolder(binding.root){
            fun bindView(cameraDto: CameraDto){
               binding.tvCameraName.text = cameraDto.title
                binding.ivGuard?.visibleIf(cameraDto.isGuarded)
                binding.ivFavorite?.visibleIf(cameraDto.isFavorite)

                binding.root.setOnClickListener {
                    if (binding.ivGuard?.visibility == View.VISIBLE){
                        binding.ivGuard.visibility = View.GONE
                    } else {
                        binding.ivGuard?.visibility = View.VISIBLE
                    }
                    binding.ivGuard?.let { guard -> listener.addGuarded(cameraDto, guard) }
                }

                binding.ivAddFavorite?.setOnClickListener {
                    if (binding.ivFavorite?.visibility == View.VISIBLE){
                        binding.ivFavorite.visibility = View.GONE
                    } else {
                        binding.ivFavorite?.visibility = View.VISIBLE
                    }
                    binding.ivFavorite?.let { view -> listener.addToFavorite(cameraDto, view) }
                }
            }
    }

    private fun removeItem(viewHolder: RecyclerView.ViewHolder){
        list.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
    }
}