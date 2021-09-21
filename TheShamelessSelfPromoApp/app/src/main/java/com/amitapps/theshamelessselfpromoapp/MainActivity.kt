package com.amitapps.theshamelessselfpromoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_preview_message.setOnClickListener {
            onPreviewClicked()
        }


        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")

        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner_job_title.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {


        val message = Message(
            edit_text_contact_name.text.toString(),
            edit_text_contact_number.text.toString(),
            edit_text_my_display_Name.text.toString(),
            spinner_job_title.selectedItem?.toString(),
            check_box_include_junior.isChecked,
            check_box_immediate_start.isChecked,
            edit_text_available_from_date.text.toString()
        )


        val previewIntentActivity: Intent = Intent(this, PreviewActivity::class.java)

        previewIntentActivity.putExtra("Message", message)

        startActivity(previewIntentActivity)
    }
}

