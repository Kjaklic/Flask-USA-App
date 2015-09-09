package com.rumbasolutions.flask.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.persistence.CountryUtil;
import com.liferay.portal.service.persistence.RegionUtil;
import com.liferay.portal.util.PortalUtil;
import com.rumbasolutions.flask.model.Event;
import com.rumbasolutions.flask.model.EventDetail;
import com.rumbasolutions.flask.model.EventType;
import com.rumbasolutions.flask.model.InfoType;
import com.rumbasolutions.flask.model.InfoTypeCategory;
import com.rumbasolutions.flask.model.Venue;
import com.rumbasolutions.flask.model.VenueDetail;
import com.rumbasolutions.flask.service.persistence.EventTypeUtil;
import com.rumbasolutions.flask.service.persistence.InfoTypeCategoryUtil;
import com.rumbasolutions.flask.service.persistence.InfoTypeUtil;
import com.rumbasolutions.flask.service.persistence.VenueUtil;


public class FlaskUtil {
	
	private static Log LOGGER = LogFactoryUtil.getLog(FlaskUtil.class);
	
	public static final String[] COUNTRY_LIST=  {"united-states","canada"};
	
	public static HashMap<Long,Country> _countryMap = new HashMap<Long, Country>();
	public static HashMap<Long, Region> _regionMap = new HashMap<Long, Region>();
	public static HashMap<Long, String> _eventType = new HashMap<Long, String>();
	public static HashMap<Long, String> _infoType = new HashMap<Long, String>();
	public static HashMap<Long, String> _infoTypeCategory = new HashMap<Long, String>();
	public static int DEFAULT_RANGE = 100; //miles
	public static Double DEFAULT_LATITUDE = 42.3400; //miles
	public static Double DEFAULT_LONGITUDE = 83.0456; //miles



	public static long repositoryId = 0;
	public static long getFlaskRepositoryId() throws PortalException, SystemException{
		if(repositoryId==0){
			long companyId = PortalUtil.getDefaultCompanyId();
			Group group = GroupLocalServiceUtil.getGroup(companyId, "guest");
			repositoryId = group.getGroupId();
		}
		return repositoryId;	
	}
	
	
	public static Calendar parseDate(String dateVal){
		Calendar cal = Calendar.getInstance();
		Date dt =null;
		String[] validFormats = {"MM-dd-yyyy", "yyyy-MM-dd", "MM/dd/yyyy" };
		for(String format : validFormats ){
				SimpleDateFormat sf  =new SimpleDateFormat(format, Locale.US);
				try {
					dt= sf.parse(dateVal);
					LOGGER.debug(dt);
					LOGGER.debug(sf.format(dt));
					cal.setTime(dt);				
					return cal;
				}catch (Exception e) {
					
				}
		}	
		return cal;
	}
	
	public static Calendar parseTime(String timeVal){
		Calendar cal = Calendar.getInstance();
		Date dt =null;
		String[] validFormats = {"hh:mm a", "hh:mm"};
		for(String format : validFormats ){
				SimpleDateFormat sf  =new SimpleDateFormat(format, Locale.US);
				try {
					dt= sf.parse(timeVal);
					LOGGER.debug(dt);
					LOGGER.debug(sf.format(dt));
					cal.setTime(dt);				
					return cal;
				}catch (Exception e) {
					
				}
		}	
		return cal;
	}

	public static Double parseLatitude(String latitude){
		Double dLatitude = DEFAULT_LATITUDE;
		try{
			dLatitude = Math.abs(Double.valueOf(latitude));
		}catch(Exception ex){
			LOGGER.error(ex.getMessage() + "Value:" + latitude);
		}
		return dLatitude;
	}
	public static Double parseLongitude(String longitude){
		Double dLongitude = DEFAULT_LONGITUDE;
		try{
			dLongitude = Math.abs(Double.valueOf(longitude));
		}catch(Exception ex){
			LOGGER.error(ex.getMessage() + "Value:" + longitude);
		}
		return dLongitude;
		
	}
	public static Event setStringNamesForEvent(Event event){
			try {
				Venue venue = VenueUtil.fetchByPrimaryKey(event.getVenueId());
				event.setVenueName(venue.getVenueName());
				event.setEventTypeName(findEventTypeNameById(event.getEventTypeId()));
			}
			catch (SystemException e) {
				LOGGER.error(e);
			}
		
			return event;
	}
	
