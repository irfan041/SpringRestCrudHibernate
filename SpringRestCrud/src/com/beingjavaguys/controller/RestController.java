package com.beingjavaguys.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beingjavaguys.model.Employee;
import com.beingjavaguys.model.Status;
import com.beingjavaguys.services.DataServices;

/**
 * 
 *
 */
@Controller
@RequestMapping("/employee")
public class RestController {

	@Autowired
	private DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	/**
	 * @param employee
	 * @return Status
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addEmployee(final @RequestBody Employee employee) {
		final String METHOD_NAME = "addEmployee";
		System.out.println("create Method");
		logger.info("Method Invoked:" + METHOD_NAME + ":" + employee);
		Status status = null;
		try {
			dataServices.addEntity(employee);
			status = new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			status = new Status(0, e.toString());
		}
		logger.info("Response From The Method:" + METHOD_NAME + ":" + status);
		return status;
	}

	/**
	 * @param employeeID
	 * @return Employee
	 */
	@RequestMapping(value = "/{employeeID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee getEmployee(
			@PathVariable("employeeID") final long employeeID) {
		Employee employee = null;
		final String METHOD_NAME = "getEmployee";
		logger.info("Method Invoked:" + METHOD_NAME + ":" + employeeID);
		try {
			employee = dataServices.getEntityById(employeeID);

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Response From The Method:" + METHOD_NAME + ":" + employee);
		return employee;
	}

	/**
	 * @return List<Employee>
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> getEmployee() {
		final String METHOD_NAME = "getEmployee";
		logger.info("Method Invoked:" + METHOD_NAME);
		List<Employee> employeeList = null;
		try {
			employeeList = dataServices.getEntityList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Response From The Method:" + METHOD_NAME + ":"
				+ employeeList);
		return employeeList;
	}

	/**
	 * @param employeeID
	 * @return Status
	 */
	@RequestMapping(value = "delete/{employeeID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status deleteEmployee(
			@PathVariable("employeeID") final long employeeID) {
		final String METHOD_NAME = "deleteEmployee";
		logger.info("Method Invoked:" + METHOD_NAME + ":" + employeeID);
		Status status = null;
		try {
			dataServices.deleteEntity(employeeID);
			status = new Status(1, "Employee deleted Successfully !");
		} catch (Exception e) {
			status = new Status(0, e.toString());
		}
		logger.info("Response From The Method:" + METHOD_NAME + ":" + status);
		return status;
	}
}
