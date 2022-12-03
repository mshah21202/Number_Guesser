package com.example.numberguesser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var easyFlag = false;
    private var negativeFlag = false;
    private var randomInt:Int = if (easyFlag) (0..10).random() else if (negativeFlag) (-100..100).random() else (0..100).random()

    public fun generateNew() {
        randomInt = if (easyFlag) (0..10).random() else if (negativeFlag) (-100..100).random() else (0..100).random()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val guessBtn:Button = findViewById(R.id.button)
        val guessED:EditText = findViewById(R.id.editTextNumberSigned)
        val resultView:TextView = findViewById(R.id.textView2)
        guessBtn.setOnClickListener {
            var guessNumber = guessED.text.toString().toInt()
            if (guessNumber > randomInt) resultView.text = "Lower" else if (guessNumber < randomInt) resultView.text = "Higher" else {
                resultView.text = "Good guess!!!"
                var dialog = WinnerDialogFragment()
                dialog.show(supportFragmentManager, "Winner Dialog")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.easy_menu -> {
                easyFlag = !easyFlag
                if (negativeFlag) {
                    negativeFlag = !negativeFlag
                    Toast.makeText(this,"Negative mode deactivated", Toast.LENGTH_SHORT).show()
                }
                if (easyFlag) Toast.makeText(this, "Easy Mode activated", Toast.LENGTH_SHORT).show() else Toast.makeText(this, "Easy Mode deactivated", Toast.LENGTH_SHORT).show()
            }
            R.id.negative_menu -> {
                negativeFlag = !negativeFlag
                if (easyFlag) {
                    easyFlag = !easyFlag
                    Toast.makeText(this,"Easy mode deactivated", Toast.LENGTH_SHORT).show()
                }
                if (negativeFlag) Toast.makeText(this,"Negative mode activated", Toast.LENGTH_SHORT).show() else Toast.makeText(this,"Negative mode deactivated", Toast.LENGTH_SHORT).show()
            }
        }
        randomInt =if (easyFlag) (1..10).random() else if (negativeFlag) (-100..100).random() else (1..100).random()
        return true
    }
}