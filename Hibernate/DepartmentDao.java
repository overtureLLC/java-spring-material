package com.ascending.training.repository;

import com.ascending.training.model.Department;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class DepartmentDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void save(Department department) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        logger.debug(String.format("The department %s was inserted into the table.", department.toString()));
    }

    public int updateDepartmentLocation(String deptName, String location) {
        String hql = "UPDATE Department as dept set dept.location = :location where dept.name = :name";
        int updatedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Department> query = session.createQuery(hql);
            query.setParameter("name", deptName);
            query.setParameter("location", location);

            transaction = session.beginTransaction();
            updatedCount = query.executeUpdate();
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        logger.debug(String.format("The department %s was updated, total updated record(s): %d", deptName, updatedCount));

        return updatedCount;
    }

    public int deleteDepartment(String deptName) {
        String hql = "DELETE Department name = :deptName";
        int deletedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Department> query = session.createQuery(hql);
            query.setParameter("deptName", deptName);

            transaction = session.beginTransaction();
            deletedCount = query.executeUpdate();
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        logger.debug(String.format("The department %s was deleted, total deleted record(s): %d", deptName, deletedCount));

        return deletedCount;
    }

    public List<Department> getDepartments() {
        String hql = "FROM Department";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Department> query = session.createQuery(hql);
            return query.list();
        }
    }

    public Department getDepartmentByName(String deptName) {
        String hql = "FROM Department as dept where dept.name = :name";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Department> query = session.createQuery(hql);
            query.setParameter("name", deptName);

            return query.uniqueResult();
        }
    }
}
