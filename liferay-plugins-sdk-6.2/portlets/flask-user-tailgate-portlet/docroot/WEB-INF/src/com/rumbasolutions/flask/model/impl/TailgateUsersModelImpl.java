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

import com.rumbasolutions.flask.model.TailgateUsers;
import com.rumbasolutions.flask.model.TailgateUsersModel;
import com.rumbasolutions.flask.model.TailgateUsersSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TailgateUsers service. Represents a row in the &quot;flasktailgate_TailgateUsers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.TailgateUsersModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TailgateUsersImpl}.
 * </p>
 *
 * @author rajeshj
 * @see TailgateUsersImpl
 * @see com.rumbasolutions.flask.model.TailgateUsers
 * @see com.rumbasolutions.flask.model.TailgateUsersModel
 * @generated
 */
@JSON(strict = true)
public class TailgateUsersModelImpl extends BaseModelImpl<TailgateUsers>
	implements TailgateUsersModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tailgate users model instance should use the {@link com.rumbasolutions.flask.model.TailgateUsers} interface instead.
	 */
	public static final String TABLE_NAME = "flasktailgate_TailgateUsers";
	public static final Object[][] TABLE_COLUMNS = {
			{ "tailgateUserId", Types.BIGINT },
			{ "tailgateId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "isAdmin", Types.INTEGER },
			{ "groupId", Types.BIGINT },
			{ "emailAddress", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table flasktailgate_TailgateUsers (tailgateUserId LONG not null primary key,tailgateId LONG,userId LONG,userName VARCHAR(75) null,isAdmin INTEGER,groupId LONG,emailAddress VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table flasktailgate_TailgateUsers";
	public static final String ORDER_BY_JPQL = " ORDER BY tailgateUsers.tailgateUserId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flasktailgate_TailgateUsers.tailgateUserId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.TailgateUsers"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.TailgateUsers"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rumbasolutions.flask.model.TailgateUsers"),
			true);
	public static long TAILGATEID_COLUMN_BITMASK = 1L;
	public static long TAILGATEUSERID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TailgateUsers toModel(TailgateUsersSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TailgateUsers model = new TailgateUsersImpl();

		model.setTailgateUserId(soapModel.getTailgateUserId());
		model.setTailgateId(soapModel.getTailgateId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setIsAdmin(soapModel.getIsAdmin());
		model.setGroupId(soapModel.getGroupId());
		model.setEmailAddress(soapModel.getEmailAddress());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TailgateUsers> toModels(TailgateUsersSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TailgateUsers> models = new ArrayList<TailgateUsers>(soapModels.length);

		for (TailgateUsersSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.TailgateUsers"));

	public TailgateUsersModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tailgateUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTailgateUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tailgateUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateUsers.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateUsers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateUserId", getTailgateUserId());
		attributes.put("tailgateId", getTailgateId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("isAdmin", getIsAdmin());
		attributes.put("groupId", getGroupId());
		attributes.put("emailAddress", getEmailAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateUserId = (Long)attributes.get("tailgateUserId");

		if (tailgateUserId != null) {
			setTailgateUserId(tailgateUserId);
		}

		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Integer isAdmin = (Integer)attributes.get("isAdmin");

		if (isAdmin != null) {
			setIsAdmin(isAdmin);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}
	}

	@JSON
	@Override
	public long getTailgateUserId() {
		return _tailgateUserId;
	}

	@Override
	public void setTailgateUserId(long tailgateUserId) {
		_tailgateUserId = tailgateUserId;
	}

	@Override
	public String getTailgateUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getTailgateUserId(), "uuid",
			_tailgateUserUuid);
	}

	@Override
	public void setTailgateUserUuid(String tailgateUserUuid) {
		_tailgateUserUuid = tailgateUserUuid;
	}

	@JSON
	@Override
	public long getTailgateId() {
		return _tailgateId;
	}

	@Override
	public void setTailgateId(long tailgateId) {
		_columnBitmask |= TAILGATEID_COLUMN_BITMASK;

		if (!_setOriginalTailgateId) {
			_setOriginalTailgateId = true;

			_originalTailgateId = _tailgateId;
		}

		_tailgateId = tailgateId;
	}

	public long getOriginalTailgateId() {
		return _originalTailgateId;
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
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public int getIsAdmin() {
		return _isAdmin;
	}

	@Override
	public void setIsAdmin(int isAdmin) {
		_isAdmin = isAdmin;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TailgateUsers.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TailgateUsers toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TailgateUsers)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TailgateUsersImpl tailgateUsersImpl = new TailgateUsersImpl();

		tailgateUsersImpl.setTailgateUserId(getTailgateUserId());
		tailgateUsersImpl.setTailgateId(getTailgateId());
		tailgateUsersImpl.setUserId(getUserId());
		tailgateUsersImpl.setUserName(getUserName());
		tailgateUsersImpl.setIsAdmin(getIsAdmin());
		tailgateUsersImpl.setGroupId(getGroupId());
		tailgateUsersImpl.setEmailAddress(getEmailAddress());

		tailgateUsersImpl.resetOriginalValues();

		return tailgateUsersImpl;
	}

	@Override
	public int compareTo(TailgateUsers tailgateUsers) {
		long primaryKey = tailgateUsers.getPrimaryKey();

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

		if (!(obj instanceof TailgateUsers)) {
			return false;
		}

		TailgateUsers tailgateUsers = (TailgateUsers)obj;

		long primaryKey = tailgateUsers.getPrimaryKey();

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
		TailgateUsersModelImpl tailgateUsersModelImpl = this;

		tailgateUsersModelImpl._originalTailgateId = tailgateUsersModelImpl._tailgateId;

		tailgateUsersModelImpl._setOriginalTailgateId = false;

		tailgateUsersModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TailgateUsers> toCacheModel() {
		TailgateUsersCacheModel tailgateUsersCacheModel = new TailgateUsersCacheModel();

		tailgateUsersCacheModel.tailgateUserId = getTailgateUserId();

		tailgateUsersCacheModel.tailgateId = getTailgateId();

		tailgateUsersCacheModel.userId = getUserId();

		tailgateUsersCacheModel.userName = getUserName();

		String userName = tailgateUsersCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			tailgateUsersCacheModel.userName = null;
		}

		tailgateUsersCacheModel.isAdmin = getIsAdmin();

		tailgateUsersCacheModel.groupId = getGroupId();

		tailgateUsersCacheModel.emailAddress = getEmailAddress();

		String emailAddress = tailgateUsersCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			tailgateUsersCacheModel.emailAddress = null;
		}

		return tailgateUsersCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{tailgateUserId=");
		sb.append(getTailgateUserId());
		sb.append(", tailgateId=");
		sb.append(getTailgateId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", isAdmin=");
		sb.append(getIsAdmin());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.TailgateUsers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tailgateUserId</column-name><column-value><![CDATA[");
		sb.append(getTailgateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tailgateId</column-name><column-value><![CDATA[");
		sb.append(getTailgateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isAdmin</column-name><column-value><![CDATA[");
		sb.append(getIsAdmin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TailgateUsers.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TailgateUsers.class
		};
	private long _tailgateUserId;
	private String _tailgateUserUuid;
	private long _tailgateId;
	private long _originalTailgateId;
	private boolean _setOriginalTailgateId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private int _isAdmin;
	private long _groupId;
	private String _emailAddress;
	private long _columnBitmask;
	private TailgateUsers _escapedModel;
}