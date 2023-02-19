package com.example.bom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bom.databinding.ActivityOnclickedBinding

class Onclicked : AppCompatActivity() {
    private lateinit var binding : ActivityOnclickedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnclickedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var title : String? = intent.getStringExtra("title")
        var code : String? = intent.getStringExtra("code")

        binding.tvTitle.text = title
        binding.tvCode.text = code

        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}