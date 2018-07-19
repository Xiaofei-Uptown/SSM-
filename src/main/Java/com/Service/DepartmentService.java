package com.Service;

import com.Dao.Departmentdao;
import com.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private Departmentdao departmentdao;

    public List<Department> selectDepts(){
        List<Department> list = departmentdao.selectAll();
        System.out.println(list);
        return list;
    }
}
