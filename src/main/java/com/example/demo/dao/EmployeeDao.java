package com.example.demo.dao;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeDao {

    private  static Map<Integer,Employee> employees=null;
    @Autowired
    private  DepartmentDao departmentDao;
    static {
        employees=new HashMap <Integer, Employee> (  );
        employees.put (1002,new Employee (1002, "BB","2864483641@qq.com",2,new Department ( 101,"后勤部" )));
        employees.put (1001,new Employee (1001, "AA","2864483641@qq.com",1,new Department ( 101,"后勤部" )));
        employees.put (1003,new Employee (1003, "CC","2864483641@qq.com",2,new Department ( 102,"技术部" )));
        employees.put (1004,new Employee (1004, "DD","2864483641@qq.com",1,new Department ( 102,"技术部" )));
    }
    private static Integer initId=1005;
    public  void  save(Employee employee)
    {
        if (employee.getId ()==null)
        {
            //模拟实现底层数据库自增
            employee.setId ( initId++ );
        }
        employee.setDepartment ( departmentDao.getDepartmentById ( employee.getDepartment ().getId () ) );
        employees.put ( employee.getId (),employee );
    }
    public Collection<Employee> getAll(){
        return employees.values ();
    }
    public Employee getEmployById(Integer id){
        return employees.get ( id );
    }

    public  void delete(Integer id){
        employees.remove ( id );
    }
}
