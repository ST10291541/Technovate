package vcmsa.projects.chocui

import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar

class EventsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        // Set up the toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        // Set up the navigation drawer
        setupNavigationDrawer()

        // TODO: Add events-specific functionality here
    }
}
