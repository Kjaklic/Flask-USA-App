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

import com.liferay.contacts.model.FlaskGroupRecipients;
import com.liferay.contacts.model.FlaskGroupRecipientsModel;
import com.liferay.contacts.model.FlaskGroupRecipientsSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

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
 * The base model implementation for the FlaskGroupRecipients service. Represents a row in the &quot;Contacts_FlaskGroupRecipients&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.contacts.model.FlaskGroupRecipientsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FlaskGroupRecipientsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupRecipientsImpl
 * @see com.liferay.contacts.model.FlaskGroupRecipients
 * @see com.liferay.contacts.model.FlaskGroupRecipientsModel
 * @generated
 */
@JSON(strict = true)
public class FlaskGroupRecipientsModelImpl extends BaseModelImpl<FlaskGroupRecipients>
	implements FlaskGroupRecipientsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a flask group recipients model instance should use the {@link com.liferay.contacts.model.FlaskGroupRecipients} interface instead.
	 */
	public static final String TABLE_NAME = "Contacts_FlaskGroupRecipients";
	public static final Object[][] TABLE_COLUMNS = {
			{ "groupRecipientId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "recipients", Types.VARCHAR },
			{ "groupMessageId", Types.BIGINT },
			{ "read_", Types.VARCHAR },
			{ "receivedDateTime", Types.TIMESTAMP },
			{ "senderId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Contacts_FlaskGroupRecipients (groupRecipientId LONG not null primary key,groupId LONG,recipients TEXT null,groupMessageId LONG,read_ TEXT null,receivedDateTime DATE null,senderId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Contacts_FlaskGroupRecipients";
	public static final String ORDER_BY_JPQL = " ORDER BY flaskGroupRecipients.receivedDateTime ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Contacts_FlaskGroupRecipients.receivedDateTime ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.contacts.model.FlaskGroupRecipients"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.contacts.model.FlaskGroupRecipients"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.contacts.model.FlaskGroupRecipients"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long GROUPMESSAGEID_COLUMN_BITMASK = 2L;
	public static long RECEIVEDDATETIME_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FlaskGroupRecipients toModel(
		FlaskGroupRecipientsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FlaskGroupRecipients model = new FlaskGroupRecipientsImpl();

		model.setGroupRecipientId(soapModel.getGroupRecipientId());
		model.setGroupId(soapModel.getGroupId());
		model.setRecipients(soapModel.getRecipients());
		model.setGroupMessageId(soapModel.getGroupMessageId());
		model.setRead(soapModel.getRead());
		model.setReceivedDateTime(soapModel.getReceivedDateTime());
		model.setSenderId(soapModel.getSenderId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<FlaskGroupRecipients> toModels(
		FlaskGroupRecipientsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FlaskGroupRecipients> models = new ArrayList<FlaskGroupRecipients>(soapModels.length);

		for (FlaskGroupRecipientsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.contacts.model.FlaskGroupRecipients"));

	public FlaskGroupRecipientsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _groupRecipientId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupRecipientId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupRecipientId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroupRecipients.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroupRecipients.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupRecipientId", getGroupRecipientId());
		attributes.put("groupId", getGroupId());
		attributes.put("recipients", getRecipients());
		attributes.put("groupMessageId", getGroupMessageId());
		attributes.put("read", getRead());
		attributes.put("receivedDateTime", getReceivedDateTime());
		attributes.put("senderId", getSenderId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupRecipientId = (Long)attributes.get("groupRecipientId");

		if (groupRecipientId != null) {
			setGroupRecipientId(groupRecipientId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String recipients = (String)attributes.get("recipients");

		if (recipients != null) {
			setRecipients(recipients);
		}

		Long groupMessageId = (Long)attributes.get("groupMessageId");

		if (groupMessageId != null) {
			setGroupMessageId(groupMessageId);
		}

		String read = (String)attributes.get("read");

		if (read != null) {
			setRead(read);
		}

		Date receivedDateTime = (Date)attributes.get("receivedDateTime");

		if (receivedDateTime != null) {
			setReceivedDateTime(receivedDateTime);
		}

		Long senderId = (Long)attributes.get("senderId");

		if (senderId != null) {
			setSenderId(senderId);
		}
	}

	@JSON
	@Override
	public long getGroupRecipientId() {
		return _groupRecipientId;
	}

	@Override
	public void setGroupRecipientId(long groupRecipientId) {
		_groupRecipientId = groupRecipientId;
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
	public String getRecipients() {
		if (_recipients == null) {
			return StringPool.BLANK;
		}
		else {
			return _recipients;
		}
	}

	@Override
	public void setRecipients(String recipients) {
		_recipients = recipients;
	}

	@JSON
	@Override
	public long getGroupMessageId() {
		return _groupMessageId;
	}

	@Override
	public void setGroupMessageId(long groupMessageId) {
		_columnBitmask |= GROUPMESSAGEID_COLUMN_BITMASK;

		if (!_setOriginalGroupMessageId) {
			_setOriginalGroupMessageId = true;

			_originalGroupMessageId = _groupMessageId;
		}

		_groupMessageId = groupMessageId;
	}

	public long getOriginalGroupMessageId() {
		return _originalGroupMessageId;
	}

	@JSON
	@Override
	public String getRead() {
		if (_read == null) {
			return StringPool.BLANK;
		}
		else {
			return _read;
		}
	}

	@Override
	public void setRead(String read) {
		_read = read;
	}

	@JSON
	@Override
	public Date getReceivedDateTime() {
		return _receivedDateTime;
	}

	@Override
	public void setReceivedDateTime(Date receivedDateTime) {
		_columnBitmask = -1L;

		_receivedDateTime = receivedDateTime;
	}

	@JSON
	@Override
	public long getSenderId() {
		return _senderId;
	}

	@Override
	public void setSenderId(long senderId) {
		_senderId = senderId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FlaskGroupRecipients.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FlaskGroupRecipients toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FlaskGroupRecipients)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FlaskGroupRecipientsImpl flaskGroupRecipientsImpl = new FlaskGroupRecipientsImpl();

		flaskGroupRecipientsImpl.setGroupRecipientId(getGroupRecipientId());
		flaskGroupRecipientsImpl.setGroupId(getGroupId());
		flaskGroupRecipientsImpl.setRecipients(getRecipients());
		flaskGroupRecipientsImpl.setGroupMessageId(getGroupMessageId());
		flaskGroupRecipientsImpl.setRead(getRead());
		flaskGroupRecipientsImpl.setReceivedDateTime(getReceivedDateTime());
		flaskGroupRecipientsImpl.setSenderId(getSenderId());

		flaskGroupRecipientsImpl.resetOriginalValues();

		return flaskGroupRecipientsImpl;
	}

	@Override
	public int compareTo(FlaskGroupRecipients flaskGroupRecipients) {
		int value = 0;

		value = DateUtil.compareTo(getReceivedDateTime(),
				flaskGroupRecipients.getReceivedDateTime());

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

		if (!(obj instanceof FlaskGroupRecipients)) {
			return false;
		}

		FlaskGroupRecipients flaskGroupRecipients = (FlaskGroupRecipients)obj;

		long primaryKey = flaskGroupRecipients.getPrimaryKey();

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
		FlaskGroupRecipientsModelImpl flaskGroupRecipientsModelImpl = this;

		flaskGroupRecipientsModelImpl._originalGroupId = flaskGroupRecipientsModelImpl._groupId;

		flaskGroupRecipientsModelImpl._setOriginalGroupId = false;

		flaskGroupRecipientsModelImpl._originalGroupMessageId = flaskGroupRecipientsModelImpl._groupMessageId;

		flaskGroupRecipientsModelImpl._setOriginalGroupMessageId = false;

		flaskGroupRecipientsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FlaskGroupRecipients> toCacheModel() {
		FlaskGroupRecipientsCacheModel flaskGroupRecipientsCacheModel = new FlaskGroupRecipientsCacheModel();

		flaskGroupRecipientsCacheModel.groupRecipientId = getGroupRecipientId();

		flaskGroupRecipientsCacheModel.groupId = getGroupId();

		flaskGroupRecipientsCacheModel.recipients = getRecipients();

		String recipients = flaskGroupRecipientsCacheModel.recipients;

		if ((recipients != null) && (recipients.length() == 0)) {
			flaskGroupRecipientsCacheModel.recipients = null;
		}

		flaskGroupRecipientsCacheModel.groupMessageId = getGroupMessageId();

		flaskGroupRecipientsCacheModel.read = getRead();

		String read = flaskGroupRecipientsCacheModel.read;

		if ((read != null) && (read.length() == 0)) {
			flaskGroupRecipientsCacheModel.read = null;
		}

		Date receivedDateTime = getReceivedDateTime();

		if (receivedDateTime != null) {
			flaskGroupRecipientsCacheModel.receivedDateTime = receivedDateTime.getTime();
		}
		else {
			flaskGroupRecipientsCacheModel.receivedDateTime = Long.MIN_VALUE;
		}

		flaskGroupRecipientsCacheModel.senderId = getSenderId();

		return flaskGroupRecipientsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{groupRecipientId=");
		sb.append(getGroupRecipientId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", recipients=");
		sb.append(getRecipients());
		sb.append(", groupMessageId=");
		sb.append(getGroupMessageId());
		sb.append(", read=");
		sb.append(getRead());
		sb.append(", receivedDateTime=");
		sb.append(getReceivedDateTime());
		sb.append(", senderId=");
		sb.append(getSenderId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.contacts.model.FlaskGroupRecipients");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupRecipientId</column-name><column-value><![CDATA[");
		sb.append(getGroupRecipientId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recipients</column-name><column-value><![CDATA[");
		sb.append(getRecipients());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupMessageId</column-name><column-value><![CDATA[");
		sb.append(getGroupMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>read</column-name><column-value><![CDATA[");
		sb.append(getRead());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receivedDateTime</column-name><column-value><![CDATA[");
		sb.append(getReceivedDateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderId</column-name><column-value><![CDATA[");
		sb.append(getSenderId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = FlaskGroupRecipients.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FlaskGroupRecipients.class
		};
	private long _groupRecipientId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _recipients;
	private long _groupMessageId;
	private long _originalGroupMessageId;
	private boolean _setOriginalGroupMessageId;
	private String _read;
	private Date _receivedDateTime;
	private long _senderId;
	private long _columnBitmask;
	private FlaskGroupRecipients _escapedModel;
}