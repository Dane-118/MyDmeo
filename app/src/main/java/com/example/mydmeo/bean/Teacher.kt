package com.example.mydmeo.bean

/**

@author fangdongdong
@description:
@date : 2020/10/20 14:55
 */
class Teacher(val gragle: Int, name: String, age: Int) : Person(name, age) {

    init {
        println("姓名：" + name)
        println("年龄：" + age)
    }

    constructor(name: String,age: Int) : this(0,name, age) {

    }


}