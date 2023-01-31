package github.noargs.jetpackfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

val STAR_SIGN_ID = "STAR_SIGN_ID"

interface StarSignListener {
    fun onSelected(starSignId: Int)
}

class MainActivity : AppCompatActivity(), StarSignListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSelected(starSignId: Int) {
        TODO("Not yet implemented")
    }
}