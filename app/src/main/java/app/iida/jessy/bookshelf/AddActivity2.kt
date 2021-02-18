package app.iida.jessy.bookshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.widget.Toolbar


class AddActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add2)

        // activity_toolbar_sample.xml からToolbar要素を取得
        val toolbar2 = findViewById<Toolbar>(R.id.toolBar2)
        // アクションバーにツールバーをセット
        setSupportActionBar(toolbar2)
        // ツールバーに戻るボタンを設置
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    // ツールバーのアイテムを押した時の処理を記述（今回は戻るボタンのみのため、戻るボタンを押した時の処理しか記述していない）
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // android.R.id.home に戻るボタンを押した時のidが取得できる
        if (item.itemId == android.R.id.home) {
            // 今回はActivityを終了させている
            finish()
        }
        return super.onOptionsItemSelected(item)

    }
}
