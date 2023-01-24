package github.noargs.loginpagesingletop

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

const val USERNAME_KEY = "USERNAME_KEY"
const val PASSWORD_KEY = "PASSWORD_KEY"

const val IS_LOGGED_IN = "IS_LOGGED_IN"
const val LOGGED_IN_USERNAME = "LOGGED_IN_USERNAME"

// this is done for simplicity and username/password credentials should never be stored in the app
const val USERNAME_CORRECT_VALUE = "Ibn"
const val PASSWORD_CORRECT_VALUE = "password"

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private var isLoggedIn = false
    private var loggedInUser = ""

    private val submitButton: Button
        get() = findViewById(R.id.submit_button)

    private val username: EditText
        get() = findViewById(R.id.username)

    private val password: EditText
        get() = findViewById(R.id.password)

    private val header: TextView
        get() = findViewById(R.id.header)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")

        submitButton.setOnClickListener {

            val usernameForm = username.text.toString().trim()
            val passwordForm = password.text.toString().trim()

            hideKeyboard()

            if (usernameForm.isNotEmpty() && passwordForm.isNotEmpty()) {

                // set the name of the activity to launch
                Intent(this, MainActivity::class.java).also { loginIntent ->

                    // Add the data
                    loginIntent.putExtra(USERNAME_KEY, usernameForm)
                    loginIntent.putExtra(PASSWORD_KEY, passwordForm)

                    // launch
                    startActivity(loginIntent)
                }
            } else {
                val toast = Toast.makeText(this, getString(R.string.login_form_entry_error), Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
        }
    }

    override fun onNewIntent(newIntent: Intent?) {
        super.onNewIntent(newIntent)

        Log.d(TAG, "onNewIntent")

        // set the new Intent to the one about to process
        // setIntent(intent) to set the intent to process
        intent = newIntent

        // get the intent which started this activity
        intent?.let { loginIntent ->

            val usernameForm = loginIntent.getStringExtra(USERNAME_KEY) ?: ""
            val passwordForm = loginIntent.getStringExtra(PASSWORD_KEY) ?: ""

            val loggedInCorrectly = hasEnteredCorrectCredentials(usernameForm.trim(), passwordForm.trim())

            if (loggedInCorrectly) {
                setLoggedIn(usernameForm)
                isLoggedIn = true
            } else {
                val toast = Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d(TAG, "onSaveInstanceState")

        outState.putBoolean(IS_LOGGED_IN, isLoggedIn)
        outState.putString(LOGGED_IN_USERNAME, loggedInUser)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.d(TAG, "onRestoreInstanceState")

        isLoggedIn = savedInstanceState.getBoolean(IS_LOGGED_IN, false)
        loggedInUser = savedInstanceState.getString(LOGGED_IN_USERNAME, "")

        if (isLoggedIn && loggedInUser.isNotEmpty()) {
            setLoggedIn(loggedInUser)
        }
    }


    private fun hasEnteredCorrectCredentials(usernameForm: String, passwordForm: String): Boolean {
        return usernameForm.contentEquals(USERNAME_CORRECT_VALUE) && passwordForm.contentEquals(
            PASSWORD_CORRECT_VALUE)
    }


    private fun setLoggedIn(loggedInUsername: String) {
        loggedInUser = loggedInUsername
        val welcomeMessage = getString(R.string.welcome_text, loggedInUsername)
        username.isVisible = false
        password.isVisible = false
        submitButton.isVisible = false
        header.text = welcomeMessage
    }


    private fun hideKeyboard() {
        if(currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

            Log.d(TAG, "hideKeyboard")
        }
    }
}