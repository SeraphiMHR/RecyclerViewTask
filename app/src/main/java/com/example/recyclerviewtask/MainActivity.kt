package com.example.recyclerviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = PhotoAdapter()
    private var photoIdList = mutableListOf(
        R.drawable.eduardo,
        R.drawable.eduardo1,
        R.drawable.eduardo2,
        R.drawable.eduardo3)
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialization()
    }

    private fun initialization(){
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
            button.setOnClickListener{onClickAddPhoto()}
        }
    }

    private fun onClickAddPhoto(){
        if(index > 3) index = 0
        val photo = Photo(photoIdList[index], "Photo Description")
        adapter.addPhoto(photo)
        index++
    }
}