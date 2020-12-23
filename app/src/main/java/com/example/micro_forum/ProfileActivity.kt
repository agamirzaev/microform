package com.example.micro_forum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.micro_forum.adapter.AdapterCommentsArticles
import com.example.micro_forum.data.model.users.Users
import com.example.micro_forum.mvp.infoUsers.UsersInfoContract
import com.example.micro_forum.mvp.infoUsers.UsersInfoPresenter
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(), UsersInfoContract.View {

    private lateinit var presenter: UsersInfoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val id = intent.getStringExtra(AdapterCommentsArticles.ID).toString()

        presenter = UsersInfoPresenter((application as App).dataManager!!)
        presenter.attachView(this)
        presenter.loadInfoUsers(id)
    }

    override fun showInfoUsers(users: Users) {
        name.text = users.getName()
        username.text = users.getUsername()
        email.text = users.getEmail()
        street.text = users.getAddress()?.getStreet()
        suite.text = users.getAddress()?.getSuite()
        city.text = users.getAddress()?.getCity()
        zipcode.text = users.getAddress()?.getZipcode()
        phone.text = users.getPhone()
        website.text = users.getWebsite()
        company_name.text = users.getCompany()?.getName()
        catchPhrase.text = users.getCompany()?.getCatchPhrase()
        bs.text = users.getCompany()?.getBs()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        address.visibility = View.GONE
        contacts.visibility = View.GONE
        company.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        address.visibility = View.VISIBLE
        contacts.visibility = View.VISIBLE
        company.visibility = View.VISIBLE
    }

    override fun noConnection() {
        noConnection.visibility = View.VISIBLE
        address.visibility = View.GONE
        contacts.visibility = View.GONE
        company.visibility = View.GONE
    }
}