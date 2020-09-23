package com.example.mydmeo.adapter

import android.view.View
import android.widget.TextView
import com.blankj.utilcode.util.SizeUtils
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.mydmeo.R
import com.example.mydmeo.entity.MainDateNode

/**

@author fangdongdong
@description:
@date : 2020/9/23 11:06
 */
class MainDateProvider : BaseNodeProvider() {

    override val itemViewType: Int
        get() = 0

    override val layoutId: Int
        get() = R.layout.main_item_date

    override fun convert(helper: BaseViewHolder, item: BaseNode) {

        val mainDateNode = item as MainDateNode
        val childNode = mainDateNode.childNode

        if (!mainDateNode.isExpanded && (childNode?.size?:0 > 0)) {
            helper.setVisible(R.id.tv_item_des, true)
            helper.getView<TextView>(R.id.view_item_routing_bottom_line).height =
                SizeUtils.dp2px(80F)
            helper.setText(R.id.tv_item_des, "${childNode?.size}站")
        } else {
            helper.setGone(R.id.tv_item_des, true)
            helper.getView<TextView>(R.id.view_item_routing_bottom_line).height =
                SizeUtils.dp2px(40F)
        }

        helper.setText(R.id.tv_item_title, item.title)

        helper.getView<TextView>(R.id.tv_item_title).setOnClickListener {
            getAdapter()?.expandOrCollapse(helper.adapterPosition)
        }

    }

    override fun onClick(helper: BaseViewHolder, view: View, data: BaseNode, position: Int) {
//        getAdapter()?.expandOrCollapse(position, true, true, 110)
    }
}