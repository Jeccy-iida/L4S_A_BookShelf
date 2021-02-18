package app.iida.jessy.bookshelf

import io.realm.RealmObject

open class Memo (
    open var title: String = "",
    open var name: String = "",
    //あれ？でも↓って数字(Int)でもいけるんか？？？
    open  var money: String =  "",
    open  var description: String = "",
) :RealmObject()