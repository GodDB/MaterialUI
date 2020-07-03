package com.example.ui.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.ui.R
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    lateinit var mTabLayout : TabLayout
    lateinit var mViewPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mTabLayout = findViewById(R.id.mainTab)
        mViewPager = findViewById(R.id.mainViewPager)

        //탭 레이아웃 메뉴 생성
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_launcher_main1_foreground))
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_launcher_main2_foreground))
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_launcher_main3_foreground))


        //뷰 페이저 어댑터 생성 및 뷰페이저에 set
        val pagerAdapter = MainTabPagerAdapter(supportFragmentManager, mTabLayout.tabCount)
        mViewPager.adapter = pagerAdapter

        //뷰페이저 리스너와 탭레이아웃 리스너 연결
        mViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mTabLayout))
        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                mViewPager.currentItem = tab!!.position
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {}
            override fun onTabUnselected(p0: TabLayout.Tab?) {}
        })
    }





}