package com.example.ui.Main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ui.Main.Main1.Main1Fragment
import com.example.ui.Main.Main2.Main2Fragment
import com.example.ui.Main.Main3.Main3Fragment

class MainTabPagerAdapter(fm : FragmentManager, private val pageCount:Int) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    /** position에 해당하는 Fragment를 반환합니다. **/
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> Main1Fragment()
            1 -> Main2Fragment()
            else -> Main3Fragment()
        }
    }

    /** page의 개수를 반환합니다. 반환 되는 수에 따라 페이지의 수가 결정됩니다. **/
    override fun getCount(): Int {
        return pageCount
    }

}