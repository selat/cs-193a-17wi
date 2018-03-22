package com.selat.cs193a.lecture01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var points: Int = 0
    private var leftNumber: Int = 0
    private var rightNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        points = 0
        updateNumbers()
    }

    fun leftButtonClick(view: View) {
        updatePoints(leftNumber >= rightNumber)
        updateNumbers()
    }

    fun rightButtonClick(view: View) {
        updatePoints(rightNumber >= leftNumber)
        updateNumbers()
    }

    private fun updatePoints(won: Boolean) {
        if (won) {
            ++points
            Toast.makeText(this, "Winner! :)", Toast.LENGTH_SHORT).show()
        } else {
            --points
            Toast.makeText(this, "Loser! :(", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateNumbers() {
        var random = Random()
        leftNumber = random.nextInt(100)
        rightNumber = random.nextInt(100)
        findViewById<Button>(left_button.id).text = leftNumber.toString()
        findViewById<Button>(right_button.id).text = rightNumber.toString()
        findViewById<TextView>(points_text_view.id).text = "Points: "  + points.toString()
    }
}
