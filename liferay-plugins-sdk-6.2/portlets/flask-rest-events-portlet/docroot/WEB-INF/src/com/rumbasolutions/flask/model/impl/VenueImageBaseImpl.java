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

package com.rumbasolutions.flask.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.rumbasolutions.flask.model.VenueImage;
import com.rumbasolutions.flask.service.VenueImageLocalServiceUtil;

/**
 * The extended model base implementation for the VenueImage service. Represents a row in the &quot;flaskevents_VenueImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VenueImageImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueImageImpl
 * @see com.rumbasolutions.flask.model.VenueImage
 * @generated
 */
public abstract class VenueImageBaseImpl extends VenueImageModelImpl
	implements VenueImage {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a venue image model instance should use the {@link VenueImage} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VenueImageLocalServiceUtil.addVenueImage(this);
		}
		else {
			VenueImageLocalServiceUtil.updateVenueImage(this);
		}
	}
}