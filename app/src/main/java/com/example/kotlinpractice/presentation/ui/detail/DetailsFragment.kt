package com.example.kotlinpractice.presentation.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.kotlinpractice.R
import com.example.kotlinpractice.databinding.FragmentDetailsBinding
import com.example.kotlinpractice.presentation.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val detailViewModel: DetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        //get id and call details
        sharedViewModel.quoteId.observe(viewLifecycleOwner) { quoteId ->
                detailViewModel.getDetails(quoteId)
        }

        detailViewModel.details.observe(viewLifecycleOwner) { details ->
            binding.authorText.text = details.author
            binding.tagText.text = details.tags.toString()

        }


        return binding.root
    }


}