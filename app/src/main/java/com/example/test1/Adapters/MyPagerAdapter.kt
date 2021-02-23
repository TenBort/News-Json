package com.example.test1.Adapters
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.test1.Fragments.FavouritesFragment
import com.example.test1.Fragments.StoriesFragment
import com.example.test1.Fragments.VideoFragment

val fragmentTitleList = mutableListOf("stories","video","favourites")

class MyPagerAdapter(fm: FragmentManager, private val fragmentCount:Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> StoriesFragment()
            1 -> VideoFragment()
            2 -> FavouritesFragment()
            else -> getItem(position)
        }
    }

    override fun getCount(): Int = fragmentCount

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]

    }
}