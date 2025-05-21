package vcmsa.projects.chocui

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class InformationActivity : AppCompatActivity() {

    private lateinit var btnCancer: Button
    private lateinit var btnBlood: Button
    private lateinit var btnTypes: Button
    private lateinit var btnEWS: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_information)


        btnCancer = findViewById(R.id.btnCancer)
        btnBlood = findViewById(R.id.btnBlood)
        btnTypes = findViewById(R.id.btnTypes)
        btnEWS = findViewById(R.id.btnEWS)

        // add actvity screens for buttons
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