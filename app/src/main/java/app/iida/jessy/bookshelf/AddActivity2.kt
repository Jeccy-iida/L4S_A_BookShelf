package app.iida.jessy.bookshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_add2.*
import java.util.*
import java.util.UUID as UUID1

//import java.util.*


class AddActivity2 : AppCompatActivity() {

    //realmが使えるように設定
    val realm: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add2)

        //戻るのボタン設定



//        if (memo != null){
//            titleEditText.setText(memo.title)
//            nameEditText.setText(memo.name)
//            moneyEditText.setText(memo.money)
//            descriptionEditText.setText(memo.description)
//        }


        //追加ボタンを押した時に入力されたテキストを取得しsave()メソッドに値を渡す
        addButton.setOnClickListener {
            val title: String = titleEditText.text.toString()
            val name: String = nameEditText.text.toString()
            val money: String = moneyEditText.text.toString()
            val descriptor: String = descriptionEditText.text.toString()
            save(title, name, money, descriptor)
        }
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

    //realm関係
    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    //受け取った情報の保存
    fun save(title: String, name: String, money: String, description: String) {

        realm.executeTransaction {
            //メモの新規作成
            val newBook: Book = it.createObject(Book::class.java, java.util.UUID.randomUUID().toString())
            newBook.title = title
            newBook.name = name
            newBook.money = money
            newBook.description = description

        }
        Snackbar.make(container, "保存しました!!", Snackbar.LENGTH_SHORT).show()
    }



}
