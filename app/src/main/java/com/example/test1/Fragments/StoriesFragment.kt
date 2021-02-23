package com.example.test1.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test1.Adapters.RecyclerAdapter
import com.example.test1.R
import com.example.test1.data.ViewModel.ViewModel
import kotlinx.android.synthetic.main.fragment_favourites.*
import kotlinx.android.synthetic.main.fragment_favourites.RecyclerViewFavourites
import kotlinx.android.synthetic.main.fragment_stories.*

class StoriesFragment : Fragment() {

    private val adapterRecycler = RecyclerAdapter()
    private val viewModel: ViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stories, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val llm = LinearLayoutManager(this.context)

        RecyclerViewStories.layoutManager = llm
        RecyclerViewStories.adapter = adapterRecycler

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.getNews()
        viewModel.listNewsLiveData.observe(viewLifecycleOwner, Observer {
            adapterRecycler.itemList = it
            adapterRecycler.notifyDataSetChanged()
        })
    }
}