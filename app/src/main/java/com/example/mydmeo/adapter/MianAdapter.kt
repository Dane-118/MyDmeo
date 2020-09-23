package com.example.mydmeo.adapter

import com.chad.library.adapter.base.BaseNodeAdapter
import com.chad.library.adapter.base.entity.node.BaseNode
import com.example.mydmeo.entity.MainChildNode
import com.example.mydmeo.entity.MainDateNode

/**

@author fangdongdong
@description:
@date : 2020/9/23 10:47
 */
class MianAdapter: BaseNodeAdapter() {

    init {
        addNodeProvider(MainDateProvider())
        addNodeProvider(MainChildProvider())
    }

    override fun getItemType(data: List<BaseNode>, position: Int): Int {
        val baseNode = data[position]
        if (baseNode is MainDateNode) {
            return 0
        } else if (baseNode is MainChildNode){
            return 1
        }
        return -1
    }

}