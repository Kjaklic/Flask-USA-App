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

package com.rumbasolutions.flask.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for FlaskGroupUsers. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupUsersServiceUtil
 * @see com.rumbasolutions.flask.service.base.FlaskGroupUsersServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.FlaskGroupUsersServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface FlaskGroupUsersService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskGroupUsersServiceUtil} to access the flask group users remote service. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.FlaskGroupUsersServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> getAllGroupUsers(
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGroupUsersCount(long groupId);

	public com.rumbasolutions.flask.model.FlaskGroupUsers addGroupUser(
		long groupId, long userId, java.lang.String userName,
		java.lang.String emailAddress, int isAdmin);

	public com.rumbasolutions.flask.model.FlaskGroupUsers updateGroupUser(
		long groupUserId, long groupId, long userId, java.lang.String userName,
		java.lang.String emailAddress, int isAdmin);

	public int addGroupOwner(long groupId, long userId);

	public void removeGroupOwner(long groupId, long userId);

	public boolean deleteGroupUser(long groupId, long userId);

	public boolean deleteGroupUsers(long groupId, java.lang.String userIds);
}