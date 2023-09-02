package com.example.androidrikmastertest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidrikmastertest.base.BaseFragment
import com.example.androidrikmastertest.databinding.FragmentCameraBinding
import com.example.androidrikmastertest.databinding.FragmentDoorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoorFragment : BaseFragment<FragmentDoorBinding>(FragmentDoorBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}