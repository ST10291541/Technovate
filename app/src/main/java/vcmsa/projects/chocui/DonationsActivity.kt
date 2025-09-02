package vcmsa.projects.chocui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DonationsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_donations)

        val MakeDonation = findViewById<Button>(R.id.btnMakeDonation)

        // Set up the toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        // Set up the navigation drawer
        setupNavigationDrawer()

        MakeDonation.setOnClickListener { v: View? ->
            val url = "https://www.walletdoc.com/pay/ChocDBN"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }

        findViewById<FloatingActionButton>(R.id.fabChat).setOnClickListener {
            startActivity(Intent(this, Chatbot::class.java))
        }

        // Copy Banking Details Button
        val btnCopyAllDetails = findViewById<Button>(R.id.btnCopyAllDetails)
        btnCopyAllDetails.setOnClickListener {
            // Get all banking details from TextViews
            val bankName = findViewById<TextView>(R.id.tvBankName).text.toString()
            val accountName = findViewById<TextView>(R.id.tvAccountName).text.toString()
            val accountNumber = findViewById<TextView>(R.id.tvAccountNumber).text.toString()
            val branchCode = findViewById<TextView>(R.id.tvBranchCode).text.toString()
            val reference = findViewById<TextView>(R.id.tvReference).text.toString()

            // Format the details for easy copying
            val bankingDetails = """
            Bank Name: $bankName
            Account Name: $accountName
            Account Number: $accountNumber
            Branch Code: $branchCode
            Reference: $reference
        """.trimIndent()

            // Copy to clipboard
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Banking Details", bankingDetails)
            clipboard.setPrimaryClip(clip)

            // Show confirmation message
            Toast.makeText(this, "Banking details copied to clipboard", Toast.LENGTH_SHORT).show()
        }
    }
}
