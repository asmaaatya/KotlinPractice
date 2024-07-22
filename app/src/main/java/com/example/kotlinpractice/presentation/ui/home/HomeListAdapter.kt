package com.example.kotlinpractice.presentation.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kotlinpractice.data.model.beans.QuoteModel
import com.example.kotlinpractice.databinding.QuoteListItemBinding

class HomeListAdapter(private val quotes: List<QuoteModel>): RecyclerView.Adapter<HomeListAdapter.QuotesListHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesListHolder {
        val binding: QuoteListItemBinding = QuoteListItemBinding.inflate(LayoutInflater.from(parent.context), null, false)
        return QuotesListHolder(binding)
    }

    override fun getItemCount(): Int {
      return quotes.size
    }

    override fun onBindViewHolder(holder: QuotesListHolder, position: Int) {
        val quote=quotes[position]
        holder.bind(quote)
    }
    class QuotesListHolder(val binding: QuoteListItemBinding) : ViewHolder(binding.root) {

        fun bind(quote: QuoteModel) {

           binding.textDate.text=quote.dateAdded
            binding.textContent.text=quote.content

        }

    }
}