package com.example.mydmeo.entity;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.example.mydmeo.bean.Student;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author fangdongdong
 * @description:
 * @date : 2020/9/23 11:01
 */
public class MainChildNode extends BaseExpandNode {

    private Student student;

    public MainChildNode(Student student) {
        this.student = student;
        setExpanded(false);
    }

    public Student getStudent() {
        return student;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}
