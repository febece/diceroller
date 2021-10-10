package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.net.FileNameMap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            rollDice()
            val toast = Toast.makeText(this,"Dice Rolled!", Toast. LENGTH_SHORT)
            toast.show()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val luckyNumber = 4
        val resultTextView : TextView = findViewById(R.id.textView)
        when (diceRoll) {

            1 -> {
                resultTextView.text = diceRoll.toString() +" So sorry!  Try again!"
            }
            2 -> {
                resultTextView.text = diceRoll.toString() +" Sadly, Try again!"
            }
            3 -> {
                resultTextView.text = diceRoll.toString() + " Unfortunately, Try again!!"
            }
            4 -> {
                resultTextView.text = diceRoll.toString() + " You rolled a 4. Try again! "
            }
            5 -> {
                resultTextView.text = diceRoll.toString() + " Don't cry! You rolled a 5. Try again!"
            }
            else -> {
                resultTextView.text = diceRoll.toString() + " You woi!!"
            }
        }
        val diceImage : ImageView = findViewById((R.id.imageView))
        val drawableResource = when(diceRoll){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6
        }
        diceImage.setImageResource((drawableResource))
        diceImage.contentDescription=diceRoll.toString()
    }
}
class Dice (val numSide: Int) {
    fun roll(): Int {
        return (1..numSide).random()
    }
}
