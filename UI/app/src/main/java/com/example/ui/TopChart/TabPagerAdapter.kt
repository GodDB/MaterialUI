package com.example.ui.TopChart

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ui.TopChart.Picks.PicksFragment
import com.example.ui.TopChart.TopPaid.TopPaidFragment
import com.example.ui.TopChart.TouchView.TouchViewFragment

class TabPagerAdapter(fm : FragmentManager, private val pageCount:Int) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    /** position에 해당하는 Fragment를 반환합니다. **/
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> PicksFragment()
            1 -> TopPaidFragment()
            else -> TouchViewFragment()

        }
    }

    /** page의 개수를 반환합니다. 반환 되는 수에 따라 페이지의 수가 결정됩니다. **/
    override fun getCount(): Int {
        return pageCount
    }

}