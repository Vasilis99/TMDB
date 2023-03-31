package com.axiom.tmdb.views.shimmer//package com.axiom.tmdb.views
//
//import android.content.Context
import android.content.Context
import android.graphics.Color
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axiom.tmdb.MyItemDecoration
import com.axiomc.core.dslanguage.constraint.Helpers.applyId
import com.axiomc.core.dslanguage.conversion.Space.dp
import com.axiomc.core.dslanguage.conversion.Space.rp
import com.axiomc.core.dslanguage.conversion.Space.sp
import com.axiomc.core.dslanguage.design.Recycler.lazyAdd
import com.axiomc.core.dslanguage.design.Recycler.vLinear
import com.axiomc.core.dslanguage.design.Text.bold
import com.axiomc.core.dslanguage.design.Text.size
import com.axiomc.core.dslanguage.design.color.Theme.color
import com.facebook.shimmer.ShimmerFrameLayout

class RecyclerViewShimmer(context: Context) : ShimmerFrameLayout(context) {

    var recyclerViewShimmer = RecyclerView(context).applyId()

    private fun createItem(): ConstraintLayout {
        var image = ImageView(context).applyId()
        var conLayBig = ConstraintLayout(context).applyId().apply {
            setBackgroundColor(Color.GRAY)
        }
        var secConLay=ConstraintLayout(context).applyId().apply {
            setBackgroundColor(Color.GRAY)
        }
        var title = TextView(context).applyId().color(Color.BLACK).bold().size(14)
        var favorite = TextView(context).applyId()
        conLayBig.layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
        secConLay.layoutParams= ConstraintLayout.LayoutParams(0, WRAP_CONTENT).apply {
            topToTop = conLayBig.id
            bottomToBottom = conLayBig.id
            startToEnd = image.id
            endToEnd=conLayBig.id
            setMargins(10, 10, 10, 10)
        }
        image.apply {
            setBackgroundColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                topToTop = conLayBig.id
                bottomToBottom = conLayBig.id
                startToStart = conLayBig.id
                minimumHeight = 528
                minimumWidth = 342
            }
        }

        conLayBig.addView(image)

        title.apply {
            setBackgroundColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(0, WRAP_CONTENT).apply {
                topToTop = secConLay.id
                startToStart = secConLay.id
                endToStart = favorite.id
                setMargins(0,0,10,0)
            }
        }
        secConLay.addView(title)
        var votesRating = TextView(context).applyId().apply {
            setBackgroundColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(200, WRAP_CONTENT).apply {
                topToBottom = title.id
                startToEnd = image.id
                setMargins(0, 10, 0, 0)
            }
        }
        secConLay.addView(votesRating)
        var temp = TextView(context)
        for (i in 0..4) {
            var text = TextView(context).applyId().apply {
                setBackgroundColor(Color.BLACK)
            }
            text.layoutParams = ConstraintLayout.LayoutParams(0, WRAP_CONTENT).apply {
                topToBottom = if (i == 0){
                    votesRating.id}
                else{
                    temp.id
                }
                startToStart = secConLay.id
                endToEnd=secConLay.id
                setMargins(0,10,0,0)
            }
            secConLay.addView(text)
            temp = text
        }

        favorite.apply {
            setBackgroundColor(Color.BLACK)
            layoutParams = ConstraintLayout.LayoutParams(sp(24), sp(24)).apply {
                endToEnd = secConLay.id
            }
        }
        secConLay.addView(favorite)
        conLayBig.addView(secConLay)
        return conLayBig
    }


    init {

        var listConLay = mutableListOf<ConstraintLayout>()
        for (i in 0..9) {
            listConLay.add(createItem())
        }

        recyclerViewShimmer.addItemDecoration(MyItemDecoration(20,20,20))

        recyclerViewShimmer.layoutManager=object : LinearLayoutManager(context) { override fun canScrollVertically() = false }
         recyclerViewShimmer.lazyAdd {
            for (i in 0..9) {
                add(listConLay[i])
            }
        }

        addView(recyclerViewShimmer)


    }
}