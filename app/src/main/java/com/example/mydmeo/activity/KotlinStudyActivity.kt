package com.example.mydmeo.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.mydmeo.R
import com.example.mydmeo.until.CalendarReminderUtils
import kotlinx.coroutines.*

@Route(path = "/app/fang/KotlinStudyActivity")
class KotlinStudyActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "KotlinStudyActivity"
    }

    @Autowired
    @JvmField var name: String? = null
    @Autowired
    @JvmField var age: Int? = 0

//    @Autowired(name = "person")
//    lateinit var person:Student

    override fun onCreate(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_study)

        Log.d(TAG, "onCreate: ${name}  ${age}")

        var list = arrayListOf(1, 2, 3)

        val filter = list.filter { it == 3 }
        val i = filter[0]
        val indexOf = list.indexOf(i)
        
        

        Log.d(Companion.TAG, "onCreate: " + filter.toString() + "  " + indexOf)

        sayHi("sdfsfsdf", age = 13)
        sayHi(name = "sdffsdfsf", 15)

        GlobalScope.launch(Dispatchers.Main, CoroutineStart.LAZY) {

            for (index in 0..10) {
                delay(100)
                Log.d(TAG, "协程1---onCreate:  $index   " + Thread.currentThread().getId())
            }
        }
        GlobalScope.launch {
            for (index in 0..10) {
                delay(100)
                Log.d(TAG, "协程2---onCreate:  $index " + Thread.currentThread().getId())
            }
        }


        CalendarReminderUtils.addCalendarEvent(this,
            "吃好吃的",
            "南信院二食堂",
            System.currentTimeMillis(),
            0)
    }


    fun sayHi(name: String = "world", age: Int) {
        Log.d(TAG, "sayHi: " + name + age)
    }


}