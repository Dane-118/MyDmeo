package com.example.mydmeo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mydmeo.R

class KotlinStudyActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "KotlinStudyActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_study)

        var list = arrayListOf(1, 2, 3)

        val filter = list.filter { it == 3 }
        val i = filter[0]
        val indexOf = list.indexOf(i)

        Log.d(Companion.TAG, "onCreate: " + filter.toString() + "  " + indexOf)

        sayHi("sdfsfsdf", age = 13)
        sayHi(name = "sdffsdfsf", 15)

    }


    fun sayHi(name: String = "world", age: Int) {
        Log.d(TAG, "sayHi: " + name + age)
    }


}