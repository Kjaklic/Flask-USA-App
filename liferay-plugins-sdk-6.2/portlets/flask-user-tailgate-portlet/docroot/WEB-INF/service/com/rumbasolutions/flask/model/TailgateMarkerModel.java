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
 * The base model interface for the TailgateMarker service. Represents a row in the &quot;flasktailgate_TailgateMarker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rumbasolutions.flask.model.impl.TailgateMarkerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMarker
 * @see com.rumbasolutions.flask.model.impl.TailgateMarkerImpl
 * @see com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl
 * @generated
 */
public interface TailgateMarkerModel extends BaseModel<TailgateMarker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tailgate marker model instance should use the {@link TailgateMarker} interface instead.
	 */

	/**
	 * Returns the primary key of this tailgate marker.
	 *
	 * @return the primary key of this tailgate marker
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tailgate marker.
	 *
	 * @param primaryKey the primary key of this tailgate marker
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the tailgatemarkerid of this tailgate marker.
	 *
	 * @return the tailgatemarkerid of this tailgate marker
	 */
	public long getTailgatemarkerid();

	/**
	 * Sets the tailgatemarkerid of this tailgate marker.
	 *
	 * @param tailgatemarkerid the tailgatemarkerid of this tailgate marker
	 */
	public void setTailgatemarkerid(long tailgatemarkerid);

	/**
	 * Returns the tailgateid of this tailgate marker.
	 *
	 * @return the tailgateid of this tailgate marker
	 */
	public long getTailgateid();

	/**
	 * Sets the tailgateid of this tailgate marker.
	 *
	 * @param tailgateid the tailgateid of this tailgate marker
	 */
	public void setTailgateid(long tailgateid);

	/**
	 * Returns the latitude of this tailgate marker.
	 *
	 * @return the latitude of this tailgate marker
	 */
	@AutoEscape
	public String getLatitude();

	/**
	 * Sets the latitude of this tailgate marker.
	 *
	 * @param latitude the latitude of this tailgate marker
	 */
	public void setLatitude(String latitude);

	/**
	 * Returns the longitude of this tailgate marker.
	 *
	 * @return the longitude of this tailgate marker
	 */
	@AutoEscape
	public String getLongitude();

	/**
	 * Sets the longitude of this tailgate marker.
	 *
	 * @param longitude the longitude of this tailgate marker
	 */
	public void setLongitude(String longitude);

	/**
	 * Returns the name of this tailgate marker.
	 *
	 * @return the name of this tailgate marker
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this tailgate marker.
	 *
	 * @param name the name of this tailgate marker
	 */
	public void setName(String name);

	/**
	 * Returns the description of this tailgate marker.
	 *
	 * @return the description of this tailgate marker
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this tailgate marker.
	 *
	 * @param description the description of this tailgate marker
	 */
	public void setDescription(String description);

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
		com.rumbasolutions.flask.model.TailgateMarker tailgateMarker);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rumbasolutions.flask.model.TailgateMarker> toCacheModel();

	@Override
	public com.rumbasolutions.flask.model.TailgateMarker toEscapedModel();

	@Override
	public com.rumbasolutions.flask.model.TailgateMarker toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}