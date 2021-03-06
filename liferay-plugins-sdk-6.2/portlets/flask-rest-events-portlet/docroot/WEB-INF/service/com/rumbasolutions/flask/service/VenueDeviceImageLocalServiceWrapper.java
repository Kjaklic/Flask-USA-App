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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VenueDeviceImageLocalService}.
 *
 * @author Ashutosh Rai
 * @see VenueDeviceImageLocalService
 * @generated
 */
public class VenueDeviceImageLocalServiceWrapper
	implements VenueDeviceImageLocalService,
		ServiceWrapper<VenueDeviceImageLocalService> {
	public VenueDeviceImageLocalServiceWrapper(
		VenueDeviceImageLocalService venueDeviceImageLocalService) {
		_venueDeviceImageLocalService = venueDeviceImageLocalService;
	}

	/**
	* Adds the venue device image to the database. Also notifies the appropriate model listeners.
	*
	* @param venueDeviceImage the venue device image
	* @return the venue device image that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage addVenueDeviceImage(
		com.rumbasolutions.flask.model.VenueDeviceImage venueDeviceImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.addVenueDeviceImage(venueDeviceImage);
	}

	/**
	* Creates a new venue device image with the primary key. Does not add the venue device image to the database.
	*
	* @param venueDeviceImageId the primary key for the new venue device image
	* @return the new venue device image
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage createVenueDeviceImage(
		long venueDeviceImageId) {
		return _venueDeviceImageLocalService.createVenueDeviceImage(venueDeviceImageId);
	}

	/**
	* Deletes the venue device image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueDeviceImageId the primary key of the venue device image
	* @return the venue device image that was removed
	* @throws PortalException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage deleteVenueDeviceImage(
		long venueDeviceImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.deleteVenueDeviceImage(venueDeviceImageId);
	}

	/**
	* Deletes the venue device image from the database. Also notifies the appropriate model listeners.
	*
	* @param venueDeviceImage the venue device image
	* @return the venue device image that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage deleteVenueDeviceImage(
		com.rumbasolutions.flask.model.VenueDeviceImage venueDeviceImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.deleteVenueDeviceImage(venueDeviceImage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _venueDeviceImageLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchVenueDeviceImage(
		long venueDeviceImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.fetchVenueDeviceImage(venueDeviceImageId);
	}

	/**
	* Returns the venue device image with the primary key.
	*
	* @param venueDeviceImageId the primary key of the venue device image
	* @return the venue device image
	* @throws PortalException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage getVenueDeviceImage(
		long venueDeviceImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.getVenueDeviceImage(venueDeviceImageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the venue device images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @return the range of venue device images
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> getVenueDeviceImages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.getVenueDeviceImages(start, end);
	}

	/**
	* Returns the number of venue device images.
	*
	* @return the number of venue device images
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVenueDeviceImagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.getVenueDeviceImagesCount();
	}

	/**
	* Updates the venue device image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param venueDeviceImage the venue device image
	* @return the venue device image that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage updateVenueDeviceImage(
		com.rumbasolutions.flask.model.VenueDeviceImage venueDeviceImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDeviceImageLocalService.updateVenueDeviceImage(venueDeviceImage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _venueDeviceImageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_venueDeviceImageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _venueDeviceImageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VenueDeviceImageLocalService getWrappedVenueDeviceImageLocalService() {
		return _venueDeviceImageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVenueDeviceImageLocalService(
		VenueDeviceImageLocalService venueDeviceImageLocalService) {
		_venueDeviceImageLocalService = venueDeviceImageLocalService;
	}

	@Override
	public VenueDeviceImageLocalService getWrappedService() {
		return _venueDeviceImageLocalService;
	}

	@Override
	public void setWrappedService(
		VenueDeviceImageLocalService venueDeviceImageLocalService) {
		_venueDeviceImageLocalService = venueDeviceImageLocalService;
	}

	private VenueDeviceImageLocalService _venueDeviceImageLocalService;
}