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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rumbasolutions.flask.model.SupplyItem;
import com.rumbasolutions.flask.model.SupplyItemModel;
import com.rumbasolutions.flask.model.SupplyItemSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the SupplyItem service. Represents a row in the &quot;flasktailgate_SupplyItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.SupplyItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SupplyItemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplyItemImpl
 * @see com.rumbasolutions.flask.model.SupplyItem
 * @see com.rumbasolutions.flask.model.SupplyItemModel
 * @generated
 */
@JSON(strict = true)
public class SupplyItemModelImpl extends BaseModelImpl<SupplyItem>
	implements SupplyItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a supply item model instance should use the {@link com.rumbasolutions.flask.model.SupplyItem} interface instead.
	 */
	public static final String TABLE_NAME = "flasktailgate_SupplyItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "supplyItemId", Types.BIGINT },
			{ "supplyItemName", Types.VARCHAR },
			{ "supplyListId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table flasktailgate_SupplyItem (supplyItemId LONG not null primary key,supplyItemName VARCHAR(75) null,supplyListId LONG,createdDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table flasktailgate_SupplyItem";
	public static final String ORDER_BY_JPQL = " ORDER BY supplyItem.supplyItemId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flasktailgate_SupplyItem.supplyItemId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.SupplyItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.SupplyItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rumbasolutions.flask.model.SupplyItem"),
			true);
	public static long SUPPLYLISTID_COLUMN_BITMASK = 1L;
	public static long SUPPLYITEMID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SupplyItem toModel(SupplyItemSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SupplyItem model = new SupplyItemImpl();

		model.setSupplyItemId(soapModel.getSupplyItemId());
		model.setSupplyItemName(soapModel.getSupplyItemName());
		model.setSupplyListId(soapModel.getSupplyListId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SupplyItem> toModels(SupplyItemSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SupplyItem> models = new ArrayList<SupplyItem>(soapModels.length);

		for (SupplyItemSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.SupplyItem"));

	public SupplyItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _supplyItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSupplyItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supplyItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SupplyItem.class;
	}

	@Override
	public String getModelClassName() {
		return SupplyItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supplyItemId", getSupplyItemId());
		attributes.put("supplyItemName", getSupplyItemName());
		attributes.put("supplyListId", getSupplyListId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supplyItemId = (Long)attributes.get("supplyItemId");

		if (supplyItemId != null) {
			setSupplyItemId(supplyItemId);
		}

		String supplyItemName = (String)attributes.get("supplyItemName");

		if (supplyItemName != null) {
			setSupplyItemName(supplyItemName);
		}

		Long supplyListId = (Long)attributes.get("supplyListId");

		if (supplyListId != null) {
			setSupplyListId(supplyListId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@JSON
	@Override
	public long getSupplyItemId() {
		return _supplyItemId;
	}

	@Override
	public void setSupplyItemId(long supplyItemId) {
		_supplyItemId = supplyItemId;
	}

	@JSON
	@Override
	public String getSupplyItemName() {
		if (_supplyItemName == null) {
			return StringPool.BLANK;
		}
		else {
			return _supplyItemName;
		}
	}

	@Override
	public void setSupplyItemName(String supplyItemName) {
		_supplyItemName = supplyItemName;
	}

	@JSON
	@Override
	public long getSupplyListId() {
		return _supplyListId;
	}

	@Override
	public void setSupplyListId(long supplyListId) {
		_columnBitmask |= SUPPLYLISTID_COLUMN_BITMASK;

		if (!_setOriginalSupplyListId) {
			_setOriginalSupplyListId = true;

			_originalSupplyListId = _supplyListId;
		}

		_supplyListId = supplyListId;
	}

	public long getOriginalSupplyListId() {
		return _originalSupplyListId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SupplyItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SupplyItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SupplyItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SupplyItemImpl supplyItemImpl = new SupplyItemImpl();

		supplyItemImpl.setSupplyItemId(getSupplyItemId());
		supplyItemImpl.setSupplyItemName(getSupplyItemName());
		supplyItemImpl.setSupplyListId(getSupplyListId());
		supplyItemImpl.setCreatedDate(getCreatedDate());
		supplyItemImpl.setModifiedDate(getModifiedDate());

		supplyItemImpl.resetOriginalValues();

		return supplyItemImpl;
	}

	@Override
	public int compareTo(SupplyItem supplyItem) {
		long primaryKey = supplyItem.getPrimaryKey();

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

		if (!(obj instanceof SupplyItem)) {
			return false;
		}

		SupplyItem supplyItem = (SupplyItem)obj;

		long primaryKey = supplyItem.getPrimaryKey();

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
		SupplyItemModelImpl supplyItemModelImpl = this;

		supplyItemModelImpl._originalSupplyListId = supplyItemModelImpl._supplyListId;

		supplyItemModelImpl._setOriginalSupplyListId = false;

		supplyItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SupplyItem> toCacheModel() {
		SupplyItemCacheModel supplyItemCacheModel = new SupplyItemCacheModel();

		supplyItemCacheModel.supplyItemId = getSupplyItemId();

		supplyItemCacheModel.supplyItemName = getSupplyItemName();

		String supplyItemName = supplyItemCacheModel.supplyItemName;

		if ((supplyItemName != null) && (supplyItemName.length() == 0)) {
			supplyItemCacheModel.supplyItemName = null;
		}

		supplyItemCacheModel.supplyListId = getSupplyListId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			supplyItemCacheModel.createdDate = createdDate.getTime();
		}
		else {
			supplyItemCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			supplyItemCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			supplyItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return supplyItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{supplyItemId=");
		sb.append(getSupplyItemId());
		sb.append(", supplyItemName=");
		sb.append(getSupplyItemName());
		sb.append(", supplyListId=");
		sb.append(getSupplyListId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.SupplyItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>supplyItemId</column-name><column-value><![CDATA[");
		sb.append(getSupplyItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplyItemName</column-name><column-value><![CDATA[");
		sb.append(getSupplyItemName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplyListId</column-name><column-value><![CDATA[");
		sb.append(getSupplyListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SupplyItem.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SupplyItem.class
		};
	private long _supplyItemId;
	private String _supplyItemName;
	private long _supplyListId;
	private long _originalSupplyListId;
	private boolean _setOriginalSupplyListId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private SupplyItem _escapedModel;
}