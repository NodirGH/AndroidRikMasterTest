package com.example.androidrikmastertest.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.androidrikmastertest.MainViewModel
import com.example.androidrikmastertest.adapter.CameraAdapter
import com.example.androidrikmastertest.base.BaseFragment
import com.example.androidrikmastertest.databinding.FragmentCameraBinding
import com.example.androidrikmastertest.dto.CamerasDto
import com.example.androidrikmastertest.utils.observe
import com.example.androidrikmastertest.utils.setItemTouchHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraFragment : BaseFragment<FragmentCameraBinding>(FragmentCameraBinding::inflate),
    CameraAdapter.CameraActionListener {

    private val cameraAdapter = CameraAdapter()
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCameraInfo()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cameraAdapter.setOnActionListener(this)
        swipeRefreshLayout = binding.swipeRefreshLayout
        recyclerView = binding.rvCamera
        recyclerView.adapter = cameraAdapter

        setItemTouchHelper(50f, requireContext(), recyclerView)

        observe(viewModel.cameras, ::onCameraInfoGotten)
    }

    override fun addToFavorite(camerasDto: CamerasDto, favorite: ImageView) {

    }

    override fun addGuarded(camerasDto: CamerasDto, guarded: ImageView) {

    }

    private fun onCameraInfoGotten(cameraInfo: List<CamerasDto>) {
        if (cameraInfo.isNotEmpty()) {
            binding.tvHall.visibility = View.VISIBLE
            binding.rvCamera.visibility = View.VISIBLE
            binding.placeHolder.root.visibility = View.GONE
            binding.emptyPlaceHolder.root.visibility = View.GONE
            cameraAdapter.submitList(cameraInfo)
        } else{
            binding.emptyPlaceHolder.root.visibility = View.VISIBLE
            binding.placeHolder.root.visibility = View.GONE
            binding.tvHall.visibility = View.GONE
            binding.rvCamera.visibility = View.GONE
        }
    }
}