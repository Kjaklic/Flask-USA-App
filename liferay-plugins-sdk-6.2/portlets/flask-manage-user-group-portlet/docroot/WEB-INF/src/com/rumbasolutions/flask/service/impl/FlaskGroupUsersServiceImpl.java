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

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rumbasolutions.flask.model.FlaskGroupUsers;
import com.rumbasolutions.flask.model.impl.FlaskGroupUsersImpl;
import com.rumbasolutions.flask.service.FlaskGroupUsersLocalServiceUtil;
import com.rumbasolutions.flask.service.FlaskGroupUsersServiceUtil;
import com.rumbasolutions.flask.service.base.FlaskGroupUsersServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.FlaskGroupUsersFinderUtil;
import com.rumbasolutions.flask.service.persistence.FlaskGroupUsersUtil;

/**
 * The implementation of the flask group users remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.FlaskGroupUsersService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Tejas Patel
 * @see com.rumbasolutions.flask.service.base.FlaskGroupUsersServiceBaseImpl
 * @see com.rumbasolutions.flask.service.FlaskGroupUsersServiceUtil
 */
public class FlaskGroupUsersServiceImpl extends FlaskGroupUsersServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.FlaskGroupUsersServiceUtil} to access the flask group users remote service.
	 */
	private static Log LOGGER = LogFactoryUtil
			.getLog(FlaskGroupUsersServiceImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<FlaskGroupUsers> getAllGroupUsers(long groupId) {
		List<FlaskGroupUsers> groupUsersList = null;
		try{
			DynamicQuery flaskGroupQuery = DynamicQueryFactoryUtil.forClass(FlaskGroupUsersImpl.class);
			flaskGroupQuery.add(PropertyFactoryUtil.forName("groupId").eq(new Long(groupId)));
			groupUsersList = FlaskGroupUsersLocalServiceUtil.dynamicQuery(flaskGroupQuery);
		}catch(Exception ex){
			LOGGER.error("Exception in Add Group User :" + ex.getMessage());
		}
		
		return groupUsersList;
	}
	
	@SuppressWarnings("unused")
	@Override
	public int getGroupUsersCount(long groupId) {
		int count =0;
		try{
			List<FlaskGroupUsers> groupUsersList = FlaskGroupUsersUtil.findByUserGroups(groupId);
			for(FlaskGroupUsers groupUser: groupUsersList){
				count++;
			}
		}catch(Exception ex){
			LOGGER.error("Exception in getGroupUsersCount :" + ex.getMessage());
		}
		
		return count;
	}
	
	@Override
	public FlaskGroupUsers addGroupUser(long groupId, long userId, String userName, String emailAddress, int isAdmin){
		FlaskGroupUsers groupUsers = null;
		try{
			int userCount = FlaskGroupUsersServiceUtil.getGroupUsersCount(groupId);
			if(userCount < 200){
				groupUsers = FlaskGroupUsersLocalServiceUtil.createFlaskGroupUsers(CounterLocalServiceUtil.increment());
				groupUsers.setGroupId(groupId);
				groupUsers.setIsAdmin(isAdmin);
				groupUsers.setUserId(userId);
				groupUsers.setUserName(userName);
				groupUsers.setEmailAddress(emailAddress);
				groupUsers = FlaskGroupUsersLocalServiceUtil.addFlaskGroupUsers(groupUsers);
			}
		}catch(SystemException e){
			LOGGER.error("Exception in Add Group User :" + e.getMessage());
		}
		return groupUsers;
	}
	
	@Override
	public FlaskGroupUsers updateGroupUser(long groupUserId,long groupId, long userId, String userName, String emailAddress, int isAdmin){
		FlaskGroupUsers groupUser = null;
		try{
			groupUser = FlaskGroupUsersLocalServiceUtil.getFlaskGroupUsers(groupUserId);
			groupUser.setGroupId(groupId);
			groupUser.setIsAdmin(isAdmin);
			groupUser.setUserId(userId);
			groupUser.setUserName(userName);
			groupUser.setEmailAddress(emailAddress);
			
			groupUser = FlaskGroupUsersLocalServiceUtil.updateFlaskGroupUsers(groupUser);
		}catch(SystemException e){
			LOGGER.error("Exception in Add Group User :" + e.getMessage());
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return groupUser;
	}
	
	@Override
	public int addGroupOwner(long groupId, long userId) {
		int cnt = 0;
		try{
			cnt = FlaskGroupUsersUtil.countByUserIdGroupId(userId, groupId);
			if(cnt>0)
				FlaskGroupUsersFinderUtil.addGroupOwner(groupId, userId);
		}catch(Exception e){
			LOGGER.error("Exception in addGroupOwner :" + e.getMessage());
		}
		return cnt;
	}
	
	@Override
	public void removeGroupOwner(long groupId, long userId){
		FlaskGroupUsers flaskGroupUser = null;
		try {
			flaskGroupUser = FlaskGroupUsersUtil.findByUserIdGroupId(userId, groupId);
			flaskGroupUser.setIsAdmin(0);
			FlaskGroupUsersUtil.update(flaskGroupUser);
		} catch (Exception e) {
			LOGGER.error("Exception in removeGroupOwner :" + e.getMessage());
		}
		
	}
	
	
	@Override
	public boolean deleteGroupUser(long groupId, long userId) {
		boolean done = false;
		try {
			FlaskGroupUsersUtil.removeByUserIdGroupId(userId, groupId);
			done = true;
		} catch (Exception e) {
			LOGGER.error("Exception in deleteGroupUser :" + e.getMessage());
		}
		return done;
	}

	@Override
	public boolean deleteGroupUsers(long groupId, String userIds) {
		boolean done = false;
		try {
			String[] userIdArr = userIds.split(",");
			for(String userId: userIdArr){
				FlaskGroupUsersUtil.removeByUserIdGroupId(Long.valueOf(userId), groupId);
			}
			done = true;
		} catch (Exception e) {
			LOGGER.error("Exception in deleteGroupUsers :" + e.getMessage());
		}	
		return done;
	}

}