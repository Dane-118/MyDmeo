package com.example.mydmeo.until

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**

@author fangdongdong
@description:
@date : 2020/10/20 17:11
 */
object ImgUntils {

    /**
     * 保存图片到指定路径
     * @param context
     * @param *bitmap   要保存的图片
     * @param fileName 自定义图片名称
     */
    fun saveImageToGallery(context: Context, bitmap: Bitmap, fileName: String) {
        var fileName = fileName
        val format: DateFormat = SimpleDateFormat("yyyyMMddHHmmss")
        fileName = fileName + format.format(Date()) + ".JPEG"
        // 保存图片至指定路径
        val storePath =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path + "LS"
        val appDir = File(storePath)
        if (!appDir.exists()) {
            appDir.mkdir()
        }
        val file = File(appDir, fileName)
        try {
            val fos = FileOutputStream(file)
            //通过io流的方式来压缩保存图片(80代表压缩20%)
            val isSuccess = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            fos.flush()
            fos.close()
            // 其次把文件插入到系统图库
            /*try {
                MediaStore.Images.Media.insertImage(
                    context.contentResolver,
                    file.absolutePath,
                    fileName,
                    null
                )
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }*/
            //发送广播通知系统图库刷新数据
            println("发送广播通知系统图库刷新数据")
            val uri = Uri.fromFile(file)
            context.sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri))
            if (isSuccess) {
                Toast.makeText(context, "图片已保存至$file", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "图片保存失败", Toast.LENGTH_SHORT).show()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}