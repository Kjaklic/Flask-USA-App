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

package com.liferay.contacts.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the NotificationAuditLog service. Represents a row in the &quot;Contacts_NotificationAuditLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.contacts.model.impl.NotificationAuditLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.contacts.model.impl.NotificationAuditLogImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationAuditLog
 * @see com.liferay.contacts.model.impl.NotificationAuditLogImpl
 * @see com.liferay.contacts.model.impl.NotificationAuditLogModelImpl
 * @generated
 */
public interface NotificationAuditLogModel extends BaseModel<NotificationAuditLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a notification audit log model instance should use the {@link NotificationAuditLog} interface instead.
	 */

	/**
	 * Returns the primary key of this notification audit log.
	 *
	 * @return the primary key of this notification audit log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this notification audit log.
	 *
	 * @param primaryKey the primary key of this notification audit log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the notification audit log ID of this notification audit log.
	 *
	 * @return the notification audit log ID of this notification audit log
	 */
	public long getNotificationAuditLogId();

	/**
	 * Sets the notification audit log ID of this notification audit log.
	 *
	 * @param notificationAuditLogId the notification audit log ID of this notification audit log
	 */
	public void setNotificationAuditLogId(long notificationAuditLogId);

	/**
	 * Returns the sender email of this notification audit log.
	 *
	 * @return the sender email of this notification audit log
	 */
	@AutoEscape
	public String getSenderEmail();

	/**
	 * Sets the sender email of this notification audit log.
	 *
	 * @param senderEmail the sender email of this notification audit log
	 */
	public void setSenderEmail(String senderEmail);

	/**
	 * Returns the receiver email of this notification audit log.
	 *
	 * @return the receiver email of this notification audit log
	 */
	@AutoEscape
	public String getReceiverEmail();

	/**
	 * Sets the receiver email of this notification audit log.
	 *
	 * @param receiverEmail the receiver email of this notification audit log
	 */
	public void setReceiverEmail(String receiverEmail);

	/**
	 * Returns the message reason of this notification audit log.
	 *
	 * @return the message reason of this notification audit log
	 */
	@AutoEscape
	public String getMessageReason();

	/**
	 * Sets the message reason of this notification audit log.
	 *
	 * @param messageReason the message reason of this notification audit log
	 */
	public void setMessageReason(String messageReason);

	/**
	 * Returns the message of this notification audit log.
	 *
	 * @return the message of this notification audit log
	 */
	@AutoEscape
	public String getMessage();

	/**
	 * Sets the message of this notification audit log.
	 *
	 * @param message the message of this notification audit log
	 */
	public void setMessage(String message);

	/**
	 * Returns the notification time of this notification audit log.
	 *
	 * @return the notification time of this notification audit log
	 */
	public Date getNotificationTime();

	/**
	 * Sets the notification time of this notification audit log.
	 *
	 * @param notificationTime the notification time of this notification audit log
	 */
	public void setNotificationTime(Date notificationTime);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.liferay.contacts.model.NotificationAuditLog notificationAuditLog);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.contacts.model.NotificationAuditLog> toCacheModel();

	@Override
	public com.liferay.contacts.model.NotificationAuditLog toEscapedModel();

	@Override
	public com.liferay.contacts.model.NotificationAuditLog toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}