package jp.techacademy.yoshitsugu.ch0510timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var mTimer: Timer? = null
    private var mTimerSec = 0.0
    private var mHandler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timer = findViewById<TextView>(R.id.timer)

        mTimer = Timer()
        mTimer!!.schedule(object: TimerTask(){
            override fun run (){
                mTimerSec += 0.1
                mHandler.post {
                    timer.text = String.format("%.1f", mTimerSec)
                }
            }
        }, 100,100)
    }
}
