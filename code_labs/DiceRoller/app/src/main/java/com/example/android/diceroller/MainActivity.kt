package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 *  DiceRoller demonstrates simple interactivity in an Android app.
 *  It contains one button that updates an image view with a dice
 *  vector image with a random value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the button view from the layout and assign a click listener to it
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUpNumber() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { resetCount() }
    }

    /**
     * Click listener for the Roll button
     */
    private fun rollDice() {
        val randomInt = (1..6).random()
        Toast.makeText(this, "Roll Dice",
            Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
        //resultText.text = "Dice Rolled!"
    }

    /**
     * Click listener for the countUp button.
     */
    private fun countUpNumber() {
        val resultText: TextView = findViewById(R.id.result_text)

        // If text is the default "Hello World!" set that text to 1.
        if (resultText.text == "Hello World!") {
            Toast.makeText(this, "Count set to 1",
                Toast.LENGTH_SHORT).show()
            resultText.text = "1"
        } else {
            // Otherwise, increment the number up to 6.
            // The text value in resultText.text is an instance of the charSequence class;
            // It needs to be converted to a String object before it can be converted to an int.
            var resultInt = resultText.text.toString().toInt()

            if (resultInt < 6) {
                Toast.makeText(this, "Count up",
                    Toast.LENGTH_SHORT).show()
                resultInt++
                resultText.text = resultInt.toString()
            } else if (resultInt == 6) {
                Toast.makeText(this, "Maximum count reached",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Click listener for the reset button
     */
    private fun resetCount() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (resultText.text != "Hello World!") {
            Toast.makeText(this, "Reset count",
                Toast.LENGTH_SHORT).show()
            val resultInt = 0
            resultText.text = resultInt.toString()
        } else {
            Toast.makeText(this, "Click Roll or Count up!",
                Toast.LENGTH_SHORT).show()
        }
    }
}