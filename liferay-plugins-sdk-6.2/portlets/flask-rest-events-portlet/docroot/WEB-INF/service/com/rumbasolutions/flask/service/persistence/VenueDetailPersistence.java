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

package com.rumbasolutions.flask.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rumbasolutions.flask.model.VenueDetail;

/**
 * The persistence interface for the venue detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDetailPersistenceImpl
 * @see VenueDetailUtil
 * @generated
 */
public interface VenueDetailPersistence extends BasePersistence<VenueDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VenueDetailUtil} to access the venue detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the venue details where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the matching venue details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetail> findByVenueId(
		long venueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the venue details where venueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param start the lower bound of the range of venue details
	* @param end the upper bound of the range of venue details (not inclusive)
	* @return the range of matching venue details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetail> findByVenueId(
		long venueId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the venue details where venueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param start the lower bound of the range of venue details
	* @param end the upper bound of the range of venue details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetail> findByVenueId(
		long venueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first venue detail in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue detail
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a matching venue detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetail findByVenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailException;

	/**
	* Returns the first venue detail in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue detail, or <code>null</code> if a matching venue detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetail fetchByVenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last venue detail in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue detail
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a matching venue detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetail findByVenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailException;

	/**
	* Returns the last venue detail in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue detail, or <code>null</code> if a matching venue detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetail fetchByVenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venue details before and after the current venue detail in the ordered set where venueId = &#63;.
	*
	* @param venueDetailId the primary key of the current venue detail
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue detail
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetail[] findByVenueId_PrevAndNext(
		long venueDetailId, long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailException;

	/**
	* Removes all the venue details where venueId = &#63; from the database.
	*
	* @param venueId the venue ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue details where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the number of matching venue details
	* @throws SystemException if a system exception occurred
	*/
	public int countByVenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the venue detail in the entity cache if it is enabled.
	*
	* @param venueDetail the venue detail
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.VenueDetail venueDetail);

	/**
	* Caches the venue details in the entity cache if it is enabled.
	*
	* @param venueDetails the venue details
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.VenueDetail> venueDetails);

	/**
	* Creates a new venue detail with the primary key. Does not add the venue detail to the database.
	*
	* @param venueDetailId the primary key for the new venue detail
	* @return the new venue detail
	*/
	public com.rumbasolutions.flask.model.VenueDetail create(long venueDetailId);

	/**
	* Removes the venue detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueDetailId the primary key of the venue detail
	* @return the venue detail that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetail remove(long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailException;

	public com.rumbasolutions.flask.model.VenueDetail updateImpl(
		com.rumbasolutions.flask.model.VenueDetail venueDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venue detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueDetailException} if it could not be found.
	*
	* @param venueDetailId the primary key of the venue detail
	* @return the venue detail
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetail findByPrimaryKey(
		long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailException;

	/**
	* Returns the venue detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueDetailId the primary key of the venue detail
	* @return the venue detail, or <code>null</code> if a venue detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetail fetchByPrimaryKey(
		long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the venue details.
	*
	* @return the venue details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the venue details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue details
	* @param end the upper bound of the range of venue details (not inclusive)
	* @return the range of venue details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the venue details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue details
	* @param end the upper bound of the range of venue details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of venue details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the venue details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue details.
	*
	* @return the number of venue details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}