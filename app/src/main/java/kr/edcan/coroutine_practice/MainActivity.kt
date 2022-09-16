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

        txtTime = findViewById(R.id.txt_main_time)
        btnStart = findViewById(R.id.btn_main_start)
        btnReset = findViewById(R.id.btn_main_reset)

        btnStart.setOnClickListener {
            Toast.makeText(this, "타이머 시작", Toast.LENGTH_SHORT).show()

            timerThread = CoroutineScope(Dispatchers.IO).launch {
                while (true){
                    time += 1

                    withContext(Dispatchers.Main) {
                        txtTime.text = String.format("%02d:%02d", time / 60, time % 60)
                    }

                    delay(1000 * 1)
                }
            }
        }

        btnReset.setOnClickListener {
            Toast.makeText(this, "타이머 종료", Toast.LENGTH_SHORT).show()

            time = 0
            txtTime.text = String.format("%02d:%02d", time / 60, time % 60)

            timerThread.cancel()
        }
    }
}