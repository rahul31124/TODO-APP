package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.Adapter
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.databinding.ActivitySplashscreenBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = Room.databaseBuilder(
            applicationContext,myDatabase::class.java, "To_Do"
        ).build()
        binding.add.setOnClickListener{
            val intent=Intent(this,CreateCard::class.java)
            startActivity(intent)
        }
        binding.delete.setOnClickListener{
            dataobject.deleteALL()
            GlobalScope.launch { db.dao().deleteAll() }
            setRecycler()
        }
         setRecycler()
    }

fun setRecycler() {
   binding.recyclerview.adapter=Adapter(dataobject.getALLDara())
    binding.recyclerview.layoutManager=LinearLayoutManager(this)


    }

}