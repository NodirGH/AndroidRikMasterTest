package com.example.androidrikmastertest.ui

import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.androidrikmastertest.CameraDto
import com.example.androidrikmastertest.base.BaseFragment
import com.example.androidrikmastertest.databinding.FragmentCameraBinding
import com.example.androidrikmastertest.adapter.MainAdapter

class CameraFragment : BaseFragment<FragmentCameraBinding>(FragmentCameraBinding::inflate),
    MainAdapter.CameraActionListener {

    private val mainAdapter = MainAdapter()
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainAdapter.setOnActionListener(this)
        val cameraList = ArrayList<CameraDto>()
        val cameraData = listOf(
            CameraDto(1, "First", isGuarded = true, isFavorite = false),
            CameraDto(2, "Second", isGuarded = false, isFavorite = false),
            CameraDto(3, "Third", isGuarded = false, isFavorite = false),
            CameraDto(4, "Fourth", isGuarded = true, isFavorite = true),
            CameraDto(5, "Fifth", isGuarded = false, isFavorite = false)
        )
        cameraList.addAll(cameraData)
        mainAdapter.reload(cameraData)

        swipeRefreshLayout = binding.swipeRefreshLayout
        recyclerView = binding.rvCamera

//        swipeRefreshLayout.setOnClickListener {
//            swipeRefreshLayout.isRefreshing = false
//
//            val list = mutableListOf<Int>()
//            for (i in 0 until 50){
//                list.add(i)
//            }
//
//            adapter.reload(list)
//
//        }
        recyclerView.adapter = mainAdapter

//        val list = mutableListOf<Int>()
//        for (i in 0 until 50){
//            list.add(i)
//        }
//
//        adapter.reload(list)
        setItemTouchHelper()
    }

    private fun setItemTouchHelper(){

        ItemTouchHelper(object : ItemTouchHelper.Callback() {

            private val limitScrollX = dipToPx(50f, requireContext())
            private var currentScrollX = 0
            private var currentScrollXWhenInActive = 0
            private var initXWhenInActive = 0f
            private var firstInActive = false

            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val dragFlags = 0
                val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            }

            override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
                return Integer.MAX_VALUE.toFloat()
            }

            override fun getSwipeEscapeVelocity(defaultValue: Float): Float {
                return Integer.MAX_VALUE.toFloat()
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
               if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
                   if (dX == 0f){
                       currentScrollX = viewHolder.itemView.scrollX
                       firstInActive = true
                   }

                   if (isCurrentlyActive){
                       var scrollOffSet = currentScrollX + (-dX).toInt()
                       if (scrollOffSet > limitScrollX){
                           scrollOffSet = limitScrollX
                       } else if (scrollOffSet < 0){
                           scrollOffSet = 0
                       }

                       viewHolder.itemView.scrollTo(scrollOffSet, 0)
                   } else {
                       if (firstInActive){
                           firstInActive = false
                           currentScrollXWhenInActive = viewHolder.itemView.scrollX
                           initXWhenInActive = dX
                       }

                       if (viewHolder.itemView.scrollX < limitScrollX){
                           viewHolder.itemView.scrollTo((currentScrollXWhenInActive * dX / initXWhenInActive).toInt(), 0)
                       }
                   }
               }
            }

            override fun clearView(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ) {
                super.clearView(recyclerView, viewHolder)
                if (viewHolder.itemView.scrollX > limitScrollX) {
                    viewHolder.itemView.scrollTo(limitScrollX, 0)
                } else if (viewHolder.itemView.scrollX < 0) {
                    viewHolder.itemView.scrollTo(0, 0)
                }
            }
        }).apply {
            attachToRecyclerView(recyclerView)
        }
    }

    private fun dipToPx(dipValue: Float, context: Context): Int {
        return (dipValue * context.resources.displayMetrics.density).toInt()
    }

    override fun addToFavorite(cameraDto: CameraDto, favorite: ImageView) {
//        if (cameraDto.isFavorite) {
//            favorite.visibility = View.GONE
//        } else {
//            favorite.visibility = View.VISIBLE
//        }
//        Toast.makeText(requireContext(), "${cameraDto.title} is favorite", Toast.LENGTH_SHORT).show()
    }

    override fun addGuarded(cameraDto: CameraDto, guarded: ImageView) {
//        if (cameraDto.isGuarded){
//            guarded.visibility = View.GONE
//        } else {
//            guarded.visibility = View.VISIBLE
//        }
//        Toast.makeText(requireContext(), "${cameraDto.title} is guarded", Toast.LENGTH_SHORT).show()
    }
}