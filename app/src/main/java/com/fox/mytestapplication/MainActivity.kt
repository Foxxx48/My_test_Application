package com.fox.mytestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fox.mytestapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var questionAdapter: QuestionAdapter
    private  var questionList = ArrayList<QuestionModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // load data to language list
//        loadQuestions()

        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)

        // pass it to rvLists layoutManager
        binding.rvList.setLayoutManager(layoutManager)

        // initialize the adapter,
        // and pass the required argument
        questionAdapter = QuestionAdapter(questionList)

        // attach adapter to the recycler view
        binding.rvList.adapter = questionAdapter

        // create new objects
        // add some row data
        val question1 = QuestionModel(
            "Платформа Андроид основывается на операционной системе: ",
            """
                Linux
                MAC
                Unix
                Windows CE
                Windows XP

            """.trimIndent(),
            "Ответ: Linux",
            false
        )
        val question2 = QuestionModel(
            "Kotlin",
            "Kotlin is a statically typed, general-purpose programming language" +
                    " developed by JetBrains, that has built world-class IDEs like IntelliJ IDEA, PhpStorm, Appcode, etc.",
            "",
            false
        )
        val question3 = QuestionModel(
            "Python",
            "Python is a high-level, general-purpose and a very popular programming language." +
                    " Python programming language (latest Python 3) is being used in web development, Machine Learning applications, " +
                    "along with all cutting edge technology in Software Industry.",
            "",
            false
        )
        val question4 = QuestionModel(
            "CPP",
            "C++ is a general purpose programming language and widely used now a days for " +
                    "competitive programming. It has imperative, object-oriented and generic programming features. ",
            "",
            false
        )

        // add items to list
        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)



    }

    // add items to the list manually in our case
//    private fun loadQuestions() {
//        questionList = listOf(
//            QuestionModel("Java" , "Exp : 3 years",false),
//            QuestionModel("Kotlin" , "Exp : 2 years", false),
//            QuestionModel("Python" , "Exp : 4 years", false),
//            QuestionModel("JavaScript" , "Exp : 6 years",false),
//            QuestionModel("PHP" , "Exp : 1 years", false),
//            QuestionModel("CPP" , "Exp : 8 years", false)
//        )
//        questionAdapter.notifyDataSetChanged()
//    }

    // on destroy of view make
    // the binding reference to null
    override fun onDestroy() {
        super.onDestroy()
        _binding = null


    }
}