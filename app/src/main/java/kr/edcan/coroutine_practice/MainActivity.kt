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
        txtTime = findViewById(R.id.txt_main_time)
        btnStart = findViewById(R.id.btn_main_start)
        btnReset = findViewById(R.id.btn_main_reset)

        btnStart.setOnClickListener {
            Toast.makeText(this, "타이머 시작", Toast.LENGTH_SHORT).show()

            // Todo 2. 새로운 IO 쓰레드 만들기
            timerThread = CoroutineScope(Dispatchers.IO).launch {

                // Todo 3. 무한 반복 시키기
                while (true){
                    // Todo 4. 시간 증가 시키기
                    time += 1

                    // Todo 5. 화면에 현재 시간 변경해주기
                    withContext(Dispatchers.Main) {
                        txtTime.text = String.format("%02d:%02d", time / 60, time % 60)
                    }

                    // Todo 6. 1초(1000ms) 딜레이 시키기
                    delay(1000 * 1)
                }
            }
        }

        btnReset.setOnClickListener {
            Toast.makeText(this, "타이머 종료", Toast.LENGTH_SHORT).show()

            // Todo 7. 시간을 0초로 만들고 화면에 시간 변경해주기
            time = 0
            txtTime.text = String.format("%02d:%02d", time / 60, time % 60)

            // Todo 8. 타이머 스레드 중지 시키기
            timerThread.cancel()
        }
    }
}