package com.example.mydmeo.until;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fangdongdong
 * @description:
 * @date : 2020/10/20 17:10
 */
public class Untils {

    /**
     * 保存图片到指定路径
     * @param context
     * @param *bitmap   要保存的图片
     * @param fileName 自定义图片名称
     */
    public void   saveImageToGallery(Context context, byte[] data, String fileName) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(data,0,data.length);
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        fileName = fileName + format.format(new Date())+".JPEG";
        // 保存图片至指定路径
        String storePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath()+"LS" ;
        File appDir = new File(storePath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //通过io流的方式来压缩保存图片(80代表压缩20%)
            boolean isSuccess = bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos);
            fos.flush();
            fos.close();
            // 其次把文件插入到系统图库
            try {
                MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //发送广播通知系统图库刷新数据
            System.out.println("发送广播通知系统图库刷新数据");
            Uri uri = Uri.fromFile(file);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));


            if (isSuccess) {
                Toast.makeText(context,"图片已保存至"+file,Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context,"图片保存失败",Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
