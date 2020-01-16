package com.beingjavaguys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beingjavaguys.dao.DataDao;
import com.beingjavaguys.model.Employee;

/**
 * 
 *
 */
@Service
public class DataServicesImpl implements DataServices {

	// static final Logger logger = Logger.getLogger(DataServicesImpl.class);
	/**
	 * 
	 */
	@Autowired
	private DataDao dataDao;

	@Override
	public boolean addEntity(final Employee employee) throws Exception {
		return dataDao.addEntity(employee);
	}

	@Override
	public Employee getEntityById(final long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Employee> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(final long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
