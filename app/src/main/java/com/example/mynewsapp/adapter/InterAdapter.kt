package com.example.mynewsapp.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsapp.R
import com.example.mynewsapp.model.News
import com.squareup.picasso.Picasso

class InterAdapter(val context: Context, private val itemList : ArrayList<News>) :
    RecyclerView.Adapter<InterAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(view : View): RecyclerView.ViewHolder(view)
    {
        val textAuthor : TextView = view.findViewById(R.id.txtAuthorInter)
        val textTitle : TextView = view.findViewById(R.id.txtTitleInter)
        val textDesc : TextView = view.findViewById(R.id.txtDescInter)
        val textPubl : TextView = view.findViewById(R.id.txtPublishedInter)
        val imgCover : ImageView = view.findViewById(R.id.imgInter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.singel_inter_adapter,parent,false)

        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val news = itemList[position]
        holder.textAuthor.text = news.author
        holder.textTitle.text = news.title
        holder.textDesc.text = news.description
        holder.textPubl.text = news.publishedAt

        Picasso.get().load(news.urlToImage).error(R.drawable.ic_launcher_background).into(holder.imgCover)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
