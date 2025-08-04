package vcmsa.projects.chocui

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import com.google.android.material.appbar.MaterialToolbar

class InformationActivity : BaseActivity() {

    private lateinit var btnCancer: Button
    private lateinit var btnBlood: Button
    private lateinit var btnTypes: Button
    private lateinit var btnEWS: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_information)

        // Set up the toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        // Set up the navigation drawer
        setupNavigationDrawer()

        // Initialize buttons
        btnCancer = findViewById(R.id.btnCancer)
        btnBlood = findViewById(R.id.btnBlood)
        btnTypes = findViewById(R.id.btnTypes)
        btnEWS = findViewById(R.id.btnEWS)

        // Set up button click listeners
        btnCancer.setOnClickListener {
            startActivity(Intent(this, CancerActivity::class.java))
        }

        btnBlood.setOnClickListener {
            startActivity(Intent(this, BloodActivity::class.java))
        }

        btnTypes.setOnClickListener {
            startActivity(Intent(this, TypesActivity::class.java))
        }

        btnEWS.setOnClickListener {
            startActivity(Intent(this, EWSActivity::class.java))
        }
    }
}
