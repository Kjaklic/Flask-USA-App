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

import com.rumbasolutions.flask.model.InfoTypeCategory;
import com.rumbasolutions.flask.model.InfoTypeCategoryModel;
import com.rumbasolutions.flask.model.InfoTypeCategorySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the InfoTypeCategory service. Represents a row in the &quot;flaskevents_InfoTypeCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.InfoTypeCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link InfoTypeCategoryImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see InfoTypeCategoryImpl
 * @see com.rumbasolutions.flask.model.InfoTypeCategory
 * @see com.rumbasolutions.flask.model.InfoTypeCategoryModel
 * @generated
 */
@JSON(strict = true)
public class InfoTypeCategoryModelImpl extends BaseModelImpl<InfoTypeCategory>
	implements InfoTypeCategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a info type category model instance should use the {@link com.rumbasolutions.flask.model.InfoTypeCategory} interface instead.
	 */
	public static final String TABLE_NAME = "flaskevents_InfoTypeCategory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "infoTypeCategoryId", Types.BIGINT },
			{ "infoTypeCategoryName", Types.VARCHAR },
			{ "displayTemplate", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table flaskevents_InfoTypeCategory (infoTypeCategoryId LONG not null primary key,infoTypeCategoryName VARCHAR(75) null,displayTemplate VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table flaskevents_InfoTypeCategory";
	public static final String ORDER_BY_JPQL = " ORDER BY infoTypeCategory.infoTypeCategoryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flaskevents_InfoTypeCategory.infoTypeCategoryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.InfoTypeCategory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.InfoTypeCategory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static InfoTypeCategory toModel(InfoTypeCategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		InfoTypeCategory model = new InfoTypeCategoryImpl();

		model.setInfoTypeCategoryId(soapModel.getInfoTypeCategoryId());
		model.setInfoTypeCategoryName(soapModel.getInfoTypeCategoryName());
		model.setDisplayTemplate(soapModel.getDisplayTemplate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<InfoTypeCategory> toModels(
		InfoTypeCategorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<InfoTypeCategory> models = new ArrayList<InfoTypeCategory>(soapModels.length);

		for (InfoTypeCategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.InfoTypeCategory"));

	public InfoTypeCategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _infoTypeCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInfoTypeCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _infoTypeCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return InfoTypeCategory.class;
	}

	@Override
	public String getModelClassName() {
		return InfoTypeCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
		attributes.put("infoTypeCategoryName", getInfoTypeCategoryName());
		attributes.put("displayTemplate", getDisplayTemplate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long infoTypeCategoryId = (Long)attributes.get("infoTypeCategoryId");

		if (infoTypeCategoryId != null) {
			setInfoTypeCategoryId(infoTypeCategoryId);
		}

		String infoTypeCategoryName = (String)attributes.get(
				"infoTypeCategoryName");

		if (infoTypeCategoryName != null) {
			setInfoTypeCategoryName(infoTypeCategoryName);
		}

		String displayTemplate = (String)attributes.get("displayTemplate");

		if (displayTemplate != null) {
			setDisplayTemplate(displayTemplate);
		}
	}

	@JSON
	@Override
	public long getInfoTypeCategoryId() {
		return _infoTypeCategoryId;
	}

	@Override
	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_infoTypeCategoryId = infoTypeCategoryId;
	}

	@JSON
	@Override
	public String getInfoTypeCategoryName() {
		if (_infoTypeCategoryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _infoTypeCategoryName;
		}
	}

	@Override
	public void setInfoTypeCategoryName(String infoTypeCategoryName) {
		_infoTypeCategoryName = infoTypeCategoryName;
	}

	@JSON
	@Override
	public String getDisplayTemplate() {
		if (_displayTemplate == null) {
			return StringPool.BLANK;
		}
		else {
			return _displayTemplate;
		}
	}

	@Override
	public void setDisplayTemplate(String displayTemplate) {
		_displayTemplate = displayTemplate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			InfoTypeCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public InfoTypeCategory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (InfoTypeCategory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		InfoTypeCategoryImpl infoTypeCategoryImpl = new InfoTypeCategoryImpl();

		infoTypeCategoryImpl.setInfoTypeCategoryId(getInfoTypeCategoryId());
		infoTypeCategoryImpl.setInfoTypeCategoryName(getInfoTypeCategoryName());
		infoTypeCategoryImpl.setDisplayTemplate(getDisplayTemplate());

		infoTypeCategoryImpl.resetOriginalValues();

		return infoTypeCategoryImpl;
	}

	@Override
	public int compareTo(InfoTypeCategory infoTypeCategory) {
		long primaryKey = infoTypeCategory.getPrimaryKey();

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

		if (!(obj instanceof InfoTypeCategory)) {
			return false;
		}

		InfoTypeCategory infoTypeCategory = (InfoTypeCategory)obj;

		long primaryKey = infoTypeCategory.getPrimaryKey();

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
	}

	@Override
	public CacheModel<InfoTypeCategory> toCacheModel() {
		InfoTypeCategoryCacheModel infoTypeCategoryCacheModel = new InfoTypeCategoryCacheModel();

		infoTypeCategoryCacheModel.infoTypeCategoryId = getInfoTypeCategoryId();

		infoTypeCategoryCacheModel.infoTypeCategoryName = getInfoTypeCategoryName();

		String infoTypeCategoryName = infoTypeCategoryCacheModel.infoTypeCategoryName;

		if ((infoTypeCategoryName != null) &&
				(infoTypeCategoryName.length() == 0)) {
			infoTypeCategoryCacheModel.infoTypeCategoryName = null;
		}

		infoTypeCategoryCacheModel.displayTemplate = getDisplayTemplate();

		String displayTemplate = infoTypeCategoryCacheModel.displayTemplate;

		if ((displayTemplate != null) && (displayTemplate.length() == 0)) {
			infoTypeCategoryCacheModel.displayTemplate = null;
		}

		return infoTypeCategoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{infoTypeCategoryId=");
		sb.append(getInfoTypeCategoryId());
		sb.append(", infoTypeCategoryName=");
		sb.append(getInfoTypeCategoryName());
		sb.append(", displayTemplate=");
		sb.append(getDisplayTemplate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.InfoTypeCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>infoTypeCategoryId</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeCategoryName</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayTemplate</column-name><column-value><![CDATA[");
		sb.append(getDisplayTemplate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = InfoTypeCategory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			InfoTypeCategory.class
		};
	private long _infoTypeCategoryId;
	private String _infoTypeCategoryName;
	private String _displayTemplate;
	private InfoTypeCategory _escapedModel;
}