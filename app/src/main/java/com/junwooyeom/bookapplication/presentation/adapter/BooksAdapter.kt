package com.junwooyeom.bookapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.junwooyeom.bookapplication.databinding.ItemBookBinding
import com.junwooyeom.bookapplication.domain.model.Book
import java.lang.IllegalArgumentException

class BooksAdapter(
    private val onBookClicked: (Book) -> Unit
) : PagingDataAdapter<Book, BooksAdapter.ViewHolder>(bookComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onBookClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemBookBinding,
        private val onBookClicked: (Book) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Book?) {
            binding.book = item
            binding.root.setOnClickListener {
                onBookClicked(item ?: throw IllegalArgumentException("Item not initialized."))
            }
        }
    }

    private companion object {
        val bookComparator = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem == newItem
            }
        }
    }
}