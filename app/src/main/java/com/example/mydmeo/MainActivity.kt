package com.example.mydmeo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydmeo.adapter.MianAdapter
import com.example.mydmeo.bean.Student
import com.example.mydmeo.entity.MainChildNode
import com.example.mydmeo.entity.MainDateNode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mainAdapter: MianAdapter = MianAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_main_zhedie?.layoutManager = LinearLayoutManager(this)

        rv_main_zhedie?.adapter = mainAdapter

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