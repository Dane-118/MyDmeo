package com.example.mydmeo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mydmeo.bean.Student

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Student("fangdong",18,"男")
        Student("jp")
        Student()
    }
}