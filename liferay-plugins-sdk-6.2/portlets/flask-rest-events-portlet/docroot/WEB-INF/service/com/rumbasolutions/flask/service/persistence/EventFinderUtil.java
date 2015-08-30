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

package com.rumbasolutions.flask.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Ashutosh Rai
 */
public class EventFinderUtil {
	public static java.util.List<com.rumbasolutions.flask.model.Event> getSimpleFilteredEvents(
		java.lang.String eventTypeIds, java.lang.String startDate,
		java.lang.String endDate, java.lang.String stringFilter,
		java.util.Map<java.lang.String, java.lang.Double> geoRange) {
		return getFinder()
				   .getSimpleFilteredEvents(eventTypeIds, startDate, endDate,
			stringFilter, geoRange);
	}

	public static EventFinder getFinder() {
		if (_finder == null) {
			_finder = (EventFinder)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					EventFinder.class.getName());

			ReferenceRegistry.registerReference(EventFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(EventFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(EventFinderUtil.class, "_finder");
	}

	private static EventFinder _finder;
}