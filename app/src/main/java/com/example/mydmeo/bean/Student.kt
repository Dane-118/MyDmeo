package com.example.mydmeo.bean

import android.util.Log

/**

@author fangdongdong
@description:
@date : 2020/9/22 20:17
 */
class Student() {

    init {
        Log.d("TAG", ": 第一次")
    }

    constructor(name: String, age: Int, sex: String) : this() {
        Log.d("TAG", ": ${name}的年龄是${age}岁")
    }

    constructor(name: String) : this(){
        Log.d("TAG", ": ${name}")
    }

}