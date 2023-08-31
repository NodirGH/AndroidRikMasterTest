package com.example.androidrikmastertest.testing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrikmastertest.R


class RecyclerviewAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder>() {
    private val mContext: Context
    private var taskList: List<Task>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.task_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task: Task = taskList[position]
        holder.tvTaskName.text = task.name
        holder.tvTaskDesc.text = task.desc
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setTaskList(taskList: List<Task>) {
        this.taskList = taskList
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val tvTaskName: TextView
         val tvTaskDesc: TextView

        init {
            tvTaskName = itemView.findViewById(R.id.task_name)
            tvTaskDesc = itemView.findViewById(R.id.task_desc)
        }
    }

    init {
        mContext = context
        taskList = ArrayList()
    }
}