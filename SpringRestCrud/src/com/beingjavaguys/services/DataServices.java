package com.beingjavaguys.services;

import java.util.List;

import com.beingjavaguys.model.Employee;

/**
 * 
 *
 */
public interface DataServices {
	/**
	 * @param employee
	 * @return boolean
	 * @throws Exception
	 */
	public abstract boolean addEntity(final Employee employee) throws Exception;

	/**
	 * @param employeeID
	 * @return Employee
	 * @throws Exception
	 */
	public abstract Employee getEntityById(final long employeeID)
			throws Exception;

	/**
	 * @return List<Employee>
	 * @throws Exception
	 */
	public abstract List<Employee> getEntityList() throws Exception;

	/**
	 * @param employeeID
	 * @return boolean
	 * @throws Exception
	 */
	public abstract boolean deleteEntity(final long employeeID)
			throws Exception;
}
