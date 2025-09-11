package vcmsa.projects.chocui

import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.Toast
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader

class RemembranceWallActivity : BaseActivity() {

    private lateinit var remembranceGrid: GridLayout
    private val namesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remembrance_wall)

        remembranceGrid = findViewById(R.id.remembranceGrid)

        // Load names from JSON
        loadNamesFromJson()

        // Display stars
        displayStars()
    }

    private fun loadNamesFromJson() {
        try {
            val inputStream = assets.open("names.json")
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val jsonString = bufferedReader.use { it.readText() }

            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                namesList.add(jsonArray.getString(i))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun displayStars() {
        remembranceGrid.removeAllViews()

        for (name in namesList) {
            val star = ImageView(this)
            star.setImageResource(android.R.drawable.btn_star_big_on)
            star.adjustViewBounds = true
            star.layoutParams = GridLayout.LayoutParams().apply {
                width = 140
                height = 140
            }

            // Show name when clicked
            star.setOnClickListener {
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
            }

            remembranceGrid.addView(star)
        }
    }
}

