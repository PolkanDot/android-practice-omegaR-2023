package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.widget.Toast
import com.example.todolist.databinding.ActivityMainBinding
import com.google.android.material.animation.AnimationUtils

class MainActivityViewBinding : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val rotateOpen: Animation by lazy { android.view.animation.AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim)}
    private val rotateClose: Animation by lazy { android.view.animation.AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim)}
    private val fromBottom: Animation by lazy { android.view.animation.AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim)}
    private val toBottom: Animation by lazy { android.view.animation.AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim)}

    private var addButtonClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)
        binding = ActivityMainBinding. inflate(layoutInflater)
        setContentView(binding. root)


        binding.addButton.setOnClickListener {
            onAddButtonClicked()
        }

        binding.addNoteButton.setOnClickListener {
            Toast.makeText(this, "Add Note Button Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.addEventButton.setOnClickListener {
            Toast.makeText(this, "Add Event Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onAddButtonClicked() {
        setVisibility(addButtonClicked)
        setAnimation(addButtonClicked)
        setClickable(addButtonClicked)
        addButtonClicked = !addButtonClicked
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked)
        {
            binding.addNoteButton.visibility = View.VISIBLE
            binding.addEventButton.visibility = View.VISIBLE
        } else{
            binding.addNoteButton.visibility = View.INVISIBLE
            binding.addEventButton.visibility = View.INVISIBLE
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked)
        {
            binding.addButton.startAnimation(rotateOpen)
            binding.addNoteButton.startAnimation(fromBottom)
            binding.addEventButton.startAnimation(fromBottom)
        } else{
            binding.addButton.startAnimation(rotateClose)
            binding.addNoteButton.startAnimation(toBottom)
            binding.addEventButton.startAnimation(toBottom)
        }
    }

    private fun setClickable(clicked: Boolean) {
        if (!clicked)
        {
            binding.addNoteButton.isClickable = true
            binding.addEventButton.isClickable = true
        } else{
            binding.addNoteButton.isClickable = false
            binding.addEventButton.isClickable = false
        }
    }
}