package app.iida.jessy.bookshelf

import android.os.CountDownTimer
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

//保存するデータの型を定義
open class Book (
    //ID
    @PrimaryKey open var id: String = UUID.randomUUID().toString(),
    open var title: String = "",
    open var name: String = "",
    open  var money: String = "",
    open  var description: String = "",
    open var time: Date = Date(System.currentTimeMillis())
) :RealmObject()