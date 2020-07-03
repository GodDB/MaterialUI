package com.example.ui.TopChart.TouchView

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.example.ui.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.math.atan
import kotlin.math.atan2


object TouchViewFragment : Fragment(), View.OnTouchListener, ScaleGestureDetector.OnScaleGestureListener, SeekBar.OnSeekBarChangeListener {

    //첫 x, y값 (뷰 drag)
    private var pressX : Float = 0f
    private var pressY : Float = 0f

    //scaleFactor (뷰 zoom)
    private var scaleFactor : Float = 1f

    //첫 각도, 뷰의 각도 (뷰 rotate)
    private var pressDegree : Float = 0f
    private var pressViewDegree : Float = 0f

    //터치 뷰
    private lateinit var touchView : View
    //투명도 조절 바
    private lateinit var transparentBar : SeekBar
    private lateinit var scaleGestureDetector: ScaleGestureDetector

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_touchview, container, false).apply {
            setOnTouchListener{ _, event ->
                //손가락이 두개 일 경우에 작동
                if(event.pointerCount ==2){
                    // zoom
                    scaleGestureDetector.onTouchEvent(event)
                    // rotation
                    rotationView(event)
                }
                true
            }
        }

        scaleGestureDetector = ScaleGestureDetector(activity, this)
        //투명도 조절 바
        transparentBar = view.findViewById<SeekBar>(R.id.transParentBar).apply { setOnSeekBarChangeListener(this@TouchViewFragment) }

        view.findViewById<BottomNavigationView>(R.id.bottomView).setOnNavigationItemSelectedListener {
            when(it.itemId){
                //터치 뷰 생성
                R.id.bottom_one -> {
     /*               val touchView= createView()
                    (view as ViewGroup).addView(touchView)
                    touchView.setOnTouchListener(this)*/
                    val intent : Intent = Intent(activity, GalleryImageAcitivity::class.java)
                    startActivity(intent)

                    true
                }

                //뷰 제거
                R.id.bottom_two -> {
                    (view as ViewGroup).removeView(touchView)
                    true
                }

                //투명도
                else -> {
                    transparentBar.visibility = View.VISIBLE
                    true
                }
            }
        }
        return view
    }

    //자식 뷰 touchEvent
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        // x,y 변위 = (터치포인트 move x,y지점) - (터치포인트 press x,y지점)
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                pressX = event.x
                pressY = event.y
                touchView = v
            }
            MotionEvent.ACTION_MOVE ->{
                //x,y변위
                val disX: Float = event.x - pressX
                val disY: Float = event.y - pressY

                //터치 뷰의 x,y + x,y변위
                touchView.x += disX
                touchView.y += disY
            }
        }
        return true
    }

    /** 뷰 회전  **/
    private fun rotationView(event : MotionEvent){
        when(event.actionMasked){
            //처음 눌렀을 때 두 손가락의 각도값, 뷰의 각도값
            MotionEvent.ACTION_POINTER_DOWN -> {
                //x,y변위값
                val pressDeltaX = event.getX(0) - event.getX(1)
                val pressDeltaY = event.getY(0) - event.getY(1)
                //아크탄젠트로 각도 계산
                val radian = atan2(pressDeltaY, pressDeltaX).toDouble()
                pressDegree = Math.toDegrees(radian).toFloat()

                //touchView 각도 저장
                pressViewDegree = touchView.rotation
            }

            //움직였을 때 두 손가락의 각도값 및 뷰 각도 갱신
            MotionEvent.ACTION_MOVE -> {
                // x,y 변위값
                val deltaX = event.getX(0) - event.getX(1)
                val deltaY = event.getY(0) - event.getY(1)
                //아크탄젠트로 각도 계산
                val radian = atan2(deltaY, deltaX).toDouble()
                val moveDegree = Math.toDegrees(radian).toFloat()

                //뷰에 각도 적용 ( 처음 뷰 각도 + 무브 각도 - 처음 눌렀을때 각도)
                touchView.rotation = (pressViewDegree + moveDegree - pressDegree)
            }
        }
    }

    /** 터치 뷰 생성 **/
    private fun createView() : ImageView{
        return ImageView(activity).apply {
            layoutParams = ViewGroup.LayoutParams(200, 200)
            setImageResource(R.drawable.book_iv)}
    }

    /** onScaleGestureListener handler **/
    override fun onScale(detector: ScaleGestureDetector): Boolean {
        scaleFactor *= detector.scaleFactor // cur_displacement / pre_displacement
        touchView.scaleX = scaleFactor
        touchView.scaleY = scaleFactor
        return true
    }

    /** onSeekbarChangeListener handler **/
    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        touchView.alpha = p1.toFloat()/100
    }



    // not using
    override fun onStartTrackingTouch(p0: SeekBar?) {}
    override fun onStopTrackingTouch(p0: SeekBar?) {}
    override fun onScaleEnd(p0: ScaleGestureDetector?) {}
    override fun onScaleBegin(p0: ScaleGestureDetector?): Boolean { return true }
}