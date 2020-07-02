package com.example.ui.TopChart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.ui.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class TopChartActivity : AppCompatActivity() {
    lateinit var mTabLayout : TabLayout
    lateinit var mViewPager : ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topchart)

        mTabLayout = findViewById(R.id.tab)
        mViewPager = findViewById(R.id.viewPager)

        //탭 레이아웃 메뉴 생성

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("PICKS")))
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("TOP PAID")))
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("TOUCH VIEW")))



        val pagerAdapter = TabPagerAdapter(
            supportFragmentManager,
            mTabLayout.tabCount
        )
        mViewPager.adapter = pagerAdapter
        mViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mTabLayout))
        mTabLayout.addOnTabSelectedListener(object :OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                mViewPager.currentItem = tab!!.position
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {}
            override fun onTabUnselected(p0: TabLayout.Tab?) {}
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }


    // 탭 레이아웃에 들어갈 뷰 생성
    private fun createTabView(tabName : String) : View {
        val tabView =LayoutInflater.from(this).inflate(R.layout.tabitems, null)
        (tabView.findViewById(R.id.tabMenu) as TextView).text = tabName
        return tabView
    }


}