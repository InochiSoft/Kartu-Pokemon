package com.dicoding.agungnovian.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.agungnovian.R
import com.dicoding.agungnovian.model.adapter.CardAdapter
import com.dicoding.agungnovian.viewmodel.CardsViewModelList

class MainActivity : AppCompatActivity() {
    private lateinit var cardsViewModelList: CardsViewModelList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val appbar = findViewById<com.google.android.material.appbar.AppBarLayout>(R.id.appBar)
        val fraSplash = findViewById<FrameLayout>(R.id.fraSplash)

        cardsViewModelList = ViewModelProvider(this).get(CardsViewModelList::class.java)

        val listView : RecyclerView = findViewById(R.id.listView)
        listView.layoutManager = LinearLayoutManager(this)

        cardsViewModelList.list(this)?.observe(
            this, Observer {
                val adapter = CardAdapter(this, it)
                listView.adapter = adapter
                appbar.visibility = View.VISIBLE
                listView.visibility = View.VISIBLE
                fraSplash.visibility = View.GONE
            }
        )

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings ->
            {
                val intent = Intent(this, AboutActivity::class.java)
                this.startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}