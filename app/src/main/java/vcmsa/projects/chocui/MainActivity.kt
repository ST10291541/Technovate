package vcmsa.projects.chocui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

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

        btnAbout = findViewById(R.id.aboutButton)
        btnDonate = findViewById(R.id.donationButton)
        btnVolunteer = findViewById(R.id.volunteerButton)
        btnInfo = findViewById(R.id.infoButton)
        btnEvents = findViewById(R.id.eventsButton)
        btnContact = findViewById(R.id.contactButton)

        // add actvity screens for buttons
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
    }
}
