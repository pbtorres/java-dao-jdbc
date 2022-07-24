package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	
	void insert(Department obj);
	void update(Department obj);
	void deleteByID(Integer id);
	Department findById(Department id);
	List<Department> findall();
	
}
