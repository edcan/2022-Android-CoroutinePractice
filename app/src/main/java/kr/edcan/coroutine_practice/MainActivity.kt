package kr.edcan.coroutine_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var txtTime : TextView
    lateinit var btnStart : Button
    lateinit var btnReset : Button

    var time = 0

    lateinit var timerThread: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Todo 1. TextView, Button 가져오기


        btnStart.setOnClickListener {
            Toast.makeText(this, "타이머 시작", Toast.LENGTH_SHORT).show()

            // Todo 2. 새로운 IO 쓰레드 만들기


            // Todo 3. 무한 반복 시키기


            // Todo 4. 시간 증가 시키기


            // Todo 5. 화면에 현재 시간 변경해주기


            // Todo 6. 1초(1000ms) 딜레이 시키기


        }

        btnReset.setOnClickListener {
            Toast.makeText(this, "타이머 종료", Toast.LENGTH_SHORT).show()

            // Todo 7. 시간을 0초로 만들고 화면에 시간 변경해주기



            // Todo 8. 타이머 스레드 중지 시키기



        }
    }
}