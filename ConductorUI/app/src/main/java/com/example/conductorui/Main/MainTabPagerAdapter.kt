package com.example.conductorui.Main

import android.util.Log
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.support.RouterPagerAdapter
import com.example.conductorui.Main.Main1.Main1Controller
import com.example.conductorui.Main.Main2.Main2Controller
import com.example.conductorui.Main.Main3.Main3Controller


class MainTabPagerAdapter(val controller: Controller, private val num: Int) :
    RouterPagerAdapter(controller) {


    /** position에 해당하는 Controller를 backstack에 담습니다. **/
    override fun configureRouter(router: Router, position: Int) {
        Log.d("godgod", "백스택 사이즈     ${router.backstackSize}")
        when (position) {
            0 -> {
                //setRoot는 백스택을 새로 생성함(기존 것은 없앰)
                //pushController는 백스택에 정상적으로 넣는 형태
                router.setRoot(RouterTransaction.with(Main1Controller()))
            }
            1 -> {
                router.setRoot(RouterTransaction.with(Main2Controller()))
            }
            2 -> {
                router.setRoot(RouterTransaction.with(Main3Controller()))
            }
        }
    }


    /** page의 개수를 반환합니다. 반환 되는 수에 따라 페이지의 수가 결정됩니다. **/
    override fun getCount(): Int {
        return num
    }


}