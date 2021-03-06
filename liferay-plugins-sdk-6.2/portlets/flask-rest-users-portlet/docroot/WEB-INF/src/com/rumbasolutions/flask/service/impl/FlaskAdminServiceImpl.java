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

package com.rumbasolutions.flask.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.NoSuchTicketException;
import com.liferay.portal.ReservedUserIdException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.webdav.Resource;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.PermissionServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.AddressUtil;
import com.liferay.portal.service.persistence.CountryUtil;
import com.liferay.portal.service.persistence.PhoneUtil;
import com.liferay.portal.service.persistence.RegionUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.rumbasolutions.flask.model.FlaskAdmin;
import com.rumbasolutions.flask.model.FlaskRole;
import com.rumbasolutions.flask.service.FlaskAdminServiceUtil;
import com.rumbasolutions.flask.service.base.FlaskAdminServiceBaseImpl;

/**
 * The implementation of the flask admin remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.FlaskAdminService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.FlaskAdminServiceBaseImpl
 * @see com.rumbasolutions.flask.service.FlaskAdminServiceUtil
 */
public class FlaskAdminServiceImpl extends FlaskAdminServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.FlaskAdminServiceUtil} to access the flask admin remote service.
	 */
	
	
/*
 * 
 * This method gets list of all users with Flask admin role
 * @see com.rumbasolutions.flask.service.FlaskAdminService#getFlaskAdmins()
 */
	private static Log LOGGER = LogFactoryUtil.getLog(FlaskAdminServiceImpl.class);
	public static final String _userProfilesFolder = "UserProfiles";
	public static Role _guestRole =null;
	
	@Override
	public List<FlaskAdmin> getFlaskAdmins(ServiceContext serviceContext){
		List<FlaskAdmin> adminList=null;
		try{
			String search="";
			String searchColumn="";
			
			adminList = getFlaskUsers(FlaskModelUtil.FLASK_ADMIN, search, searchColumn, true, serviceContext);
			adminList.addAll(getFlaskUsers(FlaskModelUtil.FLASK_CONTENT_ADMIN, search, searchColumn, true, serviceContext));
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return adminList;
	}
	
	@Override
	public List<FlaskAdmin> getFlaskRegularUsers(ServiceContext  serviceContext){
		List<FlaskAdmin> userList=new ArrayList<FlaskAdmin>();
		try{
			String search="";
			String searchColumn="";
			userList = getFlaskUsers(FlaskModelUtil.FLASK_USER, search, searchColumn, true, serviceContext);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return userList;
	}
	
	/**
	 * @param User List
	 * @throws PortalException
	 * @throws SystemException
	 */
	private List<FlaskAdmin> getFlaskUsers(String userType, String search, String searchColumn, boolean bSetRole, ServiceContext serviceContext)
			throws PortalException, SystemException {
		
		List<FlaskAdmin> adminList= new ArrayList<FlaskAdmin>();
		FlaskRole role = FlaskModelUtil.getFlaskRoleByName(userType);
		int flaskUserCount = UserLocalServiceUtil.getRoleUsersCount(role.getRoleId());
		flaskUserCount = flaskUserCount < FlaskModelUtil.MAX_USER_LIMIT ? flaskUserCount : FlaskModelUtil.MAX_USER_LIMIT;
		List<User> users= UserLocalServiceUtil.getRoleUsers(role.getRoleId(), 0, flaskUserCount);
		for(User user : users){
			adminList.add(FlaskModelUtil.getFlaskUser(user, bSetRole, serviceContext));
		}
		return adminList;
	}
	
	/*
	 * This method adds flask admins
	 * 
	 * 
	 */
	
	@Override
	public	FlaskAdmin addFlaskAdmin(String firstName, String middleName, String lastName, 
					String email, String screenName,String password1, String password2,  
					String DOB, boolean isMale,
					String streetName, String aptNo,
					String areaCode, String city,
					long stateId, long countryId,
					String mobileNumber, String userInterests, long roleId, 
					ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		User user = addUser(roleId, serviceContext.getUserId(), firstName, middleName, lastName, 
				screenName, email, password1,  password2,
				DOB, isMale,
				streetName, aptNo,
				areaCode, city,
				stateId, countryId,
				mobileNumber, userInterests, serviceContext);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, false, serviceContext);
		}
		return adminUser;
	}
	
	@Override
	@AccessControlled(guestAccessEnabled =true)
	public	FlaskAdmin signUp(String firstName, String lastName, 
					String email, String screenName,String password1, String password2,  
					String DOB, boolean isMale,	String areaCode,
					String mobileNumber, boolean agreedToTermsOfUse,
					ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		User user = addUser(20165, 0, firstName, "", lastName, 
				screenName, email, password1,  password2,
				DOB, isMale,
				"", "",
				areaCode, "",
				0, 0,
				mobileNumber, "", serviceContext);
		user = UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), agreedToTermsOfUse);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, false, serviceContext);
		}
		return adminUser;
	}
	
	
	@Override
	public  FlaskAdmin updateFlaskAdmin(long userId, String firstName, String middleName, String lastName, 
			String email, String screenName,String password1, String password2,  
			String DOB, boolean isMale,
			String streetName, String aptNo,
			String areaCode, String city,
			long stateId, long countryId,
			String mobileNumber, String userInterests,
			ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.FlaskRoleEnum.FLASK_ADMIN.getRoleName());
		User user = updateUser(userId, role.getRoleId(), serviceContext.getUserId(),
				firstName, middleName, lastName, 
				screenName, email, password1,  password2,
				DOB, isMale,
				streetName, aptNo,
				areaCode, city,
				stateId, countryId,
				mobileNumber, userInterests, serviceContext);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, true, serviceContext);
		}
		return adminUser;
	}
	
	
	/**
	 * 
	 */
	@Override
	public  void deleteFlaskAdmins(long userId, ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		if(serviceContext.getUserId() == userId){
			throw new ReservedUserIdException("User cannot delete self");
		}
		User user = UserLocalServiceUtil.getUser(userId);
		List<Role> roles = user.getRoles();
		for(Role role :roles){
			if(role.getName().contentEquals(FlaskModelUtil.LIFERAY_ADMIN)){
				throw new ReservedUserIdException("Administrators cannot be deleted");
			}
		}
		UserLocalServiceUtil.deleteUser(userId);
	}
	
	
	/**
	 *  Returns valid user id if user found else 0. -1 when there is unknown system exception
	 */
	@Override
	public  long getUserIdForScreenName(String screenName, ServiceContext serviceContext) 
	{
		
		long userId = 0;
		User  user=null;;
		try{
			user = UserLocalServiceUtil.getUserByScreenName(PortalUtil.getDefaultCompanyId(), screenName);
			userId = user.getUserId();
		}catch(PortalException  ex){
			//no user with screen name.. hence unique
			
		}catch(SystemException ex){
			LOGGER.error("Exception in getUserIdForEmail " + ex.getMessage());
			userId = -1;
		}
		return userId;
	}
	
	/**
	 *  Returns valid user id if user found else 0. -1 when there is unknown system exception
	 */
	@Override
	public  long getUserIdForEmail(String  emailAddress, ServiceContext serviceContext)
	{
		long userId = 0;
		User  user;
		try{
			user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
			userId = user.getUserId();
		}catch(PortalException  ex){
			return 0;
		}catch(SystemException ex){
			LOGGER.error("Exception in getUserIdForEmail " + ex.getMessage());
			userId = -1;
		}
		return userId;
	}
	
	/**
	 *  Returns valid user id if user found else 0. -1 when there is unknown system exception
	 */
	@Override
	public  FlaskAdmin getUserById(long userId, ServiceContext serviceContext)
	{
		FlaskAdmin flaskUser=null;
		try{
			User  user = UserLocalServiceUtil.getUser(userId);
			flaskUser =FlaskModelUtil.getFlaskUser(user, true, serviceContext);
		}catch(PortalException  ex){
			LOGGER.error("Exception in getUserIdById" + ex.getMessage());
		}catch(SystemException ex){
			LOGGER.error("Exception in getUserIdById" + ex.getMessage());
		}
		return flaskUser;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	private User addUser(long roldId, long loggedInUser, String firstName, String middleName, 
			String lastName, String screenName, String email,
			String password1, String password2,
			String DOB, boolean isMale,
			String streetName, String aptNo,
			String areaCode, String city,
			long stateId, long countryId,
			String mobileNumber, String userInterests, ServiceContext serviceContext) throws PortalException, SystemException {
		
			User user=null;
			Calendar cal = FlaskModelUtil.parseDate(DOB);
	
			
			 long[] emptyLong = {};
			 long[] roleIds ={roldId};
			 user = UserLocalServiceUtil.addUser(
					 	loggedInUser /*long creatorUserId*/,
					 	PortalUtil.getDefaultCompanyId() /*long companyId*/,
					 	false /*boolean autoPassword*/,
					 	password1 /*String password1*/,
					 	password2 /*String password2*/,
				 		false /*boolean autoScreenName*/,
				 		screenName /* String screenName*/,
				 		email 	/*String emailAddress*/,
				 		0, 		//long facebookId,
				 		"", 	//String openId
				 		new Locale("en-us") /*Locale locale*/,
				 		firstName /*String firstName*/,
				 		middleName /*String middleName*/,
				 		lastName /*String lastName*/,
				 		0/*int prefixId*/,
				 		0 /*int suffixId*/,
				 		isMale /*boolean male*/,
				 		cal.get(Calendar.MONTH) /*int birthdayMonth*/,
				 		cal.get(Calendar.DAY_OF_MONTH) /*int birthdayDay*/,
				 		cal.get(Calendar.YEAR) /*int birthdayYear*/,
				 		null /*String jobTitle*/,
				 		emptyLong, /*groupIds*/
				 		emptyLong, /*long[] organizationIds*/
				 		roleIds, /*long[] roleIds*/
				 		emptyLong, /*long[] userGroupId*/
				 		true, /*boolean sendEmail*/
				 		null);
			 
			 addUserInterest(userInterests, user);
			 
			 addAddress(streetName, aptNo, areaCode, city, stateId, countryId,
					serviceContext, user);
			 
			 if(!mobileNumber.isEmpty()){
				 addMobile(mobileNumber, user, serviceContext);
			 }
			 return user;
	}
	
	private void addUserInterest(String userInterests, User user){
		try {
			if(userInterests.isEmpty()) {
				return;
			}
			//JSONArray json = JSONFactoryUtil.createJSONArray(userInterests); //this should validate JSON else throw JSON exception
			if (user.getExpandoBridge() != null && !user.getExpandoBridge().hasAttribute(FlaskModelUtil.EXPANDO_COL_USER_INTERESTS)){
				 user.getExpandoBridge().addAttribute(FlaskModelUtil.EXPANDO_COL_USER_INTERESTS, ExpandoColumnConstants.STRING, false);
			}
			user.getExpandoBridge().setAttribute(FlaskModelUtil.EXPANDO_COL_USER_INTERESTS, userInterests, false);
		} catch (Exception e) {
			LOGGER.error("Exception in addUserInterest: "+e.getMessage());
		}
	}

	private void addMobile(String mobileNumber, User user, ServiceContext serviceContext){
		if(mobileNumber == null || mobileNumber.isEmpty()){
			LOGGER.warn("Empty mobile number");
			return;
		}
		int mobileTypeId = FlaskModelUtil.getMobilePhoneTypeId();
		try {
			Phone phone = PhoneUtil.create(CounterLocalServiceUtil.increment());
			phone.setCompanyId(user.getCompanyId());
			phone.setUserId( user.getUserId());
			phone.setClassName(Contact.class.getName());
			phone.setClassPK(user.getContact().getContactId());
			phone.setTypeId(mobileTypeId);
			phone.setPrimary(true);
			phone.setNumber(mobileNumber);
			PhoneUtil.update(phone);
		} catch (Exception e) {
			LOGGER.error("Error in adding mobile. Exception:" + e.getMessage());
		}
	}

	private void addAddress(String streetName, String aptNo, String areaCode,
							String city, long stateId, long countryId,
							ServiceContext serviceContext,User user){
		
		 int addressTypeId = FlaskModelUtil.getPersonalAddressId();
		 try {
			 long classPK = user.getContact().getContactId();
			 Address address = AddressUtil.create(CounterLocalServiceUtil.increment()); 	
			 
			 address.setCompanyId(user.getCompanyId());
			 address.setUserId(user.getUserId());
			 address.setClassName(Contact.class.getName());
			 address.setClassPK(classPK);
			 address.setCity(city);
			 address.setStreet1(aptNo);
			 address.setStreet2(streetName);
			 address.setZip(areaCode);
			 address.setRegionId(stateId);
			 address.setCountryId(countryId);
			 address.setTypeId(addressTypeId);
			 address.setMailing(false);
			 address.setPrimary(true);;
			 
			 AddressUtil.update(address);
		} catch (Exception e) {
			LOGGER.error("Exception in addAddress. Exception:" +e.getMessage());
		}
	}
	
	/**
	 * THis function sets address fields to passed Address Object and saves the address
	 * @param streetName
	 * @param aptNo
	 * @param areaCode
	 * @param city
	 * @param stateId
	 * @param countryId
	 * @param addr
	 * @throws SystemException
	 */
	
	private void setAddress(
		String streetName, String aptNo, String areaCode, String city, long stateId, long countryId, Address addr)
		throws SystemException {

		addr.setStreet1(aptNo);
		addr.setStreet2(streetName);
		addr.setCity(city);
		addr.setRegionId(stateId);
		addr.setCountryId(countryId);
		addr.setZip(areaCode);
		AddressLocalServiceUtil.updateAddress(addr);
	}
	/**
	 * 
	 * @param userId
	 * @param roleId
	 * @param loggedInUser
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param screenName
	 * @param email
	 * @param password1
	 * @param password2
	 * @param DOB
	 * @param isMale
	 * @param streetName
	 * @param aptNo
	 * @param areaCode
	 * @param city
	 * @param stateId
	 * @param countryId
	 * @param mobileNumber
	 * @param userInterests
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private User updateUser(long userId, long roleId, long loggedInUser, String firstName, String middleName, 
			String lastName, String screenName, String email, String password1, String password2,
			String DOB, boolean isMale,
			String streetName, String aptNo,
			String areaCode, String city,
			long stateId, long countryId,
			String mobileNumber, String userInterests, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		long[] roleIds= new long[1];
		User user =	UserLocalServiceUtil.getUser(userId);
		if(roleId==0){
			roleIds = new long[user.getRoleIds().length];
			roleIds = user.getRoleIds();
		}else{
			roleIds[0] = roleId;
		}
		if(!password1.equals(password2)){
			throw new com.liferay.portal.UserPasswordException(0);
		}
		if(password1.isEmpty()){
			password1 = null;
			password2 = null;
		} 
		
		Calendar cal = FlaskModelUtil.parseDate(DOB);
		user = UserLocalServiceUtil.updateUser( userId /*long userId*/,
				user.getPassword()/*String oldPassword*/,
				password1 /*String newPassword1*/,
		password1/*String newPassword2*/,
                false/*boolean passwordReset*/,
                user.getReminderQueryQuestion() /*String reminderQueryQuestion*/,
                user.getReminderQueryAnswer() /*String reminderQueryAnswer*/,
                screenName/*String screenName*/,
                email/*String emailAddress*/,
                user.getFacebookId()/*long facebookId*/,
                user.getOpenId()/*String openId*/,
                user.getLanguageId() /*String languageId*/,
                user.getTimeZoneId()/*String timeZoneId*/,
                user.getGreeting()/*String greeting*/,
                user.getComments()/*String comments*/,
                firstName/*String firstName*/,
                middleName/*String middleName*/,
                lastName/*String lastName*/,
                0/*int prefixId*/,
                0/*int suffixId*/,
                isMale/*boolean male*/,
            	cal.get(Calendar.MONTH) /*int birthdayMonth*/,
		 		cal.get(Calendar.DAY_OF_MONTH) /*int birthdayDay*/,
		 		cal.get(Calendar.YEAR) /*int birthdayYear*/,
		 		""/*String smsSn*/,
		 		""/*String aimSn*/,
                "" /*String facebookSn*/,
                "" /*String icqSn*/,
                "" /*String jabberSn*/,
                "" /*String msnSn*/,
                "" /*String mySpaceSn*/,
                ""/*String skypeSn*/,
                "" /*String twitterSn*/,
                "" /*String ymSn*/,
                user.getJobTitle() /*String jobTitle*/,
                user.getGroupIds(),
                user.getOrganizationIds()/*long[] organizationIds*/,
                roleIds/*long[] roleIds*/,
                null/*List<UserGroupRole> userGroupRoles*/,
                user.getGroupIds(),
                serviceContext);
		
			if(user.getAddresses().size() > 0){
				Address addr = user.getAddresses().get(0);
				setAddress(streetName, aptNo, areaCode, city, stateId, countryId, addr);
			}else{
				addAddress(streetName, aptNo, areaCode, city, stateId, countryId,
					serviceContext, user);
			}
			if(user.getPhones().size() > 0 ){
				Phone phone = PhoneLocalServiceUtil.getPhones(PortalUtil.getDefaultCompanyId(), Contact.class.getName(), user.getContactId()).get(0);
				phone.setNumber(mobileNumber);
				PhoneLocalServiceUtil.updatePhone(phone);
			}else{
				addMobile(mobileNumber, user, serviceContext);
			}	
			addUserInterest(userInterests, user);
			return user;
	}	
	
	/*
	 * This method adds flask admins
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	FlaskAdmin addFlaskUser(String firstName, String middleName, String lastName, 
					String email, String screenName,String password1, String password2,  
					String DOB, boolean isMale,
					String streetName, String aptNo,
					String areaCode, String city,
					long stateId, long countryId,
					String mobileNumber, String userInterests, 
					ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.FlaskRoleEnum.FLASK_USER.getRoleName());
		User user = addUser(role.getRoleId(), serviceContext.getUserId(), firstName, middleName, lastName, 
				screenName, email, password1,  password2,
				DOB, isMale,
				streetName, aptNo,
				areaCode, city,
				stateId, countryId,
				mobileNumber, userInterests, serviceContext);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, true, serviceContext);
		}
		return adminUser;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	FlaskAdmin updateFlaskUser(long userId, String firstName, String middleName, String lastName, 
					String email, String screenName,String password1, String password2,  
					String DOB, boolean isMale,
					String streetName, String aptNo,
					String areaCode, String city,
					long stateId, long countryId,
					String mobileNumber, String userInterests, 
					ServiceContext serviceContext) 
	{
		FlaskAdmin adminUser=null;
		try {
			Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.FlaskRoleEnum.FLASK_USER.getRoleName());
			User user = updateUser(userId, role.getRoleId(), serviceContext.getUserId(), firstName, middleName, lastName, screenName, email,
					password1, password2, DOB, isMale, streetName, aptNo, areaCode, city, stateId, countryId, mobileNumber, userInterests, serviceContext);
			if(user != null) {
				adminUser = FlaskModelUtil.getFlaskUser(user, true, serviceContext);
			}
		} catch (Exception e) {
			LOGGER.error("Exception in updateFlaskUser: "+e.getMessage());
		}		
		return adminUser;
	}
	
	@Override
	public  FlaskAdmin updateLoggedInUser(String firstName, String middleName, String lastName, 
			String email, String screenName,String password1, String password2,  
			String DOB, boolean isMale,
			String streetName, String aptNo,
			String areaCode, String city,
			long stateId, long countryId,
			String mobileNumber, String userInterests,
			ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		
		User user = updateUser(serviceContext.getGuestOrUserId(), 0, serviceContext.getUserId(),
				firstName, middleName, lastName, 
				screenName, email, password1,  password2,
				DOB, isMale,
				streetName, aptNo,
				areaCode, city,
				stateId, countryId,
				mobileNumber, userInterests, serviceContext);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, true, serviceContext);
		}
		return adminUser;
	}
	
	/*
	 * This method get details of country 
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	Country getCountryByName( String name, ServiceContext serviceContext) throws SystemException, PortalException
	{ 
		return  CountryUtil.fetchByName(name);
	
	}
	/*
	 * This get list of supported countries
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	List<Country> getCountries(ServiceContext serviceContext) throws SystemException, PortalException
	{ 	
		List<Country> countryList = new ArrayList<Country>();
		for (String name : FlaskModelUtil.COUNTRY_LIST){
			try{
				countryList.add(CountryUtil.fetchByName(name));
			}catch(Exception ex){
				
			}
		}
		return  countryList;
	}
	
	/*
	 * This method is accesible by guest users and returns all regions for specified country id
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	List<Region> getRegion(long countryId, ServiceContext serviceContext) throws SystemException, PortalException
	{ 
		
		return RegionUtil.findByCountryId(countryId);
	}
	
	/*
	 * This method is accesible by guest users and returns all regions for specified country id
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	List<Region> getUSARegions(ServiceContext serviceContext) throws SystemException, PortalException
	{ 
		Country country = CountryUtil.fetchByName("united-states");
		return RegionUtil.findByCountryId(country.getCountryId());
	}
	
	@Override
	@AccessControlled(guestAccessEnabled =true)
	public FileEntry addMyFileEntry(long userId, long repositoryId , long folderId,
										 String sourceFileName, String mimeType, String title,  
										 String description, String changeLog, byte[] bytes, ServiceContext serviceContext) 
														 throws PortalException, SystemException{
		FileEntry fileEntry=null;	
		try{	
			long count = CounterLocalServiceUtil.increment();
			String tempTitle = count+"_"+title;
				fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId, folderId, tempTitle, mimeType, tempTitle, tempTitle, changeLog, bytes, serviceContext);
				if(userId>0){
					User user = UserLocalServiceUtil.getUser(userId);
					user.setPortraitId(fileEntry.getFileEntryId());
					UserLocalServiceUtil.updateUser(user);
				}
			}catch(Exception e){
				LOGGER.error("Exception in addMyFileEntry: " +e.getMessage());
			}
		return fileEntry;
	}
	
	@Override
	@AccessControlled(guestAccessEnabled =true)
	public FileEntry getMyFileEntry(long userId)throws PortalException, SystemException{
		FileEntry fileEntry=null;	
		try{	User user = UserLocalServiceUtil.getUser(userId);
				fileEntry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
				FlaskModelUtil.setMyGuestViewPermission(fileEntry);
				
			}catch(Exception ex){
				
			}
		return fileEntry;
	}
	
	@Override
	@AccessControlled(guestAccessEnabled =true)
	public void deleteMyFileEntry(long userId)throws PortalException, SystemException{
		FileEntry fileEntry=null;	
		try{	
				long portraitId = UserLocalServiceUtil.getUser(userId).getPortraitId();
				DLAppLocalServiceUtil.deleteFileEntry(portraitId);
				FlaskAdminServiceUtil.updateUserForFileEntry(userId, 0, null);				
				FlaskModelUtil.setMyGuestViewPermission(fileEntry);
		}catch(Exception ex){
			
		}
	}
	
	@Override
	@AccessControlled(guestAccessEnabled =true)
	public void updateUserForFileEntry(long userId, long fileEntryId,ServiceContext serviceContext)throws PortalException, SystemException{
		try{	
				User user = UserLocalServiceUtil.getUser(userId);
				user.setPortraitId(fileEntryId);
				UserLocalServiceUtil.updateUser(user);
		}catch(Exception e){
			LOGGER.error("Exception in updateUserForFileEntry: " +e.getMessage());
		}
	}
	
	/*
	 * This method is accessible by guest users and used to check whether user exist with given email address or not
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public int getUserForEmail(String emailAddress, ServiceContext serviceContext){ 
		int userExist = 0;
		try {
			User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
			if(!user.getEmailAddress().isEmpty()){
				userExist = 1;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return userExist;
	}
	
	/*
	 * This method is accessible by guest users and used to check whether user exist with given screenName or not
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public int getUserForScreenName(String screenName, ServiceContext serviceContext){ 
		int userExist = 0;
		try {
			User user = UserLocalServiceUtil.getUserByScreenName(PortalUtil.getDefaultCompanyId(), screenName);
			if(!user.getScreenName().isEmpty()){
				userExist = 1;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return userExist;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public FileEntry uploadUserProfile(File file, ServiceContext serviceContext){
		FileEntry fileEntry = null;
		try {
			Path source = Paths.get(file.getName());
			String mimeType = Files.probeContentType(source);
			long repositoryId = FlaskModelUtil.getFlaskRepositoryId();
			long userId = serviceContext.getUserId();
			String name = userId +"_"+ file.getName();
			Folder folder = FlaskModelUtil.getOrCreateFolder(_userProfilesFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
			fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), folder.getRepositoryId(), folder.getFolderId(), name, mimeType, name, name, "", file, serviceContext);
			FlaskModelUtil.setAllRoleViewPermission(fileEntry);
			long portraitId = UserLocalServiceUtil.getUser(userId).getPortraitId();
			FlaskAdminServiceUtil.updateUserForFileEntry(userId, fileEntry.getFileEntryId(), serviceContext);
			if(portraitId>0)
				DLAppLocalServiceUtil.deleteFileEntry(portraitId);
			
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return fileEntry;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public long getCompanyId() {
		long companyId = 0;
		try{
			companyId = CompanyThreadLocal.getCompanyId();
		}catch(Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return companyId;
		
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public boolean isAddContentAccess(long userId) {
		boolean isContentAdmin = false;
		try{
			User user = UserLocalServiceUtil.getUser(userId);
			FlaskRole contentRole = FlaskModelUtil.getFlaskRoleByName(FlaskModelUtil.FLASK_CONTENT_ADMIN);
			FlaskRole adminRole = FlaskModelUtil.getFlaskRoleByName(FlaskModelUtil.FLASK_ADMIN);
			FlaskRole administrator =  FlaskModelUtil.getFlaskRoleByName(FlaskModelUtil.LIFERAY_ADMIN);
			if( FlaskModelUtil.isRoleInList(user, contentRole) || FlaskModelUtil.isRoleInList(user, adminRole) ||  FlaskModelUtil.isRoleInList(user, administrator)){
				isContentAdmin = true;
			}
		}catch(Exception ex) {
			LOGGER.error(ex.getMessage());
		}
		return isContentAdmin;
		
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	Map<String, String> updatePassword(long userId, String oldPassword, String password1, String password2) {
		 Map<String, String> statusMap = new HashMap<String, String>();
		 statusMap.put("message", "Error");
		try {
			User user = UserLocalServiceUtil.getUser(userId);
//			 if(user.getPassword() == oldPassword) {
//				statusMap.put("message", "OldPasswordError");
//			 }
			 if(password1.equals(password2)) {
				UserLocalServiceUtil.updatePassword(userId, password1, password2, false,true);
				statusMap.put("message", "OK");
			}else {
				statusMap.put("message", "ConfirmPaswordError");
			}
		}catch(Exception exception) {
			
			LOGGER.error(exception);
		}
		return statusMap;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public boolean forgotPassword(String emailAddress, ServiceContext serviceContext){
		boolean done = false;
		InternetAddress fromAddress = null; 
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress("info@flaskus.com");
			toAddress = new InternetAddress(emailAddress);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress); 
			mailMessage.setFrom(fromAddress);
			User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date tomorrow = calendar.getTime();
			Ticket ticket = TicketLocalServiceUtil.addTicket(PortalUtil.getDefaultCompanyId(), FlaskAdminServiceImpl.class.getName(), user.getUserId(), 3, "", tomorrow, serviceContext);
			mailMessage.setSubject("https://www.flask-usa.com: Reset Password verification code");
			mailMessage.setBody("Dear " + user.getFullName() + ",\n\n" +
								"You can reset your password for https://www.flask-usa.com using verification code given below which will be expired on " + tomorrow + "\n\n" +
								"verification code: " + ticket.getTicketId());
			MailServiceUtil.sendEmail(mailMessage);
			done = true;
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return done;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public boolean contactUs(String name, String emailAddress, String phoneNumber, String subject, String message){
		boolean done = false;
		InternetAddress fromAddress = null; 
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress("info@flaskus.com");
			toAddress = new InternetAddress("info@flaskus.com");
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject(subject);
			mailMessage.setBody("Contact Us message from "+name+", "+emailAddress+ ", "+phoneNumber+" \n"+message);
			MailServiceUtil.sendEmail(mailMessage);
			done = true;
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return done;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	@Override
	public boolean resetPassword(String emailAddress, String password1, String password2, long otp, ServiceContext serviceContext)throws NoSuchTicketException, Exception{
		boolean done = false;
		try {
			Ticket ticket = TicketLocalServiceUtil.getTicket(otp);
			if(ticket.isExpired())
				throw new Exception("OTP is expired");
			if(password1.equals(password2)) {
				User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
				if(ticket.getClassPK() == user.getUserId()){
					user = UserLocalServiceUtil.updatePassword(user.getUserId(), password1, password2, false,true);
					TicketLocalServiceUtil.deleteTicket(ticket);
					done = true;
				}else{
					throw new Exception("Invalid OTP");
				}
			}
		} catch(NoSuchTicketException e){
			LOGGER.error(e);
			throw new NoSuchTicketException("Invalid OTP");
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
		return done;
	}
}