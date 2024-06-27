package com.example.todo

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Cardinfo
import com.example.todoapp.updatecard
import com.example.todoapp.databinding.ViewBinding

class Adapter(var data: List<Cardinfo>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (data[position].priority.toLowerCase()) {
            "high" -> holder.binding.mylayout.setBackgroundColor(Color.parseColor("#F05454"))
            "medium" -> holder.binding.mylayout.setBackgroundColor(Color.parseColor("#EDC988"))
            else -> holder.binding.mylayout.setBackgroundColor(Color.parseColor("#00917C"))
        }

        holder.binding.title.text = data[position].title
        holder.binding.priority.text = data[position].priority
        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.binding.root.context, updatecard::class.java)
            intent.putExtra("id", position)
            holder.binding.root.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
