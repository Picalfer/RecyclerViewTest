package com.example.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val indexes: List<String>,
    private val names: List<String>,
    private val name2: List<String>
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) { // special class for optimize data
        var titleText: TextView? = null
        var contentText: TextView? = null
        var indexText: TextView? = null

        init {
            titleText = itemView.findViewById(R.id.titleText)
            contentText = itemView.findViewById(R.id.contentText)
            indexText = itemView.findViewById(R.id.indexText)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder { // here we write id of layout for one listItem's component (xml "list_item_for...")
        // and we must to return an object of class ViewHolder
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_for_recycler_view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) { // here we bind text labels with data
        holder.titleText?.text = names[position]
        holder.contentText?.text = name2[position]
        holder.indexText?.text = indexes[position]
    }

    override fun getItemCount() = names.size // here we get a number of items of our component
}