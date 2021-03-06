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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rumbasolutions.flask.model.CampaignEvent;
import com.rumbasolutions.flask.model.CampaignEventModel;
import com.rumbasolutions.flask.model.CampaignEventSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CampaignEvent service. Represents a row in the &quot;flaskads_CampaignEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.CampaignEventModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CampaignEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignEventImpl
 * @see com.rumbasolutions.flask.model.CampaignEvent
 * @see com.rumbasolutions.flask.model.CampaignEventModel
 * @generated
 */
@JSON(strict = true)
public class CampaignEventModelImpl extends BaseModelImpl<CampaignEvent>
	implements CampaignEventModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a campaign event model instance should use the {@link com.rumbasolutions.flask.model.CampaignEvent} interface instead.
	 */
	public static final String TABLE_NAME = "flaskads_CampaignEvent";
	public static final Object[][] TABLE_COLUMNS = {
			{ "campaignEventId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "campaignId", Types.BIGINT },
			{ "eventId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table flaskads_CampaignEvent (campaignEventId LONG not null primary key,userId LONG,createdDate DATE null,modifiedDate DATE null,campaignId LONG,eventId LONG)";
	public static final String TABLE_SQL_DROP = "drop table flaskads_CampaignEvent";
	public static final String ORDER_BY_JPQL = " ORDER BY campaignEvent.campaignEventId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flaskads_CampaignEvent.campaignEventId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.CampaignEvent"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.CampaignEvent"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rumbasolutions.flask.model.CampaignEvent"),
			true);
	public static long CAMPAIGNID_COLUMN_BITMASK = 1L;
	public static long EVENTID_COLUMN_BITMASK = 2L;
	public static long CAMPAIGNEVENTID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CampaignEvent toModel(CampaignEventSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CampaignEvent model = new CampaignEventImpl();

		model.setCampaignEventId(soapModel.getCampaignEventId());
		model.setUserId(soapModel.getUserId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCampaignId(soapModel.getCampaignId());
		model.setEventId(soapModel.getEventId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CampaignEvent> toModels(CampaignEventSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CampaignEvent> models = new ArrayList<CampaignEvent>(soapModels.length);

		for (CampaignEventSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.CampaignEvent"));

	public CampaignEventModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _campaignEventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCampaignEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campaignEventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignEvent.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignEventId", getCampaignEventId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("campaignId", getCampaignId());
		attributes.put("eventId", getEventId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignEventId = (Long)attributes.get("campaignEventId");

		if (campaignEventId != null) {
			setCampaignEventId(campaignEventId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	@JSON
	@Override
	public long getCampaignEventId() {
		return _campaignEventId;
	}

	@Override
	public void setCampaignEventId(long campaignEventId) {
		_campaignEventId = campaignEventId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCampaignId() {
		return _campaignId;
	}

	@Override
	public void setCampaignId(long campaignId) {
		_columnBitmask |= CAMPAIGNID_COLUMN_BITMASK;

		if (!_setOriginalCampaignId) {
			_setOriginalCampaignId = true;

			_originalCampaignId = _campaignId;
		}

		_campaignId = campaignId;
	}

	public long getOriginalCampaignId() {
		return _originalCampaignId;
	}

	@JSON
	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_columnBitmask |= EVENTID_COLUMN_BITMASK;

		if (!_setOriginalEventId) {
			_setOriginalEventId = true;

			_originalEventId = _eventId;
		}

		_eventId = eventId;
	}

	public long getOriginalEventId() {
		return _originalEventId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CampaignEvent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CampaignEvent toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CampaignEvent)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CampaignEventImpl campaignEventImpl = new CampaignEventImpl();

		campaignEventImpl.setCampaignEventId(getCampaignEventId());
		campaignEventImpl.setUserId(getUserId());
		campaignEventImpl.setCreatedDate(getCreatedDate());
		campaignEventImpl.setModifiedDate(getModifiedDate());
		campaignEventImpl.setCampaignId(getCampaignId());
		campaignEventImpl.setEventId(getEventId());

		campaignEventImpl.resetOriginalValues();

		return campaignEventImpl;
	}

	@Override
	public int compareTo(CampaignEvent campaignEvent) {
		long primaryKey = campaignEvent.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignEvent)) {
			return false;
		}

		CampaignEvent campaignEvent = (CampaignEvent)obj;

		long primaryKey = campaignEvent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CampaignEventModelImpl campaignEventModelImpl = this;

		campaignEventModelImpl._originalCampaignId = campaignEventModelImpl._campaignId;

		campaignEventModelImpl._setOriginalCampaignId = false;

		campaignEventModelImpl._originalEventId = campaignEventModelImpl._eventId;

		campaignEventModelImpl._setOriginalEventId = false;

		campaignEventModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CampaignEvent> toCacheModel() {
		CampaignEventCacheModel campaignEventCacheModel = new CampaignEventCacheModel();

		campaignEventCacheModel.campaignEventId = getCampaignEventId();

		campaignEventCacheModel.userId = getUserId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			campaignEventCacheModel.createdDate = createdDate.getTime();
		}
		else {
			campaignEventCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			campaignEventCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			campaignEventCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		campaignEventCacheModel.campaignId = getCampaignId();

		campaignEventCacheModel.eventId = getEventId();

		return campaignEventCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{campaignEventId=");
		sb.append(getCampaignEventId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.CampaignEvent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>campaignEventId</column-name><column-value><![CDATA[");
		sb.append(getCampaignEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CampaignEvent.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CampaignEvent.class
		};
	private long _campaignEventId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _campaignId;
	private long _originalCampaignId;
	private boolean _setOriginalCampaignId;
	private long _eventId;
	private long _originalEventId;
	private boolean _setOriginalEventId;
	private long _columnBitmask;
	private CampaignEvent _escapedModel;
}