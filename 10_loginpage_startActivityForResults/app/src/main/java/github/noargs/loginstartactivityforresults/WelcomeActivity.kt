package github.noargs.loginstartactivityforresults

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


// only done for illustration, avoid using hardcoded credentials in app
const val USERNAME_CORRECT_VALUE = "ibn"
const val PASSWORD_CORRECT_VALUE = "password"
const val LOGIN_REQUEST_CODE = 1

class WelcomeActivity : AppCompatActivity() {

    private val TAG = "WelcomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        Log.d(TAG, "onCreate")

        // get the intent which started this activity
        intent.let { loginIntent ->

            val usernameForm = loginIntent?.getStringExtra(USERNAME_KEY) ?: ""
            val passwordForm = loginIntent?.getStringExtra(PASSWORD_KEY) ?: ""

            val loggedInCorrectly = hasEnteredCorrectCredentials(usernameForm.trim(), passwordForm.trim())

            if (loggedInCorrectly) {
                setResult(Activity.RESULT_OK, loginIntent)
            } else {
                setResult(Activity.RESULT_CANCELED)
            }

            finish()
        }
    }

    private fun hasEnteredCorrectCredentials(usernameForm: String, passwordForm: String): Boolean {
        return usernameForm.contentEquals(USERNAME_CORRECT_VALUE) && passwordForm.contentEquals(
            PASSWORD_CORRECT_VALUE)
    }
}