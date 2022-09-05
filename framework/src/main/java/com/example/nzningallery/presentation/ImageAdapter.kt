package com.example.nzningallery.presentation

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.business.domain.Data
import com.example.nzningallery.presentation.util.ImageItem

/**
 * This class is adapter for product RecyclerView
 */

class ImageAdapter(var data: Data, var context: Context) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ImageItem(parent.context))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageItem: ImageItem = holder.itemView as ImageItem

        Glide.with(context).load(data.images?.get(position)?.portrait)
            .into(imageItem.image)
    }

    override fun getItemCount(): Int {
        return data.images!!.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}
