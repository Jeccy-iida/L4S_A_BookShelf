package app.iida.jessy.bookshelf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_add2.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    //    val realm: Realm = Realm.getDefaultInstance()
// こなつさんので書き換える
    private val realm: Realm by lazy {
        Realm.init(this)
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //toolbarをTopbarに設定してる
        setSupportActionBar(toolbar)

        //記入したデーターを全て読み込んでる。１つだけならval book: Book? = read()
        val taskList = readAll()


        //詳細画面へ画面遷移　データーを渡す
        val adapter = BookAdapter(this, taskList, object : BookAdapter.OnItemClickListener {
            override fun onItemClick(item: Book) {
                // クリック時の処理
                //Intentのインスタンスを作成
                val intent = Intent(applicationContext, DetailActivity::class.java)

                //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
                intent.putExtra("ID", item.id)

                //画面遷移を開始
                startActivity(intent)
            }
        }, true)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this,3,RecyclerView.VERTICAL,false)
        recyclerView.adapter = adapter


        //画面遷移でAddに飛ぶ
        plusButton.setOnClickListener{
            val toAddActivity2Intent = Intent(this, AddActivity2::class.java)
            startActivity(toAddActivity2Intent)
        }

    }



    fun read(): Book? {
        return realm.where(Book::class.java).findFirst()
    }


    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }


    fun readAll(): RealmResults<Book> {
        return realm.where(Book::class.java).findAll()
    }
}