	public static JSONArray setStringNamesForEvents(List<Event> eventList, List<Long> myEventList){
		JSONArray eventListJsonArr =  JSONFactoryUtil.createJSONArray();

		for (Event event : eventList){
			setStringNamesForEvent(event);
			try {
				JSONObject obj = JSONFactoryUtil.createJSONObject(JSONFactoryUtil.looseSerialize(event));
				int userEvent = 0;
				if(myEventList != null && myEventList.contains(event.getEventId())){
					userEvent = 1;
				}
				obj.put("userEvent", userEvent);
				eventListJsonArr.put(obj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return eventListJsonArr;
	}
	
	public static EventDetail setNamesForEventDetail(EventDetail detail){
		
		detail.setStateName(findRegionNameById(detail.getStateId()));
		detail.setCountryName(findCountryNameById(detail.getCountryId()));
		detail.setInfoTypeCategoryName(findInfoTypeCategoryNameById(detail.getInfoTypeCategoryId()));
		detail.setInfoTypeName(findInfoTypeNameById(detail.getInfoTypeId()));

		return detail;
	}
	
	public static List<EventDetail> setNamesForEventDetail(List<EventDetail> detailList){
		for (EventDetail eventDetail: detailList){
			setNamesForEventDetail(eventDetail);
		}
		return detailList;
	}
	
	public static VenueDetail setNamesForVenueDetail(VenueDetail detail){
		
		detail.setStateName(findRegionNameById(detail.getStateId()));
		detail.setCountryName(findCountryNameById(detail.getCountryId()));
		detail.setInfoTypeName(findInfoTypeNameById(detail.getInfoTypeId()));
		detail.setInfoTypeCategoryName(findInfoTypeCategoryNameById(detail.getInfoTypeCategoryId()));
		return detail;
	}
	
	public static List<VenueDetail> setNamesForVenueDetail(List<VenueDetail> detailList){
		for (VenueDetail venueDetail: detailList){
			setNamesForVenueDetail(venueDetail);
		}
		return detailList;
	}
	
	public static List<Venue> setVenueStringValues(List<Venue> venueList){
		for(Venue venue: venueList){
			setVenueStringValues(venue);
		}
		return venueList;
	}
	
	
	public static Venue setVenueStringValues(Venue venue){
		venue.setVenueCountryName(findCountryNameById(venue.getVenueCountryId()));
		venue.setVenueStateName(findRegionNameById(venue.getVenueStateId()));
		return venue;
	}
	
	
	public	static HashMap<Long, Country> getCountries()
	{ 	
		HashMap<Long, Country> countryMap = new HashMap<Long, Country>();
		for (String name : COUNTRY_LIST){
			try{
				Country country = CountryUtil.fetchByName(name);
				countryMap.put(country.getCountryId(), country);
			}catch(Exception ex){
				
			}
		}
		return  countryMap;
	}
	
	
	
	public static String findCountryNameById(long countryId){
		if (_countryMap.size() == 0){
			_countryMap.putAll(getCountries());
		}
		String countryName="";
		Country country = _countryMap.get(countryId);
		if(country != null){
			countryName = country.getNameCurrentValue();
		}
		return countryName;
	}
	
	public static String findRegionNameById(long regionId){
			String name="";
			Region region = _regionMap.get(regionId);
			if( region == null){
				try {
					region = RegionUtil.fetchByPrimaryKey(regionId);
				} catch (SystemException e) {
					LOGGER.error("Cannot find region:" + regionId);
				}
				if(region != null){
					_regionMap.put(region.getRegionId(), region);
				}
			}
			if(region != null){
				name = region.getName();
			}
			return name;
	}
	
	/*
	 * 	public static HashMap<Long, String> _eventType = new HashMap<Long, String>();
	public static HashMap<Long, String> _infoType = new HashMap<Long, String>();
	public static HashMap<Long, String> _infoTypeCategory = new HashMap<Long, String>();
	
	 */
	public static HashMap<Long, String> getEventType(){
		HashMap<Long, String> eventTypeMap = new HashMap<Long, String>();
		
		try {
			List<EventType> eventTypeList = EventTypeUtil.findAll();
			for( EventType e: eventTypeList){
				eventTypeMap.put(e.getEventTypeId(), e.getEventTypeName());
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return eventTypeMap;
	}
	public static String findEventTypeNameById(long eventTypeId){
		if (_eventType.size() == 0){
			_eventType.putAll(getEventType());
		}
		String  eventTypeName = _eventType.get(eventTypeId);
		eventTypeName = eventTypeName != null ? eventTypeName : "";
	
		return eventTypeName;
	}
	
	public static HashMap<Long, String> getInfoTypes(){
		HashMap<Long, String> infoTypeMap = new HashMap<Long, String>();
		
		try {
			List<InfoType> infoTypeList = InfoTypeUtil.findAll();
			for( InfoType e: infoTypeList){
				infoTypeMap.put(e.getInfoTypeId(), e.getInfoTypeName());
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return infoTypeMap;
	}
	public static String findInfoTypeNameById(long infoTypeId){
		if (_infoType.size() == 0){
			_infoType.putAll(getInfoTypes());
		}
		String  infoTypeName = _infoType.get(infoTypeId);
		infoTypeName = infoTypeName != null ? infoTypeName : "";
	
		return infoTypeName;
	}
	
	public static HashMap<Long, String> getInfoTypeCategory(){
		HashMap<Long, String> infoTypeCategoryMap = new HashMap<Long, String>();
		
		try {
			List<InfoTypeCategory> infoTypeList = InfoTypeCategoryUtil.findAll();
			for( InfoTypeCategory e: infoTypeList){
				infoTypeCategoryMap.put(e.getInfoTypeCategoryId(), e.getInfoTypeCategoryName());
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return infoTypeCategoryMap;
	}
	public static String findInfoTypeCategoryNameById(long InfoTypeCategoryId){
		if (_infoTypeCategory.size() == 0){
			_infoTypeCategory.putAll(getInfoTypeCategory());
		}
		String  infoTypeCategoryName = _infoTypeCategory.get(InfoTypeCategoryId);
		infoTypeCategoryName = infoTypeCategoryName != null ? infoTypeCategoryName : "";
	
		return infoTypeCategoryName;
	}
	
	public static Map<String, Double> getLatitudeAndLongitudeRange(
			double latitude, double longitude, int distance) {
		Map<String, Double> latitudeLongitudeMap = new HashMap<String, Double>();
		
		double radius = 3959;
		Double latN = Math.asin(Math.sin(Math.toRadians(latitude))
				* Math.cos(distance / radius)
				+ Math.cos(Math.toRadians(latitude))
				* Math.sin(distance / radius) * Math.cos(Math.toRadians(0)));

		Double latS = Math.asin(Math.sin(Math.toRadians(latitude))
				* Math.cos(distance / radius)
				+ Math.cos(Math.toRadians(latitude))
				* Math.sin(distance / radius) * Math.cos(Math.toRadians(180)));

		Double longE = Math.toRadians(longitude)
				+ Math.atan2(
						Math.sin(Math.toRadians(90))
								* Math.sin(distance / radius)
								* Math.cos(Math.toRadians(latitude)),
						Math.cos(Math.toRadians(distance / radius))
								- Math.sin(Math.toRadians(latitude))
								* Math.sin(Math.toRadians(latN)));

		Double longW = Math.toRadians(longitude)
				+ Math.atan2(
						Math.sin(Math.toRadians(270))
								* Math.sin(distance / radius)
								* Math.cos(Math.toRadians(latitude)),
						Math.cos(Math.toRadians(distance / radius))
								- Math.sin(Math.toRadians(latitude))
								* Math.sin(Math.toRadians(latN)));

		latitudeLongitudeMap.put("latitudeNorth", Math.toDegrees(latN));
		latitudeLongitudeMap.put("latitudeSouth", Math.toDegrees(latS));
		latitudeLongitudeMap.put("longitudeEast", Math.toDegrees(longE));
		latitudeLongitudeMap.put("longitudeWest", Math.toDegrees(longW));
		return latitudeLongitudeMap;
	}

	public static JSONObject mergeEventVenueJSON(JSONObject eventObj, JSONObject venueObj){
		
		if(eventObj == null || venueObj == null){
			return null;
		}
		eventObj.put("Venue", venueObj.getString("Venue"));
		JSONArray eventArr = eventObj.getJSONArray("Details");
		if(eventArr == null){
			eventArr = JSONFactoryUtil.createJSONArray();
		}
		JSONArray  venueArr = venueObj.getJSONArray("Details");
		if(venueArr != null){
			for(int i=0; i < venueArr.length(); i++ ){
				eventArr.put(venueArr.getJSONObject(i));
			}
		}
		eventObj.put("Details", eventArr);
		
		return eventObj;
	}
	
}
