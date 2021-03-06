/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rumbasolutions.flask.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rumbasolutions.flask.model.FlaskAdmin;
import com.rumbasolutions.flask.service.FlaskAdminService;
import com.rumbasolutions.flask.service.persistence.FlaskAdminPersistence;
import com.rumbasolutions.flask.service.persistence.FlaskRolePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the flask admin remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rumbasolutions.flask.service.impl.FlaskAdminServiceImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.impl.FlaskAdminServiceImpl
 * @see com.rumbasolutions.flask.service.FlaskAdminServiceUtil
 * @generated
 */
public abstract class FlaskAdminServiceBaseImpl extends BaseServiceImpl
	implements FlaskAdminService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rumbasolutions.flask.service.FlaskAdminServiceUtil} to access the flask admin remote service.
	 */

	/**
	 * Returns the flask admin remote service.
	 *
	 * @return the flask admin remote service
	 */
	public com.rumbasolutions.flask.service.FlaskAdminService getFlaskAdminService() {
		return flaskAdminService;
	}

	/**
	 * Sets the flask admin remote service.
	 *
	 * @param flaskAdminService the flask admin remote service
	 */
	public void setFlaskAdminService(
		com.rumbasolutions.flask.service.FlaskAdminService flaskAdminService) {
		this.flaskAdminService = flaskAdminService;
	}

	/**
	 * Returns the flask admin persistence.
	 *
	 * @return the flask admin persistence
	 */
	public FlaskAdminPersistence getFlaskAdminPersistence() {
		return flaskAdminPersistence;
	}

	/**
	 * Sets the flask admin persistence.
	 *
	 * @param flaskAdminPersistence the flask admin persistence
	 */
	public void setFlaskAdminPersistence(
		FlaskAdminPersistence flaskAdminPersistence) {
		this.flaskAdminPersistence = flaskAdminPersistence;
	}

	/**
	 * Returns the flask role remote service.
	 *
	 * @return the flask role remote service
	 */
	public com.rumbasolutions.flask.service.FlaskRoleService getFlaskRoleService() {
		return flaskRoleService;
	}

	/**
	 * Sets the flask role remote service.
	 *
	 * @param flaskRoleService the flask role remote service
	 */
	public void setFlaskRoleService(
		com.rumbasolutions.flask.service.FlaskRoleService flaskRoleService) {
		this.flaskRoleService = flaskRoleService;
	}

	/**
	 * Returns the flask role persistence.
	 *
	 * @return the flask role persistence
	 */
	public FlaskRolePersistence getFlaskRolePersistence() {
		return flaskRolePersistence;
	}

	/**
	 * Sets the flask role persistence.
	 *
	 * @param flaskRolePersistence the flask role persistence
	 */
	public void setFlaskRolePersistence(
		FlaskRolePersistence flaskRolePersistence) {
		this.flaskRolePersistence = flaskRolePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return FlaskAdmin.class;
	}

	protected String getModelClassName() {
		return FlaskAdmin.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = flaskAdminPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rumbasolutions.flask.service.FlaskAdminService.class)
	protected com.rumbasolutions.flask.service.FlaskAdminService flaskAdminService;
	@BeanReference(type = FlaskAdminPersistence.class)
	protected FlaskAdminPersistence flaskAdminPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.FlaskRoleService.class)
	protected com.rumbasolutions.flask.service.FlaskRoleService flaskRoleService;
	@BeanReference(type = FlaskRolePersistence.class)
	protected FlaskRolePersistence flaskRolePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private FlaskAdminServiceClpInvoker _clpInvoker = new FlaskAdminServiceClpInvoker();
}