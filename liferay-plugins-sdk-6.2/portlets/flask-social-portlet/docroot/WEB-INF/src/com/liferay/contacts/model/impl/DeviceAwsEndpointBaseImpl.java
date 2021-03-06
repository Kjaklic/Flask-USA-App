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

package com.liferay.contacts.model.impl;

import com.liferay.contacts.model.DeviceAwsEndpoint;
import com.liferay.contacts.service.DeviceAwsEndpointLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the DeviceAwsEndpoint service. Represents a row in the &quot;Contacts_DeviceAwsEndpoint&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DeviceAwsEndpointImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeviceAwsEndpointImpl
 * @see com.liferay.contacts.model.DeviceAwsEndpoint
 * @generated
 */
public abstract class DeviceAwsEndpointBaseImpl
	extends DeviceAwsEndpointModelImpl implements DeviceAwsEndpoint {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a device aws endpoint model instance should use the {@link DeviceAwsEndpoint} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DeviceAwsEndpointLocalServiceUtil.addDeviceAwsEndpoint(this);
		}
		else {
			DeviceAwsEndpointLocalServiceUtil.updateDeviceAwsEndpoint(this);
		}
	}
}