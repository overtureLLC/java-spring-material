/*
 * Test Case
 */
package com.ascending.training.repository;

import com.ascending.training.model.Department;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class DepartmentDaoTest {
    private DepartmentDao departmentDao;

    @Before
    public void init() {
        departmentDao = new DepartmentDao();
    }

    @Test
    public void getDepartments() {
        List<Department> departments = departmentDao.getDepartments();
        int expectedNumOfDept = 4;

        for (Department department : departments) {
            System.out.println(department);
        }

        Assert.assertEquals(expectedNumOfDept, departments.size());
    }

    @Test
    public void getDepartmentByName() {
        String deptName = "R&D";
        Department department = departmentDao.getDepartmentByName(deptName);
        Assert.assertEquals(deptName, department.getName());
    }

    @Test
    public void updateDepartmentLocation() {
        String deptName = "R&D";
        String location = "11126 Fairhaven Court, Fairfax, VA";
        departmentDao.updateDepartmentLocation(deptName, location);
        Department department = departmentDao.getDepartmentByName(deptName);
        Assert.assertEquals(location, department.getLocation());
    }
}


/*
 * Test Suite
 */
package com.ascending.training.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DepartmentDaoTest.class,
        EmployeeDaoTest.class,
        AccountDaoTest.class
})

public class TestAll {
} 

/*
 * Test Runner 
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public final static Logger logger = Logger.getLogger(TestRunner.class);
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestAll.class);

        for (Failure failure : result.getFailures()) {
            logger.error(failure.toString());
        }
		
        logger.info(result.wasSuccessful());
    }
}