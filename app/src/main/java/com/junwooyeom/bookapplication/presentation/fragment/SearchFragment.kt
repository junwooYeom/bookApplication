package com.junwooyeom.bookapplication.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.junwooyeom.bookapplication.R
import com.junwooyeom.bookapplication.databinding.FragmentSearchBinding
import com.junwooyeom.bookapplication.domain.model.Book
import com.junwooyeom.bookapplication.presentation.adapter.BooksAdapter
import com.junwooyeom.bookapplication.presentation.viewmodel.BookViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private val viewModel by viewModels<BookViewModel>()

    private val bookAdapter by lazy {
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
        initListener()
    }

    private fun searchBooks(query: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getBookList(query).collect {
                bookAdapter.submitData(it)
            }
        }
    }

    private fun initListener() {
        val editText = binding.etBooks.editText ?: throw IllegalArgumentException("EditText Must be initialized.")
        binding.btnSearch.setOnClickListener {
            if (editText.text.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "검색어를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                searchBooks(editText.text.toString())
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvBooks.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = bookAdapter
        }
    }

    private fun onBookClicked(book: Book) {
        val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(
            book
        )
        findNavController().navigate(action)
    }
}
