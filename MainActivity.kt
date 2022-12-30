package com.nmproject.quizapp.myoggproject
import android.content.Intent

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import org.json.JSONArray
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var questionsList: ArrayList<QuestionModel>
    private var index: Int = 0
    lateinit var questionModel: QuestionModel

    private var correctAnswerCount: Int = 0
    private var wrongAnswerCount: Int = 0
    private var donemSec: Int = 0

    lateinit var countDown: TextView
    private lateinit var questions: TextView
    private lateinit var option1: Button
    private lateinit var option2: Button
    private lateinit var option3: Button
    private lateinit var option4: Button
    private lateinit var option5: Button


    private var backPressedTime: Long = 0
    private var backToast: Toast? = null


    override fun onCreate(savedInstanceState: Bundle?) {


        donemSec = intent.getIntExtra("Donem", 0)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        countDown = findViewById(R.id.countdown)
        questions = findViewById(R.id.questions)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        option5 = findViewById(R.id.option5)

        if (donemSec == 0) {
            questionsList = ArrayList()
            val jsonFileString = getJsonDataFromAsset(applicationContext, "Sorular1.json")
            val questions = JSONArray(jsonFileString)
            (0 until questions.length()).forEach {
                val question = questions.getJSONObject(it)
                val q1 = question.get("question")
                val opt1 = question.get("option1")
                val opt2 = question.get("option2")
                val opt3 = question.get("option3")
                val opt4 = question.get("option4")
                val opt5 = question.get("option5")
                val answ = question.get("answer")
                val questionDetail = QuestionModel(
                    question = q1 as String, option1 = opt1 as String,
                    option2 = opt2 as String, option3 = opt3 as String,
                    option4 = opt4 as String, option5 = opt5 as String,
                    answer = answ as String
                )
                questionsList.add(questionDetail)
            }
        }
        if (donemSec == 1) {
            questionsList = ArrayList()
            val jsonFileString = getJsonDataFromAsset(applicationContext, "Sorular2.json")
            val questions = JSONArray(jsonFileString)
            (0 until questions.length()).forEach {
                val question = questions.getJSONObject(it)
                val q1 = question.get("question")
                val opt1 = question.get("option1")
                val opt2 = question.get("option2")
                val opt3 = question.get("option3")
                val opt4 = question.get("option4")
                val opt5 = question.get("option5")
                val answ = question.get("answer")
                val questionDetail = QuestionModel(
                    question = q1 as String, option1 = opt1 as String,
                    option2 = opt2 as String, option3 = opt3 as String,
                    option4 = opt4 as String, option5 = opt5 as String,
                    answer = answ as String
                )
                questionsList.add(questionDetail)
            }
        }
        if (donemSec == 2) {
            questionsList = ArrayList()
            val jsonFileString = getJsonDataFromAsset(applicationContext, "Sorular3.json")
            val questions = JSONArray(jsonFileString)
            (0 until questions.length()).forEach {
                val question = questions.getJSONObject(it)
                val q1 = question.get("question")
                val opt1 = question.get("option1")
                val opt2 = question.get("option2")
                val opt3 = question.get("option3")
                val opt4 = question.get("option4")
                val opt5 = question.get("option5")
                val answ = question.get("answer")
                val questionDetail = QuestionModel(
                    question = q1 as String, option1 = opt1 as String,
                    option2 = opt2 as String, option3 = opt3 as String,
                    option4 = opt4 as String, option5 = opt5 as String,
                    answer = answ as String
                )
                questionsList.add(questionDetail)
            }
        }
        if (donemSec == 3) {
            questionsList = ArrayList()
            val jsonFileString = getJsonDataFromAsset(applicationContext, "Sorular4.json")
            val questions = JSONArray(jsonFileString)
            (0 until questions.length()).forEach {
                val question = questions.getJSONObject(it)
                val q1 = question.get("question")
                val opt1 = question.get("option1")
                val opt2 = question.get("option2")
                val opt3 = question.get("option3")
                val opt4 = question.get("option4")
                val opt5 = question.get("option5")
                val answ = question.get("answer")
                val questionDetail = QuestionModel(
                    question = q1 as String, option1 = opt1 as String,
                    option2 = opt2 as String, option3 = opt3 as String,
                    option4 = opt4 as String, option5 = opt5 as String,
                    answer = answ as String
                )
                questionsList.add(questionDetail)
            }
        }

        if (donemSec == 4) {
            questionsList = ArrayList()
            val jsonFileString = getJsonDataFromAsset(applicationContext, "Sorular5.json")
            val questions = JSONArray(jsonFileString)
            (0 until questions.length()).forEach {
                val question = questions.getJSONObject(it)
                val q1 = question.get("question")
                val opt1 = question.get("option1")
                val opt2 = question.get("option2")
                val opt3 = question.get("option3")
                val opt4 = question.get("option4")
                val opt5 = question.get("option5")
                val answ = question.get("answer")
                val questionDetail = QuestionModel(
                    question = q1 as String, option1 = opt1 as String,
                    option2 = opt2 as String, option3 = opt3 as String,
                    option4 = opt4 as String, option5 = opt5 as String,
                    answer = answ as String
                )
                questionsList.add(questionDetail)
            }
        }


        //questionsList.shuffle()
        questionModel = questionsList[index]


        setAllQuestions()

        countdown()

    }

    fun countdown() {
        val duration = TimeUnit.SECONDS.toMillis(15)
        object : CountDownTimer(duration, 1000) {

            override fun onTick(millisUntilFinished: Long) {

                val sDuration: String = String.format(
                    Locale.ENGLISH,
                    "%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                    )
                )

                countDown.text = sDuration
            }

            override fun onFinish() {
                index++
                if (index < questionsList.size) {
                    questionModel = questionsList[index]
                    setAllQuestions()
                    resetBackground()
                    enableButton()
                    countdown()

                } else {

                    gameResult()

                }


            }


        }.start()


    }

    private fun correctAns(option: Button) {
        option.background = ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)

        correctAnswerCount++


    }

    private fun wrongAns(option: Button) {

        option.background = ResourcesCompat.getDrawable(resources, R.drawable.wrong_bg, null)
        when (questionModel.answer) {
            questionModel.option1 -> option1.background =
                ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)
            questionModel.option2 -> option2.background =
                ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)
            questionModel.option3 -> option3.background =
                ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)
            questionModel.option4 -> option4.background =
                ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)
            questionModel.option5 -> option5.background =
                ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)
        }
        wrongAnswerCount++


    }

    private fun gameResult() {
        val intent = Intent(this, ResultActivity::class.java)

        intent.putExtra("correct", correctAnswerCount.toString())
        intent.putExtra("total", questionsList.size.toString())

        startActivity(intent)
    }

    private fun setAllQuestions() {
        questions.text = questionModel.question
        option1.text = questionModel.option1
        option2.text = questionModel.option2
        option3.text = questionModel.option3
        option4.text = questionModel.option4
        option5.text = questionModel.option5
    }

    private fun enableButton() {
        option1.isClickable = true
        option2.isClickable = true
        option3.isClickable = true
        option4.isClickable = true
        option5.isClickable = true

    }

    private fun disableButton() {
        option1.isClickable = false
        option2.isClickable = false
        option3.isClickable = false
        option4.isClickable = false
        option5.isClickable = false
    }

    private fun resetBackground() {
        option1.background = ResourcesCompat.getDrawable(resources, R.drawable.option_bg, null)
        option2.background = ResourcesCompat.getDrawable(resources, R.drawable.option_bg, null)
        option3.background = ResourcesCompat.getDrawable(resources, R.drawable.option_bg, null)
        option4.background = ResourcesCompat.getDrawable(resources, R.drawable.option_bg, null)
        option5.background = ResourcesCompat.getDrawable(resources, R.drawable.option_bg, null)
    }

    fun option1Clicked(view: View) {
        disableButton()
        if (questionModel.option1 == questionModel.answer) {
            option1.background = ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)

            correctAns(option1)


        } else {
            wrongAns(option1)


        }
    }

    fun option2Clicked(view: View) {
        disableButton()
        if (questionModel.option2 == questionModel.answer) {
            option2.background = ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)


            correctAns(option2)

        } else {
            wrongAns(option2)
        }
    }

    fun option3Clicked(view: View) {
        disableButton()
        if (questionModel.option3 == questionModel.answer) {

            option3.background = ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)

            correctAns(option3)
        } else {
            wrongAns(option3)
        }
    }

    fun option4Clicked(view: View) {
        disableButton()
        if (questionModel.option4 == questionModel.answer) {
            option4.background = ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)


            correctAns(option4)

        } else {
            wrongAns(option4)
        }
    }

    fun option5Clicked(view: View) {
        disableButton()
        if (questionModel.option5 == questionModel.answer) {
            option5.background = ResourcesCompat.getDrawable(resources, R.drawable.right_bg, null)


            correctAns(option5)

        } else {
            wrongAns(option5)
        }
    }

    override fun onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast?.cancel()
            finish()
        } else {
            backToast = Toast.makeText(baseContext, "Çift tıkayarak çıkın!", Toast.LENGTH_SHORT)
            backToast?.show()
        }
        backPressedTime = System.currentTimeMillis()

    }


}