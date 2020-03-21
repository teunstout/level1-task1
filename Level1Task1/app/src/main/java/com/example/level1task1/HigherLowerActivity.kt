package com.example.level1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1
    private val img = intArrayOf(
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        updateUI()

        btnLower.setOnClickListener { onLowerClick() }
        btnEquals.setOnClickListener { onEqualClick() }
        btnHigher.setOnClickListener { onHigherClick() }
    }

    fun updateUI() {
        lastThrow = currentThrow                                            // last throw is this throw
        currentThrow = (1..6).random()                                      // roll again
        dice.setImageResource(img[currentThrow - 1])                        // set image. (-1 for right index)
        lastThrowText.text = getString(R.string.textLastThrow, lastThrow)   // set the text of the last throw
    }

    fun onHigherClick() {
        updateUI()
        toastMessage(currentThrow > lastThrow)
    }

    fun onLowerClick() {
        updateUI()
        toastMessage(currentThrow < lastThrow)
    }

    fun onEqualClick() {
        updateUI()
        toastMessage(currentThrow == lastThrow)
    }

    fun toastMessage(awnserGood: Boolean) {
        val message = if (awnserGood) R.string.correct else R.string.incorrect
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
