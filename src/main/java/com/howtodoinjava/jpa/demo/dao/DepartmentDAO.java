package com.howtodoinjava.jpa.demo.dao;
 
import java.util.List;
import com.howtodoinjava.jpa.demo.entity.DepartmentEntity;
 
public interface DepartmentDAO
{
    public List<DepartmentEntity> getAllDepartments();
    public DepartmentEntity getDepartmentById(Integer id);
    public boolean addDepartment(DepartmentEntity dept);
    public boolean removeDepartment(DepartmentEntity dept);
    public boolean removeAllDepartments();
    
    public void validarDepartamento() throws Exception;
}
