package com.example.mydmeo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mydmeo.R

class KotlinStudyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_study)

        var list = arrayListOf(1,2,3)

        val filter = list.filter { it == 3 }
        val i = filter[0]
        val indexOf = list.indexOf(i)

        Log.d(Companion.TAG, "onCreate: " + filter.toString()  +  "  " + indexOf)

    }

    companion object {
        private const val TAG = "KotlinStudyActivity"
    }
}