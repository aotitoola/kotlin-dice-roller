package com.learn.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton: Button = findViewById(R.id.count_up_button)
        val resetButton: Button = findViewById(R.id.reset_button)

        rollButton.setOnClickListener{ rollDice() }
        resetButton.setOnClickListener{ resetCount() }
        countUpButton.setOnClickListener{ countUp() }
    }

    private fun rollDice(){
        val randomInt = Random().nextInt(6) + 1
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
/*        resultText.text = "Dice Rolled!"
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()*/
    }

    private fun resetCount(){
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "0"
    }

    private fun countUp(){
        val resultText: TextView = findViewById(R.id.result_text)
        val count =  resultText.text.toString().toIntOrNull()
        val isInteger = count != null

        if(count == 6){
            return
        }

        if (isInteger){
            val newCount = count?.plus(1)
            resultText.text = newCount.toString()
        } else {
            resultText.text = "1"
        }


    }
}
