package com.thisaay.youtuber.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.FrameLayout
import androidx.core.graphics.alpha
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thisaay.youtuber.R
import com.thisaay.youtuber.YoutuberApplication
import com.thisaay.youtuber.data.model.Video
import com.thisaay.youtuber.di.component.ApplicationComponent
import com.thisaay.youtuber.di.component.DaggerActivityComponent
import com.thisaay.youtuber.di.component.DaggerApplicationComponent
import com.thisaay.youtuber.di.module.ActivityModule
import com.thisaay.youtuber.di.module.ApplicationModule
import com.thisaay.youtuber.utils.common.Resource
import com.thisaay.youtuber.utils.common.Status
import com.thisaay.youtuber.utils.common.YoutubeHelper
import com.thisaay.youtuber.utils.log.Logger
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var res: Resource<String>

    lateinit var videos: MutableList<Video>
    lateinit var recyclerView: RecyclerView
    lateinit var videosAdapter: VideosAdapter


    private var hasNext = true

    private var loading = true
    private var pastVisiblesItems: Int = 0
    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.videos.observe(this, Observer {
            if (it.status == Status.SUCCESS) {
                val nv = it.data
                val start = videos.size

                videos.addAll(nv)
                videosAdapter.notifyItemRangeChanged(start, nv.size)
                loading = true
                Logger.d(TAG, "Updating list ${videos.size}")
                stopBottomLoading()
            }
        })
        viewModel.getVideos()
        setupRecyclerView()


    }

    private fun injectDependencies() {
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as YoutuberApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }

    private fun startBottomLoading() {
        val view = findViewById<FrameLayout>(R.id.loadingView)
        view.visibility = View.VISIBLE
        view.animate()
            .setDuration(500)
            .alpha(1f)
            .start()

    }

    private fun stopBottomLoading() {
        val view = findViewById<FrameLayout>(R.id.loadingView)
        view.visibility = View.VISIBLE
        view.animate()
            .setDuration(500)
            .alpha(0f)
            .start()


    }

    private fun onClick(pos: Int, item: Video) {
        YoutubeHelper.openYoutubeVideo(this,item.id)
    }

    private fun setupRecyclerView() {

        recyclerView = findViewById(R.id.list)
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(this)

        videos = mutableListOf()
        videosAdapter = VideosAdapter(this, videos)
        recyclerView.adapter = videosAdapter

        videosAdapter.onClick = { pos, item ->
            onClick(pos, item)
        }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!hasNext)
                    return
                if (dy > 0)
                //check for scroll down
                {
                    if (recyclerView.layoutManager == null)
                        return
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    visibleItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    pastVisiblesItems = layoutManager.findFirstVisibleItemPosition()

                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false
                            Logger.v("TAG", "Last Item Wow !")
                            hasNext = viewModel.getNextVideos()
                            if (!hasNext)
                                stopBottomLoading()
                            else
                                startBottomLoading()
                        }
                    }
                }
            }
        })

    }
}
