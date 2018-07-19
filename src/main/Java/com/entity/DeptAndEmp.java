package com.entity;

public class DeptAndEmp {
    private Integer dept_id;
    private Integer dId;
    private String dept_name;
    private Integer emp_id;
    private String emp_name;
    private String gender;
    private String email;
    public Integer getDept_id() {
        return dept_id;
    }

    public Integer getdId() {
        return dId;
    }
    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public DeptAndEmp(int dept_id, Integer dId, String dept_name, int emp_id, String emp_name, String gender, String email) {
        this.dept_id = dept_id;
        this.dId = dId;
        this.dept_name = dept_name;
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.gender = gender;
        this.email = email;
    }
    public DeptAndEmp() {
    }
    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public void setDept_id(Integer dept_id) { this.dept_id = dept_id; }

    public Integer getEmp_id() {return emp_id; }

    public void setEmp_id(Integer emp_id) { this.emp_id = emp_id; }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
