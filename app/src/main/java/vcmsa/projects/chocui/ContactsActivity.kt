package vcmsa.projects.chocui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ContactsActivity : BaseActivity() {

    private lateinit var mapDbn: MapView
    private lateinit var mapPmb: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        // Set up the toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        // Setup navigation drawer
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

        // maps for durban and pmb
        mapDbn = findViewById(R.id.mapDbn)
        mapPmb = findViewById(R.id.mapPmb)

        // Must call onCreate() for each MapView
        mapDbn.onCreate(savedInstanceState)
        mapPmb.onCreate(savedInstanceState)

        mapDbn.getMapAsync { googleMap ->
            val durban = LatLng(-29.8579, 31.0292) // Durban co-ordinates
            googleMap.addMarker(MarkerOptions().position(durban).title("Durban Office"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(durban, 14f))
        }

        mapPmb.getMapAsync { googleMap ->
            val pmb = LatLng(-29.6104, 30.3794) // Pietermaritzburg co-ordinates
            googleMap.addMarker(MarkerOptions().position(pmb).title("PMB Office"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pmb, 14f))
        }

        // Setup social media buttons
        findViewById<MaterialButton>(R.id.facebookButton).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.facebook.com/CHOC.Childhood.Cancer.Foundation/")
            }
            startActivity(intent)
        }

        findViewById<FloatingActionButton>(R.id.fabChat).setOnClickListener {
            startActivity(Intent(this, Chatbot::class.java))
        }
    }

    // Pass lifecycle events to both MapViews
    override fun onResume() {
        super.onResume()
        mapDbn.onResume()
        mapPmb.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapDbn.onPause()
        mapPmb.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapDbn.onDestroy()
        mapPmb.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapDbn.onLowMemory()
        mapPmb.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapDbn.onSaveInstanceState(outState)
        mapPmb.onSaveInstanceState(outState)
    }
}
