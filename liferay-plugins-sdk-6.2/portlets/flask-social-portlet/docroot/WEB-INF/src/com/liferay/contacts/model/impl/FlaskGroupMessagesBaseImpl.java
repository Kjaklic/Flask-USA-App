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

import com.liferay.contacts.model.FlaskGroupMessages;
import com.liferay.contacts.service.FlaskGroupMessagesLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the FlaskGroupMessages service. Represents a row in the &quot;Contacts_FlaskGroupMessages&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FlaskGroupMessagesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupMessagesImpl
 * @see com.liferay.contacts.model.FlaskGroupMessages
 * @generated
 */
public abstract class FlaskGroupMessagesBaseImpl
	extends FlaskGroupMessagesModelImpl implements FlaskGroupMessages {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a flask group messages model instance should use the {@link FlaskGroupMessages} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FlaskGroupMessagesLocalServiceUtil.addFlaskGroupMessages(this);
		}
		else {
			FlaskGroupMessagesLocalServiceUtil.updateFlaskGroupMessages(this);
		}
	}
}