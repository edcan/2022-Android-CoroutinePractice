package kr.edcan.coroutine_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class TimerActivity : AppCompatActivity() {
    lateinit var txtTime: TextView
    lateinit var btnPlus: Button
    lateinit var btnMinus: Button
    lateinit var btnTimerControl: Button

    var time = 0

    lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        txtTime = findViewById(R.id.txt_timer_time)
        btnPlus = findViewById(R.id.btn_timer_plus)
        btnMinus = findViewById(R.id.btn_timer_minus)
        btnTimerControl = findViewById(R.id.btn_timer_timerControl)

        btnPlus.setOnClickListener {
            addTime(5)
        }

        btnMinus.setOnClickListener {
            minusTime(5)
        }

        btnTimerControl.setOnClickListener {
            if (btnTimerControl.text == "시작") {



                btnTimerControl.text = "정지"
            } else {



                btnTimerControl.text = "시작"
            }
        }

    }


    fun addTime(t: Int) {
        time += t

        txtTime.text = String.format("%02d:%02d", time / 60, time % 60)
    }

    fun minusTime(t: Int) {
        if(time - t >= 0)
            time -= t

        txtTime.text = String.format("%02d:%02d", time / 60, time % 60)
    }
}