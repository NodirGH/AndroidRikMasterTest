package com.example.androidrikmastertest.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrikmastertest.MainViewModel
import com.example.androidrikmastertest.adapter.CameraAdapter
import com.example.androidrikmastertest.adapter.DoorAdapter
import com.example.androidrikmastertest.base.BaseFragment
import com.example.androidrikmastertest.databinding.FragmentDoorBinding
import com.example.androidrikmastertest.dto.DoorsDto
import com.example.androidrikmastertest.utils.observe
import com.example.androidrikmastertest.utils.setItemTouchHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoorFragment : BaseFragment<FragmentDoorBinding>(FragmentDoorBinding::inflate), DoorAdapter.DoorActionListener {

    private val viewModel: MainViewModel by viewModels()
    private val doorAdapter = DoorAdapter()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDoorInfo()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvDoor
        recyclerView.adapter = doorAdapter
        doorAdapter.setOnActionListener(this)

        setItemTouchHelper(100f, requireContext(), recyclerView)
        observe(viewModel.door, ::onDoorInfoGotten)
    }

    private fun onDoorInfoGotten(doorInfo: List<DoorsDto>) {
        if (doorInfo.isNotEmpty()) {
            binding.rvDoor.visibility = View.VISIBLE
            binding.placeHolder.root.visibility = View.GONE
            binding.emptyPlaceHolder.root.visibility = View.GONE
            doorAdapter.submitList(doorInfo)
        } else{
            binding.emptyPlaceHolder.root.visibility = View.VISIBLE
            binding.placeHolder.root.visibility = View.GONE
            binding.rvDoor.visibility = View.GONE
        }
    }

    override fun addToFavorite(doorsDto: DoorsDto, favorite: ImageView) {

    }

    override fun lockOrUnlock(doorsDto: DoorsDto, locked: ImageView, isLocked: Boolean) {

    }

    override fun editName(doorsDto: DoorsDto) {
        Toast.makeText(requireContext(), "Edit name ${doorsDto.name}", Toast.LENGTH_SHORT).show()
    }
}