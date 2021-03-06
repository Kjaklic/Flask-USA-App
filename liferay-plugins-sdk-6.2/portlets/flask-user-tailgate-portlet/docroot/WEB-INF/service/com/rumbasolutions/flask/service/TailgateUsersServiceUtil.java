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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for TailgateUsers. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.TailgateUsersServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateUsersService
 * @see com.rumbasolutions.flask.service.base.TailgateUsersServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.TailgateUsersServiceImpl
 * @generated
 */
public class TailgateUsersServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.TailgateUsersServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateUsers> getTailgateMembers(
		long tailgateId) {
		return getService().getTailgateMembers(tailgateId);
	}

	public static boolean isTailgateAdmin(long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().isTailgateAdmin(tailgateId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateUsers> getTailgateGroups(
		long tailgateId, long groupId) {
		return getService().getTailgateGroups(tailgateId, groupId);
	}

	public static boolean checkTailgateUserExist(long tailgateId, long userId) {
		return getService().checkTailgateUserExist(tailgateId, userId);
	}

	public static com.rumbasolutions.flask.model.TailgateUsers addTailgateUser(
		long tailgateId, long userId, java.lang.String userName,
		java.lang.String emailAddress, int isAdmin, boolean isPaid,
		java.lang.String paymentMode, int groupId) {
		return getService()
				   .addTailgateUser(tailgateId, userId, userName, emailAddress,
			isAdmin, isPaid, paymentMode, groupId);
	}

	public static com.rumbasolutions.flask.model.TailgateUsers updateTailgateUser(
		long userId, long tailgateId, boolean isPaid,
		java.lang.String paymentMode, java.lang.String description) {
		return getService()
				   .updateTailgateUser(userId, tailgateId, isPaid, paymentMode,
			description);
	}

	public static int updateTailgateUserRole(long userId, long tailgateId) {
		return getService().updateTailgateUserRole(userId, tailgateId);
	}

	public static void deleteTailgateUser(long tailgateId, long userId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteTailgateUser(tailgateId, userId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TailgateUsersService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TailgateUsersService.class.getName());

			if (invokableService instanceof TailgateUsersService) {
				_service = (TailgateUsersService)invokableService;
			}
			else {
				_service = new TailgateUsersServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(TailgateUsersServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TailgateUsersService service) {
	}

	private static TailgateUsersService _service;
}