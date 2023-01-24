package github.noargs.intentintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // get the intent which started this activity
        intent?.let {
            // set the welcome message
            val fullName = it.getStringExtra(FULL_NAME_KEY)
            findViewById<TextView>(R.id.welcome_text).text = getString(R.string.welcome_text, fullName)
        }
    }
}