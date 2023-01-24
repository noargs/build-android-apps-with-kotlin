package github.noargs.settingthelaunchmodeofanactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class ActivityOne : AppCompatActivity() {

    private val TAG = "Activity 1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        Log.d(TAG, "onCreate")

        val buttonClickListener = View.OnClickListener {view ->

            when (view.id) {
                R.id.number_1 -> startActivity(Intent(this, ActivityOne::class.java))
                R.id.number_2 -> startActivity(Intent(this, ActivityTwo::class.java))
                R.id.number_3 -> startActivity(Intent(this, ActivityThree::class.java))
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

        findViewById<View>(R.id.number_1).setOnClickListener(buttonClickListener)
        findViewById<View>(R.id.number_2).setOnClickListener(buttonClickListener)
        findViewById<View>(R.id.number_3).setOnClickListener(buttonClickListener)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent")
    }
}