package com.example.conductorui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.example.conductorui.Main.MainController

class MainActivity : AppCompatActivity() {

    lateinit var router : Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val parent =findViewById<ViewGroup>(R.id.mainAcitivy_parent)

        router = Conductor.attachRouter(this, parent, savedInstanceState)
        if(!router.hasRootController()){
            router.setRoot(RouterTransaction.with(MainController()))
        }

        Log.d("godgod", "부모 액티비티 라우터 :  ${router}  백스택   : ${router.backstack}    ")
    }

    override fun onBackPressed() {
        if(!router.handleBack()){
            super.onBackPressed()
        }
    }
}