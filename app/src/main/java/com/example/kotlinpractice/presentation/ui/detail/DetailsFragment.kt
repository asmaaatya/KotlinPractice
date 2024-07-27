package com.example.kotlinpractice.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.kotlinpractice.data.model.request.Result
import com.example.kotlinpractice.databinding.FragmentDetailsBinding
import com.example.kotlinpractice.presentation.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            sharedViewModel.quoteId.collect { quoteId ->
                quoteId?.let { detailViewModel.getDetails(it) }
            }
        }
        lifecycleScope.launch {
            detailViewModel.details.collect { result ->
                when (result) {
                    is Result.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.authorText.text = result.data.author
                        binding.tagText.text = result.data.tags.toString()
                    }

                    is Result.Failure -> {
                        binding.progressBar.visibility = View.GONE
                        //handle error
                        Toast.makeText(requireContext(), result.message, Toast.LENGTH_LONG).show()
                    }

                    is Result.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }


                }
            }
        }
        return binding.root
    }


}