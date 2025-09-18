package vcmsa.projects.chocui

import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import org.json.JSONArray
import java.nio.charset.Charset

class RemembranceWallActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remembrance_wall)

        val gridLayout = findViewById<GridLayout>(R.id.remembranceGrid)

        // Load names from JSON
        val names = loadNamesFromJson()

        // Create a heart for each name
        for (name in names) {
            val heartView = AppCompatTextView(this).apply {
                text = "💙"
                textSize = 32f
                setTextColor(resources.getColor(android.R.color.holo_blue_light, theme))
                setPadding(24, 24, 24, 24)

                setOnClickListener {
                    Toast.makeText(this@RemembranceWallActivity, name, Toast.LENGTH_SHORT).show()
                }
            }
            gridLayout.addView(heartView)
        }
    }

    private fun loadNamesFromJson(): List<String> {
        val inputStream = assets.open("names.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charset.forName("UTF-8"))

        val jsonArray = JSONArray(json)
        val names = mutableListOf<String>()
        for (i in 0 until jsonArray.length()) {
            names.add(jsonArray.getString(i))
        }
        return names
    }
}


