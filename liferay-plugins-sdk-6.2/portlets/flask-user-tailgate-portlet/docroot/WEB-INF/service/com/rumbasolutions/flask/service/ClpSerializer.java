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

package com.rumbasolutions.flask.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.rumbasolutions.flask.model.SupplyItemClp;
import com.rumbasolutions.flask.model.SupplyListClp;
import com.rumbasolutions.flask.model.TailgateImagesClp;
import com.rumbasolutions.flask.model.TailgateInfoClp;
import com.rumbasolutions.flask.model.TailgateMarkerClp;
import com.rumbasolutions.flask.model.TailgateMessageBoardClp;
import com.rumbasolutions.flask.model.TailgateSupplyItemClp;
import com.rumbasolutions.flask.model.TailgateUsersClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"flask-user-tailgate-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"flask-user-tailgate-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "flask-user-tailgate-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SupplyItemClp.class.getName())) {
			return translateInputSupplyItem(oldModel);
		}

		if (oldModelClassName.equals(SupplyListClp.class.getName())) {
			return translateInputSupplyList(oldModel);
		}

		if (oldModelClassName.equals(TailgateImagesClp.class.getName())) {
			return translateInputTailgateImages(oldModel);
		}

		if (oldModelClassName.equals(TailgateInfoClp.class.getName())) {
			return translateInputTailgateInfo(oldModel);
		}

		if (oldModelClassName.equals(TailgateMarkerClp.class.getName())) {
			return translateInputTailgateMarker(oldModel);
		}

		if (oldModelClassName.equals(TailgateMessageBoardClp.class.getName())) {
			return translateInputTailgateMessageBoard(oldModel);
		}

		if (oldModelClassName.equals(TailgateSupplyItemClp.class.getName())) {
			return translateInputTailgateSupplyItem(oldModel);
		}

		if (oldModelClassName.equals(TailgateUsersClp.class.getName())) {
			return translateInputTailgateUsers(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputSupplyItem(BaseModel<?> oldModel) {
		SupplyItemClp oldClpModel = (SupplyItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSupplyItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSupplyList(BaseModel<?> oldModel) {
		SupplyListClp oldClpModel = (SupplyListClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSupplyListRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTailgateImages(BaseModel<?> oldModel) {
		TailgateImagesClp oldClpModel = (TailgateImagesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTailgateImagesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTailgateInfo(BaseModel<?> oldModel) {
		TailgateInfoClp oldClpModel = (TailgateInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTailgateInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTailgateMarker(BaseModel<?> oldModel) {
		TailgateMarkerClp oldClpModel = (TailgateMarkerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTailgateMarkerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTailgateMessageBoard(
		BaseModel<?> oldModel) {
		TailgateMessageBoardClp oldClpModel = (TailgateMessageBoardClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTailgateMessageBoardRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTailgateSupplyItem(BaseModel<?> oldModel) {
		TailgateSupplyItemClp oldClpModel = (TailgateSupplyItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTailgateSupplyItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTailgateUsers(BaseModel<?> oldModel) {
		TailgateUsersClp oldClpModel = (TailgateUsersClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTailgateUsersRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.SupplyItemImpl")) {
			return translateOutputSupplyItem(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.SupplyListImpl")) {
			return translateOutputSupplyList(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.TailgateImagesImpl")) {
			return translateOutputTailgateImages(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.TailgateInfoImpl")) {
			return translateOutputTailgateInfo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.TailgateMarkerImpl")) {
			return translateOutputTailgateMarker(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.TailgateMessageBoardImpl")) {
			return translateOutputTailgateMessageBoard(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.TailgateSupplyItemImpl")) {
			return translateOutputTailgateSupplyItem(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.rumbasolutions.flask.model.impl.TailgateUsersImpl")) {
			return translateOutputTailgateUsers(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchSupplyItemException")) {
			return new com.rumbasolutions.flask.NoSuchSupplyItemException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchSupplyListException")) {
			return new com.rumbasolutions.flask.NoSuchSupplyListException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchTailgateImagesException")) {
			return new com.rumbasolutions.flask.NoSuchTailgateImagesException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchTailgateInfoException")) {
			return new com.rumbasolutions.flask.NoSuchTailgateInfoException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchTailgateMarkerException")) {
			return new com.rumbasolutions.flask.NoSuchTailgateMarkerException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchTailgateMessageBoardException")) {
			return new com.rumbasolutions.flask.NoSuchTailgateMessageBoardException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchTailgateSupplyItemException")) {
			return new com.rumbasolutions.flask.NoSuchTailgateSupplyItemException();
		}

		if (className.equals(
					"com.rumbasolutions.flask.NoSuchTailgateUsersException")) {
			return new com.rumbasolutions.flask.NoSuchTailgateUsersException();
		}

		return throwable;
	}

	public static Object translateOutputSupplyItem(BaseModel<?> oldModel) {
		SupplyItemClp newModel = new SupplyItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSupplyItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSupplyList(BaseModel<?> oldModel) {
		SupplyListClp newModel = new SupplyListClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSupplyListRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTailgateImages(BaseModel<?> oldModel) {
		TailgateImagesClp newModel = new TailgateImagesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTailgateImagesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTailgateInfo(BaseModel<?> oldModel) {
		TailgateInfoClp newModel = new TailgateInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTailgateInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTailgateMarker(BaseModel<?> oldModel) {
		TailgateMarkerClp newModel = new TailgateMarkerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTailgateMarkerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTailgateMessageBoard(
		BaseModel<?> oldModel) {
		TailgateMessageBoardClp newModel = new TailgateMessageBoardClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTailgateMessageBoardRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTailgateSupplyItem(
		BaseModel<?> oldModel) {
		TailgateSupplyItemClp newModel = new TailgateSupplyItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTailgateSupplyItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTailgateUsers(BaseModel<?> oldModel) {
		TailgateUsersClp newModel = new TailgateUsersClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTailgateUsersRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}