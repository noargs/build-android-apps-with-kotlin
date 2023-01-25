package github.noargs.loginpagestandard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible


class WelcomeActivity : AppCompatActivity() {

    private val header: TextView
        get() = findViewById(R.id.header)

    private val backButton: Button
        get() = findViewById(R.id.back_button)

    private val TAG = "WelcomeActivity"

    private var isLoggedIn = false
    private var loggedInUser = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        Log.d(TAG, "onCreate")

        intent.let { loginIntent ->

            val usernameForm = loginIntent?.getStringExtra(USERNAME_KEY) ?: ""
            val passwordForm = loginIntent?.getStringExtra(PASSWORD_KEY) ?: ""

            val loggedInCorrectly = hasEnteredCorrectCredentials(usernameForm.trim(), passwordForm.trim())

            if (loggedInCorrectly) {
                setLoggedIn(usernameForm)
                isLoggedIn = true
            } else {
                header.text = getString(R.string.login_error)
                backButton.isVisible = true
                backButton.setOnClickListener {
                    // Finishes this activity and so goes back to the previous activity
                    finish()
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(IS_LOGGED_IN, isLoggedIn)
        outState.putString(LOGGED_IN_USERNAME, loggedInUser)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        isLoggedIn = savedInstanceState.getBoolean(IS_LOGGED_IN, false)
        loggedInUser = savedInstanceState.getString(LOGGED_IN_USERNAME, "")

        if (isLoggedIn && loggedInUser.isNotBlank()) {
            setLoggedIn(loggedInUser)
        }
    }

    private fun setLoggedIn(username: String) {

        loggedInUser = username
        val welcomeMessage = getString(R.string.welcome_text, username)
        backButton.isVisible = false
        header.text = welcomeMessage
    }

    private fun hasEnteredCorrectCredentials(usernameForm: String, passwordForm: String): Boolean {
        return usernameForm.contentEquals(USERNAME_CORRECT_VALUE) && passwordForm.contentEquals(
            PASSWORD_CORRECT_VALUE)
    }
}