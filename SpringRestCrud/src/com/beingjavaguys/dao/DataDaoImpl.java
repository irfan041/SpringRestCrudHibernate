package com.beingjavaguys.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.beingjavaguys.model.Employee;

/**
 * 
 *
 */
@Repository
public class DataDaoImpl implements DataDao {
	static final Logger logger = Logger.getLogger(DataDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addEntity(final Employee employee) throws Exception {
		final String METHOD_NAME = "addEntity()";
		logger.info("Method Invoked:" + METHOD_NAME + ":" + employee);
		Session session = null;
		Transaction transaction = null;
		boolean regFlag = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			regFlag = true;
		} catch (DataAccessException e) {
			// e.printStackTrace();
			transaction.rollback();
			logger.error(e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (DataAccessException e) {
				// e.printStackTrace();
				logger.fatal(e.getMessage());
			}
		}
		logger.info("Response From The Method:" + METHOD_NAME + ":" + regFlag);

		return regFlag;
	}

	@Override
	public Employee getEntityById(final long employeeID) throws Exception {
		final String METHOD_NAME = "getEntityById()";
		logger.info("Method Invoked:" + METHOD_NAME + ":" + employeeID);
		Employee employee = null;
		// System.out.println("From DAO getEntityById Method:" + employeeID);
		Session session = null;

		try {
			session = sessionFactory.openSession();
			employee = (Employee) session.load(Employee.class, new Long(
					employeeID));
			// System.out.println("From DAO:" + employee);
			logger.info(employee);
		} catch (DataAccessException e) {
			// e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (DataAccessException e) {
				logger.fatal(e.getMessage());
			}
		}
		logger.info("Response From The Method:" + METHOD_NAME + ":" + employee);
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEntityList() throws Exception {
		final String METHOD_NAME = " getEntityList()";
		logger.info("Method Invoked:" + METHOD_NAME);
		List<Employee> employeeList = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			employeeList = session.createCriteria(Employee.class).list();
		} catch (DataAccessException e) {
			// e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (DataAccessException e) {
				// e.printStackTrace();
				logger.fatal(e.getMessage());
			}
		}
		logger.info("Response From The Method:" + METHOD_NAME + ":"
				+ employeeList);
		return employeeList;
	}

	@Override
	public boolean deleteEntity(final long employeeID) throws Exception {
		boolean deletionFlag = false;
		final String METHOD_NAME = " deleteEntity()";
		logger.info("Method Invoked:" + METHOD_NAME + ":" + employeeID);
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			Object object = session.load(Employee.class, employeeID);
			transaction = session.getTransaction();
			session.beginTransaction();
			session.delete(object);
			transaction.commit();
			deletionFlag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (DataAccessException e) {
				// e.printStackTrace();
				logger.fatal(e.getMessage());
			}
		}
		logger.info("Response From The Method:" + METHOD_NAME + ":"
				+ deletionFlag);
		return deletionFlag;
	}

}
