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

package com.liferay.contacts.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for FlaskMessages. This utility wraps
 * {@link com.liferay.contacts.service.impl.FlaskMessagesServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskMessagesService
 * @see com.liferay.contacts.service.base.FlaskMessagesServiceBaseImpl
 * @see com.liferay.contacts.service.impl.FlaskMessagesServiceImpl
 * @generated
 */
public class FlaskMessagesServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contacts.service.impl.FlaskMessagesServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.contacts.model.FlaskMessages sendFlaskMessage(
		java.lang.String recipients, java.lang.String message,
		boolean sendEmail,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .sendFlaskMessage(recipients, message, sendEmail,
			serviceContext);
	}

	public static boolean sendSnsEmail(java.lang.String subject,
		java.lang.String message) {
		return getService().sendSnsEmail(subject, message);
	}

	public static com.liferay.portal.kernel.json.JSONArray getAllMyFlaskMessages(
		long receiverId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getAllMyFlaskMessages(receiverId, serviceContext);
	}

	public static java.util.List<com.liferay.contacts.model.FlaskMessages> getMyUnreadFlaskMessages(
		long receiverId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getMyUnreadFlaskMessages(receiverId, serviceContext);
	}

	public static int getMyFlaskMessagesCount(long receiverId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getMyFlaskMessagesCount(receiverId, serviceContext);
	}

	public static int getMyUnreadFlaskMessagesCount(long receiverId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .getMyUnreadFlaskMessagesCount(receiverId, serviceContext);
	}

	public static int getTotalUnreadChatCount(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getTotalUnreadChatCount(serviceContext);
	}

	public static void deleteMessage(long messageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteMessage(messageId, serviceContext);
	}

	public static void deleteMessagesByDateRange(java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.deleteMessagesByDateRange(startDate, endDate, serviceContext);
	}

	public static boolean deleteMyChatMessages(java.lang.Long[] messageIds,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().deleteMyChatMessages(messageIds, serviceContext);
	}

	public static boolean registerWithSNS(long userId,
		java.lang.String userEmail, java.lang.String devicePlatform,
		java.lang.String deviceDetails, java.lang.String deviceToken,
		java.util.Date registrationTime, java.lang.Boolean active,
		java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .registerWithSNS(userId, userEmail, devicePlatform,
			deviceDetails, deviceToken, registrationTime, active,
			lastNotificationTime, lastNotificationMsg, serviceContext);
	}

	public static boolean sendPush(long userId, java.lang.String title,
		java.lang.String message, java.lang.String infoType,
		java.util.Map<java.lang.String, java.lang.Object> infoDataMap,
		long notId) {
		return getService()
				   .sendPush(userId, title, message, infoType, infoDataMap,
			notId);
	}

	public static void clearService() {
		_service = null;
	}

	public static FlaskMessagesService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FlaskMessagesService.class.getName());

			if (invokableService instanceof FlaskMessagesService) {
				_service = (FlaskMessagesService)invokableService;
			}
			else {
				_service = new FlaskMessagesServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(FlaskMessagesServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FlaskMessagesService service) {
	}

	private static FlaskMessagesService _service;
}