package com.example.level1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {
    private var currentThrow: Int = 1       // current throw
    private var lastThrow: Int = 1          // last throw
    // images in a array
    private val img = intArrayOf(R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)

        updateUI()                                                          // call update
        // Listeners
        btnLower.setOnClickListener{onLowerClick()}
        btnEquals.setOnClickListener{onEqualClick()}
        btnHigher.setOnClickListener{onHigherClick()}
    }

    fun updateUI() {
        lastThrow = currentThrow                                            // last throw is this throw
        currentThrow = (1..6).random()                                      // roll again
        dice.setImageResource(img[currentThrow] - 1)                        // set image. (-1 for right index)
        lastThrowText.text = getString(R.string.textLastThrow, lastThrow)   // set the text of the last throw. 2nd variable is parameter
    }

    // functions for buttons

    fun onHigherClick() {
        updateUI()
        if (currentThrow > lastThrow) onAnswerCorrect() else onAnswerIncorrect()
    }

    fun onLowerClick(){
        updateUI()
        if (currentThrow < lastThrow) onAnswerCorrect() else onAnswerIncorrect()
    }

    fun onEqualClick() {
        updateUI()
        if (currentThrow == lastThrow) onAnswerCorrect() else onAnswerIncorrect()
    }

    // correct incorrect messages

    fun onAnswerCorrect(){
        Toast.makeText(this, R.string.correct , Toast.LENGTH_SHORT).show()
    }

    fun onAnswerIncorrect() {
        Toast.makeText(this, R.string.incorrect , Toast.LENGTH_SHORT).show()
    }
}
