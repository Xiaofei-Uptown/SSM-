package com.Service;

import com.Dao.Employeedao;
import com.entity.DeptAndEmp;
import com.entity.DeptNum;
import com.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    Employeedao employeedao;

    public void deleteEmp(Integer id){
        employeedao.delete(id);
    }

    public List<DeptAndEmp> getAll(){

        return employeedao.selectEmpandDept();
    }
    public void saveEmp(Employee employee){

        employeedao.insert(employee);
    }
    public Employee getEmp(Integer id){

         return employeedao.get(id);
    }
    public void updateEmp(Employee employee){

        employeedao.update(employee);
    }
    public List<DeptNum> selectPeople(){

        return employeedao.findDept();
    }



}
