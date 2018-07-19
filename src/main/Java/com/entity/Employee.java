package com.entity;

public class Employee {
    private Integer emp_id;
    private String emp_name;
    private String gender;
    private String email;
    private Integer dId;

    public Employee() {
    }

    public Employee(Integer emp_id, String emp_name, String gender, String email, Integer dId) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }



    public Employee(String emp_name, String gender, String email, Integer dId) {
        this.emp_name = emp_name;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }

    public Integer getdId() {

        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }


    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmp_id() {

        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {

        return email;
    }
}
