package com.example.kotlinpractice.presentation.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.kotlinpractice.R
import com.example.kotlinpractice.data.model.request.Result
import com.example.kotlinpractice.databinding.FragmentHomeBinding
import com.example.kotlinpractice.domain.model.QuoteModel
import com.example.kotlinpractice.presentation.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeListAdapter.IoClickQuote {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            homeViewModel.quotes.collect { result ->
                when (result) {
                    is Result.Success -> {
                        binding.progressBar.visibility = View.GONE
                        setList(result.data)
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


    private fun setList(result: List<QuoteModel>) {
        binding.quoteList.adapter =
            HomeListAdapter(result, this)
        binding.quoteList.setHasFixedSize(true)
    }

    override fun clickQuote(quote: QuoteModel) {
//pass quote id to next fragment when click
        sharedViewModel.setQuoteId(quote._id)
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
    }

}