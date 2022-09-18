package com.example.nzningallery.presentation

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.business.domain.Data
import com.example.business.util.DataState
import com.example.nzningallery.R
import com.example.nzningallery.presentation.util.LayoutHelper
import dagger.hilt.android.AndroidEntryPoint

/**
 * This class is fragment image for products list
 */

@AndroidEntryPoint
class ImageFragment : Fragment() {

    private lateinit var rootView: FrameLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    lateinit var textView: TextView

    private val imageViewModel: ImageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = FrameLayout(requireContext())

        recyclerView = RecyclerView(requireContext())
        recyclerView.id=R.id.image_listView
        recyclerView.layoutManager =
            GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        rootView.addView(
            recyclerView, LayoutHelper.createFrame(
                LayoutHelper.MATCH_PARENT,
                LayoutHelper.MATCH_PARENT,
                Gravity.CENTER,
                8, 8, 8, 8

            )
        )

        progressBar = ProgressBar(requireContext())
        progressBar.id=R.id.progress
        progressBar.visibility = View.GONE
        rootView.addView(
            progressBar, LayoutHelper.createFrame(
                LayoutHelper.WRAP_CONTENT,
                LayoutHelper.WRAP_CONTENT,
                Gravity.CENTER
            )
        )

        textView = TextView(requireContext())
        textView.visibility = View.GONE
        textView.typeface = ResourcesCompat.getFont(requireContext(), R.font.main_font)
        textView.setTextColor(R.color.teal_700)
        rootView.addView(
            textView, LayoutHelper.createFrame(
                LayoutHelper.WRAP_CONTENT,
                LayoutHelper.WRAP_CONTENT,
                Gravity.CENTER
            )
        )

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageViewModel.getPostList()
        getProductResponse()
    }

    private fun getProductResponse() {
        imageViewModel.imageListLiveData.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DataState.Success<Data> -> {
                    displayProgressBar(false)
                    appendProductData(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    textView.visibility = View.VISIBLE
                    textView.text = dataState.exception.message.toString()
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun appendProductData(products: Data) {
        recyclerView.adapter = context?.let { ImageAdapter(products, it) }
    }

}