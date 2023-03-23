package com.axiom.tmdb

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MyItemDecoration(var space:Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom=space
        outRect.left=space
        outRect.right=space

        if(parent.getChildAdapterPosition(view) == 0) {
            outRect.top = space;
        }
    }
}