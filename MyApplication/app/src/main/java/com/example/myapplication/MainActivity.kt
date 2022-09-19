package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Exception
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var height_data : TextView
    private lateinit var weight_data : TextView
    private lateinit var up_field : TextView
    private lateinit var down_field : TextView
    private lateinit var calculate_button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        height_data = findViewById(R.id.height_calculate)
        weight_data = findViewById(R.id.weight_calculate)
        up_field = findViewById(R.id.up_field)
        down_field = findViewById(R.id.down_field)
        calculate_button = findViewById(R.id.calculate_button)

        calculate_button.setOnClickListener()
        {
            var height : Double? = null
            var weight : Double? = null

            try{
                height = height_data.text.toString().toDouble()
                weight = weight_data.text.toString().toDouble()
                if(height != null && weight != null)
                {
                    var up : Double = (weight / height.pow(2)) * 10000

                    if(up < 18.5)
                    {
                        down_field.text = "Underweight"
                    }
                    else if(up >= 18.5 && up < 25)
                    {
                        down_field.text = "Healthy"
                    }
                    else if(up >= 25 && up < 30)
                    {
                        down_field.text = "Overweight"
                    }
                    else{
                        down_field.text = "Obese"
                    }
                    up_field.text = String.format("%.2f", up)
                }
            }
            catch (e : Exception){
                up_field.text = "Fill both metrics"
                down_field.text = ""
                println(e.toString())
            }
        }

    }
}