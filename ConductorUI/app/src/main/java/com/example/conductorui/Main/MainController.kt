package com.example.conductorui.Main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.bluelinelabs.conductor.Controller
import com.example.conductorui.R
import com.google.android.material.tabs.TabLayout

class MainController() : Controller(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        val view = inflater.inflate(R.layout.controller_main, container, false)

        val viewPager = view.findViewById<ViewPager>(R.id.mainViewPager)

        val tabLayout = view.findViewById<TabLayout>(R.id.mainTab).apply {
            addTab(this.newTab().setIcon(R.drawable.ic_launcher_main1_foreground))
            addTab(this.newTab().setIcon(R.drawable.ic_launcher_main2_foreground))
            addTab(this.newTab().setIcon(R.drawable.ic_launcher_main3_foreground))
        }

        //뷰 페이저 어댑터 생성 및 뷰페이저에 set
        val pagerAdapter = MainTabPagerAdapter(this, tabLayout.tabCount)
        viewPager.adapter = pagerAdapter

        //뷰페이저 리스너와 탭레이아웃 리스너 연결
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {}
            override fun onTabUnselected(p0: TabLayout.Tab?) {}
        })

        Log.d("godgod", "메인 컨트롤러 라우터 :  ${router}  백스택   : ${router.backstack}    ")
        return view
    }
}