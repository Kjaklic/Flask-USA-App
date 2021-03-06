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

package com.rumbasolutions.flask.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.rumbasolutions.flask.service.VenueServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.VenueServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.VenueSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.Venue}, that is translated to a
 * {@link com.rumbasolutions.flask.model.VenueSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueServiceHttp
 * @see com.rumbasolutions.flask.model.VenueSoap
 * @see com.rumbasolutions.flask.service.VenueServiceUtil
 * @generated
 */
public class VenueServiceSoap {
	public static com.rumbasolutions.flask.model.VenueSoap[] getAllVenues(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.Venue> returnValue = VenueServiceUtil.getAllVenues(serviceContext);

			return com.rumbasolutions.flask.model.VenueSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueSoap getVenue(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.Venue returnValue = VenueServiceUtil.getVenue(venueId,
					serviceContext);

			return com.rumbasolutions.flask.model.VenueSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueSoap addVenue(
		java.lang.String venueName, java.lang.String venueDescription,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String venueZipCode, java.lang.String venueCity,
		java.lang.String venueMetroArea, long venueStateId,
		long venueCountryId, java.lang.String longitude,
		java.lang.String latitude, int venueDetailsDistRange,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.Venue returnValue = VenueServiceUtil.addVenue(venueName,
					venueDescription, addrLine1, addrLine2, venueZipCode,
					venueCity, venueMetroArea, venueStateId, venueCountryId,
					longitude, latitude, venueDetailsDistRange, serviceContext);

			return com.rumbasolutions.flask.model.VenueSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueSoap updateVenue(
		long venueId, java.lang.String venueName,
		java.lang.String venueDescription, java.lang.String addrLine1,
		java.lang.String addrLine2, java.lang.String venueZipCode,
		java.lang.String venueCity, java.lang.String venueMetroArea,
		long venueStateId, long venueCountryId, java.lang.String longitude,
		java.lang.String latitude, int venueDetailsDistRange,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.Venue returnValue = VenueServiceUtil.updateVenue(venueId,
					venueName, venueDescription, addrLine1, addrLine2,
					venueZipCode, venueCity, venueMetroArea, venueStateId,
					venueCountryId, longitude, latitude, venueDetailsDistRange,
					serviceContext);

			return com.rumbasolutions.flask.model.VenueSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteVenue(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			VenueServiceUtil.deleteVenue(venueId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* @param venueList comms seperated venueId list
	* @param serviceContext
	* @return
	*/
	public static void deleteVenues(java.lang.String venueList,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			VenueServiceUtil.deleteVenues(venueList, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueImageSoap addVenueImage(
		long venueId, java.lang.String title, java.lang.String venueImageUUID,
		long groupId, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueImage returnValue = VenueServiceUtil.addVenueImage(venueId,
					title, venueImageUUID, groupId, serviceContext);

			return com.rumbasolutions.flask.model.VenueImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueImageSoap[] getVenueImages(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueImage> returnValue =
				VenueServiceUtil.getVenueImages(venueId, serviceContext);

			return com.rumbasolutions.flask.model.VenueImageSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueImageSoap getVenueImage(
		long venueImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueImage returnValue = VenueServiceUtil.getVenueImage(venueImageId,
					serviceContext);

			return com.rumbasolutions.flask.model.VenueImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void updateVenueImage(long venueImageId,
		java.lang.String title, java.lang.String venueImageUUID,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			VenueServiceUtil.updateVenueImage(venueImageId, title,
				venueImageUUID, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteVenueImage(long venueImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			VenueServiceUtil.deleteVenueImage(venueImageId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteAllVenueImages(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			VenueServiceUtil.deleteAllVenueImages(venueId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDetailSoap addVenueDetail(
		long venueId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoShortDesc,
		java.lang.String infoDesc, java.lang.String addrLine1,
		java.lang.String addrLine2, java.lang.String zipCode,
		java.lang.String city, long stateId, long countryId,
		java.lang.String latitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String mobileAppName,
		java.lang.String website, java.lang.Double cost,
		java.lang.String hoursOfOperation,
		java.lang.Boolean premiumDisplayEnabled,
		java.lang.String venueSubDetails,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueDetail returnValue = VenueServiceUtil.addVenueDetail(venueId,
					infoTypeId, infoTypeCategoryId, infoTitle, infoShortDesc,
					infoDesc, addrLine1, addrLine2, zipCode, city, stateId,
					countryId, latitude, longitude, phone, mobileAppName,
					website, cost, hoursOfOperation, premiumDisplayEnabled,
					venueSubDetails, serviceContext);

			return com.rumbasolutions.flask.model.VenueDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDetailSoap updateVenueDetail(
		long venueDetailId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoShortDesc,
		java.lang.String infoDesc, java.lang.String addrLine1,
		java.lang.String addrLine2, java.lang.String zipCode,
		java.lang.String city, long stateId, long countryId,
		java.lang.String latitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String mobileAppName,
		java.lang.String website, java.lang.Double cost,
		java.lang.String hoursOfOperation,
		java.lang.Boolean premiumDisplayEnabled,
		java.lang.String venueSubDetails,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueDetail returnValue = VenueServiceUtil.updateVenueDetail(venueDetailId,
					infoTypeId, infoTypeCategoryId, infoTitle, infoShortDesc,
					infoDesc, addrLine1, addrLine2, zipCode, city, stateId,
					countryId, latitude, longitude, phone, mobileAppName,
					website, cost, hoursOfOperation, premiumDisplayEnabled,
					venueSubDetails, serviceContext);

			return com.rumbasolutions.flask.model.VenueDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDetailSoap getVenueDetail(
		long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueDetail returnValue = VenueServiceUtil.getVenueDetail(venueDetailId,
					serviceContext);

			return com.rumbasolutions.flask.model.VenueDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDetailSoap[] getVenueDetails(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueDetail> returnValue =
				VenueServiceUtil.getVenueDetails(venueId, serviceContext);

			return com.rumbasolutions.flask.model.VenueDetailSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteVenueDetail(long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			VenueServiceUtil.deleteVenueDetail(venueDetailId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteAllVenueDetails(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			VenueServiceUtil.deleteAllVenueDetails(venueId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDetailImageSoap addVenueDetailImage(
		long venueDetailId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueDetailImage returnValue = VenueServiceUtil.addVenueDetailImage(venueDetailId,
					imageTitle, imageDesc, imageUUID, groupId, serviceContext);

			return com.rumbasolutions.flask.model.VenueDetailImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDetailImageSoap updateVenueDetailImage(
		long venueDetailImageId, long venueDetailId,
		java.lang.String imageTitle, java.lang.String imageDesc,
		java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueDetailImage returnValue = VenueServiceUtil.updateVenueDetailImage(venueDetailImageId,
					venueDetailId, imageTitle, imageDesc, imageUUID, groupId,
					serviceContext);

			return com.rumbasolutions.flask.model.VenueDetailImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDetailImageSoap getVenueDetailImage(
		long venueDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueDetailImage returnValue = VenueServiceUtil.getVenueDetailImage(venueDetailImageId,
					serviceContext);

			return com.rumbasolutions.flask.model.VenueDetailImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDetailImageSoap[] getVenueDetailImages(
		long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> returnValue =
				VenueServiceUtil.getVenueDetailImages(venueDetailId,
					serviceContext);

			return com.rumbasolutions.flask.model.VenueDetailImageSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDetailImageSoap[] getVenueDetailImagesByVenueIdandDeviceType(
		long venueDetailId, java.lang.String deviceType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> returnValue =
				VenueServiceUtil.getVenueDetailImagesByVenueIdandDeviceType(venueDetailId,
					deviceType, serviceContext);

			return com.rumbasolutions.flask.model.VenueDetailImageSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteVenueDetailImage(long venueDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			VenueServiceUtil.deleteVenueDetailImage(venueDetailImageId,
				serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteAllVenueDetailImages(long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			VenueServiceUtil.deleteAllVenueDetailImages(venueDetailId,
				serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getVenueDetailsWithImages(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = VenueServiceUtil.getVenueDetailsWithImages(venueId,
					serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String copyVenueDetailsWithImages(
		long sourceVenueId, long destinationVenueId, long infoTypeCategoryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = VenueServiceUtil.copyVenueDetailsWithImages(sourceVenueId,
					destinationVenueId, infoTypeCategoryId, serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addFileEntry(long destinationVenueId,
		long srcVenueDetailId,
		com.rumbasolutions.flask.model.VenueDetailSoap destVenueDetail,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			VenueServiceUtil.addFileEntry(destinationVenueId, srcVenueDetailId,
				com.rumbasolutions.flask.model.impl.VenueDetailModelImpl.toModel(
					destVenueDetail), serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImageSoap addVenueDeviceImage(
		long venueDetailImageId, long venueId, java.lang.String deviceType,
		java.lang.String venueDeviceImageUUID, java.lang.String aspectRatio)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueDeviceImage returnValue = VenueServiceUtil.addVenueDeviceImage(venueDetailImageId,
					venueId, deviceType, venueDeviceImageUUID, aspectRatio);

			return com.rumbasolutions.flask.model.VenueDeviceImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImageSoap[] getVenueDeviceImagesByVenueId(
		long venueId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> returnValue =
				VenueServiceUtil.getVenueDeviceImagesByVenueId(venueId);

			return com.rumbasolutions.flask.model.VenueDeviceImageSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImageSoap[] getVenueDeviceImagesByVenueDetailImageId(
		long venueDetailImageId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> returnValue =
				VenueServiceUtil.getVenueDeviceImagesByVenueDetailImageId(venueDetailImageId);

			return com.rumbasolutions.flask.model.VenueDeviceImageSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImageSoap[] getVenueDeviceImagesByDeviceType(
		java.lang.String deviceType) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> returnValue =
				VenueServiceUtil.getVenueDeviceImagesByDeviceType(deviceType);

			return com.rumbasolutions.flask.model.VenueDeviceImageSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDetailImageSoap[] getVenueImagesByVenueIdAndDeviceType(
		long venueId, java.lang.String deviceType,
		java.lang.String aspectRatio,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> returnValue =
				VenueServiceUtil.getVenueImagesByVenueIdAndDeviceType(venueId,
					deviceType, aspectRatio, serviceContext);

			return com.rumbasolutions.flask.model.VenueDetailImageSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImageSoap getVenueDeviceImage(
		long venueDeviceImageId) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueDeviceImage returnValue = VenueServiceUtil.getVenueDeviceImage(venueDeviceImageId);

			return com.rumbasolutions.flask.model.VenueDeviceImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImageSoap[] getAllVenueDeviceImages()
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> returnValue =
				VenueServiceUtil.getAllVenueDeviceImages();

			return com.rumbasolutions.flask.model.VenueDeviceImageSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImageSoap updateVenueDeviceImage(
		long venueImageDeviceId, long venueDetailImageId, long venueId,
		java.lang.String deviceType, java.lang.String venueDeviceImageUUID,
		java.lang.String aspectRatio) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueDeviceImage returnValue = VenueServiceUtil.updateVenueDeviceImage(venueImageDeviceId,
					venueDetailImageId, venueId, deviceType,
					venueDeviceImageUUID, aspectRatio);

			return com.rumbasolutions.flask.model.VenueDeviceImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteVenueDeviceImage(long venueDeviceImageId)
		throws RemoteException {
		try {
			VenueServiceUtil.deleteVenueDeviceImage(venueDeviceImageId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VenueServiceSoap.class);
}