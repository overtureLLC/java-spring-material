package com.ascending.training.jdbc;

import com.ascending.training.model.Department;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DepartmentDaoTest {
    @Test
    public void testFindAllOrderedByName() {
        DepartmentDao departmentDao = new DepartmentDao();
        List<Department> departments = departmentDao.getDepartments();
        int expectedNumOfDept = 4;

        for (Department department : departments) {
            System.out.println(department);
        }

        Assert.assertEquals(expectedNumOfDept, departments.size());
    }
}