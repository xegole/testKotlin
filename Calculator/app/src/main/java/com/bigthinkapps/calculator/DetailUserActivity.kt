package com.bigthinkapps.calculator

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.bigthinkapps.calculator.adapter.PagePagerAdapter
import com.bigthinkapps.calculator.fragment.PageFragment
import com.bigthinkapps.calculator.model.UserList
import kotlinx.android.synthetic.main.activity_detail_user.*


class DetailUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val userExtra = intent.extras.getSerializable("user_list_extra") as UserList
        initToolBar(userExtra.name)

        val listFragment = ArrayList<Fragment>()
        listFragment.add(PageFragment.newInstance(R.drawable.image_1))
        listFragment.add(PageFragment.newInstance(R.drawable.image_2))
        listFragment.add(PageFragment.newInstance(R.drawable.image_3))
        listFragment.add(PageFragment.newInstance(R.drawable.image_4))
        listFragment.add(PageFragment.newInstance(R.drawable.image_1))
        listFragment.add(PageFragment.newInstance(R.drawable.image_2))
        listFragment.add(PageFragment.newInstance(R.drawable.image_3))
        listFragment.add(PageFragment.newInstance(R.drawable.image_4))
        listFragment.add(PageFragment.newInstance(R.drawable.image_1))
        listFragment.add(PageFragment.newInstance(R.drawable.image_2))
        listFragment.add(PageFragment.newInstance(R.drawable.image_3))
        listFragment.add(PageFragment.newInstance(R.drawable.image_4))
        listFragment.add(PageFragment.newInstance(R.drawable.image_1))
        listFragment.add(PageFragment.newInstance(R.drawable.image_2))
        listFragment.add(PageFragment.newInstance(R.drawable.image_3))
        listFragment.add(PageFragment.newInstance(R.drawable.image_4))
        listFragment.add(PageFragment.newInstance(R.drawable.image_1))
        listFragment.add(PageFragment.newInstance(R.drawable.image_2))
        listFragment.add(PageFragment.newInstance(R.drawable.image_3))
        listFragment.add(PageFragment.newInstance(R.drawable.image_4))
        listFragment.add(PageFragment.newInstance(R.drawable.image_1))
        listFragment.add(PageFragment.newInstance(R.drawable.image_2))
        listFragment.add(PageFragment.newInstance(R.drawable.image_3))
        listFragment.add(PageFragment.newInstance(R.drawable.image_4))
        listFragment.add(PageFragment.newInstance(R.drawable.image_1))
        listFragment.add(PageFragment.newInstance(R.drawable.image_2))
        listFragment.add(PageFragment.newInstance(R.drawable.image_3))
        listFragment.add(PageFragment.newInstance(R.drawable.image_4))

        val pagerAdapter = PagePagerAdapter(listFragment, supportFragmentManager)
        viewPagerPages.adapter = pagerAdapter
        viewPagerPages.offscreenPageLimit = 2
    }


    private fun initToolBar(title: String) {
        toolbar.title = title

        setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}
