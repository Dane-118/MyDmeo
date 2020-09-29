package com.example.mydmeo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.mydmeo.activity.KotlinStudyActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<Button>(R.id.rv_zhedie).setOnClickListener { view ->
            startActivity(Intent(this,MainActivity::class.java))
        }

        findViewById<Button>(R.id.btn_kotlin).setOnClickListener { view ->
            startActivity(Intent(this,KotlinStudyActivity::class.java))
        }

    }
}