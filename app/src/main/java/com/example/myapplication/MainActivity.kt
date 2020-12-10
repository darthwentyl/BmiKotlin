package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.Bmi.BmiForCmKg
import com.example.myapplication.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun count(view: View) {
        binding.apply {
            val errMsg = "Please provide value."
            if (editHeight.text.isBlank()) {
                editHeight.error = errMsg
            }
            if (editMass.text.isBlank()) {
                editMass.error = errMsg
            }
            try {
                val bmi = BmiForCmKg(binding.editMass.text.toString().toDouble(), binding.editHeight.text.toString().toDouble())
                bmiView.text = "%.2f".format(bmi.count())
            } catch (e: Exception) {
                if (e.message!!.contains("The mass", false)) {
                    editMass.error = e.message
                }
                if (e.message!!.contains("The height", false)) {
                    editHeight.error = e.message
                }
                bmiView.text = "0.0"
            }
        }
    }
}