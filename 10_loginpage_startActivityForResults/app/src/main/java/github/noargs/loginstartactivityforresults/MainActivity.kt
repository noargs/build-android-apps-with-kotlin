package github.noargs.loginstartactivityforresults

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")

        submitButton.setOnClickListener {

            val usernameForm = username.text.toString().trim()
            val passwordForm = password.text.toString().trim()

            hideKeyboard()

            if (usernameForm.isNotEmpty() && passwordForm.isNotEmpty()) {
                Intent(this, WelcomeActivity::class.java)
                    .also { welcomeIntent ->

                        welcomeIntent.putExtra(USERNAME_KEY, usernameForm)
                        welcomeIntent.putExtra(PASSWORD_KEY, passwordForm)

                        this.username.text.clear()
                        this.password.text.clear()

                        // Launch
                        startActivityForResult(welcomeIntent, LOGIN_REQUEST_CODE)

                    }
            } else {
                val toast = Toast.makeText(
                    this,
                    getString(R.string.login_form_entry_error),
                    Toast.LENGTH_LONG
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(LOGGED_IN_USERNAME, loggedInUser)
        outState.putBoolean(IS_LOGGED_IN, isLoggedIn)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        isLoggedIn = savedInstanceState.getBoolean(IS_LOGGED_IN, false)
        loggedInUser = savedInstanceState.getString(LOGGED_IN_USERNAME, "")

        if (isLoggedIn && loggedInUser.isNotBlank()) {
            setLoggedIn(loggedInUser)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == LOGIN_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val usernameForm = data?.getStringExtra(USERNAME_KEY) ?: ""

            setLoggedIn(usernameForm)
            isLoggedIn = true
        } else if (requestCode == LOGIN_REQUEST_CODE && resultCode == Activity.RESULT_CANCELED) {
            val toast = Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
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
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }
}


















