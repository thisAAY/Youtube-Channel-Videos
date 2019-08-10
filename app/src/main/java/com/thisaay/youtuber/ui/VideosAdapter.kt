package com.thisaay.youtuber.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thisaay.youtuber.R
import com.thisaay.youtuber.data.model.Video
import kotlinx.android.synthetic.main.video_view_layout.view.*
import java.util.zip.Inflater

class VideosAdapter(val context: Context, val videos: List<Video>) :
    RecyclerView.Adapter<VideosAdapter.ViewHolder>() {

    lateinit var onClick: ((pos: Int, item: Video) -> Unit)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.thumbnail)
        val titleView: TextView = itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.video_view_layout, parent, false))
            .apply {
                    itemView.setOnClickListener { onClick(adapterPosition, videos[adapterPosition]) }
            }
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videos[position]
        val imageView = holder.imageView
        val titleView = holder.titleView

        Glide.with(context)
            .load(video.thumbnailUrl)
            .thumbnail(.1f)
            .into(imageView)
        titleView.text = video.title
    }
}