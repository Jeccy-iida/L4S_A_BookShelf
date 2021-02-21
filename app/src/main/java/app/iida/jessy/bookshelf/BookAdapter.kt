package app.iida.jessy.bookshelf

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.listbook.view.*
import java.text.SimpleDateFormat
import java.util.*

class BookAdapter(
        private val context: Context,
        private var bookList: OrderedRealmCollection<Book>?,
        private var listener: OnItemClickListener,
        private val autoUpdate: Boolean
) :
        RealmRecyclerViewAdapter<Book, BookAdapter.BookViewHolder>(bookList, autoUpdate) {

    override fun getItemCount(): Int = bookList?.size ?: 0

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book: Book = bookList?.get(position) ?: return

        holder.date.setOnClickListener{
            listener.onItemClick(book)
        }

        //holder.imageView.setImageResource(book.imageId)
        holder.contentTextView.text = book.title
        holder.nameTextView.text = book.name
        holder.dateTextView.text =
         //○分前表示にしたい
                SimpleDateFormat("mm"+"分前", Locale.JAPANESE).format(book.time)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BookViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.listbook, viewGroup, false)
        return BookViewHolder(v)
    }

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date : LinearLayout = view.date
        val contentTextView: TextView = view.bookTitleTextView
        val nameTextView: TextView = view.nameTextView
        val dateTextView: TextView = view.timeTextView
    }

    interface OnItemClickListener {
        fun onItemClick(item: Book)
    }
}