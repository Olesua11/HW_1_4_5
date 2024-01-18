package com.example.hw1_4_5.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_1_4_5.R
import com.example.hw_1_4_5.ui.taskedit.TaskAdapter

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter
    private val taskList = mutableListOf("ЗОНТ", "МУХАМОР", "В", "Г","А", "Б", "В", "Г","А", "Б", "В", "Г","А", "Б", "В", "Г")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = TaskAdapter(taskList) { position -> onTaskItemClick(position) }
        recyclerView.adapter = adapter

        val buttonAddTask: Button = view.findViewById(R.id.buttonAddTask)
        buttonAddTask.setOnClickListener {
            addBlankTask()
        }

        return view
    }

    private fun addBlankTask() {
        taskList.add("blank task")
        adapter.notifyDataSetChanged()
    }

    private fun onTaskItemClick(position: Int) {
        val selectedTask = taskList[position]
        val bundle = bundleOf("task" to selectedTask, "position" to position)

        findNavController().navigate(R.id.action_navigation_home_to_taskEditFragment, bundle)
    }

    fun updateTask(position: Int, updatedTask: String) {
        taskList[position] = updatedTask
        adapter.notifyDataSetChanged()
    }
}
