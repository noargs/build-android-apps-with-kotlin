package github.noargs.colors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_create_color)?.setOnClickListener {
            var redChannelText = findViewById<TextInputEditText>(R.id.te_red_channel)?.text.toString()
            var greenChannelText = findViewById<TextInputEditText>(R.id.te_green_channel)?.text.toString()
            var blueChannelText = findViewById<TextInputEditText>(R.id.te_blue_channel)?.text.toString()

            // Check that all fields are filled in and show error otherwise
            if (redChannelText.isEmpty() or greenChannelText.isEmpty() or blueChannelText.isEmpty()) {
                Toast.makeText(this, "All values are required", Toast.LENGTH_LONG).show()
            } else {
                // check that 2 hexadecimal character have been entered otherwise entered the same hexadecimal character again
                if (redChannelText.length == 1) redChannelText = redChannelText.plus(redChannelText)
                if (greenChannelText.length == 1) greenChannelText = greenChannelText.plus(greenChannelText)
                if (blueChannelText.length == 1) blueChannelText = blueChannelText.plus(blueChannelText)

                val colorDisplay = redChannelText.plus(greenChannelText).plus(blueChannelText)

                val colorAsInt: Int
                try {
                    colorAsInt = Color.parseColor("#".plus(colorDisplay))
                    Log.d(TAG, colorAsInt.toString())
                    findViewById<TextView>(R.id.tv_create_color_results)?.setBackgroundColor(colorAsInt)

                } catch (e: NumberFormatException){
                    Toast.makeText(this, "Please enter valid color hexadecimal", Toast.LENGTH_LONG).show()
                }

                Log.d(TAG, "code ran....")

            }
        }
    }

    companion object {
        private const val TAG = "myColor"
    }
}