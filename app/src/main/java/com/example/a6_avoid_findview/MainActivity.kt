package com.example.a6_avoid_findview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a6_avoid_findview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var firstsp = getSharedPreferences("firstsp", MODE_PRIVATE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try {
            var stringval:String? = firstsp.getString("name1",null)
            binding.name.setText(stringval.toString())
        }
        catch (e:Exception){
            Toast.makeText(this@MainActivity,e.toString(),Toast.LENGTH_SHORT).show()
        }
        binding.show.setOnClickListener {


            val editor = firstsp.edit()
            editor.apply {

                var nm = binding.name.toString()
                putString("name1", nm)
            }.apply()



        }

    }
}