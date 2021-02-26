package com.example.test1.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.test1.data.model.News
import com.example.test1.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*


class RecyclerAdapter() :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var itemList  = listOf<News>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val item = itemView.inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(item)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.size

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageContainer = view.imageView
        private val nameContainer = view.nameText
        private val dateContainer = view.dateText
        private val idContainer = view.idText
        private val likeImage = view.favouritImage




        fun bind(news: News) {
            nameContainer.text = news.name
            dateContainer.text = news.date
            idContainer.text = news.id

            likeImage.setOnClickListener {
                news.isFavourite = true
                likeImage.setColorFilter(Color.RED)
            }

            Picasso.get()
                .load(news.image)
                .placeholder(R.drawable.loading)
                .error(R.drawable.loading)
                .into(imageContainer)
        }

    }

}




