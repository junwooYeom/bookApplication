package com.junwooyeom.bookapplication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.junwooyeom.bookapplication.R
import com.junwooyeom.bookapplication.databinding.FragmentSearchBinding
import com.junwooyeom.bookapplication.domain.model.Book
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private val adapter by lazy {
        BooksAdapter(this::onBookClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSearchBinding.bind(view)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvBooks.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(), DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun onBookClicked(book: Book) {
        val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(
            book
        )
        findNavController().navigate(action)
    }
}
