package com.example.listviewsample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        lvMenu.onItemClickListener = ListItemClickListener()

        var menuList = mutableListOf("牛丼定食", "からあげ定食", "カレー定食", "焼き魚定食", "唐揚げ定食", "天ぷら定食", "焼肉定食", "とんかつ定食", "鰻定食", "寿司定食", "天丼定食", "豆腐定食", "焼き鳥定食", "麺類定食", "刺身定食")

        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, menuList)

        lvMenu.adapter = adapter
    }

    public inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val dialogFragment = OrderConfirmDialogFragment()
            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")
        }
    }
}