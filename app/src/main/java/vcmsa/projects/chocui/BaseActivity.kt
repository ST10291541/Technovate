package vcmsa.projects.chocui

import android.content.Intent
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    protected lateinit var drawerLayout: DrawerLayout
    protected lateinit var toggle: ActionBarDrawerToggle

    protected fun setupNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            findViewById(R.id.topAppBar),
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val context = this

        // Helper function to start activity only if we're not already on it
        fun <T : BaseActivity> startActivityIfNotCurrent(activityClass: Class<T>) {
            if (context::class.java != activityClass) {
                startActivity(Intent(context, activityClass))
                finish()
            }
        }

        when (item.itemId) {
            R.id.nav_home -> startActivityIfNotCurrent(MainActivity::class.java)
            R.id.nav_about -> startActivityIfNotCurrent(AboutUsActivity::class.java)
            R.id.nav_contacts -> startActivityIfNotCurrent(ContactsActivity::class.java)
            R.id.nav_donate -> startActivityIfNotCurrent(DonationsActivity::class.java)
            R.id.nav_events -> startActivityIfNotCurrent(EventsActivity::class.java)
            R.id.nav_remembrance -> startActivityIfNotCurrent(RemembranceActivity::class.java)
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
