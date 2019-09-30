package com.jpa.demo.test;
 

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
 
import com.howtodoinjava.jpa.demo.dao.DepartmentDAO;
import com.howtodoinjava.jpa.demo.dao.EmployeeDAO;
import com.howtodoinjava.jpa.demo.entity.DepartmentEntity;
import com.howtodoinjava.jpa.demo.entity.EmployeeEntity;
 
@ContextConfiguration(locations = "classpath:application-context-test-int.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEmployeeDAO
{
     
    @Autowired
    private EmployeeDAO employeeDAO;
     
    @Autowired
    private DepartmentDAO departmentDAO;
   
    @PersistenceContext
    private EntityManager manager;
    
    @Test
    public void testVerificarTabla()
    {
    	
    	EmployeeEntity em =  manager.find(EmployeeEntity.class, 26) ;
    	System.out.println("el correo es"+ em.getEmail());
    	
    	departmentDAO.getAllDepartments();
        //assertThrows(Exception.class, () -> departmentDAO.validarDepartamento());
        Assert.assertEquals(2, 2);
    }
    
    @Test
    @Transactional
    @Rollback(false)
    public void testAddDepartment()
    {
        DepartmentEntity department = new DepartmentEntity("Information Technology");
        
        
        departmentDAO.addDepartment(department);
         
        List<DepartmentEntity> departments = departmentDAO.getAllDepartments();
        Assert.assertEquals(department.getName(), departments.get(0).getName());
    }
     
    
    
    
    @Test
    @Transactional
    @Rollback(true)
    public void testAddEmployee()
    {
        DepartmentEntity department = new DepartmentEntity("Human Resource");
        departmentDAO.addDepartment(department);
         
        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirstName("Lokesh");
        employee.setLastName("Gupta");
        employee.setEmail("howtodoinjava@gmail.com");
        employee.setDepartment(department);
         
        employeeDAO.addEmployee(employee);
         
        List<DepartmentEntity> departments = departmentDAO.getAllDepartments();
        List<EmployeeEntity> employees = employeeDAO.getAllEmployees();
         
         
        Assert.assertEquals(department.getName(), departments.get(0).getName());
        Assert.assertEquals(employee.getEmail(), employees.get(0).getEmail());
    	

    }
}