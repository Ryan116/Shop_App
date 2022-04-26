package com.example.shopapp.features.bookmarksScreen.presentation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopapp.features.bookmarksScreen.databinding.FragmentBookmarksBinding
import com.example.shopapp.features.bookmarksScreen.domain.model.Bookmark
import com.example.shopapp.features.bookmarksScreen.presentation.adapter.BookmarkAdapter
import com.example.shopapp.features.bookmarksScreen.presentation.viewModel.BookmarksScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class BookmarksFragment : Fragment() {
    private var _binding: FragmentBookmarksBinding? = null
    private val binding
        get() = _binding!!
    private val bookmarksScreenViewModel by viewModel<BookmarksScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookmarksScreenViewModel.bookmarksList.observe(viewLifecycleOwner) {
            val adapterBookmark = BookmarkAdapter({
                val uri = Uri.parse("shopapp://ToProductDetailsScreen")
                findNavController().navigate(uri)

            },
                object : BookmarkAdapter.BookmarkClickListener {

                    override fun deleteBookmark(bookmark: Bookmark) {
                        bookmarksScreenViewModel.deleteBookmark(bookmark)
                    }

                }
            )
            adapterBookmark.submitList(it)
            binding.recyclerViewBookmarks.adapter = adapterBookmark
            binding.recyclerViewBookmarks.layoutManager = GridLayoutManager(requireContext(), 2)

        }

        binding.buttonDeleteAll.setOnClickListener {
            bookmarksScreenViewModel.deleteAllBooks()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}