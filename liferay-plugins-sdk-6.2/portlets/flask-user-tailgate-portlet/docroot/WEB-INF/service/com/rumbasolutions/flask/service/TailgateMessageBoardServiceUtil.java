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
 * Provides the remote service utility for TailgateMessageBoard. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.TailgateMessageBoardServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMessageBoardService
 * @see com.rumbasolutions.flask.service.base.TailgateMessageBoardServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.TailgateMessageBoardServiceImpl
 * @generated
 */
public class TailgateMessageBoardServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.TailgateMessageBoardServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.rumbasolutions.flask.model.TailgateMessageBoard addMessageBoard(
		java.lang.String messageText, long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addMessageBoard(messageText, tailgateId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.TailgateMessageBoard updateMessageBoard(
		long tailgateMessageId, java.lang.String messageText, long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateMessageBoard(tailgateMessageId, messageText,
			tailgateId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.TailgateMessageBoard getTailgMessageBoard(
		long tailgateMessageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .getTailgMessageBoard(tailgateMessageId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> getAllTailgateMessageBoards(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getAllTailgateMessageBoards(serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> getMessageBoardsByTailgateId(
		long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .getMessageBoardsByTailgateId(tailgateId, serviceContext);
	}

	public static void deleteMessageBoard(long tailgateMessageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteMessageBoard(tailgateMessageId, serviceContext);
	}

	public static void deleteMyMessageBoards(
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteMyMessageBoards(serviceContext);
	}

	public static void deleteBoardsByTailgateId(long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteBoardsByTailgateId(tailgateId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TailgateMessageBoardService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TailgateMessageBoardService.class.getName());

			if (invokableService instanceof TailgateMessageBoardService) {
				_service = (TailgateMessageBoardService)invokableService;
			}
			else {
				_service = new TailgateMessageBoardServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(TailgateMessageBoardServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TailgateMessageBoardService service) {
	}

	private static TailgateMessageBoardService _service;
}