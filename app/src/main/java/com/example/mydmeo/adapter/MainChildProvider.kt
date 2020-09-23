package com.example.mydmeo.adapter

import android.view.View
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.mydmeo.R
import com.example.mydmeo.entity.MainChildNode

/**

@author fangdongdong
@description:
@date : 2020/9/23 13:41
 */
class MainChildProvider: BaseNodeProvider() {
    override val itemViewType: Int
        get() = 1
    override val layoutId: Int
        get() = R.layout.main_item_date

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val mainChildNode = item as MainChildNode
        if (mainChildNode.isExpanded){

        }
        val student = mainChildNode.student
        helper.setText(R.id.tv_item_title,student.name)
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: BaseNode, position: Int) {

    }


}