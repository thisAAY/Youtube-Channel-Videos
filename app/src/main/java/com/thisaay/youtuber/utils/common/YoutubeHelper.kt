package com.thisaay.youtuber.utils.common

import androidx.core.content.ContextCompat.startActivity
import android.content.ActivityNotFoundException
import android.R.id
import android.content.Context
import android.content.Intent
import android.net.Uri


object YoutubeHelper {
    fun openYoutubeVideo(context: Context,id : String?){
        if(id == null)
            return
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com/watch?v=$id")
        )
        try {
            context.startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            context.startActivity(webIntent)
        }

    }
}