package com.example.todoapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.todo.ddEntity
import com.example.todoapp.databinding.ActivityUpdatecard2Binding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class updatecard : AppCompatActivity() {
    private lateinit var binding:ActivityUpdatecard2Binding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityUpdatecard2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lottieAnimationView.playAnimation()
        val db = Room.databaseBuilder(
            applicationContext,
            myDatabase::class.java, "To_Do"
        ).build()
    val pos=intent.getIntExtra("id",-1)
        if (pos!=-1) {
            val title = dataobject.getData(pos).title
            val priority = dataobject.getData(pos).priority
            binding.createtitle.setText(title)
            binding.priority.setText(priority)

            binding.deletebutton.setOnClickListener {
                dataobject.deleteDATA(pos)
                GlobalScope.launch {
                    db.dao().deleteTask(
                        ddEntity(
                            pos + 1, binding.createtitle.text.toString(),
                            binding.priority.text.toString()
                        )
                    )
                }
                myIntent()
            }


            binding.updatebutton.setOnClickListener {
                dataobject.updateData(
                    pos,
                    binding.createtitle.text.toString(),
                    binding.priority.text.toString()
                )
                GlobalScope.launch {
                    db.dao().updateTask(
                        ddEntity(
                            pos + 1,
                            binding.createtitle.text.toString(),
                            binding.priority.text.toString()
                        )
                    )
                }

                myIntent()

            }
        }





    }

     fun myIntent() {
         val intent = Intent( this,MainActivity::class.java)
         startActivity(intent)
    }
}