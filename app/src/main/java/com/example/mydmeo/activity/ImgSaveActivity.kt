package com.example.mydmeo.activity

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mydmeo.R
import com.example.mydmeo.until.ImgUntils
import java.io.*
import java.text.SimpleDateFormat
import java.util.*


class ImgSaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_img_save)


        findViewById<Button>(R.id.img_save).setOnClickListener {
            val bitmap =
                BitmapFactory.decodeResource(this.resources, R.drawable.bg_home_card)
            ImgUntils.saveImageToGallery(this,bitmap,"123")
//            saveBitmap(bitmap,"123")
        }



    }




    /*
    * 保存文件，文件名为当前日期
    */
    fun saveBitmap(bitmap: Bitmap, bitName: String): Boolean {
        val fileName: String
        val file: File
        val brand = Build.BRAND
        fileName = if (brand == "xiaomi") { // 小米手机brand.equals("xiaomi")
            Environment.getExternalStorageDirectory().getPath()
                .toString() + "/DCIM/Camera/" + bitName
        } else if (brand.equals("Huawei", ignoreCase = true)) {
            Environment.getExternalStorageDirectory().getPath()
                .toString() + "/DCIM/Camera/" + bitName
        } else { // Meizu 、Oppo
            Environment.getExternalStorageDirectory().getPath().toString() + "/DCIM/" + bitName
        }
        //        fileName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/" + bitName;
        if (Build.VERSION.SDK_INT >= 29) {
//            boolean isTrue = saveSignImage(bitName, bitmap);
            saveSignImage(bitName, bitmap)
            return true
            //            file= getPrivateAlbumStorageDir(NewPeoActivity.this, bitName,brand);
//            return isTrue;
        } else {
            Log.v("saveBitmap brand", "" + brand)
            file = File(fileName)
        }
        if (file.exists()) {
            file.delete()
        }
        val out: FileOutputStream
        try {
            out = FileOutputStream(file)
            // 格式为 JPEG，照相机拍出的图片为JPEG格式的，PNG格式的不能显示在相册中
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)) {
                out.flush()
                out.close()
                // 插入图库
                if (Build.VERSION.SDK_INT >= 29) {
                    val values = ContentValues()
                    values.put(MediaStore.Images.Media.DATA, file.getAbsolutePath())
                    values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                    val uri: Uri? =
                        contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
                } else {
                    MediaStore.Images.Media.insertImage(
                        this.contentResolver,
                        file.getAbsolutePath(),
                        bitName,
                        null
                    )
                }
            }
        } catch (e: FileNotFoundException) {
            Log.e("FileNotFoundException", "FileNotFoundException:" + e.message.toString())
            e.printStackTrace()
            return false
        } catch (e: IOException) {
            Log.e("IOException", "IOException:" + e.message.toString())
            e.printStackTrace()
            return false
        } catch (e: Exception) {
            Log.e("IOException", "IOException:" + e.message.toString())
            e.printStackTrace()
            return false

// 发送广播，通知刷新图库的显示
        }
        //        if(Build.VERSION.SDK_INT >= 29){
//            copyPrivateToDownload(this,file.getAbsolutePath(),bitName);
//        }
        this.sendBroadcast(
            Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.parse("file://$fileName")
            )
        )
        return true
    }


    //将文件保存到公共的媒体文件夹
    //这里的filepath不是绝对路径，而是某个媒体文件夹下的子路径，和沙盒子文件夹类似
    //这里的filename单纯的指文件名，不包含路径
    fun saveSignImage( /*String filePath,*/
        fileName: String?, bitmap: Bitmap
    ) {
        try {
            //设置保存参数到ContentValues中
            val contentValues = ContentValues()
            //设置文件名
            contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
            //兼容Android Q和以下版本
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                //android Q中不再使用DATA字段，而用RELATIVE_PATH代替
                //RELATIVE_PATH是相对路径不是绝对路径
                //DCIM是系统文件夹，关于系统文件夹可以到系统自带的文件管理器中查看，不可以写没存在的名字
                contentValues.put(MediaStore.Images.Media.RELATIVE_PATH, "DCIM/")
                //contentValues.put(MediaStore.Images.Media.RELATIVE_PATH, "Music/signImage");
            } else {
                contentValues.put(
                    MediaStore.Images.Media.DATA, Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES
                    ).path
                )
            }
            //设置文件类型
            contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/JPEG")
            //执行insert操作，向系统文件夹中添加文件
            //EXTERNAL_CONTENT_URI代表外部存储器，该值不变
            val uri =
                contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
            if (uri != null) {
                //若生成了uri，则表示该文件添加成功
                //使用流将内容写入该uri中即可
                val outputStream: OutputStream? = contentResolver.openOutputStream(uri)
                if (outputStream != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
                    outputStream.flush()
                    outputStream.close()
                }
            }
        } catch (e: java.lang.Exception) {
        }
    }


}