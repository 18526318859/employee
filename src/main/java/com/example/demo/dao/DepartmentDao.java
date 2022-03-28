package com.example.demo.dao;

import com.example.demo.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component

public class DepartmentDao {
    @Autowired
    //模拟数据
    private static Map<Integer,Department> departments=null;
    static {
       departments = new HashMap <Integer,Department>( );
       departments.put ( 101,new Department (101,"后勤部") );

        departments.put ( 102,new Department (102,"技术部") );

    }
    public Collection<Department> getDepartments()
    {
        return departments.values ();
    }
    public  Department getDepartmentById(Integer id)
    {
        return departments.get ( id );
    }

}
