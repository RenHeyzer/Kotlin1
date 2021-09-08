package com.example.kotlin1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin1.GetTextActivity.Companion.RE_INTENT_KEY
import com.example.kotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()
        reGetDataFromTv()
    }

    private fun clickListener() {
        binding.button.setOnClickListener() {
            if (binding.editText.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, GetTextActivity::class.java)
                intent.putExtra(INTENT_KEY, binding.editText.text.toString())
                startActivity(intent)
            }
        }
    }

    private fun reGetDataFromTv() {
        val reData = intent.getStringExtra(RE_INTENT_KEY)
        binding.textView2.text = reData
    }

    companion object {
        const val INTENT_KEY = "text"
    }
}