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

package com.rumbasolutions.flask.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Event service. Represents a row in the &quot;flaskevents_Event&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rumbasolutions.flask.model.impl.EventModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rumbasolutions.flask.model.impl.EventImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see Event
 * @see com.rumbasolutions.flask.model.impl.EventImpl
 * @see com.rumbasolutions.flask.model.impl.EventModelImpl
 * @generated
 */
public interface EventModel extends BaseModel<Event> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a event model instance should use the {@link Event} interface instead.
	 */

	/**
	 * Returns the primary key of this event.
	 *
	 * @return the primary key of this event
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this event.
	 *
	 * @param primaryKey the primary key of this event
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the event ID of this event.
	 *
	 * @return the event ID of this event
	 */
	public long getEventId();

	/**
	 * Sets the event ID of this event.
	 *
	 * @param eventId the event ID of this event
	 */
	public void setEventId(long eventId);

	/**
	 * Returns the company ID of this event.
	 *
	 * @return the company ID of this event
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this event.
	 *
	 * @param companyId the company ID of this event
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this event.
	 *
	 * @return the user ID of this event
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this event.
	 *
	 * @param userId the user ID of this event
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this event.
	 *
	 * @return the user uuid of this event
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this event.
	 *
	 * @param userUuid the user uuid of this event
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the created date of this event.
	 *
	 * @return the created date of this event
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this event.
	 *
	 * @param createdDate the created date of this event
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified date of this event.
	 *
	 * @return the modified date of this event
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this event.
	 *
	 * @param modifiedDate the modified date of this event
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the event name of this event.
	 *
	 * @return the event name of this event
	 */
	@AutoEscape
	public String getEventName();

	/**
	 * Sets the event name of this event.
	 *
	 * @param eventName the event name of this event
	 */
	public void setEventName(String eventName);

	/**
	 * Returns the description of this event.
	 *
	 * @return the description of this event
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this event.
	 *
	 * @param description the description of this event
	 */
	public void setDescription(String description);

	/**
	 * Returns the event date of this event.
	 *
	 * @return the event date of this event
	 */
	public Date getEventDate();

	/**
	 * Sets the event date of this event.
	 *
	 * @param eventDate the event date of this event
	 */
	public void setEventDate(Date eventDate);

	/**
	 * Returns the start time of this event.
	 *
	 * @return the start time of this event
	 */
	public long getStartTime();

	/**
	 * Sets the start time of this event.
	 *
	 * @param startTime the start time of this event
	 */
	public void setStartTime(long startTime);

	/**
	 * Returns the end time of this event.
	 *
	 * @return the end time of this event
	 */
	public long getEndTime();

	/**
	 * Sets the end time of this event.
	 *
	 * @param endTime the end time of this event
	 */
	public void setEndTime(long endTime);

	/**
	 * Returns the event type ID of this event.
	 *
	 * @return the event type ID of this event
	 */
	public long getEventTypeId();

	/**
	 * Sets the event type ID of this event.
	 *
	 * @param eventTypeId the event type ID of this event
	 */
	public void setEventTypeId(long eventTypeId);

	/**
	 * Returns the event type name of this event.
	 *
	 * @return the event type name of this event
	 */
	@AutoEscape
	public String getEventTypeName();

	/**
	 * Sets the event type name of this event.
	 *
	 * @param eventTypeName the event type name of this event
	 */
	public void setEventTypeName(String eventTypeName);

	/**
	 * Returns the event image u u i d of this event.
	 *
	 * @return the event image u u i d of this event
	 */
	@AutoEscape
	public String getEventImageUUID();

	/**
	 * Sets the event image u u i d of this event.
	 *
	 * @param eventImageUUID the event image u u i d of this event
	 */
	public void setEventImageUUID(String eventImageUUID);

	/**
	 * Returns the event image group ID of this event.
	 *
	 * @return the event image group ID of this event
	 */
	public long getEventImageGroupId();

	/**
	 * Sets the event image group ID of this event.
	 *
	 * @param eventImageGroupId the event image group ID of this event
	 */
	public void setEventImageGroupId(long eventImageGroupId);

	/**
	 * Returns the venue ID of this event.
	 *
	 * @return the venue ID of this event
	 */
	public long getVenueId();

	/**
	 * Sets the venue ID of this event.
	 *
	 * @param venueId the venue ID of this event
	 */
	public void setVenueId(long venueId);

	/**
	 * Returns the venue name of this event.
	 *
	 * @return the venue name of this event
	 */
	@AutoEscape
	public String getVenueName();

	/**
	 * Sets the venue name of this event.
	 *
	 * @param venueName the venue name of this event
	 */
	public void setVenueName(String venueName);

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
	public int compareTo(com.rumbasolutions.flask.model.Event event);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rumbasolutions.flask.model.Event> toCacheModel();

	@Override
	public com.rumbasolutions.flask.model.Event toEscapedModel();

	@Override
	public com.rumbasolutions.flask.model.Event toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}