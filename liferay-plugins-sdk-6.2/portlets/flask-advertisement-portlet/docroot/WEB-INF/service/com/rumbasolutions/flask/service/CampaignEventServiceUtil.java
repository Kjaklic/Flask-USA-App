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
 * Provides the remote service utility for CampaignEvent. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.CampaignEventServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignEventService
 * @see com.rumbasolutions.flask.service.base.CampaignEventServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.CampaignEventServiceImpl
 * @generated
 */
public class CampaignEventServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.CampaignEventServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> getCampaignEvents(
		long campaignId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getCampaignEvents(campaignId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> getEventCampaigns(
		long eventId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getEventCampaigns(eventId, serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONObject getEventCampaignImages(
		java.lang.String eventIdList,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getEventCampaignImages(eventIdList, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static CampaignEventService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CampaignEventService.class.getName());

			if (invokableService instanceof CampaignEventService) {
				_service = (CampaignEventService)invokableService;
			}
			else {
				_service = new CampaignEventServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(CampaignEventServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CampaignEventService service) {
	}

	private static CampaignEventService _service;
}