package com.example.mydmeo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.mydmeo.R;
import com.example.mydmeo.calendar.CalendarProviderManager;

@Route(path = "/app/fang/CalendarActivity")
public class CalendarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        long l = System.currentTimeMillis() + 10 * 60000;
        Log.d("TAG", "onCreate: " + l);
        int result = CalendarProviderManager.addCalendarEvent(this,
                "将乘坐列车XXX（车次编号）从XX（出发站）前往XX（到达站）",
                "https://www.baidu.com/", l, 9);
        if (result == 0) {
            Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
        } else if (result == -1) {
            Toast.makeText(this, "插入失败", Toast.LENGTH_SHORT).show();
        } else if (result == -2) {
            Toast.makeText(this, "没有权限", Toast.LENGTH_SHORT).show();
        }

        long end = 10 * 60 * 1000 + 1604648320093L;
        boolean b = CalendarProviderManager.isEventAlreadyExist(this, 1604648320093L, end, "将乘坐列车XXX（车次编号）从XX（出发站）前往XX（到达站）");
        if (b) {
            Toast.makeText(this, "存在", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "不存在", Toast.LENGTH_SHORT).show();
        }
    }
}