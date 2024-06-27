package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Database
import androidx.room.Room
import com.example.todo.ddEntity
import com.example.todoapp.databinding.ActivityCreateCardBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCard : AppCompatActivity() {

    private lateinit var binding:ActivityCreateCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCreateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lottieAnimationView.playAnimation()
        val db = Room.databaseBuilder(
            applicationContext,
            myDatabase::class.java, "To_Do"
        ).build()
        binding.savebutton.setOnClickListener{
            if(binding.createtitle.text.toString().trim { it<=' ' }.isNotBlank()&&binding.priority.text.toString().trim { it<=' ' }.isNotBlank()){
                var title=binding.createtitle.getText().toString()
                var priority=binding.priority.getText().toString()
                dataobject.setData(title,priority)
                GlobalScope.launch {
                    db.dao().insertTask(ddEntity(0,title,priority))
                }
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}