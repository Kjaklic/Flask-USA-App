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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rumbasolutions.flask.model.AdCampaign;
import com.rumbasolutions.flask.model.AdCampaignModel;
import com.rumbasolutions.flask.model.AdCampaignSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the AdCampaign service. Represents a row in the &quot;flaskads_AdCampaign&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.AdCampaignModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AdCampaignImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdCampaignImpl
 * @see com.rumbasolutions.flask.model.AdCampaign
 * @see com.rumbasolutions.flask.model.AdCampaignModel
 * @generated
 */
@JSON(strict = true)
public class AdCampaignModelImpl extends BaseModelImpl<AdCampaign>
	implements AdCampaignModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ad campaign model instance should use the {@link com.rumbasolutions.flask.model.AdCampaign} interface instead.
	 */
	public static final String TABLE_NAME = "flaskads_AdCampaign";
	public static final Object[][] TABLE_COLUMNS = {
			{ "campaignId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "campaignName", Types.VARCHAR },
			{ "customerId", Types.BIGINT },
			{ "displayGeneral", Types.BOOLEAN },
			{ "displayPreEvent", Types.BOOLEAN },
			{ "displayDuringEvent", Types.BOOLEAN },
			{ "displayPostEvent", Types.BOOLEAN },
			{ "frequencyPerHour", Types.BIGINT },
			{ "eventTypeId", Types.BIGINT },
			{ "imageTitle", Types.VARCHAR },
			{ "imageDesc", Types.VARCHAR },
			{ "imageUUID", Types.VARCHAR },
			{ "imageGroupId", Types.BIGINT },
			{ "showAlways", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table flaskads_AdCampaign (campaignId LONG not null primary key,userId LONG,createdDate DATE null,modifiedDate DATE null,campaignName VARCHAR(100) null,customerId LONG,displayGeneral BOOLEAN,displayPreEvent BOOLEAN,displayDuringEvent BOOLEAN,displayPostEvent BOOLEAN,frequencyPerHour LONG,eventTypeId LONG,imageTitle VARCHAR(100) null,imageDesc VARCHAR(255) null,imageUUID VARCHAR(75) null,imageGroupId LONG,showAlways BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table flaskads_AdCampaign";
	public static final String ORDER_BY_JPQL = " ORDER BY adCampaign.campaignName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flaskads_AdCampaign.campaignName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.AdCampaign"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.AdCampaign"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rumbasolutions.flask.model.AdCampaign"),
			true);
	public static long CUSTOMERID_COLUMN_BITMASK = 1L;
	public static long CAMPAIGNNAME_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AdCampaign toModel(AdCampaignSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AdCampaign model = new AdCampaignImpl();

		model.setCampaignId(soapModel.getCampaignId());
		model.setUserId(soapModel.getUserId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCampaignName(soapModel.getCampaignName());
		model.setCustomerId(soapModel.getCustomerId());
		model.setDisplayGeneral(soapModel.getDisplayGeneral());
		model.setDisplayPreEvent(soapModel.getDisplayPreEvent());
		model.setDisplayDuringEvent(soapModel.getDisplayDuringEvent());
		model.setDisplayPostEvent(soapModel.getDisplayPostEvent());
		model.setFrequencyPerHour(soapModel.getFrequencyPerHour());
		model.setEventTypeId(soapModel.getEventTypeId());
		model.setImageTitle(soapModel.getImageTitle());
		model.setImageDesc(soapModel.getImageDesc());
		model.setImageUUID(soapModel.getImageUUID());
		model.setImageGroupId(soapModel.getImageGroupId());
		model.setShowAlways(soapModel.getShowAlways());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AdCampaign> toModels(AdCampaignSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AdCampaign> models = new ArrayList<AdCampaign>(soapModels.length);

		for (AdCampaignSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.AdCampaign"));

	public AdCampaignModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _campaignId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCampaignId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campaignId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AdCampaign.class;
	}

	@Override
	public String getModelClassName() {
		return AdCampaign.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignId", getCampaignId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("campaignName", getCampaignName());
		attributes.put("customerId", getCustomerId());
		attributes.put("displayGeneral", getDisplayGeneral());
		attributes.put("displayPreEvent", getDisplayPreEvent());
		attributes.put("displayDuringEvent", getDisplayDuringEvent());
		attributes.put("displayPostEvent", getDisplayPostEvent());
		attributes.put("frequencyPerHour", getFrequencyPerHour());
		attributes.put("eventTypeId", getEventTypeId());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageDesc", getImageDesc());
		attributes.put("imageUUID", getImageUUID());
		attributes.put("imageGroupId", getImageGroupId());
		attributes.put("showAlways", getShowAlways());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
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

		String campaignName = (String)attributes.get("campaignName");

		if (campaignName != null) {
			setCampaignName(campaignName);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Boolean displayGeneral = (Boolean)attributes.get("displayGeneral");

		if (displayGeneral != null) {
			setDisplayGeneral(displayGeneral);
		}

		Boolean displayPreEvent = (Boolean)attributes.get("displayPreEvent");

		if (displayPreEvent != null) {
			setDisplayPreEvent(displayPreEvent);
		}

		Boolean displayDuringEvent = (Boolean)attributes.get(
				"displayDuringEvent");

		if (displayDuringEvent != null) {
			setDisplayDuringEvent(displayDuringEvent);
		}

		Boolean displayPostEvent = (Boolean)attributes.get("displayPostEvent");

		if (displayPostEvent != null) {
			setDisplayPostEvent(displayPostEvent);
		}

		Long frequencyPerHour = (Long)attributes.get("frequencyPerHour");

		if (frequencyPerHour != null) {
			setFrequencyPerHour(frequencyPerHour);
		}

		Long eventTypeId = (Long)attributes.get("eventTypeId");

		if (eventTypeId != null) {
			setEventTypeId(eventTypeId);
		}

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		String imageDesc = (String)attributes.get("imageDesc");

		if (imageDesc != null) {
			setImageDesc(imageDesc);
		}

		String imageUUID = (String)attributes.get("imageUUID");

		if (imageUUID != null) {
			setImageUUID(imageUUID);
		}

		Long imageGroupId = (Long)attributes.get("imageGroupId");

		if (imageGroupId != null) {
			setImageGroupId(imageGroupId);
		}

		Boolean showAlways = (Boolean)attributes.get("showAlways");

		if (showAlways != null) {
			setShowAlways(showAlways);
		}
	}

	@JSON
	@Override
	public long getCampaignId() {
		return _campaignId;
	}

	@Override
	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
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
	public String getCampaignName() {
		if (_campaignName == null) {
			return StringPool.BLANK;
		}
		else {
			return _campaignName;
		}
	}

	@Override
	public void setCampaignName(String campaignName) {
		_columnBitmask = -1L;

		_campaignName = campaignName;
	}

	@JSON
	@Override
	public long getCustomerId() {
		return _customerId;
	}

	@Override
	public void setCustomerId(long customerId) {
		_columnBitmask |= CUSTOMERID_COLUMN_BITMASK;

		if (!_setOriginalCustomerId) {
			_setOriginalCustomerId = true;

			_originalCustomerId = _customerId;
		}

		_customerId = customerId;
	}

	public long getOriginalCustomerId() {
		return _originalCustomerId;
	}

	@JSON
	@Override
	public boolean getDisplayGeneral() {
		return _displayGeneral;
	}

	@Override
	public boolean isDisplayGeneral() {
		return _displayGeneral;
	}

	@Override
	public void setDisplayGeneral(boolean displayGeneral) {
		_displayGeneral = displayGeneral;
	}

	@JSON
	@Override
	public boolean getDisplayPreEvent() {
		return _displayPreEvent;
	}

	@Override
	public boolean isDisplayPreEvent() {
		return _displayPreEvent;
	}

	@Override
	public void setDisplayPreEvent(boolean displayPreEvent) {
		_displayPreEvent = displayPreEvent;
	}

	@JSON
	@Override
	public boolean getDisplayDuringEvent() {
		return _displayDuringEvent;
	}

	@Override
	public boolean isDisplayDuringEvent() {
		return _displayDuringEvent;
	}

	@Override
	public void setDisplayDuringEvent(boolean displayDuringEvent) {
		_displayDuringEvent = displayDuringEvent;
	}

	@JSON
	@Override
	public boolean getDisplayPostEvent() {
		return _displayPostEvent;
	}

	@Override
	public boolean isDisplayPostEvent() {
		return _displayPostEvent;
	}

	@Override
	public void setDisplayPostEvent(boolean displayPostEvent) {
		_displayPostEvent = displayPostEvent;
	}

	@JSON
	@Override
	public long getFrequencyPerHour() {
		return _frequencyPerHour;
	}

	@Override
	public void setFrequencyPerHour(long frequencyPerHour) {
		_frequencyPerHour = frequencyPerHour;
	}

	@JSON
	@Override
	public long getEventTypeId() {
		return _eventTypeId;
	}

	@Override
	public void setEventTypeId(long eventTypeId) {
		_eventTypeId = eventTypeId;
	}

	@JSON
	@Override
	public String getImageTitle() {
		if (_imageTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageTitle;
		}
	}

	@Override
	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
	}

	@JSON
	@Override
	public String getImageDesc() {
		if (_imageDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageDesc;
		}
	}

	@Override
	public void setImageDesc(String imageDesc) {
		_imageDesc = imageDesc;
	}

	@JSON
	@Override
	public String getImageUUID() {
		if (_imageUUID == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageUUID;
		}
	}

	@Override
	public void setImageUUID(String imageUUID) {
		_imageUUID = imageUUID;
	}

	@JSON
	@Override
	public long getImageGroupId() {
		return _imageGroupId;
	}

	@Override
	public void setImageGroupId(long imageGroupId) {
		_imageGroupId = imageGroupId;
	}

	@JSON
	@Override
	public boolean getShowAlways() {
		return _showAlways;
	}

	@Override
	public boolean isShowAlways() {
		return _showAlways;
	}

	@Override
	public void setShowAlways(boolean showAlways) {
		_showAlways = showAlways;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			AdCampaign.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AdCampaign toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AdCampaign)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AdCampaignImpl adCampaignImpl = new AdCampaignImpl();

		adCampaignImpl.setCampaignId(getCampaignId());
		adCampaignImpl.setUserId(getUserId());
		adCampaignImpl.setCreatedDate(getCreatedDate());
		adCampaignImpl.setModifiedDate(getModifiedDate());
		adCampaignImpl.setCampaignName(getCampaignName());
		adCampaignImpl.setCustomerId(getCustomerId());
		adCampaignImpl.setDisplayGeneral(getDisplayGeneral());
		adCampaignImpl.setDisplayPreEvent(getDisplayPreEvent());
		adCampaignImpl.setDisplayDuringEvent(getDisplayDuringEvent());
		adCampaignImpl.setDisplayPostEvent(getDisplayPostEvent());
		adCampaignImpl.setFrequencyPerHour(getFrequencyPerHour());
		adCampaignImpl.setEventTypeId(getEventTypeId());
		adCampaignImpl.setImageTitle(getImageTitle());
		adCampaignImpl.setImageDesc(getImageDesc());
		adCampaignImpl.setImageUUID(getImageUUID());
		adCampaignImpl.setImageGroupId(getImageGroupId());
		adCampaignImpl.setShowAlways(getShowAlways());

		adCampaignImpl.resetOriginalValues();

		return adCampaignImpl;
	}

	@Override
	public int compareTo(AdCampaign adCampaign) {
		int value = 0;

		value = getCampaignName().compareTo(adCampaign.getCampaignName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdCampaign)) {
			return false;
		}

		AdCampaign adCampaign = (AdCampaign)obj;

		long primaryKey = adCampaign.getPrimaryKey();

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
		AdCampaignModelImpl adCampaignModelImpl = this;

		adCampaignModelImpl._originalCustomerId = adCampaignModelImpl._customerId;

		adCampaignModelImpl._setOriginalCustomerId = false;

		adCampaignModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AdCampaign> toCacheModel() {
		AdCampaignCacheModel adCampaignCacheModel = new AdCampaignCacheModel();

		adCampaignCacheModel.campaignId = getCampaignId();

		adCampaignCacheModel.userId = getUserId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			adCampaignCacheModel.createdDate = createdDate.getTime();
		}
		else {
			adCampaignCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			adCampaignCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			adCampaignCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		adCampaignCacheModel.campaignName = getCampaignName();

		String campaignName = adCampaignCacheModel.campaignName;

		if ((campaignName != null) && (campaignName.length() == 0)) {
			adCampaignCacheModel.campaignName = null;
		}

		adCampaignCacheModel.customerId = getCustomerId();

		adCampaignCacheModel.displayGeneral = getDisplayGeneral();

		adCampaignCacheModel.displayPreEvent = getDisplayPreEvent();

		adCampaignCacheModel.displayDuringEvent = getDisplayDuringEvent();

		adCampaignCacheModel.displayPostEvent = getDisplayPostEvent();

		adCampaignCacheModel.frequencyPerHour = getFrequencyPerHour();

		adCampaignCacheModel.eventTypeId = getEventTypeId();

		adCampaignCacheModel.imageTitle = getImageTitle();

		String imageTitle = adCampaignCacheModel.imageTitle;

		if ((imageTitle != null) && (imageTitle.length() == 0)) {
			adCampaignCacheModel.imageTitle = null;
		}

		adCampaignCacheModel.imageDesc = getImageDesc();

		String imageDesc = adCampaignCacheModel.imageDesc;

		if ((imageDesc != null) && (imageDesc.length() == 0)) {
			adCampaignCacheModel.imageDesc = null;
		}

		adCampaignCacheModel.imageUUID = getImageUUID();

		String imageUUID = adCampaignCacheModel.imageUUID;

		if ((imageUUID != null) && (imageUUID.length() == 0)) {
			adCampaignCacheModel.imageUUID = null;
		}

		adCampaignCacheModel.imageGroupId = getImageGroupId();

		adCampaignCacheModel.showAlways = getShowAlways();

		return adCampaignCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{campaignId=");
		sb.append(getCampaignId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", campaignName=");
		sb.append(getCampaignName());
		sb.append(", customerId=");
		sb.append(getCustomerId());
		sb.append(", displayGeneral=");
		sb.append(getDisplayGeneral());
		sb.append(", displayPreEvent=");
		sb.append(getDisplayPreEvent());
		sb.append(", displayDuringEvent=");
		sb.append(getDisplayDuringEvent());
		sb.append(", displayPostEvent=");
		sb.append(getDisplayPostEvent());
		sb.append(", frequencyPerHour=");
		sb.append(getFrequencyPerHour());
		sb.append(", eventTypeId=");
		sb.append(getEventTypeId());
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", imageDesc=");
		sb.append(getImageDesc());
		sb.append(", imageUUID=");
		sb.append(getImageUUID());
		sb.append(", imageGroupId=");
		sb.append(getImageGroupId());
		sb.append(", showAlways=");
		sb.append(getShowAlways());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.AdCampaign");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
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
			"<column><column-name>campaignName</column-name><column-value><![CDATA[");
		sb.append(getCampaignName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerId</column-name><column-value><![CDATA[");
		sb.append(getCustomerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayGeneral</column-name><column-value><![CDATA[");
		sb.append(getDisplayGeneral());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayPreEvent</column-name><column-value><![CDATA[");
		sb.append(getDisplayPreEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayDuringEvent</column-name><column-value><![CDATA[");
		sb.append(getDisplayDuringEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayPostEvent</column-name><column-value><![CDATA[");
		sb.append(getDisplayPostEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frequencyPerHour</column-name><column-value><![CDATA[");
		sb.append(getFrequencyPerHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventTypeId</column-name><column-value><![CDATA[");
		sb.append(getEventTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageTitle</column-name><column-value><![CDATA[");
		sb.append(getImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageDesc</column-name><column-value><![CDATA[");
		sb.append(getImageDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUUID</column-name><column-value><![CDATA[");
		sb.append(getImageUUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageGroupId</column-name><column-value><![CDATA[");
		sb.append(getImageGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>showAlways</column-name><column-value><![CDATA[");
		sb.append(getShowAlways());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = AdCampaign.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			AdCampaign.class
		};
	private long _campaignId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _campaignName;
	private long _customerId;
	private long _originalCustomerId;
	private boolean _setOriginalCustomerId;
	private boolean _displayGeneral;
	private boolean _displayPreEvent;
	private boolean _displayDuringEvent;
	private boolean _displayPostEvent;
	private long _frequencyPerHour;
	private long _eventTypeId;
	private String _imageTitle;
	private String _imageDesc;
	private String _imageUUID;
	private long _imageGroupId;
	private boolean _showAlways;
	private long _columnBitmask;
	private AdCampaign _escapedModel;
}