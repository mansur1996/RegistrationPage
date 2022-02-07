package com.example.registrationpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }
    private fun initViews(){
        val textView = findViewById<TextView>(R.id.tv_user_name)
        val imageView = findViewById<ImageView>(R.id.img_user)

        textView.text = intent.getParcelableExtra<User>("user").toString()
        imageView.setImageResource(intent.getIntExtra("image",404))
    }
}