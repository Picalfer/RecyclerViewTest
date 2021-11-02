package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recView: RecyclerView = findViewById(R.id.rView)
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recView.adapter = MyAdapter(fillList(),getCatList(),getCatSecondNameList())
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..12).forEach { i -> data.add("$i element")}
        return data
    }

    private fun getCatList(): List<String> {
        return this.resources.getStringArray(R.array.names).toList()
    }

    private fun getCatSecondNameList(): List<String> {
        return this.resources.getStringArray(R.array.name2).toList()
    }
}