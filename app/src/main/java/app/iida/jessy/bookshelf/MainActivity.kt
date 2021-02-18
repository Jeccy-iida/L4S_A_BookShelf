package app.iida.jessy.bookshelf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        plusButton.setOnClickListener{
            val toAddActivity2Intent = Intent(this,AddActivity2::class.java)
             startActivity(toAddActivity2Intent)
        }
    }
}

