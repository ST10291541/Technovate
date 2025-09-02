package vcmsa.projects.chocui

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.random.Random

class RemembranceWallActivity : BaseActivity() {

    private lateinit var names: List<String>
    private lateinit var starContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remembrance_wall)

        starContainer = findViewById(R.id.starContainer)

        // Load names from JSON file
        names = loadNamesFromJson()

        // Wait until layout is drawn so we know width/height
        starContainer.post {
            addStars()
        }

        setupNavigationDrawer()
    }

    private fun addStars() {
        val containerWidth = starContainer.width
        val containerHeight = starContainer.height

        names.forEach { name ->
            val star = ImageView(this).apply {
                setImageResource(android.R.drawable.btn_star_big_on) // Star icon
                layoutParams = FrameLayout.LayoutParams(80, 80) // Size of star

                // Random position
                x = Random.nextInt(containerWidth - 100).toFloat()
                y = Random.nextInt(containerHeight - 100).toFloat()

                setOnClickListener {
                    AlertDialog.Builder(this@RemembranceWallActivity)
                        .setTitle("Remembrance")
                        .setMessage(name)
                        .setPositiveButton("Close", null)
                        .show()
                }
            }

            starContainer.addView(star)
        }
    }

    private fun loadNamesFromJson(): List<String> {
        val inputStream = assets.open("remembrance.json")
        val reader = BufferedReader(InputStreamReader(inputStream))
        val jsonString = reader.readText()
        reader.close()

        val jsonObject = JSONObject(jsonString)
        val jsonArray = jsonObject.getJSONArray("names")

        val nameList = mutableListOf<String>()
        for (i in 0 until jsonArray.length()) {
            nameList.add(jsonArray.getString(i))
        }
        return nameList
    }
}

