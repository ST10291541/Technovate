package vcmsa.projects.chocui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : BaseActivity() {

    private lateinit var btnChat: Button
    private lateinit var btnEvents: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout) // make sure the filename matches!

        // Set up the toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        // Find drawer layout
        drawerLayout = findViewById(R.id.drawer_layout)

        // Setup navigation drawer
        setupNavigationDrawer()

        // Initialize visible buttons
        btnChat = findViewById(R.id.btnChat)
        btnEvents = findViewById(R.id.eventsButton)

        // Set up click listeners
        btnChat.setOnClickListener {
            startActivity(Intent(this, Chatbot::class.java))
        }

        btnEvents.setOnClickListener {
            startActivity(Intent(this, EventsActivity::class.java))
        }


    }
}
