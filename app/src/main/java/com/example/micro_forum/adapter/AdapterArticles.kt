package com.example.micro_forum.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.micro_forum.InfoArticles
import com.example.micro_forum.R
import com.example.micro_forum.data.model.article.Article
import kotlinx.android.synthetic.main.item_all_articles.view.*

class AdapterArticles(private var articles: ArrayList<Article>) :
    RecyclerView.Adapter<AdapterArticles.ViewHolder>() {

    companion object {
        const val COUNT = 20
        const val ID: String = "ID"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterArticles.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_all_articles, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return COUNT
    }

    override fun onBindViewHolder(holder: AdapterArticles.ViewHolder, position: Int) {
        val articles = articles[position]
        holder.bind(articles)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(articles: Article) {
            itemView.article.text = articles.getTitle()
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, InfoArticles::class.java)
                intent.putExtra(ID, articles.getId().toString())
                itemView.context.startActivity(intent)
            }
        }
    }
}