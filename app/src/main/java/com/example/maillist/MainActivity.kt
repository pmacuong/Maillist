package com.example.maillist

import adapters.EmailAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.Email

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: EmailAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        viewManager = LinearLayoutManager(this)
        viewAdapter = EmailAdapter(getDummyEmails())

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun getDummyEmails(): List<Email> {
        return listOf(
            Email("Nguyen A", "Hello", "Hello"),
            Email("Tran B", "Greeting", "Test"),
            Email("Phung C", "Chao", "Hi"),
            Email("Dao D", "long test", "this is a long email this is a long email this is a long email this is a long email this is a long email this is a long email this is a long email this is a long email this is a long email this is a long email this is a long email"),
        )
    }
}