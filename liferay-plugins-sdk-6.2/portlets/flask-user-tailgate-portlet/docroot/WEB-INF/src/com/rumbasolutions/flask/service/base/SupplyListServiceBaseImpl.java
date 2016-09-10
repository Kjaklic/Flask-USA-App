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

package com.rumbasolutions.flask.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rumbasolutions.flask.model.SupplyList;
import com.rumbasolutions.flask.service.SupplyListService;
import com.rumbasolutions.flask.service.persistence.SupplyItemPersistence;
import com.rumbasolutions.flask.service.persistence.SupplyListPersistence;
import com.rumbasolutions.flask.service.persistence.TailgateImagesPersistence;
import com.rumbasolutions.flask.service.persistence.TailgateInfoFinder;
import com.rumbasolutions.flask.service.persistence.TailgateInfoPersistence;
import com.rumbasolutions.flask.service.persistence.TailgateMarkerFinder;
import com.rumbasolutions.flask.service.persistence.TailgateMarkerPersistence;
import com.rumbasolutions.flask.service.persistence.TailgateMessageBoardPersistence;
import com.rumbasolutions.flask.service.persistence.TailgateSupplyItemPersistence;
import com.rumbasolutions.flask.service.persistence.TailgateUsersFinder;
import com.rumbasolutions.flask.service.persistence.TailgateUsersPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the supply list remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rumbasolutions.flask.service.impl.SupplyListServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.impl.SupplyListServiceImpl
 * @see com.rumbasolutions.flask.service.SupplyListServiceUtil
 * @generated
 */
