package com.example.kotlinpractice.presentation.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kotlinpractice.R
import com.example.kotlinpractice.data.model.beans.QuoteModel
import com.example.kotlinpractice.databinding.FragmentHomeBinding
import com.example.kotlinpractice.presentation.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(),HomeListAdapter.IoClickQuote {
   private var _binding:FragmentHomeBinding?=null
       private val binding get() = _binding!!
    private val homeViewModel:HomeViewModel by viewModels()
    private val sharedViewModel:SharedViewModel by activityViewModels()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
                homeViewModel.loadQuotes()
        homeViewModel.quotes.observe(viewLifecycleOwner) { quotes ->
            binding.quoteList.adapter = HomeListAdapter(quotes,this)
            binding.quoteList.setHasFixedSize(true)
        }
        return binding.root
    }

    override fun clickQuote(quote: QuoteModel) {
//pass quote id to next fragment when click
        sharedViewModel.setQuoteId(quote._id)
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
    }

}