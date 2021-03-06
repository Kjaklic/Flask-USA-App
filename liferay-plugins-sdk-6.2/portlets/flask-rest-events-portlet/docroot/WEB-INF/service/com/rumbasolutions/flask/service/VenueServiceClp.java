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

import com.liferay.portal.service.InvokableService;

/**
 * @author Ashutosh Rai
 * @generated
 */
public class VenueServiceClp implements VenueService {
	public VenueServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getAllVenues";

		_methodParameterTypes3 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName4 = "getVenue";

		_methodParameterTypes4 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName5 = "addVenue";

		_methodParameterTypes5 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "java.lang.String",
				"java.lang.String", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName6 = "updateVenue";

		_methodParameterTypes6 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"java.lang.String", "java.lang.String", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName7 = "deleteVenue";

		_methodParameterTypes7 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName8 = "deleteVenues";

		_methodParameterTypes8 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName9 = "addVenueImage";

		_methodParameterTypes9 = new String[] {
				"long", "java.lang.String", "java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName10 = "getVenueImages";

		_methodParameterTypes10 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName11 = "getVenueImage";

		_methodParameterTypes11 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName12 = "updateVenueImage";

		_methodParameterTypes12 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName13 = "deleteVenueImage";

		_methodParameterTypes13 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName14 = "deleteAllVenueImages";

		_methodParameterTypes14 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName15 = "addVenueDetail";

		_methodParameterTypes15 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.Double",
				"java.lang.String", "java.lang.Boolean", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName16 = "updateVenueDetail";

		_methodParameterTypes16 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.Double",
				"java.lang.String", "java.lang.Boolean", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName17 = "getVenueDetail";

		_methodParameterTypes17 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName18 = "getVenueDetails";

		_methodParameterTypes18 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName19 = "deleteVenueDetail";

		_methodParameterTypes19 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName20 = "deleteAllVenueDetails";

		_methodParameterTypes20 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName21 = "addVenueDetailImage";

		_methodParameterTypes21 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName22 = "updateVenueDetailImage";

		_methodParameterTypes22 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName23 = "getVenueDetailImage";

		_methodParameterTypes23 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName24 = "getVenueDetailImages";

		_methodParameterTypes24 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName25 = "getVenueDetailImagesByVenueIdandDeviceType";

		_methodParameterTypes25 = new String[] {
				"long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName26 = "deleteVenueDetailImage";

		_methodParameterTypes26 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName27 = "deleteAllVenueDetailImages";

		_methodParameterTypes27 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName28 = "getVenueDetailsWithImages";

		_methodParameterTypes28 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName29 = "copyVenueDetailsWithImages";

		_methodParameterTypes29 = new String[] {
				"long", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName30 = "addFileEntry";

		_methodParameterTypes30 = new String[] {
				"long", "long", "com.rumbasolutions.flask.model.VenueDetail",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName31 = "addVenueDeviceImage";

		_methodParameterTypes31 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName32 = "getVenueDeviceImagesByVenueId";

		_methodParameterTypes32 = new String[] { "long" };

		_methodName33 = "getVenueDeviceImagesByVenueDetailImageId";

		_methodParameterTypes33 = new String[] { "long" };

		_methodName34 = "getVenueDeviceImagesByDeviceType";

		_methodParameterTypes34 = new String[] { "java.lang.String" };

		_methodName35 = "getVenueImagesByVenueIdAndDeviceType";

		_methodParameterTypes35 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName36 = "getVenueDeviceImage";

		_methodParameterTypes36 = new String[] { "long" };

		_methodName37 = "getAllVenueDeviceImages";

		_methodParameterTypes37 = new String[] {  };

		_methodName38 = "updateVenueDeviceImage";

		_methodParameterTypes38 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName39 = "deleteVenueDeviceImage";

		_methodParameterTypes39 = new String[] { "long" };

		_methodName40 = "uploadDeviceImage";

		_methodParameterTypes40 = new String[] {
				"java.io.File", "long", "java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.Venue> getAllVenues(
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(serviceContext) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.rumbasolutions.flask.model.Venue>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.Venue getVenue(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						venueId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.Venue)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.Venue addVenue(
		java.lang.String venueName, java.lang.String venueDescription,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String venueZipCode, java.lang.String venueCity,
		java.lang.String venueMetroArea, long venueStateId,
		long venueCountryId, java.lang.String longitude,
		java.lang.String latitude, int venueDetailsDistRange,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						ClpSerializer.translateInput(venueName),
						
					ClpSerializer.translateInput(venueDescription),
						
					ClpSerializer.translateInput(addrLine1),
						
					ClpSerializer.translateInput(addrLine2),
						
					ClpSerializer.translateInput(venueZipCode),
						
					ClpSerializer.translateInput(venueCity),
						
					ClpSerializer.translateInput(venueMetroArea),
						
					venueStateId,
						
					venueCountryId,
						
					ClpSerializer.translateInput(longitude),
						
					ClpSerializer.translateInput(latitude),
						
					venueDetailsDistRange,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.Venue)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.Venue updateVenue(long venueId,
		java.lang.String venueName, java.lang.String venueDescription,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String venueZipCode, java.lang.String venueCity,
		java.lang.String venueMetroArea, long venueStateId,
		long venueCountryId, java.lang.String longitude,
		java.lang.String latitude, int venueDetailsDistRange,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						venueId,
						
					ClpSerializer.translateInput(venueName),
						
					ClpSerializer.translateInput(venueDescription),
						
					ClpSerializer.translateInput(addrLine1),
						
					ClpSerializer.translateInput(addrLine2),
						
					ClpSerializer.translateInput(venueZipCode),
						
					ClpSerializer.translateInput(venueCity),
						
					ClpSerializer.translateInput(venueMetroArea),
						
					venueStateId,
						
					venueCountryId,
						
					ClpSerializer.translateInput(longitude),
						
					ClpSerializer.translateInput(latitude),
						
					venueDetailsDistRange,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.Venue)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteVenue(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName7,
				_methodParameterTypes7,
				new Object[] {
					venueId,
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void deleteVenues(java.lang.String venueList,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName8,
				_methodParameterTypes8,
				new Object[] {
					ClpSerializer.translateInput(venueList),
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public com.rumbasolutions.flask.model.VenueImage addVenueImage(
		long venueId, java.lang.String title, java.lang.String venueImageUUID,
		long groupId, com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						venueId,
						
					ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(venueImageUUID),
						
					groupId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueImage> getVenueImages(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] {
						venueId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.rumbasolutions.flask.model.VenueImage>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueImage getVenueImage(
		long venueImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] {
						venueImageId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void updateVenueImage(long venueImageId, java.lang.String title,
		java.lang.String venueImageUUID,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName12,
				_methodParameterTypes12,
				new Object[] {
					venueImageId,
					
				ClpSerializer.translateInput(title),
					
				ClpSerializer.translateInput(venueImageUUID),
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void deleteVenueImage(long venueImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName13,
				_methodParameterTypes13,
				new Object[] {
					venueImageId,
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void deleteAllVenueImages(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName14,
				_methodParameterTypes14,
				new Object[] {
					venueId,
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetail addVenueDetail(
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
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] {
						venueId,
						
					infoTypeId,
						
					infoTypeCategoryId,
						
					ClpSerializer.translateInput(infoTitle),
						
					ClpSerializer.translateInput(infoShortDesc),
						
					ClpSerializer.translateInput(infoDesc),
						
					ClpSerializer.translateInput(addrLine1),
						
					ClpSerializer.translateInput(addrLine2),
						
					ClpSerializer.translateInput(zipCode),
						
					ClpSerializer.translateInput(city),
						
					stateId,
						
					countryId,
						
					ClpSerializer.translateInput(latitude),
						
					ClpSerializer.translateInput(longitude),
						
					ClpSerializer.translateInput(phone),
						
					ClpSerializer.translateInput(mobileAppName),
						
					ClpSerializer.translateInput(website),
						
					ClpSerializer.translateInput(cost),
						
					ClpSerializer.translateInput(hoursOfOperation),
						
					ClpSerializer.translateInput(premiumDisplayEnabled),
						
					ClpSerializer.translateInput(venueSubDetails),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetail updateVenueDetail(
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
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName16,
					_methodParameterTypes16,
					new Object[] {
						venueDetailId,
						
					infoTypeId,
						
					infoTypeCategoryId,
						
					ClpSerializer.translateInput(infoTitle),
						
					ClpSerializer.translateInput(infoShortDesc),
						
					ClpSerializer.translateInput(infoDesc),
						
					ClpSerializer.translateInput(addrLine1),
						
					ClpSerializer.translateInput(addrLine2),
						
					ClpSerializer.translateInput(zipCode),
						
					ClpSerializer.translateInput(city),
						
					stateId,
						
					countryId,
						
					ClpSerializer.translateInput(latitude),
						
					ClpSerializer.translateInput(longitude),
						
					ClpSerializer.translateInput(phone),
						
					ClpSerializer.translateInput(mobileAppName),
						
					ClpSerializer.translateInput(website),
						
					ClpSerializer.translateInput(cost),
						
					ClpSerializer.translateInput(hoursOfOperation),
						
					ClpSerializer.translateInput(premiumDisplayEnabled),
						
					ClpSerializer.translateInput(venueSubDetails),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetail getVenueDetail(
		long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName17,
					_methodParameterTypes17,
					new Object[] {
						venueDetailId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueDetail)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDetail> getVenueDetails(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName18,
					_methodParameterTypes18,
					new Object[] {
						venueId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.rumbasolutions.flask.model.VenueDetail>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteVenueDetail(long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName19,
				_methodParameterTypes19,
				new Object[] {
					venueDetailId,
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void deleteAllVenueDetails(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName20,
				_methodParameterTypes20,
				new Object[] {
					venueId,
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage addVenueDetailImage(
		long venueDetailId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName21,
					_methodParameterTypes21,
					new Object[] {
						venueDetailId,
						
					ClpSerializer.translateInput(imageTitle),
						
					ClpSerializer.translateInput(imageDesc),
						
					ClpSerializer.translateInput(imageUUID),
						
					groupId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueDetailImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage updateVenueDetailImage(
		long venueDetailImageId, long venueDetailId,
		java.lang.String imageTitle, java.lang.String imageDesc,
		java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName22,
					_methodParameterTypes22,
					new Object[] {
						venueDetailImageId,
						
					venueDetailId,
						
					ClpSerializer.translateInput(imageTitle),
						
					ClpSerializer.translateInput(imageDesc),
						
					ClpSerializer.translateInput(imageUUID),
						
					groupId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueDetailImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage getVenueDetailImage(
		long venueDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] {
						venueDetailImageId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueDetailImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> getVenueDetailImages(
		long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] {
						venueDetailId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.rumbasolutions.flask.model.VenueDetailImage>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> getVenueDetailImagesByVenueIdandDeviceType(
		long venueDetailId, java.lang.String deviceType,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] {
						venueDetailId,
						
					ClpSerializer.translateInput(deviceType),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.rumbasolutions.flask.model.VenueDetailImage>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteVenueDetailImage(long venueDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName26,
				_methodParameterTypes26,
				new Object[] {
					venueDetailImageId,
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void deleteAllVenueDetailImages(long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName27,
				_methodParameterTypes27,
				new Object[] {
					venueDetailId,
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getVenueDetailsWithImages(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						venueId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject copyVenueDetailsWithImages(
		long sourceVenueId, long destinationVenueId, long infoTypeCategoryId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName29,
					_methodParameterTypes29,
					new Object[] {
						sourceVenueId,
						
					destinationVenueId,
						
					infoTypeCategoryId,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void addFileEntry(long destinationVenueId, long srcVenueDetailId,
		com.rumbasolutions.flask.model.VenueDetail destVenueDetail,
		com.liferay.portal.service.ServiceContext serviceContext) {
		try {
			_invokableService.invokeMethod(_methodName30,
				_methodParameterTypes30,
				new Object[] {
					destinationVenueId,
					
				srcVenueDetailId,
					
				ClpSerializer.translateInput(destVenueDetail),
					
				ClpSerializer.translateInput(serviceContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage addVenueDeviceImage(
		long venueDetailImageId, long venueId, java.lang.String deviceType,
		java.lang.String venueDeviceImageUUID, java.lang.String aspectRatio) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] {
						venueDetailImageId,
						
					venueId,
						
					ClpSerializer.translateInput(deviceType),
						
					ClpSerializer.translateInput(venueDeviceImageUUID),
						
					ClpSerializer.translateInput(aspectRatio)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueDeviceImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> getVenueDeviceImagesByVenueId(
		long venueId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName32,
					_methodParameterTypes32, new Object[] { venueId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> getVenueDeviceImagesByVenueDetailImageId(
		long venueDetailImageId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName33,
					_methodParameterTypes33, new Object[] { venueDetailImageId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> getVenueDeviceImagesByDeviceType(
		java.lang.String deviceType) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] { ClpSerializer.translateInput(deviceType) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> getVenueImagesByVenueIdAndDeviceType(
		long venueId, java.lang.String deviceType,
		java.lang.String aspectRatio,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName35,
					_methodParameterTypes35,
					new Object[] {
						venueId,
						
					ClpSerializer.translateInput(deviceType),
						
					ClpSerializer.translateInput(aspectRatio),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.rumbasolutions.flask.model.VenueDetailImage>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage getVenueDeviceImage(
		long venueDeviceImageId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName36,
					_methodParameterTypes36, new Object[] { venueDeviceImageId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueDeviceImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> getAllVenueDeviceImages() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName37,
					_methodParameterTypes37, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage updateVenueDeviceImage(
		long venueImageDeviceId, long venueDetailImageId, long venueId,
		java.lang.String deviceType, java.lang.String venueDeviceImageUUID,
		java.lang.String aspectRatio) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName38,
					_methodParameterTypes38,
					new Object[] {
						venueImageDeviceId,
						
					venueDetailImageId,
						
					venueId,
						
					ClpSerializer.translateInput(deviceType),
						
					ClpSerializer.translateInput(venueDeviceImageUUID),
						
					ClpSerializer.translateInput(aspectRatio)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueDeviceImage)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteVenueDeviceImage(long venueDeviceImageId) {
		try {
			_invokableService.invokeMethod(_methodName39,
				_methodParameterTypes39, new Object[] { venueDeviceImageId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public com.rumbasolutions.flask.model.VenueImage uploadDeviceImage(
		java.io.File file, long venueId, java.lang.String deviceType,
		java.lang.String aspectRatio,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] {
						ClpSerializer.translateInput(file),
						
					venueId,
						
					ClpSerializer.translateInput(deviceType),
						
					ClpSerializer.translateInput(aspectRatio),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.rumbasolutions.flask.model.VenueImage)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
}