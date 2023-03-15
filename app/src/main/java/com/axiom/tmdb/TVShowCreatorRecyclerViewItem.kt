package com.axiom.tmdb

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.axiomc.core.components.generic.Skeletons.loadSkelly
import com.axiomc.core.dslanguage.constraint.Definition.define
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.constraint.Params.params
import com.axiomc.core.dslanguage.constraint.Params.paramsWW
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.design.Text.text

class TVShowCreatorRecyclerViewItem(context: Context) : ConstraintLayout(context) {
    var name = TextView(context).applyId()
    var photo = ImageView(context).applyId()

    init {
        layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        this@TVShowCreatorRecyclerViewItem.applyId()
        name.layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToTop = this@TVShowCreatorRecyclerViewItem.id
            startToStart = this@TVShowCreatorRecyclerViewItem.id
            endToEnd = this@TVShowCreatorRecyclerViewItem.id
        }

        photo.layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
            topToBottom = name.id
            startToStart = this@TVShowCreatorRecyclerViewItem.id
            endToEnd = this@TVShowCreatorRecyclerViewItem.id
        }
        addView(name)
        addView(photo)
    }
}