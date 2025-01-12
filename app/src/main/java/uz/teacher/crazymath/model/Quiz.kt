package uz.teacher.crazymath.model

import android.util.Log
import java.io.Console

class Quiz {
    private var score = 0
    private var operand1 = 0
    private var operand2 = 0
    private var operators = arrayOf("+", "-", "*", "/")
    private var answer = 0
    private var operatorIndex = 0
    private var question = ""

    fun createQuiz(level:Int): String {
        if (level == 1) {
            return easyQuiz()
        }
        if (level == 2) {
            return mediumQuiz()
        }
        if(level == 3){
            return hardQuiz()
        }
        return ""

    }

    fun easyQuiz(): String {
        operand1 = (1..10).random()
        operand2 = (1..10).random()
        operatorIndex = (0..1).random()
        question = "$operand1 x $operand2 = ${getAnswer()}"
        return question
    }

    fun mediumQuiz(): String {
        operand1 = (10..100).random()
        operand2 = (10..100).random()
        operatorIndex = (0..3).random()
        question = "$operand1 x $operand2 = ${getAnswer()}"
        return question
    }

    fun hardQuiz(): String {
        operand1 = (100..1000).random()
        operand2 = (100..1000).random()
        operatorIndex = (0..3).random()
        question = "$operand1 x $operand2 = ${getAnswer()}"
        return question

    }

    private fun getAnswer(): Int {
        when (operators[operatorIndex]) {
            "+" -> answer = operand1 + operand2
            "-" -> answer = operand1 - operand2
            "*" -> answer = operand1 * operand2
            "/" -> answer = operand1 / operand2
        }
        return answer
    }

    fun checkAnswer(userAnswer:String): Boolean {
        Log.d("checkAnswer", "checkAnswer: ${operators[operatorIndex]}")
        return userAnswer == operators[operatorIndex]
    }


}