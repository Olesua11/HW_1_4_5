package com.example.hw1_4_2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.hw1_4_2.MainActivity
import com.example.hw_1_4_5.R

class TaskEditFragment : Fragment() {

    private lateinit var editTextTask: EditText
    private lateinit var buttonDone: Button

    val args: TaskEditFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_edit, container, false)

        editTextTask = view.findViewById(R.id.editTextTask)
        buttonDone = view.findViewById(R.id.buttonDone)

        editTextTask.setText(args.task)

        buttonDone.setOnClickListener {
            val position = args.position
            if (position != -1) {
                (activity as MainActivity).updateTask(position, editTextTask.text.toString())
            }
            activity?.onBackPressed()
        }

        return view
    }
}
