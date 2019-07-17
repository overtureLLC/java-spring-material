package com.ascending.training.repository;

import com.ascending.training.model.Department;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class MappingClassesTest {
    @Test
    public void mappingClassTest() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Department department = session.get(Department.class, 1L);
            Assert.assertNotNull(department);
        }
    }
}