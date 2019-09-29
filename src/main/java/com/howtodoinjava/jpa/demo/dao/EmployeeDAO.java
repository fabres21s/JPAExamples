package com.howtodoinjava.jpa.demo.dao;
 
import java.util.List;
import com.howtodoinjava.jpa.demo.entity.EmployeeEntity;
 
public interface EmployeeDAO
{
    public List<EmployeeEntity> getAllEmployees();
    public List<EmployeeEntity> getAllEmployeesByDeptId(Integer id);
    public EmployeeEntity getEmployeeById(Integer id);
    public boolean addEmployee(EmployeeEntity employee);
    public boolean removeEmployee(EmployeeEntity employee);
    public boolean removeAllEmployees();
}