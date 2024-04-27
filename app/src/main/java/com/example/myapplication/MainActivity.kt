package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categories = listOf("HVAC", "Electrical", "Plumbing")
        val adapter = CustomArrayAdapter(this, R.layout.item_drop_down,R.id.tv1,  categories)

        binding.category.setAdapter(adapter)

        binding.category.setOnItemClickListener { _, _, position, _ ->
            adapter.updateLastSelectedIndex(position)
        }
    }
}
