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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rumbasolutions.flask.service.ClpSerializer;
import com.rumbasolutions.flask.service.UserTailgateLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rajeshj
 */
public class UserTailgateClp extends BaseModelImpl<UserTailgate>
	implements UserTailgate {
	public UserTailgateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserTailgate.class;
	}

	@Override
	public String getModelClassName() {
		return UserTailgate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tailgateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTailgateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tailgateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateId", getTailgateId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tailgateName", getTailgateName());
		attributes.put("tailgateDescription", getTailgateDescription());
		attributes.put("eventId", getEventId());
		attributes.put("eventName", getEventName());
		attributes.put("tailgateDate", getTailgateDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String tailgateName = (String)attributes.get("tailgateName");

		if (tailgateName != null) {
			setTailgateName(tailgateName);
		}

		String tailgateDescription = (String)attributes.get(
				"tailgateDescription");

		if (tailgateDescription != null) {
			setTailgateDescription(tailgateDescription);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String eventName = (String)attributes.get("eventName");

		if (eventName != null) {
			setEventName(eventName);
		}

		Date tailgateDate = (Date)attributes.get("tailgateDate");

		if (tailgateDate != null) {
			setTailgateDate(tailgateDate);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}
	}

	@Override
	public long getTailgateId() {
		return _tailgateId;
	}

	@Override
	public void setTailgateId(long tailgateId) {
		_tailgateId = tailgateId;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateId", long.class);

				method.invoke(_userTailgateRemoteModel, tailgateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_userTailgateRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userTailgateRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_userTailgateRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_userTailgateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTailgateName() {
		return _tailgateName;
	}

	@Override
	public void setTailgateName(String tailgateName) {
		_tailgateName = tailgateName;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateName", String.class);

				method.invoke(_userTailgateRemoteModel, tailgateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTailgateDescription() {
		return _tailgateDescription;
	}

	@Override
	public void setTailgateDescription(String tailgateDescription) {
		_tailgateDescription = tailgateDescription;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateDescription",
						String.class);

				method.invoke(_userTailgateRemoteModel, tailgateDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_userTailgateRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventName() {
		return _eventName;
	}

	@Override
	public void setEventName(String eventName) {
		_eventName = eventName;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setEventName", String.class);

				method.invoke(_userTailgateRemoteModel, eventName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getTailgateDate() {
		return _tailgateDate;
	}

	@Override
	public void setTailgateDate(Date tailgateDate) {
		_tailgateDate = tailgateDate;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateDate", Date.class);

				method.invoke(_userTailgateRemoteModel, tailgateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", Date.class);

				method.invoke(_userTailgateRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;

		if (_userTailgateRemoteModel != null) {
			try {
				Class<?> clazz = _userTailgateRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", Date.class);

				method.invoke(_userTailgateRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserTailgateRemoteModel() {
		return _userTailgateRemoteModel;
	}

	public void setUserTailgateRemoteModel(BaseModel<?> userTailgateRemoteModel) {
		_userTailgateRemoteModel = userTailgateRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _userTailgateRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_userTailgateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserTailgateLocalServiceUtil.addUserTailgate(this);
		}
		else {
			UserTailgateLocalServiceUtil.updateUserTailgate(this);
		}
	}

	@Override
	public UserTailgate toEscapedModel() {
		return (UserTailgate)ProxyUtil.newProxyInstance(UserTailgate.class.getClassLoader(),
			new Class[] { UserTailgate.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserTailgateClp clone = new UserTailgateClp();

		clone.setTailgateId(getTailgateId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTailgateName(getTailgateName());
		clone.setTailgateDescription(getTailgateDescription());
		clone.setEventId(getEventId());
		clone.setEventName(getEventName());
		clone.setTailgateDate(getTailgateDate());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());

		return clone;
	}

	@Override
	public int compareTo(UserTailgate userTailgate) {
		int value = 0;

		if (getTailgateId() < userTailgate.getTailgateId()) {
			value = -1;
		}
		else if (getTailgateId() > userTailgate.getTailgateId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof UserTailgateClp)) {
			return false;
		}

		UserTailgateClp userTailgate = (UserTailgateClp)obj;

		long primaryKey = userTailgate.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{tailgateId=");
		sb.append(getTailgateId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", tailgateName=");
		sb.append(getTailgateName());
		sb.append(", tailgateDescription=");
		sb.append(getTailgateDescription());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append(", eventName=");
		sb.append(getEventName());
		sb.append(", tailgateDate=");
		sb.append(getTailgateDate());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.UserTailgate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tailgateId</column-name><column-value><![CDATA[");
		sb.append(getTailgateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>tailgateName</column-name><column-value><![CDATA[");
		sb.append(getTailgateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tailgateDescription</column-name><column-value><![CDATA[");
		sb.append(getTailgateDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventName</column-name><column-value><![CDATA[");
		sb.append(getEventName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tailgateDate</column-name><column-value><![CDATA[");
		sb.append(getTailgateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tailgateId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _tailgateName;
	private String _tailgateDescription;
	private long _eventId;
	private String _eventName;
	private Date _tailgateDate;
	private Date _startTime;
	private Date _endTime;
	private BaseModel<?> _userTailgateRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}