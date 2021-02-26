package com.example.test1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test1.adapters.RecyclerAdapter
import com.example.test1.R
import com.example.test1.data.view_model.FavouritesViewModel
import kotlinx.android.synthetic.main.fragment_favourites.*

class FavouritesFragment : Fragment() {

    private val adapterRecycler = RecyclerAdapter()
    private val viewModel: FavouritesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val llm = LinearLayoutManager(this.context)

        RecyclerViewFavourites.layoutManager = llm
        RecyclerViewFavourites.adapter = adapterRecycler

       observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.getFavourites()
        viewModel.listFavouritesLiveData.observe(viewLifecycleOwner, Observer {
            adapterRecycler.itemList = it
            adapterRecycler.notifyDataSetChanged()
        })
    }

}
