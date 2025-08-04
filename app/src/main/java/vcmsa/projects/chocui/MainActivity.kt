package vcmsa.projects.chocui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : BaseActivity() {

    private lateinit var btnAbout: Button
    private lateinit var btnDonate: Button
    private lateinit var btnVolunteer: Button
    private lateinit var btnInfo: Button
    private lateinit var btnEvents: Button
    private lateinit var btnContact: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Set up the toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        // Set up the navigation drawer
        setupNavigationDrawer()

        // Initialize buttons
        btnAbout = findViewById(R.id.aboutButton)
        btnDonate = findViewById(R.id.donationButton)
        btnVolunteer = findViewById(R.id.volunteerButton)
        btnInfo = findViewById(R.id.infoButton)
        btnEvents = findViewById(R.id.eventsButton)
        btnContact = findViewById(R.id.contactButton)

        // Set up button click listeners
        btnAbout.setOnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java))
        }

        btnDonate.setOnClickListener {
            startActivity(Intent(this, DonationsActivity::class.java))
        }

        btnVolunteer.setOnClickListener {
            startActivity(Intent(this, VolunteerActivity::class.java))
        }

        btnInfo.setOnClickListener {
            startActivity(Intent(this, InformationActivity::class.java))
        }

        btnEvents.setOnClickListener {
            startActivity(Intent(this, EventsActivity::class.java))
        }

        btnContact.setOnClickListener {
            startActivity(Intent(this, ContactsActivity::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
