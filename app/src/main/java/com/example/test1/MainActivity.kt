package com.example.test1

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.SearchView
import androidx.core.content.ContextCompat
import com.example.test1.Adapters.MyPagerAdapter
import com.example.test1.Adapters.RecyclerAdapter
import com.example.test1.data.model.News
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapterRecycler = RecyclerAdapter()
//    val adapterlist = adapterRecycler.itemList
//    val list = mutableListOf<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        list.addAll(adapterlist)

        val fragmentAdapter =
            MyPagerAdapter(
                supportFragmentManager,
                3
            )
        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        val searchItem = menu?.findItem(R.id.menu_search)


        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView

            val searchPlate =
                searchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
            searchPlate.hint = "Search"
            val searchPlateView: View =
                searchView.findViewById(androidx.appcompat.R.id.search_plate)
            searchPlateView.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    android.R.color.transparent
                )
            )

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
//                    if (newText!!.isNotEmpty()) {
//                        list.clear()
//
//                        val search = newText.toLowerCase()
//                        list.forEach {
//                            if (it.name.toLowerCase().contains(search)) {
//                                list.add(it)
//                            }
//                        }
//
//                        viewPager.adapter?.notifyDataSetChanged()
//                    } else {
//                        list.clear()
//                        list.addAll(adapterlist)
//                        viewPager.adapter?.notifyDataSetChanged()
//                    }

                    return false
                }
            })
            val searchManager =
                getSystemService(Context.SEARCH_SERVICE) as SearchManager
            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }



        return super.onCreateOptionsMenu(menu)
    }
}