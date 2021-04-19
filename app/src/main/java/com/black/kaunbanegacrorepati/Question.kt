package com.black.kaunbanegacrorepati

data class Question (
    val id: Int,
    val question: String,
    val OptionOne: String,
    val OptionTwo: String,
    val OptionThree: String,
    val OptionFour: String,
    val correct: Int
)