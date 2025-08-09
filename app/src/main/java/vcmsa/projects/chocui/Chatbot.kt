package vcmsa.projects.chocui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Chatbot : AppCompatActivity() {
    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var messageInput: EditText
    private lateinit var chatAdapter: Adapter

    private val messages = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        messageInput = findViewById(R.id.messageInput)

        chatAdapter = Adapter(messages) { option ->
            addUserMessage(option)
            getBotResponse(option)
        }

        chatRecyclerView.layoutManager = LinearLayoutManager(this)
        chatRecyclerView.adapter = chatAdapter

        // Start conversation
        addBotMessage(
            "Hi there! What would you like to know?",
            listOf("What is Cancer?", "Types of Childhood Cancer", "Blood Disorders", "Early Warning Signs", "Contact CHOC", "Restart")
        )

        // Handle Enter key
        messageInput.setOnEditorActionListener { _, _, _ ->
            val inputText = messageInput.text.toString().trim()
            if (inputText.isNotEmpty()) {
                addUserMessage(inputText)
                getBotResponse(inputText)
                messageInput.text.clear()
            }
            true
        }
    }

    private fun addUserMessage(text: String) {
        messages.add(Message(text, true))
        chatAdapter.notifyItemInserted(messages.size - 1)
        scrollToBottom()
    }

    private fun addBotMessage(text: String, options: List<String>? = null) {
        messages.add(Message(text, false, options))
        chatAdapter.notifyItemInserted(messages.size - 1)
        scrollToBottom()
    }

    private fun scrollToBottom() {
        chatRecyclerView.scrollToPosition(messages.size - 1)
    }

    private fun getBotResponse(userInput: String) {
        Handler(Looper.getMainLooper()).postDelayed({
            when (userInput.lowercase()) {

                // --- Main Menu ---
                "main menu" -> addBotMessage(
                    "What would you like to know?",
                    listOf("What is Cancer?", "Types of Childhood Cancer", "Blood Disorders", "Early Warning Signs", "Contact CHOC", "Restart")
                )

                "early warning signs" -> addBotMessage(
                    "What are these early warning signs of childhood cancer?\n" +
                            "\n" +
                            "S — SEEK\n" +
                            "Medical help early for persistent symptoms.\n" +
                            "\n" +
                            "I — EYE\n" +
                            "White spot in the eye, new squint, new blindness, bulging eyeball.\n" +
                            "\n" +
                            "L — LUMP\n" +
                            "Abdomen and pelvis, head and neck, limbs, testes and glands.\n" +
                            "\n" +
                            "U — UNEXPLAINED\n" +
                            "Prolonged fever over two weeks, loss of weight, pallor, fatigue, easy bruising or bleeding.\n" +
                            "\n" +
                            "A — ACHING\n" +
                            "Bones, joints, back and easy fractures.\n" +
                            "\n" +
                            "N — NEUROLOGICAL SIGNS\n" +
                            "Change or deterioration in walk, balance or speech, regression of milestones, headache for more than a week with or without vomiting, enlarging head.",
                    listOf("How is childhood cancer different?", "Types of Childhood Cancer", "Blood Disorders", "Main Menu")
                )

                "what is cancer?" -> addBotMessage(
                    "Cancer is a disease of the body’s cells. Normally, cells grow in a controlled way. Cancer starts when some cells grow out of control, stop working properly, and may form lumps or tumors. If untreated, they can spread and take over normal cells.",
                    listOf("How is childhood cancer different?", "Types of Childhood Cancer", "Blood Disorders", "Main Menu")
                )

                "how is childhood cancer different?" -> addBotMessage(
                    "Childhood cancers are usually found in organs, look different under a microscope, and often respond better to treatment than adult cancers. Cure rates are generally higher in children.",
                    listOf("Types of Childhood Cancer", "Blood Disorders", "Main Menu")
                )

                "types of childhood cancer" -> addBotMessage(
                    "The most common types are:\n1. Leukemia (~34%)\n2. Brain Tumors (~22%)\n3. Lymphoma (~11%)\n4. Wilms Tumor (~14%)\n5. Soft Tissue Sarcomas.\nWhich would you like to learn about?",
                    listOf("Leukemia", "Brain Tumor", "Lymphoma", "Wilms Tumor", "Soft Tissue Sarcoma", "Main Menu")
                )

                // --- Cancer Types ---
                "leukemia" -> addBotMessage(
                    "Leukemia is blood cancer starting in bone marrow. Abnormal white blood cells crowd out healthy cells.\nSymptoms: infections, easy bruising, bleeding, tiredness, bone pain.\nTreatment: 6–9 months of intensive chemo, then 2–3 years maintenance.",
                    listOf("Brain Tumor", "Lymphoma", "Wilms Tumor", "Soft Tissue Sarcoma", "Main Menu")
                )

                "brain tumor" -> addBotMessage(
                    "Brain tumors are abnormal cell growths in the brain/spinal cord. Symptoms: morning headaches, vomiting, drowsiness, appetite loss, muscle weakness, vision/swallowing problems.\nTreatment: surgery, chemo, and radiotherapy.",
                    listOf("Leukemia", "Lymphoma", "Wilms Tumor", "Soft Tissue Sarcoma", "Main Menu")
                )

                "lymphoma" -> addBotMessage(
                    "Lymphoma affects the lymphatic system. Symptoms: swollen neck glands, chest tumors causing cough/breathlessness, abdominal swelling, fever, weight loss, night sweats.\nTreatment: chemo (6 months–2 years) and sometimes radiotherapy.",
                    listOf("Leukemia", "Brain Tumor", "Wilms Tumor", "Soft Tissue Sarcoma", "Main Menu")
                )

                "wilms tumor" -> addBotMessage(
                    "Wilms Tumor is kidney cancer in children under 5. Stages 1–5 range from confined to kidney to both kidneys affected.\nSymptoms: swollen firm tummy, pain, fever, blood in urine.\nTreatment: chemo before/after surgery, sometimes radiotherapy.",
                    listOf("Leukemia", "Brain Tumor", "Lymphoma", "Soft Tissue Sarcoma", "Main Menu")
                )

                "soft tissue sarcoma" -> addBotMessage(
                    "Soft tissue sarcomas (like Rhabdomyosarcoma) grow in muscles or connective tissue.\nSymptoms depend on location: eye bulging, blocked nose, facial paralysis, lumps, chest pain, etc.\nTreatment: chemo, surgery/radiotherapy, sometimes bone marrow transplant.",
                    listOf("Leukemia", "Brain Tumor", "Lymphoma", "Wilms Tumor", "Main Menu")
                )

                // --- Blood Disorders ---
                "blood disorders" -> addBotMessage(
                    "Blood disorders affect how blood cells are made in bone marrow.\nExamples: anaemia, low platelets, low white blood cells.\nWhich would you like to know about?",
                    listOf("Anaemia", "Low Platelets", "Low White Cells", "Main Menu")
                )

                "anaemia" -> addBotMessage(
                    "Anaemia = low red blood cells.\nSymptoms: weakness, tiredness, breathlessness, pale skin.\nCauses: leukemia, bone marrow failure, iron deficiency, red cell destruction, chronic blood loss.",
                    listOf("Low Platelets", "Low White Cells", "Main Menu")
                )

                "low platelets" -> addBotMessage(
                    "Low platelets cause easy bruising, nose/gum bleeding, or internal bleeding (esp. brain).",
                    listOf("Anaemia", "Low White Cells", "Main Menu")
                )

                "low white cells" -> addBotMessage(
                    "Low white blood cells cause frequent infections and unexplained fevers.",
                    listOf("Anaemia", "Low Platelets", "Main Menu")
                )

                // --- Contact Info ---
                "contact choc" -> addBotMessage(
                    "📞 031 240 2917\n✉️ dbn@choc.org.za\n🏥 Inkosi Albert Luthuli Central Hospital, Durban\n💳 Standard Bank Killarney – Acc No: 241 319 978, Branch: 007205\nFacebook: CHOC Childhood Cancer Foundation",
                    listOf("Main Menu")
                )

                // --- Restart ---
                "restart" -> {
                    messages.clear()
                    chatAdapter.notifyDataSetChanged()
                    addBotMessage(
                        "Restarted. What would you like to do?",
                        listOf("What is Cancer?", "Types of Childhood Cancer", "Blood Disorders", "Contact CHOC", "Restart")
                    )
                }

                // --- Fallback ---
                else -> addBotMessage(
                    "I'm sorry, I didn't understand that. Try one of these:",
                    listOf("What is Cancer?", "Types of Childhood Cancer", "Blood Disorders", "Contact CHOC", "Main Menu", "Restart")
                )
            }
        }, 800)
    }
}
