package com.example.nzningallery.presentation.util

import android.content.Context
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView

/**
 * This class is item for images adapter
 */

class ImageItem(
    context: Context
) : FrameLayout(context) {

    var image = AppCompatImageView(context)
    var cardView = CardView(context)

    init {
        cardView.elevation = 2f
        addView(
            cardView,
            LayoutHelper.createFrame(
                LayoutHelper.MATCH_PARENT,
                LayoutHelper.MATCH_PARENT,
                Gravity.NO_GRAVITY,
                4,
                4,
                4,
                4
            )
        )

        image.adjustViewBounds = true
        cardView.addView(
            image, LayoutHelper.createFrame(
                LayoutHelper.MATCH_PARENT,
                LayoutHelper.WRAP_CONTENT
            )
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(
            MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec),
                MeasureSpec.EXACTLY
            ),
            MeasureSpec.makeMeasureSpec(
                0,
                MeasureSpec.UNSPECIFIED
            )
        )
    }
}