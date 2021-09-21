package com.amitapps.theshamelessselfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {


    //lateinit can be intialized later;

    private lateinit var message: Message


    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        displayMessage()
        setUpButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message


        messagePreviewText = """
                Hi ${message.contactName},
                My name is ${message.myDisplayName} and I am a ${message.getFullJobDescription()}.
                I have a Portfolio of apps snd i will start ${message.getAvailabilty()}
                Please get in touch .
                Thanks and best regards.
            """.trimIndent()

        text_view_cardMessage.text = messagePreviewText
    }


    private fun setUpButton() {

        button_send_message.setOnClickListener {

            // Send Message intent;

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")
                putExtra("sms_body", messagePreviewText)
            }

            startActivity(intent)
        }

    }
}
