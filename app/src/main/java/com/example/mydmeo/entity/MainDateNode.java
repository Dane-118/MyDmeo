package com.example.mydmeo.entity;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.example.mydmeo.bean.Student;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangdongdong
 * @description:
 * @date : 2020/9/23 10:56
 */
public class MainDateNode extends BaseExpandNode {

    private List<MainChildNode> childNode;
    private String title;

    public MainDateNode(List<MainChildNode> childNode, String title) {
        this.childNode = childNode;
        this.title = title;
        setExpanded(false);
    }

    public String getTitle(){
        return title;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        List<BaseNode> childNode = new ArrayList<BaseNode>(this.childNode);
        return childNode;
    }
}
