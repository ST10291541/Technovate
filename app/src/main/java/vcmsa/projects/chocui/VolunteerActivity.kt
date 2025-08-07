package vcmsa.projects.chocui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import vcmsa.projects.chocui.R

class VolunteerActivity : AppCompatActivity() {

    private val pdfUrl = "https://drive.google.com/uc?export=download&id=1KSgPfQRS-rzEcaZWNLWgikhW1mu-S7hz"

    private val emailAddress = "CHOCvolunteer@choc.org.za"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer)

        val downloadBtn: Button = findViewById(R.id.downloadBtn)
        val emailBtn: Button = findViewById(R.id.emailBtn)

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
    }
}
