package vcmsa.projects.chocui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.google.android.material.appbar.MaterialToolbar

class AboutUsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about_us)


        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)


        setupNavigationDrawer()
    }
}
