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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the VenueDeviceImage service. Represents a row in the &quot;flaskevents_VenueDeviceImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDeviceImage
 * @see com.rumbasolutions.flask.model.impl.VenueDeviceImageImpl
 * @see com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl
 * @generated
 */
public interface VenueDeviceImageModel extends BaseModel<VenueDeviceImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a venue device image model instance should use the {@link VenueDeviceImage} interface instead.
	 */

	/**
	 * Returns the primary key of this venue device image.
	 *
	 * @return the primary key of this venue device image
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this venue device image.
	 *
	 * @param primaryKey the primary key of this venue device image
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the venue device image ID of this venue device image.
	 *
	 * @return the venue device image ID of this venue device image
	 */
	public long getVenueDeviceImageId();

	/**
	 * Sets the venue device image ID of this venue device image.
	 *
	 * @param venueDeviceImageId the venue device image ID of this venue device image
	 */
	public void setVenueDeviceImageId(long venueDeviceImageId);

	/**
	 * Returns the venue detail image ID of this venue device image.
	 *
	 * @return the venue detail image ID of this venue device image
	 */
	public long getVenueDetailImageId();

	/**
	 * Sets the venue detail image ID of this venue device image.
	 *
	 * @param venueDetailImageId the venue detail image ID of this venue device image
	 */
	public void setVenueDetailImageId(long venueDetailImageId);

	/**
	 * Returns the venue ID of this venue device image.
	 *
	 * @return the venue ID of this venue device image
	 */
	public long getVenueId();

	/**
	 * Sets the venue ID of this venue device image.
	 *
	 * @param venueId the venue ID of this venue device image
	 */
	public void setVenueId(long venueId);

	/**
	 * Returns the device type of this venue device image.
	 *
	 * @return the device type of this venue device image
	 */
	@AutoEscape
	public String getDeviceType();

	/**
	 * Sets the device type of this venue device image.
	 *
	 * @param deviceType the device type of this venue device image
	 */
	public void setDeviceType(String deviceType);

	/**
	 * Returns the venue device image u u i d of this venue device image.
	 *
	 * @return the venue device image u u i d of this venue device image
	 */
	@AutoEscape
	public String getVenueDeviceImageUUID();

	/**
	 * Sets the venue device image u u i d of this venue device image.
	 *
	 * @param venueDeviceImageUUID the venue device image u u i d of this venue device image
	 */
	public void setVenueDeviceImageUUID(String venueDeviceImageUUID);

	/**
	 * Returns the aspect ratio of this venue device image.
	 *
	 * @return the aspect ratio of this venue device image
	 */
	@AutoEscape
	public String getAspectRatio();

	/**
	 * Sets the aspect ratio of this venue device image.
	 *
	 * @param aspectRatio the aspect ratio of this venue device image
	 */
	public void setAspectRatio(String aspectRatio);

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
		com.rumbasolutions.flask.model.VenueDeviceImage venueDeviceImage);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rumbasolutions.flask.model.VenueDeviceImage> toCacheModel();

	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage toEscapedModel();

	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}