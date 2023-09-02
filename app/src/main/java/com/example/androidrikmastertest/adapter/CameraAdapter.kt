package com.example.androidrikmastertest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrikmastertest.databinding.ItemRvCameraBinding
import com.example.androidrikmastertest.dto.CamerasDto
import com.example.androidrikmastertest.utils.visibleIf

class CameraAdapter : RecyclerView.Adapter<CameraAdapter.CameraViewHolder>() {

    private lateinit var listener: CameraActionListener

    fun setOnActionListener(listener: CameraActionListener) {
        this.listener = listener
    }

    interface CameraActionListener {
        fun addToFavorite(camerasDto: CamerasDto, favorite: ImageView)
        fun addGuarded(camerasDto: CamerasDto, guarded: ImageView)
    }

    private var list : List<CamerasDto> = emptyList()

    fun submitList(cameraList: List<CamerasDto>){
        list = cameraList
        notifyDataSetChanged()
    }

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
        holder.bindView(
            list[holder.adapterPosition]
        )
    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class CameraViewHolder(private val binding: ItemRvCameraBinding): RecyclerView.ViewHolder(binding.root){
            fun bindView(camerasDto: CamerasDto){

               binding.tvCameraName.text = camerasDto.name
                binding.ivFavorite?.visibleIf(camerasDto.favorites)
                binding.ivRec?.visibleIf(camerasDto.rec)

                binding.root.setOnClickListener {
                    if (binding.ivGuard?.visibility == View.VISIBLE){
                        binding.ivGuard.visibility = View.GONE
                    } else {
                        binding.ivGuard?.visibility = View.VISIBLE
                    }
                    binding.ivGuard?.let { guard -> listener.addGuarded(camerasDto, guard) }
                }

                binding.ivAddFavorite?.setOnClickListener {
                    if (binding.ivFavorite?.visibility == View.VISIBLE){
                        binding.ivFavorite.visibility = View.GONE
                    } else {
                        binding.ivFavorite?.visibility = View.VISIBLE
                    }
                    binding.ivFavorite?.let { view -> listener.addToFavorite(camerasDto, view) }
                }
            }
    }
}