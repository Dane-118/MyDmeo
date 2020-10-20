package com.example.mydmeo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.mydmeo.activity.ImgSaveActivity
import com.example.mydmeo.activity.KotlinStudyActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setSupportActionBar(findViewById(R.id.toolbar))

        ActivityCompat.requestPermissions(
            this@SplashActivity,
            arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE
            ),
            100
        )

        findViewById<Button>(R.id.rv_zhedie).setOnClickListener { view ->
            startActivity(Intent(this, MainActivity::class.java))
        }
        findViewById<Button>(R.id.btn_img_save).setOnClickListener { view ->
            startActivity(Intent(this, ImgSaveActivity::class.java))
        }

        findViewById<Button>(R.id.btn_kotlin).setOnClickListener { view ->
            startActivity(Intent(this, KotlinStudyActivity::class.java))
        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            100 ->                 // 判断是否是已经授权过
                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 执行授权后的操作
                } else {
                    // 执行未授权的操作
                    // 判断是否曾经拒绝并且勾选了不再提醒（我应该向用户解释一下我为什么要这些权限吗）
                    if (ActivityCompat.shouldShowRequestPermissionRationale(
                            this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        )
                    ) {
                        // 弹出解释框
                    } else {
                        // 跳转到系统权限设置页面
                    }
                }
            else -> {
            }
        }
    }



}