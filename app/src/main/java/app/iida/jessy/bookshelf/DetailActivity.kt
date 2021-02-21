package app.iida.jessy.bookshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {

    private val realm: Realm by lazy {
        Realm.init(this)
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //受け取った変数を入れる (IDはお役御免
        val id = intent.getStringExtra("ID")

        //bookの中身は25行目のid検索の結果出てきた１つのBookが入ってる
        val book = read(id!!)

        //取り出した情報を各入れ物に入れる
        titleText.text = book?.title
        nameText.text = book?.name
        moneyText.text = book?.money
        descriptionText.text = book?.description
    }

    fun read(searchId:String): Book?{

        return realm.where(Book::class.java).equalTo("id" , searchId).findFirst()

    }

}