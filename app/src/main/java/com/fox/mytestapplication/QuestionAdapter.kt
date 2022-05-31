package com.fox.mytestapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fox.mytestapplication.databinding.QuestionItemBinding

class QuestionAdapter(var questionList: List<QuestionModel>) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

     inner class ViewHolder (val binding: QuestionItemBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = QuestionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(questionList[position]) {
                binding.tvQuestion.text = this.questionName
                binding.tvAnswer.text = this.answer
                binding.expandedView.visibility = if (this.expand) View.VISIBLE else View.GONE
                binding.cardView.setOnClickListener {
                    this.expand = !this.expand
                    notifyDataSetChanged()
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

}