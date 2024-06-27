package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.room.Room
import com.example.todoapp.databinding.ActivitySplashscreenBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class splashscreen : AppCompatActivity() {
    private lateinit var binding:ActivitySplashscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = Room.databaseBuilder(
            applicationContext,
            myDatabase::class.java, "To_Do"
        ).build()
        GlobalScope.launch {
            dataobject.listdata= db.dao().getTasks() as MutableList<Cardinfo>
        }




        binding.lottieAnimationView.playAnimation()
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent( this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },5000)

    }

}