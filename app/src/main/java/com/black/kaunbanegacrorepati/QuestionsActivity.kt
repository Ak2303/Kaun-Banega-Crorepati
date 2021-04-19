package com.black.kaunbanegacrorepati

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mUsername: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUsername = intent.getStringExtra(Constants.USERNAME)

        mQuestionList = Constants.getQuestions()

        setQuestion()
        optionOneTV.setOnClickListener(this)
        optionTwoTV.setOnClickListener(this)
        optionThreeTV.setOnClickListener(this)
        optionFourTV.setOnClickListener(this)
        submitbtn.setOnClickListener(this)
    }

    private fun setQuestion(){

        val question: Question? = mQuestionList!![mCurrentPosition-1]
        defaultOptionsView()

        progressBar.progress = mCurrentPosition
        progress.text = "${mCurrentPosition}" + "/"+ progressBar.max

        questionTV.text = question!!.question
        optionOneTV.text = question.OptionOne
        optionTwoTV.text = question.OptionTwo
        optionThreeTV.text = question.OptionThree
        optionFourTV.text = question.OptionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, optionOneTV)
        options.add(1, optionTwoTV)
        options.add(2, optionThreeTV)
        options.add(3, optionFourTV)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.defaultbtn)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.optionOneTV->{
                selectedOptionView(optionOneTV, 1)
            }

            R.id.optionTwoTV->{
                selectedOptionView(optionTwoTV, 2)
            }

            R.id.optionThreeTV->{
                selectedOptionView(optionThreeTV, 3)
            }

            R.id.optionFourTV->{
                selectedOptionView(optionFourTV, 4)
            }

            R.id.submitbtn->{

                if(mSelectedOption != 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size->{
                            val question = mQuestionList?.get(mCurrentPosition - 2)
                            if(question!!.correct == mSelectedOption){
                                mCorrectAnswer++
                            }
                            setQuestion()
                        }else->{
                            val question = mQuestionList?.get(mCurrentPosition - 2)
                            if(question!!.correct == mSelectedOption){
                                mCorrectAnswer++
                            }
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USERNAME, mUsername)
                            intent.putExtra(Constants.CORRECT, mCorrectAnswer)
                            startActivity(intent)
                            finish()
                        }
                    }
                    mSelectedOption = 0
                }else{
                    Toast.makeText(this, "Select any option", Toast.LENGTH_SHORT).show()
                }

                if(mCurrentPosition == 10){
                    submitbtn.text = "Finish"
                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOption: Int){
        defaultOptionsView()
        mSelectedOption = selectedOption
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selectedbtn)

    }
}