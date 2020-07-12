package com.example.conductorui.TopChart

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.support.RouterPagerAdapter
import com.example.conductorui.TopChart.Picks.PicksController
import com.example.conductorui.TopChart.TopPaid.TopPaidController
import com.example.conductorui.TopChart.TouchView.TouchViewController


class TabPagerAdapter(controller : Controller, private val pageCount : Int) : RouterPagerAdapter(controller) {


    /** position에 해당하는 Controller를 backstack에 담습니다. **/
    override fun configureRouter(router: Router, position: Int) {
        when(position){
            0 -> router.setRoot(RouterTransaction.with(PicksController()))
            1 -> router.setRoot(RouterTransaction.with(TopPaidController()))
            2 -> router.setRoot(RouterTransaction.with(TouchViewController()))
        }

    }

    /** page의 개수를 반환합니다. 반환 되는 수에 따라 페이지의 수가 결정됩니다. **/
    override fun getCount(): Int {
        return pageCount
    }

}