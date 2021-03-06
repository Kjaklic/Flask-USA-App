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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.liferay.contacts.model.FlaskGroupMessages;
import com.liferay.contacts.model.FlaskGroupRecipients;
import com.liferay.contacts.service.FlaskGroupMessagesLocalServiceUtil;
import com.liferay.contacts.service.FlaskGroupMessagesServiceUtil;
import com.liferay.contacts.service.FlaskGroupRecipientsLocalServiceUtil;
import com.liferay.contacts.service.FlaskGroupRecipientsServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.FlaskGroup;
import com.rumbasolutions.flask.model.FlaskGroupUsers;
import com.rumbasolutions.flask.service.FlaskGroupLocalServiceUtil;
import com.rumbasolutions.flask.service.FlaskGroupServiceUtil;
import com.rumbasolutions.flask.service.FlaskGroupUsersLocalServiceUtil;
import com.rumbasolutions.flask.service.FlaskGroupUsersServiceUtil;
import com.rumbasolutions.flask.service.base.FlaskGroupServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.FlaskGroupFinderUtil;
import com.rumbasolutions.flask.service.persistence.FlaskGroupUsersUtil;
import com.rumbasolutions.flask.service.persistence.FlaskGroupUtil;

/**
 * The implementation of the flask group remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.FlaskGroupService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Tejas Patel
 * @see com.rumbasolutions.flask.service.base.FlaskGroupServiceBaseImpl
 * @see com.rumbasolutions.flask.service.FlaskGroupServiceUtil
 */
