package vcmsa.projects.chocui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val messages: MutableList<Message>,
    private val onOptionClicked: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_USER = 0
        const val TYPE_BOT_TEXT = 1
    }

    override fun getItemViewType(position: Int): Int {
        val msg = messages[position]
        return if (msg.isUser) {
            TYPE_USER
        } else {
            TYPE_BOT_TEXT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_USER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user_message, parent, false)
                UserViewHolder(view)
            }
            TYPE_BOT_TEXT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_bot_message, parent, false)
                BotViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]
        when (holder) {
            is UserViewHolder -> holder.bind(message)
            is BotViewHolder -> holder.bind(message)
        }
    }

    override fun getItemCount(): Int = messages.size

    // Your existing addMessage function
    fun addMessage(message: Message) {
        messages.add(message)
        notifyItemInserted(messages.size - 1)
    }

    // Existing UserViewHolder (no change)
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userText: TextView = itemView.findViewById(R.id.userMessage)
        fun bind(message: Message) {
            userText.text = message.text
        }
    }

    // Existing BotViewHolder (no change)
    inner class BotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val botText: TextView = itemView.findViewById(R.id.botMessage)
        private val optionContainer: GridLayout = itemView.findViewById(R.id.optionContainer)

        fun bind(message: Message) {
            botText.text = message.text
            optionContainer.removeAllViews()

            if (!message.options.isNullOrEmpty()) {
                optionContainer.visibility = View.VISIBLE
                optionContainer.columnCount = 3

                message.options.forEach { option ->
                    val button = Button(itemView.context).apply {
                        text = option
                        textSize = 14f
                        setTextColor(itemView.context.getColor(android.R.color.black))
                        setBackgroundColor(itemView.context.getColor(R.color.blue))
                        setOnClickListener { onOptionClicked(option) }
                        layoutParams = GridLayout.LayoutParams().apply {
                            width = 0
                            height = 120
                            columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                            setMargins(8, 8, 8, 8)
                        }
                        isAllCaps = false
                    }
                    optionContainer.addView(button)
                }
            } else {
                optionContainer.visibility = View.GONE
            }
        }
    }
}