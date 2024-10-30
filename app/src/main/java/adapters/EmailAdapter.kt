package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maillist.R
import models.Email

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(emails[position])
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val senderTextView: TextView = itemView.findViewById(R.id.sender)
        private val subjectTextView: TextView = itemView.findViewById(R.id.subject)
        private val messageTextView: TextView = itemView.findViewById(R.id.message)

        fun bind(email: Email) {
            senderTextView.text = email.sender
            subjectTextView.text = email.subject
            messageTextView.text = email.message
        }
    }
}