public class FlaskGroupServiceImpl extends FlaskGroupServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.FlaskGroupServiceUtil} to access the flask group remote service.
	 */
	private static Log LOGGER = LogFactoryUtil
			.getLog(FlaskGroupServiceImpl.class);

	@Override
	public List<FlaskGroup> getAllGroups() {
		List<FlaskGroup> groupList = new ArrayList<FlaskGroup>();
		try {
			groupList = FlaskGroupUtil.findAll();
		} catch (SystemException e) {
			LOGGER.error("Exception in getGroups :" + e.getMessage());
		}
		return groupList;
	}
	
	@Override
	public JSONArray getAllMyGroups(long userId, ServiceContext serviceContext)throws Exception{
		JSONArray iAarray = JSONFactoryUtil.createJSONArray();
		try {
			List<FlaskGroupUsers> userGroups = FlaskGroupUsersUtil.findByUserId(userId);
			for(FlaskGroupUsers userGroup: userGroups){
				FlaskGroup myGroup = FlaskGroupServiceUtil.getGroup(userGroup.getGroupId());
				if(myGroup != null){
					List<FlaskGroupRecipients> flaskGroupRecipients = FlaskGroupRecipientsServiceUtil.getGroupRecipientsByGroupId(myGroup.getGroupId());
					JSONObject obj= JSONFactoryUtil.createJSONObject();
					obj.put("groupId", myGroup.getGroupId());
					obj.put("groupName", myGroup.getGroupName());
					obj.put("groupDescription", myGroup.getGroupDescription());
					obj.put("createdDate", myGroup.getCreatedDate());
					obj.put("createdBy", myGroup.getCreatedBy());
					obj.put("isAdmin", userGroup.getIsAdmin());
					obj.put("isActive", myGroup.getIsActive());
					obj.put("isDelete", myGroup.getIsDelete());
					int count = 0;
					for(FlaskGroupRecipients recp: flaskGroupRecipients){
						JSONObject recpInfo = JSONFactoryUtil.createJSONObject(recp.getMessageStatusInfo());				
						if(recpInfo.has(String.valueOf(serviceContext.getUserId()))){
							JSONObject recpObj = recpInfo.getJSONObject(String.valueOf(serviceContext.getUserId()));
							if(!recpObj.getBoolean("deleted") && !recpObj.getBoolean("read")){
								count++;
							}
						}
					}
					String dateTime ="";
					JSONArray messages = FlaskGroupMessagesServiceUtil.getAllMyFlaskGroupMessages(myGroup.getGroupId(), serviceContext);
					if(messages.length() > 0){
						JSONObject object = messages.getJSONObject(0);
						dateTime = object.getString("dateTime");						
						obj.put("lastMessageDateTime", dateTime);
					}else{
						obj.put("lastMessageDateTime", "0000-00-00 00:00:00:0");
					}
					obj.put("unreadGroupMesageCount", count);
					iAarray.put(obj);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception in getAllMyGroups. " + e.getMessage());
		}
		return iAarray;
	}
	
	@Override
	public List<FlaskGroup> getGroups(long userId){
		List<FlaskGroup> myGroupList = new ArrayList<FlaskGroup>();
		try {
			List<FlaskGroupUsers> grpUsers = FlaskGroupUsersUtil.findByUserId(userId);
			for(FlaskGroupUsers grpUser: grpUsers){
				FlaskGroup group = FlaskGroupServiceUtil.getGroup(grpUser.getGroupId());
				if(group != null)
					myGroupList.add(group);
			}
		} catch (SystemException e) {
			LOGGER.error("Exception in getGroups:"+e.getMessage());
		}
		return myGroupList;
	}
	
	@Override
	public List<FlaskGroup> getMyGroups(long userId){
		int isAdmin = 1;
		List<FlaskGroup> myGroupList = null;
		myGroupList = FlaskGroupFinderUtil.getGroupList(userId, isAdmin);
		return myGroupList;
	}
	
	@Override
	public List<FlaskGroup> getParticipatingGroups(long userId){
		int isAdmin = 0;
		List<FlaskGroup> participatingGroupList = null;
		participatingGroupList = FlaskGroupFinderUtil.getGroupList(userId, isAdmin);
		return participatingGroupList;
	}
	
	@Override
	public FlaskGroup getGroup(long groupId) {
		FlaskGroup group = null;
		try {
			group = FlaskGroupUtil.fetchByPrimaryKey(groupId);
		} catch (Exception e) {
			LOGGER.error("Exception in getGroups :" + e.getMessage());
		}
		return group;
	}
	

	@Override
	public FlaskGroup addGroup(String groupName, String groupDescription,
			String createdBy, String createdDate, int isActive, int isDelete, ServiceContext serviceContext) {
		FlaskGroup group = null;
		try {
			group = FlaskGroupLocalServiceUtil.createFlaskGroup(CounterLocalServiceUtil.increment());
			group.setGroupName(groupName);
			group.setGroupDescription(groupDescription);
			group.setCreatedBy(createdBy);
			group.setCreatedDate(createdDate);
			group.setIsActive(isActive);
			group.setIsDelete(isDelete);
			group = FlaskGroupLocalServiceUtil.addFlaskGroup(group);
		} catch (Exception e) {
			LOGGER.error(" Exception in Add Group :" + e.getMessage());
		}
		return group;
	}

	@Override
	public FlaskGroup updateGroup(long groupId, String groupName,
			String groupDescription, String createdDate, String createdBy, int isActive, int isDelete) {
		FlaskGroup group = null;
		try {
			group = FlaskGroupLocalServiceUtil.getFlaskGroup(groupId);
			group.setGroupName(groupName);
			group.setGroupDescription(groupDescription);
			group.setCreatedBy(createdBy);
			group.setCreatedDate(createdDate);
			group.setIsActive(isActive);
			group.setIsDelete(isDelete);
			group = FlaskGroupLocalServiceUtil.updateFlaskGroup(group);
		} catch (Exception e) {
			LOGGER.error(" Exception in Update Group :" + e.getMessage());
		}
		return group;
	}

	@Override
	public void deleteGroup(long groupId, ServiceContext serviceContext) {
		try {
			FlaskGroupUsers flaskGroupUser = FlaskGroupUsersUtil.fetchByUserIdGroupId(serviceContext.getUserId(), groupId);
			if(flaskGroupUser.getIsAdmin() == 1){
				List <FlaskGroupUsers> flaskGroupUsers = FlaskGroupUsersServiceUtil.getAllGroupUsers(groupId);
				for(FlaskGroupUsers user: flaskGroupUsers){
					FlaskGroupUsersLocalServiceUtil.deleteFlaskGroupUsers(user.getGroupUserId());
				}
				List<FlaskGroupMessages> flaskGroupMessages = FlaskGroupMessagesServiceUtil.getGroupMessages(groupId);
				for(FlaskGroupMessages flaskGroupMessage : flaskGroupMessages){
					FlaskGroupMessagesLocalServiceUtil.deleteFlaskGroupMessages(flaskGroupMessage.getGroupMessagesId());
				}
				List <FlaskGroupRecipients> flaskGroupRecepients = FlaskGroupRecipientsServiceUtil.getGroupRecipientsByGroupId(groupId);
				for(FlaskGroupRecipients recp: flaskGroupRecepients){
					FlaskGroupRecipientsLocalServiceUtil.deleteFlaskGroupRecipients(recp.getGroupRecipientId());
				}
				FlaskGroupLocalServiceUtil.deleteFlaskGroup(groupId);
			}
		} catch (Exception e) {
			LOGGER.error(" Exception in delete Group :" + e.getMessage());
		}
	}

	@Override
	public void deleteGroups(String groupList, ServiceContext serviceContext) {
		try {
			List<String> grpId = Arrays.asList(groupList.split(","));
			for(String strGroupId: grpId){
				FlaskGroupUsers flaskGroupUser = FlaskGroupUsersUtil.fetchByUserIdGroupId(serviceContext.getUserId(), Long.parseLong(strGroupId));
				if(flaskGroupUser.getIsAdmin() == 1){
					List <FlaskGroupUsers> flaskGroupUsers = FlaskGroupUsersServiceUtil.getAllGroupUsers(Long.parseLong(strGroupId));
					for(FlaskGroupUsers user: flaskGroupUsers){
						FlaskGroupUsersLocalServiceUtil.deleteFlaskGroupUsers(user.getGroupUserId());
					}
					List<FlaskGroupMessages> flaskGroupMessages = FlaskGroupMessagesServiceUtil.getGroupMessages(Long.parseLong(strGroupId));
					for(FlaskGroupMessages flaskGroupMessage : flaskGroupMessages){
						FlaskGroupMessagesLocalServiceUtil.deleteFlaskGroupMessages(flaskGroupMessage.getGroupMessagesId());
					}
					List <FlaskGroupRecipients> flaskGroupRecepients = FlaskGroupRecipientsServiceUtil.getGroupRecipientsByGroupId(Long.parseLong(strGroupId));
					for(FlaskGroupRecipients recp: flaskGroupRecepients){
						FlaskGroupRecipientsLocalServiceUtil.deleteFlaskGroupRecipients(recp.getGroupRecipientId());
					}
					FlaskGroupLocalServiceUtil.deleteFlaskGroup(Long.parseLong(strGroupId));
				}
			}
			
		} catch (Exception e) {
			LOGGER.error(" Exception in delete Groups :" + e.getMessage());
		}
	}
	
	@Override
	public void deactivateGroup(long groupId, ServiceContext serviceContext){
		try {
		FlaskGroupFinderUtil.deActivateGroup(groupId);
		}catch(Exception e){
			LOGGER.error(" Exception in deactivate Groups :" + e.getMessage());
		}
	}
}