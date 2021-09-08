package com.example.kotlin1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin1.MainActivity.Companion.INTENT_KEY
import com.example.kotlin1.databinding.ActivityGetTextBinding

class GetTextActivity : AppCompatActivity() {
    lateinit var binding: ActivityGetTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_text)
        binding = ActivityGetTextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataFromEt()
        passClickListener()
    }

    private fun getDataFromEt() {
        val data = intent.getStringExtra(INTENT_KEY)
        binding.textView.text = data
    }

    private fun passClickListener() {
        binding.button2.setOnClickListener() {
            binding.textView.text
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(RE_INTENT_KEY, binding.textView.text.toString())
            startActivity(intent)
        }
    }

    companion object {
        const val RE_INTENT_KEY = "retext"
    }
}