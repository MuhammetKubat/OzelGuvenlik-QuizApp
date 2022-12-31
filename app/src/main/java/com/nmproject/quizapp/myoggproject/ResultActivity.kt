package com.nmproject.quizapp.myoggproject


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat


class ResultActivity : AppCompatActivity() {

    private lateinit var correctAns: TextView
    private lateinit var totalAns: TextView
    private lateinit var performance: TextView
    private lateinit var slashss: TextView
    private lateinit var output: LinearLayout


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.hide()

        correctAns = findViewById(R.id.correctAns)
        totalAns = findViewById(R.id.totalAns)
        performance = findViewById(R.id.performance)
        output = findViewById(R.id.output)
        slashss = findViewById(R.id.slash)

        val intent = intent
        val correctAnsNo = intent.getStringExtra("correct")
        val totalAnsNo = intent.getStringExtra("total")
        correctAns.text = correctAnsNo
        totalAns.text = totalAnsNo

        val percentage = (correctAnsNo?.toFloat()?.div(totalAnsNo?.toFloat()!!))?.times(100)

        if (percentage != null) {
            when {
                50 <= percentage && percentage <= 99 -> {

                    performance.text = "İYİ"

                    performance.setTextColor(Color.parseColor("#FDD835"))
                    correctAns.setTextColor(Color.parseColor("#FDD835"))
                    slashss.setTextColor(Color.parseColor("#FDD835"))
                    output.background =
                        ResourcesCompat.getDrawable(resources, R.drawable.option_bg, null)
                }
                percentage >= 100 -> {
                    performance.text = "MÜKEMMEL"
                    performance.setTextColor(Color.parseColor("#C0CA33"))
                    correctAns.setTextColor(Color.parseColor("#FFFF00"))
                    slashss.setTextColor(Color.parseColor("#FFFF00"))
                    output.background =
                        ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)
                }
                percentage < 50 -> {
                    performance.text = "KÖTÜ"
                    performance.setTextColor(Color.parseColor("#F4511E"))
                    correctAns.setTextColor(Color.parseColor("#FF5252"))
                    slashss.setTextColor(Color.parseColor("#FF5252"))
                    output.background =
                        ResourcesCompat.getDrawable(resources, R.drawable.wrong_bg, null)
                }
            }


        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }
}