package com.axiom.tmdb.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.axiom.tmdb.TMDB
import com.axiom.tmdb.views.TVShowCreatorRecyclerViewItem

class TVShowCreatorAdapter(var creators:List<TMDB.Creator>) : RecyclerView.Adapter<TVShowCreatorAdapter.TVShowCreatorViewHolder>(){


        class TVShowCreatorViewHolder(val view: TVShowCreatorRecyclerViewItem): RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowCreatorViewHolder {
            return TVShowCreatorViewHolder(TVShowCreatorRecyclerViewItem(parent.context))

        }


        override fun getItemCount(): Int {
            return creators.size
        }

        override fun onBindViewHolder(holder: TVShowCreatorViewHolder, position: Int) {
            holder.view.name.text=creators[position].name
            println(holder.view.name.text)
            holder.view.photo.load("https://image.tmdb.org/t/p/w185" + creators[position].profile_path)
        }

}