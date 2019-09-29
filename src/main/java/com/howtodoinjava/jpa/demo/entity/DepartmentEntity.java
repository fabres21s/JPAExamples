package com.howtodoinjava.jpa.demo.entity;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity(name="DepartmentEntity")
@Table (name="department")
@NamedQueries({
	@NamedQuery(
			name = DepartmentEntity.CONSULTAR_DEPARTAMENTO,
			query = "Select d FROM DepartmentEntity d  "
	)
})
public class DepartmentEntity implements Serializable {
  
	public static final String CONSULTAR_DEPARTAMENTO = "ConsultarDepartamento";
	
    private static final long serialVersionUID = 1L;
      
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Date creationDate;
      
    public DepartmentEntity(){
    }
  
    public DepartmentEntity(String name) {
        super();
        this.name = name;
        this.creationDate = new Date();
    }
      
    @OneToMany(mappedBy="department",cascade=CascadeType.PERSIST)
    private List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();
      
    //Setters and Getters
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}
	
    @Override
    public String toString() {
        return "DepartmentVO [id=" + id + ", name=" + name + "]";
    }

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}