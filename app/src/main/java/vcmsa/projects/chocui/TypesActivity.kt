package vcmsa.projects.chocui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TypesActivity : AppCompatActivity() {

    private lateinit var btnLeukemia: Button
    private lateinit var btnBrain: Button
    private lateinit var btnLymphomas: Button
    private lateinit var btnWilms: Button
    private lateinit var btnSarcoma: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_types)

        btnLeukemia = findViewById(R.id.btnLeukemia)
        btnBrain = findViewById(R.id.btnBrain)
        btnLymphomas = findViewById(R.id.btnLymphomas)
        btnWilms = findViewById(R.id.btnWilms)
        btnSarcoma = findViewById(R.id.btnSarcoma)
        btnBack = findViewById(R.id.btnBack)

        // add actvity screens for buttons
        btnLeukemia.setOnClickListener {
            startActivity(Intent(this, LeukemiaActivity::class.java))
        }

        btnBrain.setOnClickListener {
            startActivity(Intent(this, BrainActivity::class.java))
        }

        btnLymphomas.setOnClickListener {
            startActivity(Intent(this, LymphomaActivity::class.java))
        }

        btnWilms.setOnClickListener {
            startActivity(Intent(this, WilmsActivity::class.java))
        }

        btnSarcoma.setOnClickListener {
            startActivity(Intent(this, SarcomaActivity::class.java))
        }

        btnBack.setOnClickListener {
            startActivity(Intent(this, InformationActivity::class.java))
        }
    }
}