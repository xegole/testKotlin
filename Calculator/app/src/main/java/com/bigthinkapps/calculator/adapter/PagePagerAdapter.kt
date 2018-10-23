package com.bigthinkapps.calculator.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PagePagerAdapter(private val listFragment: List<Fragment>, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val arrayTitle = arrayOf("Global", "Places", "Others")

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getCount(): Int {
        return listFragment.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return arrayTitle[position]
    }
}