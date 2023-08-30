package com.example.androidrikmastertest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidrikmastertest.base.BaseFragment
import com.example.androidrikmastertest.databinding.FragmentCameraBinding

class CameraFragment : BaseFragment<FragmentCameraBinding>(FragmentCameraBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}