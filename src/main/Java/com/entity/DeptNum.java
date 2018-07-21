package com.entity;

public class DeptNum {
    private String dept_name;
    private int count;

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DeptNum() {

    }

    public DeptNum(String dept_name, int count) {

        this.dept_name = dept_name;
        this.count = count;
    }
}
