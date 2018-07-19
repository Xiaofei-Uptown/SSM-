package com.Dao;

import com.entity.DeptAndEmp;
import com.entity.Employee;

import java.util.List;

public interface Employeedao {
    public Employee get(int id);

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public Employee get(Employee entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：com.entity.setPage(new Page<T>());
     * @param
     * @return
     */
    public List<Employee> findList();


   // public Employee selsectEmpandDeptByID(Employee entity);



    public List<DeptAndEmp> selectEmpandDept();
    /**
     * 插入数据
     * @param entity
     * @return
     */
    public void insert(Employee entity);



    /**
     * 更新数据
     * @param entity
     * @return
     */
    public void update(Employee entity);


    /**
     * 删除数据（一般为逻辑删除，更
     * 新del_flag字段为1）
     * @param id
     * @see public int delete(T com.entity)
     * @return
     */
    @Deprecated
    public int delete(Integer id);

    /**
     * 删除数据
     * @param entity
     * @return
     */

}
