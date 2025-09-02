package vcmsa.projects.chocui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class VideosActivity : BaseActivity() {

    private val videoList = listOf(
        Video("Blood Disorders", "JrJ6UJOlg2g", "An overview of types of blood disorders related to childhood cancer"),
        Video("What is cancer", "ToJ7lioWayo", "What is cancer?"),
        Video("Types of Caner", "W73YT2vLz44", "Different types of cancers"),
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)


        val recyclerView = findViewById<RecyclerView>(R.id.videosRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = VideoAdapter(videoList)

        setupNavigationDrawer()
    }

    data class Video(val title: String, val videoId: String, val description: String)
}