public abstract class SupplyListServiceBaseImpl extends BaseServiceImpl
	implements SupplyListService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rumbasolutions.flask.service.SupplyListServiceUtil} to access the supply list remote service.
	 */

	/**
	 * Returns the supply item local service.
	 *
	 * @return the supply item local service
	 */
	public com.rumbasolutions.flask.service.SupplyItemLocalService getSupplyItemLocalService() {
		return supplyItemLocalService;
	}

	/**
	 * Sets the supply item local service.
	 *
	 * @param supplyItemLocalService the supply item local service
	 */
	public void setSupplyItemLocalService(
		com.rumbasolutions.flask.service.SupplyItemLocalService supplyItemLocalService) {
		this.supplyItemLocalService = supplyItemLocalService;
	}

	/**
	 * Returns the supply item remote service.
	 *
	 * @return the supply item remote service
	 */
	public com.rumbasolutions.flask.service.SupplyItemService getSupplyItemService() {
		return supplyItemService;
	}

	/**
	 * Sets the supply item remote service.
	 *
	 * @param supplyItemService the supply item remote service
	 */
	public void setSupplyItemService(
		com.rumbasolutions.flask.service.SupplyItemService supplyItemService) {
		this.supplyItemService = supplyItemService;
	}

	/**
	 * Returns the supply item persistence.
	 *
	 * @return the supply item persistence
	 */
	public SupplyItemPersistence getSupplyItemPersistence() {
		return supplyItemPersistence;
	}

	/**
	 * Sets the supply item persistence.
	 *
	 * @param supplyItemPersistence the supply item persistence
	 */
	public void setSupplyItemPersistence(
		SupplyItemPersistence supplyItemPersistence) {
		this.supplyItemPersistence = supplyItemPersistence;
	}

	/**
	 * Returns the supply list local service.
	 *
	 * @return the supply list local service
	 */
	public com.rumbasolutions.flask.service.SupplyListLocalService getSupplyListLocalService() {
		return supplyListLocalService;
	}

	/**
	 * Sets the supply list local service.
	 *
	 * @param supplyListLocalService the supply list local service
	 */
	public void setSupplyListLocalService(
		com.rumbasolutions.flask.service.SupplyListLocalService supplyListLocalService) {
		this.supplyListLocalService = supplyListLocalService;
	}

	/**
	 * Returns the supply list remote service.
	 *
	 * @return the supply list remote service
	 */
	public com.rumbasolutions.flask.service.SupplyListService getSupplyListService() {
		return supplyListService;
	}

	/**
	 * Sets the supply list remote service.
	 *
	 * @param supplyListService the supply list remote service
	 */
	public void setSupplyListService(
		com.rumbasolutions.flask.service.SupplyListService supplyListService) {
		this.supplyListService = supplyListService;
	}

	/**
	 * Returns the supply list persistence.
	 *
	 * @return the supply list persistence
	 */
	public SupplyListPersistence getSupplyListPersistence() {
		return supplyListPersistence;
	}

	/**
	 * Sets the supply list persistence.
	 *
	 * @param supplyListPersistence the supply list persistence
	 */
	public void setSupplyListPersistence(
		SupplyListPersistence supplyListPersistence) {
		this.supplyListPersistence = supplyListPersistence;
	}

	/**
	 * Returns the tailgate images local service.
	 *
	 * @return the tailgate images local service
	 */
	public com.rumbasolutions.flask.service.TailgateImagesLocalService getTailgateImagesLocalService() {
		return tailgateImagesLocalService;
	}

	/**
	 * Sets the tailgate images local service.
	 *
	 * @param tailgateImagesLocalService the tailgate images local service
	 */
	public void setTailgateImagesLocalService(
		com.rumbasolutions.flask.service.TailgateImagesLocalService tailgateImagesLocalService) {
		this.tailgateImagesLocalService = tailgateImagesLocalService;
	}

	/**
	 * Returns the tailgate images remote service.
	 *
	 * @return the tailgate images remote service
	 */
	public com.rumbasolutions.flask.service.TailgateImagesService getTailgateImagesService() {
		return tailgateImagesService;
	}

	/**
	 * Sets the tailgate images remote service.
	 *
	 * @param tailgateImagesService the tailgate images remote service
	 */
	public void setTailgateImagesService(
		com.rumbasolutions.flask.service.TailgateImagesService tailgateImagesService) {
		this.tailgateImagesService = tailgateImagesService;
	}

	/**
	 * Returns the tailgate images persistence.
	 *
	 * @return the tailgate images persistence
	 */
	public TailgateImagesPersistence getTailgateImagesPersistence() {
		return tailgateImagesPersistence;
	}

	/**
	 * Sets the tailgate images persistence.
	 *
	 * @param tailgateImagesPersistence the tailgate images persistence
	 */
	public void setTailgateImagesPersistence(
		TailgateImagesPersistence tailgateImagesPersistence) {
		this.tailgateImagesPersistence = tailgateImagesPersistence;
	}

	/**
	 * Returns the tailgate info local service.
	 *
	 * @return the tailgate info local service
	 */
	public com.rumbasolutions.flask.service.TailgateInfoLocalService getTailgateInfoLocalService() {
		return tailgateInfoLocalService;
	}

	/**
	 * Sets the tailgate info local service.
	 *
	 * @param tailgateInfoLocalService the tailgate info local service
	 */
	public void setTailgateInfoLocalService(
		com.rumbasolutions.flask.service.TailgateInfoLocalService tailgateInfoLocalService) {
		this.tailgateInfoLocalService = tailgateInfoLocalService;
	}

	/**
	 * Returns the tailgate info remote service.
	 *
	 * @return the tailgate info remote service
	 */
	public com.rumbasolutions.flask.service.TailgateInfoService getTailgateInfoService() {
		return tailgateInfoService;
	}

	/**
	 * Sets the tailgate info remote service.
	 *
	 * @param tailgateInfoService the tailgate info remote service
	 */
	public void setTailgateInfoService(
		com.rumbasolutions.flask.service.TailgateInfoService tailgateInfoService) {
		this.tailgateInfoService = tailgateInfoService;
	}

	/**
	 * Returns the tailgate info persistence.
	 *
	 * @return the tailgate info persistence
	 */
	public TailgateInfoPersistence getTailgateInfoPersistence() {
		return tailgateInfoPersistence;
	}

	/**
	 * Sets the tailgate info persistence.
	 *
	 * @param tailgateInfoPersistence the tailgate info persistence
	 */
	public void setTailgateInfoPersistence(
		TailgateInfoPersistence tailgateInfoPersistence) {
		this.tailgateInfoPersistence = tailgateInfoPersistence;
	}

	/**
	 * Returns the tailgate info finder.
	 *
	 * @return the tailgate info finder
	 */
	public TailgateInfoFinder getTailgateInfoFinder() {
		return tailgateInfoFinder;
	}

	/**
	 * Sets the tailgate info finder.
	 *
	 * @param tailgateInfoFinder the tailgate info finder
	 */
	public void setTailgateInfoFinder(TailgateInfoFinder tailgateInfoFinder) {
		this.tailgateInfoFinder = tailgateInfoFinder;
	}

	/**
	 * Returns the tailgate marker local service.
	 *
	 * @return the tailgate marker local service
	 */
	public com.rumbasolutions.flask.service.TailgateMarkerLocalService getTailgateMarkerLocalService() {
		return tailgateMarkerLocalService;
	}

	/**
	 * Sets the tailgate marker local service.
	 *
	 * @param tailgateMarkerLocalService the tailgate marker local service
	 */
	public void setTailgateMarkerLocalService(
		com.rumbasolutions.flask.service.TailgateMarkerLocalService tailgateMarkerLocalService) {
		this.tailgateMarkerLocalService = tailgateMarkerLocalService;
	}

	/**
	 * Returns the tailgate marker remote service.
	 *
	 * @return the tailgate marker remote service
	 */
	public com.rumbasolutions.flask.service.TailgateMarkerService getTailgateMarkerService() {
		return tailgateMarkerService;
	}

	/**
	 * Sets the tailgate marker remote service.
	 *
	 * @param tailgateMarkerService the tailgate marker remote service
	 */
	public void setTailgateMarkerService(
		com.rumbasolutions.flask.service.TailgateMarkerService tailgateMarkerService) {
		this.tailgateMarkerService = tailgateMarkerService;
	}

	/**
	 * Returns the tailgate marker persistence.
	 *
	 * @return the tailgate marker persistence
	 */
	public TailgateMarkerPersistence getTailgateMarkerPersistence() {
		return tailgateMarkerPersistence;
	}

	/**
	 * Sets the tailgate marker persistence.
	 *
	 * @param tailgateMarkerPersistence the tailgate marker persistence
	 */
	public void setTailgateMarkerPersistence(
		TailgateMarkerPersistence tailgateMarkerPersistence) {
		this.tailgateMarkerPersistence = tailgateMarkerPersistence;
	}

	/**
	 * Returns the tailgate marker finder.
	 *
	 * @return the tailgate marker finder
	 */
	public TailgateMarkerFinder getTailgateMarkerFinder() {
		return tailgateMarkerFinder;
	}

	/**
	 * Sets the tailgate marker finder.
	 *
	 * @param tailgateMarkerFinder the tailgate marker finder
	 */
	public void setTailgateMarkerFinder(
		TailgateMarkerFinder tailgateMarkerFinder) {
		this.tailgateMarkerFinder = tailgateMarkerFinder;
	}

	/**
	 * Returns the tailgate message board local service.
	 *
	 * @return the tailgate message board local service
	 */
	public com.rumbasolutions.flask.service.TailgateMessageBoardLocalService getTailgateMessageBoardLocalService() {
		return tailgateMessageBoardLocalService;
	}

	/**
	 * Sets the tailgate message board local service.
	 *
	 * @param tailgateMessageBoardLocalService the tailgate message board local service
	 */
	public void setTailgateMessageBoardLocalService(
		com.rumbasolutions.flask.service.TailgateMessageBoardLocalService tailgateMessageBoardLocalService) {
		this.tailgateMessageBoardLocalService = tailgateMessageBoardLocalService;
	}

	/**
	 * Returns the tailgate message board remote service.
	 *
	 * @return the tailgate message board remote service
	 */
	public com.rumbasolutions.flask.service.TailgateMessageBoardService getTailgateMessageBoardService() {
		return tailgateMessageBoardService;
	}

	/**
	 * Sets the tailgate message board remote service.
	 *
	 * @param tailgateMessageBoardService the tailgate message board remote service
	 */
	public void setTailgateMessageBoardService(
		com.rumbasolutions.flask.service.TailgateMessageBoardService tailgateMessageBoardService) {
		this.tailgateMessageBoardService = tailgateMessageBoardService;
	}

	/**
	 * Returns the tailgate message board persistence.
	 *
	 * @return the tailgate message board persistence
	 */
	public TailgateMessageBoardPersistence getTailgateMessageBoardPersistence() {
		return tailgateMessageBoardPersistence;
	}

	/**
	 * Sets the tailgate message board persistence.
	 *
	 * @param tailgateMessageBoardPersistence the tailgate message board persistence
	 */
	public void setTailgateMessageBoardPersistence(
		TailgateMessageBoardPersistence tailgateMessageBoardPersistence) {
		this.tailgateMessageBoardPersistence = tailgateMessageBoardPersistence;
	}

	/**
	 * Returns the tailgate supply item local service.
	 *
	 * @return the tailgate supply item local service
	 */
	public com.rumbasolutions.flask.service.TailgateSupplyItemLocalService getTailgateSupplyItemLocalService() {
		return tailgateSupplyItemLocalService;
	}

	/**
	 * Sets the tailgate supply item local service.
	 *
	 * @param tailgateSupplyItemLocalService the tailgate supply item local service
	 */
	public void setTailgateSupplyItemLocalService(
		com.rumbasolutions.flask.service.TailgateSupplyItemLocalService tailgateSupplyItemLocalService) {
		this.tailgateSupplyItemLocalService = tailgateSupplyItemLocalService;
	}

	/**
	 * Returns the tailgate supply item remote service.
	 *
	 * @return the tailgate supply item remote service
	 */
	public com.rumbasolutions.flask.service.TailgateSupplyItemService getTailgateSupplyItemService() {
		return tailgateSupplyItemService;
	}

	/**
	 * Sets the tailgate supply item remote service.
	 *
	 * @param tailgateSupplyItemService the tailgate supply item remote service
	 */
	public void setTailgateSupplyItemService(
		com.rumbasolutions.flask.service.TailgateSupplyItemService tailgateSupplyItemService) {
		this.tailgateSupplyItemService = tailgateSupplyItemService;
	}

	/**
	 * Returns the tailgate supply item persistence.
	 *
	 * @return the tailgate supply item persistence
	 */
	public TailgateSupplyItemPersistence getTailgateSupplyItemPersistence() {
		return tailgateSupplyItemPersistence;
	}

	/**
	 * Sets the tailgate supply item persistence.
	 *
	 * @param tailgateSupplyItemPersistence the tailgate supply item persistence
	 */
	public void setTailgateSupplyItemPersistence(
		TailgateSupplyItemPersistence tailgateSupplyItemPersistence) {
		this.tailgateSupplyItemPersistence = tailgateSupplyItemPersistence;
	}

	/**
	 * Returns the tailgate users local service.
	 *
	 * @return the tailgate users local service
	 */
	public com.rumbasolutions.flask.service.TailgateUsersLocalService getTailgateUsersLocalService() {
		return tailgateUsersLocalService;
	}

	/**
	 * Sets the tailgate users local service.
	 *
	 * @param tailgateUsersLocalService the tailgate users local service
	 */
	public void setTailgateUsersLocalService(
		com.rumbasolutions.flask.service.TailgateUsersLocalService tailgateUsersLocalService) {
		this.tailgateUsersLocalService = tailgateUsersLocalService;
	}

	/**
	 * Returns the tailgate users remote service.
	 *
	 * @return the tailgate users remote service
	 */
	public com.rumbasolutions.flask.service.TailgateUsersService getTailgateUsersService() {
		return tailgateUsersService;
	}

	/**
	 * Sets the tailgate users remote service.
	 *
	 * @param tailgateUsersService the tailgate users remote service
	 */
	public void setTailgateUsersService(
		com.rumbasolutions.flask.service.TailgateUsersService tailgateUsersService) {
		this.tailgateUsersService = tailgateUsersService;
	}

	/**
	 * Returns the tailgate users persistence.
	 *
	 * @return the tailgate users persistence
	 */
	public TailgateUsersPersistence getTailgateUsersPersistence() {
		return tailgateUsersPersistence;
	}

	/**
	 * Sets the tailgate users persistence.
	 *
	 * @param tailgateUsersPersistence the tailgate users persistence
	 */
	public void setTailgateUsersPersistence(
		TailgateUsersPersistence tailgateUsersPersistence) {
		this.tailgateUsersPersistence = tailgateUsersPersistence;
	}

	/**
	 * Returns the tailgate users finder.
	 *
	 * @return the tailgate users finder
	 */
	public TailgateUsersFinder getTailgateUsersFinder() {
		return tailgateUsersFinder;
	}

	/**
	 * Sets the tailgate users finder.
	 *
	 * @param tailgateUsersFinder the tailgate users finder
	 */
	public void setTailgateUsersFinder(TailgateUsersFinder tailgateUsersFinder) {
		this.tailgateUsersFinder = tailgateUsersFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SupplyList.class;
	}

	protected String getModelClassName() {
		return SupplyList.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = supplyListPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rumbasolutions.flask.service.SupplyItemLocalService.class)
	protected com.rumbasolutions.flask.service.SupplyItemLocalService supplyItemLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.SupplyItemService.class)
	protected com.rumbasolutions.flask.service.SupplyItemService supplyItemService;
	@BeanReference(type = SupplyItemPersistence.class)
	protected SupplyItemPersistence supplyItemPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.SupplyListLocalService.class)
	protected com.rumbasolutions.flask.service.SupplyListLocalService supplyListLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.SupplyListService.class)
	protected com.rumbasolutions.flask.service.SupplyListService supplyListService;
	@BeanReference(type = SupplyListPersistence.class)
	protected SupplyListPersistence supplyListPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateImagesLocalService.class)
	protected com.rumbasolutions.flask.service.TailgateImagesLocalService tailgateImagesLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateImagesService.class)
	protected com.rumbasolutions.flask.service.TailgateImagesService tailgateImagesService;
	@BeanReference(type = TailgateImagesPersistence.class)
	protected TailgateImagesPersistence tailgateImagesPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateInfoLocalService.class)
	protected com.rumbasolutions.flask.service.TailgateInfoLocalService tailgateInfoLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateInfoService.class)
	protected com.rumbasolutions.flask.service.TailgateInfoService tailgateInfoService;
	@BeanReference(type = TailgateInfoPersistence.class)
	protected TailgateInfoPersistence tailgateInfoPersistence;
	@BeanReference(type = TailgateInfoFinder.class)
	protected TailgateInfoFinder tailgateInfoFinder;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateMarkerLocalService.class)
	protected com.rumbasolutions.flask.service.TailgateMarkerLocalService tailgateMarkerLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateMarkerService.class)
	protected com.rumbasolutions.flask.service.TailgateMarkerService tailgateMarkerService;
	@BeanReference(type = TailgateMarkerPersistence.class)
	protected TailgateMarkerPersistence tailgateMarkerPersistence;
	@BeanReference(type = TailgateMarkerFinder.class)
	protected TailgateMarkerFinder tailgateMarkerFinder;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateMessageBoardLocalService.class)
	protected com.rumbasolutions.flask.service.TailgateMessageBoardLocalService tailgateMessageBoardLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateMessageBoardService.class)
	protected com.rumbasolutions.flask.service.TailgateMessageBoardService tailgateMessageBoardService;
	@BeanReference(type = TailgateMessageBoardPersistence.class)
	protected TailgateMessageBoardPersistence tailgateMessageBoardPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateSupplyItemLocalService.class)
	protected com.rumbasolutions.flask.service.TailgateSupplyItemLocalService tailgateSupplyItemLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateSupplyItemService.class)
	protected com.rumbasolutions.flask.service.TailgateSupplyItemService tailgateSupplyItemService;
	@BeanReference(type = TailgateSupplyItemPersistence.class)
	protected TailgateSupplyItemPersistence tailgateSupplyItemPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateUsersLocalService.class)
	protected com.rumbasolutions.flask.service.TailgateUsersLocalService tailgateUsersLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateUsersService.class)
	protected com.rumbasolutions.flask.service.TailgateUsersService tailgateUsersService;
	@BeanReference(type = TailgateUsersPersistence.class)
	protected TailgateUsersPersistence tailgateUsersPersistence;
	@BeanReference(type = TailgateUsersFinder.class)
	protected TailgateUsersFinder tailgateUsersFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SupplyListServiceClpInvoker _clpInvoker = new SupplyListServiceClpInvoker();
}