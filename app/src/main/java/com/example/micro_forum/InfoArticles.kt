package com.example.micro_forum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micro_forum.adapter.AdapterArticles
import com.example.micro_forum.adapter.AdapterCommentsArticles
import com.example.micro_forum.data.model.article.ArticleComments
import com.example.micro_forum.data.model.article.ArticleInfo
import com.example.micro_forum.mvp.infoArticles.InfoArticlesContract
import com.example.micro_forum.mvp.infoArticles.InfoArticlesPresenter
import kotlinx.android.synthetic.main.activity_info_articles.*

class InfoArticles : AppCompatActivity(), InfoArticlesContract.View{

    private lateinit var presenter: InfoArticlesPresenter
    private lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_articles)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        id = intent.getStringExtra(AdapterArticles.ID).toString()

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerComments!!.layoutManager = linearLayoutManager

        recyclerComments!!.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        presenter = InfoArticlesPresenter((application as App).dataManager!!)
        presenter.attachView(this)
        presenter.loadArticlesInfo(id)
        presenter.loadCommentsArticles(id)
    }

    override fun showArticles(articlesInfo: ArticleInfo) {
        articleTitle.text = articlesInfo.getTitle()
        articleBody.text = articlesInfo.getBody()
    }

    override fun showArticlesComments(articlesComments: ArrayList<ArticleComments>?) {
        val adapterCommentsArticles = articlesComments?.let { AdapterCommentsArticles(it) }
        recyclerComments!!.adapter = adapterCommentsArticles
        titleComments.text = "Комментарии " + articlesComments?.size
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun noConnection() {
        noConnection.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }
}