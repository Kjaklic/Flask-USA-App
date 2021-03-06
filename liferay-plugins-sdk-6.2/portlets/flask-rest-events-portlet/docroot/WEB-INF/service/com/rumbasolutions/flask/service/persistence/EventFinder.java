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

/**
 * @author Ashutosh Rai
 */
public interface EventFinder {
	public java.util.List<com.rumbasolutions.flask.model.Event> getSimpleFilteredEvents(
		java.lang.String eventTypeIds, java.lang.String startDate,
		java.lang.String endDate, java.lang.String stringFilter,
		java.util.Map<java.lang.String, java.lang.Double> geoRange);
}