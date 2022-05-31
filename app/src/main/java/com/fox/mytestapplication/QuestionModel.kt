package com.fox.mytestapplication

data class QuestionModel(
    val questionName : String = "",
    val variantAnswer : String = "",
    val answer : String = "",
    var expand : Boolean = false
)
