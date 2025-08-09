package vcmsa.projects.chocui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class VolunteerActivity : BaseActivity() {

    private val pdfUrl = "https://drive.google.com/uc?export=download&id=1KSgPfQRS-rzEcaZWNLWgikhW1mu-S7hz"
    private val emailAddress = "CHOCvolunteer@choc.org.za"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer)

        // Set up the toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        // Setup navigation drawer
        setupNavigationDrawer()

        // Set up buttons
        val downloadBtn: MaterialButton = findViewById(R.id.downloadBtn)
        val emailBtn: MaterialButton = findViewById(R.id.emailBtn)

        downloadBtn.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl))
            startActivity(browserIntent)
        }

        emailBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$emailAddress")
                putExtra(Intent.EXTRA_SUBJECT, "CHOC Volunteer Registration Form")
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Hi\n\nPlease find my completed volunteer form attached.\n\nRegards,\n CHOC"
                )
            }
            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        findViewById<FloatingActionButton>(R.id.fabChat).setOnClickListener {
            startActivity(Intent(this, Chatbot::class.java))
        }
    }
}
