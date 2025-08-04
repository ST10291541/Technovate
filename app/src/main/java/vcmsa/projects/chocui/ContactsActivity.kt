package vcmsa.projects.chocui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton

class ContactsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        // Set up the toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        // Set up the navigation drawer
        setupNavigationDrawer()

        // Setup phone button
        findViewById<MaterialButton>(R.id.phoneButton).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:0312402917")
            }
            startActivity(intent)
        }

        // Setup email button
        findViewById<MaterialButton>(R.id.emailButton).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:dbn@choc.org.za")
            }
            startActivity(intent)
        }

        // Setup Facebook button
        findViewById<MaterialButton>(R.id.facebookButton).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(getString(R.string.facebook_link))
            }
            startActivity(intent)
        }
    }
}
