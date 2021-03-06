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
import com.liferay.contacts.model.FlaskGroupMessagesModel;
import com.liferay.contacts.model.FlaskGroupMessagesSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
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

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the FlaskGroupMessages service. Represents a row in the &quot;Contacts_FlaskGroupMessages&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.contacts.model.FlaskGroupMessagesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FlaskGroupMessagesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupMessagesImpl
 * @see com.liferay.contacts.model.FlaskGroupMessages
 * @see com.liferay.contacts.model.FlaskGroupMessagesModel
 * @generated
 */
@JSON(strict = true)
public class FlaskGroupMessagesModelImpl extends BaseModelImpl<FlaskGroupMessages>
	implements FlaskGroupMessagesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a flask group messages model instance should use the {@link com.liferay.contacts.model.FlaskGroupMessages} interface instead.
	 */
	public static final String TABLE_NAME = "Contacts_FlaskGroupMessages";
	public static final Object[][] TABLE_COLUMNS = {
			{ "groupMessagesId", Types.BIGINT },
			{ "senderEmail", Types.VARCHAR },
			{ "senderUserId", Types.BIGINT },
			{ "senderName", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "message", Types.VARCHAR },
			{ "sendEmail", Types.BOOLEAN },
			{ "dateTime", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table Contacts_FlaskGroupMessages (groupMessagesId LONG not null primary key,senderEmail VARCHAR(75) null,senderUserId LONG,senderName VARCHAR(75) null,groupId LONG,message VARCHAR(255) null,sendEmail BOOLEAN,dateTime DATE null)";
	public static final String TABLE_SQL_DROP = "drop table Contacts_FlaskGroupMessages";
	public static final String ORDER_BY_JPQL = " ORDER BY flaskGroupMessages.dateTime ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Contacts_FlaskGroupMessages.dateTime ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.contacts.model.FlaskGroupMessages"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.contacts.model.FlaskGroupMessages"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.contacts.model.FlaskGroupMessages"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long DATETIME_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FlaskGroupMessages toModel(FlaskGroupMessagesSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FlaskGroupMessages model = new FlaskGroupMessagesImpl();

		model.setGroupMessagesId(soapModel.getGroupMessagesId());
		model.setSenderEmail(soapModel.getSenderEmail());
		model.setSenderUserId(soapModel.getSenderUserId());
		model.setSenderName(soapModel.getSenderName());
		model.setGroupId(soapModel.getGroupId());
		model.setMessage(soapModel.getMessage());
		model.setSendEmail(soapModel.getSendEmail());
		model.setDateTime(soapModel.getDateTime());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<FlaskGroupMessages> toModels(
		FlaskGroupMessagesSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FlaskGroupMessages> models = new ArrayList<FlaskGroupMessages>(soapModels.length);

		for (FlaskGroupMessagesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.contacts.model.FlaskGroupMessages"));

	public FlaskGroupMessagesModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _groupMessagesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupMessagesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupMessagesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroupMessages.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroupMessages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupMessagesId", getGroupMessagesId());
		attributes.put("senderEmail", getSenderEmail());
		attributes.put("senderUserId", getSenderUserId());
		attributes.put("senderName", getSenderName());
		attributes.put("groupId", getGroupId());
		attributes.put("message", getMessage());
		attributes.put("sendEmail", getSendEmail());
		attributes.put("dateTime", getDateTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupMessagesId = (Long)attributes.get("groupMessagesId");

		if (groupMessagesId != null) {
			setGroupMessagesId(groupMessagesId);
		}

		String senderEmail = (String)attributes.get("senderEmail");

		if (senderEmail != null) {
			setSenderEmail(senderEmail);
		}

		Long senderUserId = (Long)attributes.get("senderUserId");

		if (senderUserId != null) {
			setSenderUserId(senderUserId);
		}

		String senderName = (String)attributes.get("senderName");

		if (senderName != null) {
			setSenderName(senderName);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Boolean sendEmail = (Boolean)attributes.get("sendEmail");

		if (sendEmail != null) {
			setSendEmail(sendEmail);
		}

		Date dateTime = (Date)attributes.get("dateTime");

		if (dateTime != null) {
			setDateTime(dateTime);
		}
	}

	@JSON
	@Override
	public long getGroupMessagesId() {
		return _groupMessagesId;
	}

	@Override
	public void setGroupMessagesId(long groupMessagesId) {
		_groupMessagesId = groupMessagesId;
	}

	@JSON
	@Override
	public String getSenderEmail() {
		if (_senderEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _senderEmail;
		}
	}

	@Override
	public void setSenderEmail(String senderEmail) {
		_senderEmail = senderEmail;
	}

	@JSON
	@Override
	public long getSenderUserId() {
		return _senderUserId;
	}

	@Override
	public void setSenderUserId(long senderUserId) {
		_senderUserId = senderUserId;
	}

	@Override
	public String getSenderUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getSenderUserId(), "uuid",
			_senderUserUuid);
	}

	@Override
	public void setSenderUserUuid(String senderUserUuid) {
		_senderUserUuid = senderUserUuid;
	}

	@JSON
	@Override
	public String getSenderName() {
		if (_senderName == null) {
			return StringPool.BLANK;
		}
		else {
			return _senderName;
		}
	}

	@Override
	public void setSenderName(String senderName) {
		_senderName = senderName;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public String getMessage() {
		if (_message == null) {
			return StringPool.BLANK;
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		_message = message;
	}

	@JSON
	@Override
	public boolean getSendEmail() {
		return _sendEmail;
	}

	@Override
	public boolean isSendEmail() {
		return _sendEmail;
	}

	@Override
	public void setSendEmail(boolean sendEmail) {
		_sendEmail = sendEmail;
	}

	@JSON
	@Override
	public Date getDateTime() {
		return _dateTime;
	}

	@Override
	public void setDateTime(Date dateTime) {
		_columnBitmask = -1L;

		_dateTime = dateTime;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FlaskGroupMessages.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FlaskGroupMessages toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FlaskGroupMessages)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FlaskGroupMessagesImpl flaskGroupMessagesImpl = new FlaskGroupMessagesImpl();

		flaskGroupMessagesImpl.setGroupMessagesId(getGroupMessagesId());
		flaskGroupMessagesImpl.setSenderEmail(getSenderEmail());
		flaskGroupMessagesImpl.setSenderUserId(getSenderUserId());
		flaskGroupMessagesImpl.setSenderName(getSenderName());
		flaskGroupMessagesImpl.setGroupId(getGroupId());
		flaskGroupMessagesImpl.setMessage(getMessage());
		flaskGroupMessagesImpl.setSendEmail(getSendEmail());
		flaskGroupMessagesImpl.setDateTime(getDateTime());

		flaskGroupMessagesImpl.resetOriginalValues();

		return flaskGroupMessagesImpl;
	}

	@Override
	public int compareTo(FlaskGroupMessages flaskGroupMessages) {
		int value = 0;

		value = DateUtil.compareTo(getDateTime(),
				flaskGroupMessages.getDateTime());

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

		if (!(obj instanceof FlaskGroupMessages)) {
			return false;
		}

		FlaskGroupMessages flaskGroupMessages = (FlaskGroupMessages)obj;

		long primaryKey = flaskGroupMessages.getPrimaryKey();

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
		FlaskGroupMessagesModelImpl flaskGroupMessagesModelImpl = this;

		flaskGroupMessagesModelImpl._originalGroupId = flaskGroupMessagesModelImpl._groupId;

		flaskGroupMessagesModelImpl._setOriginalGroupId = false;

		flaskGroupMessagesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FlaskGroupMessages> toCacheModel() {
		FlaskGroupMessagesCacheModel flaskGroupMessagesCacheModel = new FlaskGroupMessagesCacheModel();

		flaskGroupMessagesCacheModel.groupMessagesId = getGroupMessagesId();

		flaskGroupMessagesCacheModel.senderEmail = getSenderEmail();

		String senderEmail = flaskGroupMessagesCacheModel.senderEmail;

		if ((senderEmail != null) && (senderEmail.length() == 0)) {
			flaskGroupMessagesCacheModel.senderEmail = null;
		}

		flaskGroupMessagesCacheModel.senderUserId = getSenderUserId();

		flaskGroupMessagesCacheModel.senderName = getSenderName();

		String senderName = flaskGroupMessagesCacheModel.senderName;

		if ((senderName != null) && (senderName.length() == 0)) {
			flaskGroupMessagesCacheModel.senderName = null;
		}

		flaskGroupMessagesCacheModel.groupId = getGroupId();

		flaskGroupMessagesCacheModel.message = getMessage();

		String message = flaskGroupMessagesCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			flaskGroupMessagesCacheModel.message = null;
		}

		flaskGroupMessagesCacheModel.sendEmail = getSendEmail();

		Date dateTime = getDateTime();

		if (dateTime != null) {
			flaskGroupMessagesCacheModel.dateTime = dateTime.getTime();
		}
		else {
			flaskGroupMessagesCacheModel.dateTime = Long.MIN_VALUE;
		}

		return flaskGroupMessagesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{groupMessagesId=");
		sb.append(getGroupMessagesId());
		sb.append(", senderEmail=");
		sb.append(getSenderEmail());
		sb.append(", senderUserId=");
		sb.append(getSenderUserId());
		sb.append(", senderName=");
		sb.append(getSenderName());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", sendEmail=");
		sb.append(getSendEmail());
		sb.append(", dateTime=");
		sb.append(getDateTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.contacts.model.FlaskGroupMessages");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupMessagesId</column-name><column-value><![CDATA[");
		sb.append(getGroupMessagesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderEmail</column-name><column-value><![CDATA[");
		sb.append(getSenderEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderUserId</column-name><column-value><![CDATA[");
		sb.append(getSenderUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderName</column-name><column-value><![CDATA[");
		sb.append(getSenderName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendEmail</column-name><column-value><![CDATA[");
		sb.append(getSendEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateTime</column-name><column-value><![CDATA[");
		sb.append(getDateTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = FlaskGroupMessages.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FlaskGroupMessages.class
		};
	private long _groupMessagesId;
	private String _senderEmail;
	private long _senderUserId;
	private String _senderUserUuid;
	private String _senderName;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _message;
	private boolean _sendEmail;
	private Date _dateTime;
	private long _columnBitmask;
	private FlaskGroupMessages _escapedModel;
}