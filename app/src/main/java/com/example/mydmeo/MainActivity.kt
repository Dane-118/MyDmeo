package com.example.mydmeo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.mydmeo.adapter.MianAdapter
import com.example.mydmeo.bean.Student
import com.example.mydmeo.entity.MainChildNode
import com.example.mydmeo.entity.MainDateNode
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

@Route(path = "/app/fang/MainActivity")
class MainActivity : AppCompatActivity() {

    private var mainAdapter: MianAdapter = MianAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_main_zhedie?.layoutManager = LinearLayoutManager(this)

        rv_main_zhedie?.adapter = mainAdapter

        if (BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP) == BigDecimal.ZERO){
            Log.d("TAG", "onCreate: 3333333333333333333333333333333333333")
        }



        val dateList: MutableList<MainDateNode> = arrayListOf()
        for (index in 0..5) {
            val list: ArrayList<MainChildNode> = arrayListOf()
            if (index % 2 == 0) {
                for (index1 in 0..9 step 3) {
                    list.add(MainChildNode(Student("男士${index1}")))
                }
            }
            dateList.add(MainDateNode(list, "城市${index}"))
        }

        mainAdapter.setOnItemClickListener { adapter, view, position ->

        }


        mainAdapter.setList(dateList)


    }
}