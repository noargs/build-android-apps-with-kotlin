package github.noargs.loginpagestandard

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val USERNAME_KEY = "USERNAME_KEY"
const val PASSWORD_KEY = "PASSWORD_KEY"

const val IS_LOGGED_IN = "IS_LOGGED_IN"
const val LOGGED_IN_USERNAME = "LOGGED_IN_USERNAME"

// for simplicity only don't do it in production code
const val USERNAME_CORRECT_VALUE = "ibn"
const val PASSWORD_CORRECT_VALUE = "password"

class MainActivity : AppCompatActivity() {

    private val submitButton: Button
        get() = findViewById(R.id.button)

    private val username: EditText
        get() = findViewById(R.id.username)

    private val password: EditText
        get() = findViewById(R.id.password)

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

                        // Reset text fields to blank
                        this.username.text.clear()
                        this.password.text.clear()

                        // Launch
                        startActivity(welcomeIntent)
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

    private fun hideKeyboard() {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }
}




























