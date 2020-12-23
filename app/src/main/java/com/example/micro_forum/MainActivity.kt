package com.example.micro_forum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micro_forum.adapter.AdapterArticles
import com.example.micro_forum.data.model.article.Article
import com.example.micro_forum.mvp.allArticles.ArticlesContract
import com.example.micro_forum.mvp.allArticles.ArticlesPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ArticlesContract.View {

    private lateinit var presenter: ArticlesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        )
        recyclerArticles!!.layoutManager = linearLayoutManager

        recyclerArticles!!.addItemDecoration(
                DividerItemDecoration(
                        this,
                        LinearLayoutManager.VERTICAL
                )
        )

        presenter = ArticlesPresenter((application as App).dataManager!!)
        presenter.attachView(this)
        presenter.loadArticlesInfo()
    }

    override fun showArticles(articles: ArrayList<Article>) {
        val adapterArticles = AdapterArticles(articles)
        recyclerArticles!!.adapter = adapterArticles
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
    }

    override fun noConnection() {
        noConnection!!.visibility = View.VISIBLE
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