package com.example.conductorui.TopChart

import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.bluelinelabs.conductor.Controller
import com.example.conductorui.R
import com.google.android.material.tabs.TabLayout

class TopChartController : Controller(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_topchart, container, false)

        val mTabLayout : TabLayout = view.findViewById(R.id.tab)
        val mViewPager : ViewPager = view.findViewById(R.id.viewPager)

        //탭 레이아웃 메뉴 생성
        mTabLayout.apply {
            addTab(this.newTab().setCustomView(createTabView("PICKS")))
            addTab(this.newTab().setCustomView(createTabView("TOP PAID")))
            addTab(this.newTab().setCustomView(createTabView("TOUCH VIEW")))
        }

        val pagerAdapter = TabPagerAdapter(
            this,
            mTabLayout.tabCount
        )

        mViewPager.adapter = pagerAdapter
        mViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mTabLayout))
        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                mViewPager.currentItem = tab!!.position
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {}
            override fun onTabUnselected(p0: TabLayout.Tab?) {}
        })

        Log.d("godgod", "탑차트 컨트롤러 라우터 :  ${router}  백스택   : ${router.backstack}    ")
        return view
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_menu, menu)
    }

    // 탭 레이아웃에 들어갈 뷰 생성
    private fun createTabView(tabName : String) : View {
        val tabView =LayoutInflater.from(activity).inflate(R.layout.tabitems, null)
        (tabView.findViewById(R.id.tabMenu) as TextView).text = tabName
        return tabView
    }
}