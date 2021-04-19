package com.black.kaunbanegacrorepati

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USERNAME)
        val correct = intent.getIntExtra(Constants.CORRECT, 0)

        usernameTV.text = username
        score.text = "Your score is ${correct} out of 10"

        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        btnAnswer.setOnClickListener{
            startActivity(Intent(this, AnswerActivity::class.java))
            finish()
        }

        btnExit.setOnClickListener{
            finish()
        }
    }
}