package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.widget.addTextChangedListener as addTextChangedListener1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        slider.addOnChangeListener { slider, value, fromUser ->
            updateTextView() // Responds to when slider's value is changed
        }

        edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateTextView()
            }
        })
    }

    private fun updateTextView() {
        if (edit_text.text.isNotBlank()){
            text_view.visibility = View.VISIBLE
            text_view.text = getString(R.string.text_view).format(edit_text.text.toString().toFloat() * slider.value / 100)
        } else {
            text_view.visibility = View.INVISIBLE
        }

    }

}