package github.noargs.settingthelaunchmodeofanactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class ActivityA : AppCompatActivity() {

    private val TAG = "Activity A"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        Log.d(TAG, "onCreate")

        val buttonClickListener = View.OnClickListener { view ->

            when (view.id) {
                R.id.letter_a -> startActivity(Intent(this, ActivityA::class.java))
                R.id.letter_b -> startActivity(Intent(this, ActivityB::class.java))
                R.id.letter_c -> startActivity(Intent(this, ActivityC::class.java))
                else -> {
                    Toast.makeText(
                        this,
                        getString(R.string.unexpected_button_pressed),
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }
        }

        findViewById<View>(R.id.letter_a).setOnClickListener(buttonClickListener)
        findViewById<View>(R.id.letter_b).setOnClickListener(buttonClickListener)
        findViewById<View>(R.id.letter_c).setOnClickListener(buttonClickListener)
    }
}