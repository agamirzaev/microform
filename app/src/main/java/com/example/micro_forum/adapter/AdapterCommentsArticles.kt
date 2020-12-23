package com.example.micro_forum.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.micro_forum.ProfileActivity
import com.example.micro_forum.R
import com.example.micro_forum.data.model.article.ArticleComments
import kotlinx.android.synthetic.main.item_articler_comments.view.*

class AdapterCommentsArticles(private var articlesComments: ArrayList<ArticleComments>) :
    RecyclerView.Adapter<AdapterCommentsArticles.ViewHolder>() {

    companion object {
        const val ID: String = "ID"
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_articler_comments, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articlesComments.size
    }

    override fun onBindViewHolder(holder: AdapterCommentsArticles.ViewHolder, position: Int) {
        val comments = articlesComments[position]
        holder.bind(comments)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comments: ArticleComments) {
            itemView.nickname.text = comments.getName()
            itemView.textComments.text = comments.getBody()

            itemView.nickname.setOnClickListener {
                val intent = Intent(itemView.context, ProfileActivity::class.java)
                intent.putExtra(ID, comments.getId().toString())
                itemView.context.startActivity(intent)
            }
        }
    }
}
