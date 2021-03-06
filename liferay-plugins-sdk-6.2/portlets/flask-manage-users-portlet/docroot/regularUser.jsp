<%
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
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ include file="init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%
  	long repositoryId = themeDisplay.getLayout().getGroupId();
	boolean isAuthorised = renderRequest.isUserInRole("administrator") 
						|| renderRequest.isUserInRole("flask-admin");
	
	  String portletId = themeDisplay.getPortletDisplay().getId();
	 if(portletId.contentEquals("myaccount_WAR_flaskmanageusersportlet")){
		  isAuthorised = true;
	 }
	 boolean isSignedin = themeDisplay.isSignedIn();
%>

	<script type="text/javascript">
	var bCreated;
	Liferay.Portlet.ready(initialize);
	
	function initialize(portletId, portlet){
		if(portletId == "regularuser_WAR_flaskmanageusersportlet") 
		{
			$("#adminForm").hide();
			createTable({},_userModel.DATA_MODEL.ADMIN, $('#grid'), "actionMenu", "Edit", contextMenuHandler, ["Admin", "Images"]);
			loadRegUserData();
			addRegUserClickHandlers();
			//$("#DOB").jqxDateTimeInput({ width: '250px', height: '25px', formatString: "MM-dd-yyyy" });
			$('.userInterests').jqxTree({ height: 'auto', hasThreeStates: true, checkboxes: true});	  
			$(".jqx-checkbox").css("margin-top","6.5px");
			$('#DOB').combodate({
				firstItem: 'name',
			    minYear: 1960,
			    maxYear: 2016,
			    smartDays: true
			});
		}
		if(portletId == "myaccount_WAR_flaskmanageusersportlet")
		{
			$('#DOB').combodate({
				firstItem: 'name',
			    minYear: 1960,
			    maxYear: 2016,
			    smartDays: true
			});
			$("#adminForm").show();
			$("#adminDataTable").hide();
			loadForm();
			addMyAccClickHandlers();
			$(".hideOnMyAcc").hide();
			//document.getElementById('roleId').disabled=true;
			//$("#DOB").jqxDateTimeInput({ width: '250px', height: '25px', formatString: "MM-dd-yyyy" });
			$('.userInterests').jqxTree({ height: 'auto', hasThreeStates: true, checkboxes: true});	
			$(".jqx-checkbox").css("margin-top","6.5px");
		}
	}
	</script>
<body>
<c:if test="<%= !isSignedin %>">
			<div id="action-msg1" class="alert alert-error">
				You are not signed-in to view this page.
			</div>
</c:if>

<c:if test="<%= isSignedin %>">
<c:if test="<%= !isAuthorised %>">
			<div id="action-msg1" class="alert alert-error">
				You are not authorize to view this page.
			</div>
</c:if>
<c:if test="<%= isAuthorised %>">

	<input type="hidden" id="repositoryId" value="<%=repositoryId%>"> 
	<div class="yui3-skin-sam">
	  <div id="modal">
	  </div>
	 <div id="Upload-Photo">
	    <label class="control-label" for="firstName">Upload photo:</label>
	    <div class="controls">
	  <input type='file' id='fileinput' multiple="multiple">
	   </div>
	 </div>    
	</div>
	<div id="action-msg" style="display:none">
	</div>
	<div id="adminDataTable" class="table-condensed">
		<div class="cssGridMenu">
			<div class="cssAddUser"><div class="iconAddUser"></div></div>
			<div class="cssSearchUser"><div class="iconSearchUser"><i class="icon-search"></i></div></div>
			<div class="cssDelUser"><div class="iconDelUser"><i class="icon-list"></i></div></div>
			<div class="cssDelete"><div class="iconDelete"><i class="icon-trash"></i></div></div>
		</div>
	
		<div id="GridContainer" class="device-mobile-tablet"> 
		    <div id="container" class="device-mobile-tablet-container">
		        <div style="border: none;" id='grid'></div>
		    </div>
		</div>
	</div>
	
	<div id='actionMenu' style="display:none">
	    <ul>
			<li>Edit</li> 					<!--fnShowForm({value}); -->
			<li>Delete</li>					<!--fnDelete({value}); -->
			<li><div id="popup"> Change Role</div></li>
		</ul>
	</div>
	
	<form id="adminForm">
	<ul class="nav nav-tabs">
		  <li class="active"><a href="#tab1" data-toggle="tab">Contact</a></li>
		  <li><a href="#tab2" data-toggle="tab" id="tab21">Address</a></li>
		  <li><a href="#tab3" data-toggle="tab" id="tab31">Interests</a></li>
	</ul>
	<div class="tab-content">
	<div class="tab-pane active" id="tab1">
	  <div class="">
	  	<div id="ProfilePic" style="background-image:url('http://localhost:8080/documents/20181/0/21491')"></div> <br> 
	   <div class="form-group">
	     <label class="control-label" for="firstName">First Name:</label>
	     <div class="controls">
	       <input name="firstName" id="firstName" class="form-control" maxlength="100" type="text">
	     </div>
	   </div>
	   <div class="form-group">
	     <label class="control-label" for="lastName">Last Name:</label>
	     <div class="controls">
	       <input name="lastName" id="lastName" class="form-control" maxlength="100" type="text">
	     </div>
	   </div>
	   
	     <div class="">
	   <div class="form-group">
	     <label class="control-label" for="screenName">Screen Name:</label>
	     <div class="controls">
	       <input name="screenName" id="screenName" class="form-control" maxlength="100" type="text">
	     </div>
	   </div>
	 
	   <div class="form-group">
	     <label class="control-label" for="email">E-mail:</label>
	     <div class="controls">
	       <input name="email" id="email" class="form-control" maxlength="100" type="text">
	     </div>
	   </div>
	 
	   <div class="form-group">
	     <label class="control-label" for="password1">Password:</label>
	     <div class="controls">
	       <input name="password1" id="password1" class="form-control" type="password">
	     </div>
	   </div>
	   
	   <div class="form-group">
	     <label class="control-label" for="password2">Confirm Password:</label>
	     <div class="controls">
	       <input name="password2" id="password2" class="form-control" type="password">
	     </div>
	   </div> 
	   <div class="form-group hideOnMyAcc">
	     <label class="control-label" for="roleId">Role:</label>
	     <div class="controls">
	       <select id="roleId" name="roleId" class="form-control"></select>
	     </div>
	   </div>  
	   <div class="form-group">
	      <label class="control-label" for="gender">Gender:</label>
	      <div class="controls">
		     <input name="gender" class="gender" type="radio" value="Male" checked>Male
		     <input name="gender" class="gender" type="radio" value="Female">Female
	      </div>
	  </div>
	   
	   <div class="form-group">
		  <label class="control-label" for="DOB">Date of Birth:</label>
			  <div class="controls">
			   	<input id="DOB" class="form-control" type="text" value="" data-format="MM-DD-YYYY" data-template="MMM D YYYY">
			  </div>
	   </div>  
	   
	   <div class="form-group">
	     <label class="control-label" for="mobileNumber">Mobile:</label>
		     <div class="controls">
		       <input name="mobileNumber" id="mobileNumber" class="form-control" maxlength="10" type="text">
		     </div>
	   </div>
	   </div>
	   </div>
	</div>
	<div class="tab-pane" id="tab2">
	  <div class="">
	   <div class="form-group">
	     <label class="control-label" for="streetName">Street:</label>
	     <div class="controls">
	       <input name="streetName" id="streetName" class="form-control" maxlength="100" type="text">
	     </div>
	   </div>
	   
	   <div class="form-group">
	     <label class="control-label" for="aptNo">Apartment#:</label>
	     <div class="controls">
	       <input name="aptNo" id="aptNo" class="form-control" type="text">
	     </div>
	   </div>  
	   
	    <div class="form-group">
	     <label class="control-label" for="areaCode">Zip Code:</label>
	     <div class="controls">
	       <input name="areaCode" id="areaCode" class="form-control" maxlength="20" type="text">
	     </div>
	   </div>
	   
	    <div class="form-group">
	     <label class="control-label" for="city">City:</label>
	     <div class="controls">
	       <input name="city" id="city" class="form-control" maxlength="100" type="text">
	     </div>
	   </div>  
	   
	    <div class="form-group">
	     <label class="control-label" for="stateId">State:</label>
	     <div class="controls">
	       <select id="stateId" name="stateId" class="form-control"></select>
	     </div>
	   </div>  
	     
	   <div class="form-group">
	     <label class="control-label" for="countryId">Country:</label>
	     <div class="controls">
	       <select id="countryId" name="countryId" class="form-control" ></select>
	     </div>
	   </div>  
	  </div>
	</div>
	<div class="tab-pane" id="tab3">
	<div class="form-group">
	    
	 <div class="row-fluid">
	 <h4><span>Preferences</span></h4>
	 <div class="row-fluid">
	 <div style="border: none;" class="userInterests span4">
	  <ul>
	         <li item-expanded='true' id="sports">Sports
	           <ul>
	           		   <li id="sports-pro-basketball">Basketball</li>
	                   <li id="sports-pro-basebball">Basebball</li>
	                   <li id="sports-pro-football">Football</li>
	                   <li id="sports-pro-hockey">Hockey</li>
	                   <li id="sports-pro-soccer">Soccer</li>
	                   <li id="sports-pro-tennis">Tennis</li>
	          </ul>
	   </li>
	  </ul>
	 </div>
	 <div style="border: none;" class="userInterests span4">
	  <ul>
	         <li item-expanded='true' id="sports">Level
	           <ul>
	                 <li id="sports-pro">Professional</li>
	                 <li id="sports-col">College</li>
	           </ul>
	   </li>
	  </ul>
	 </div>
	 </div>
	 <div class="row-fluid">
	 <div style="border: none;" class="userInterests span4">
	  <ul>   
	         <li item-expanded='true' id="concerts">Concerts
	             <ul>
	                 <li  id="concerts-country">Country</li>
	                 <li id="concerts-pop">Pop</li>
	                 <li id="concerts-rock">Rock</li>
	                 <li id="concerts-rap">Rap</li>
	                 <li id="concerts-alternative">Alternative</li>
	                 <li id="concerts-electronic">Electronic</li>
	             </ul>
	         </li>
	  </ul>
	 </div>
	 <div style="border: none;" class="userInterests span4">   
	  <ul>         
	         <li item-expanded='true' id="special-events">
	          Special Events
	          <ul><li id="special-events-comedy">Comedy</li></ul>
	         </li>
	     </ul>   
	 </div> 
	 </div>
	 </div>
	</div>
	 </div>
	 </div>
	  <input class="btn btn-info clsSave" type="button" value="Save"/>
	  <input class="btn btn-primary clsCancel" type="button" value="Cancel" >
	  <input id="userId" type="hidden" value="0">
	  <input id="fileEntryId" type="hidden" value="0">
	  <input name="middleName" id="middleName" type="hidden">
	   <%-- jqx popup window for change role --%>
	        <div id='jqxwindow'>
	            <div>
	               Change role
	            </div>
	            <div>
	                 <label class="control-label" for="roleId">Role:</label>
				     <div class="controls">
				       <select id="roleId1" name="roleId" ></select>
				     </div>
	                Set the role?<br />
	                <div>
	                <div id="y"><input type="button" value="Yes" class="btn-primary" style="width: 98%" id="button_input"></div>
	               <div id="n"><input type="button" value="No" class="btn-primary" id="button_no" /></div></div>
	            </div>
	        </div>
	<%--End of jqx popup window for change role --%>
	</form>
	
	
	<div id="spinningSquaresG">
		<div class="ball"></div>
		<div class="ball1"></div>
	</div>
</c:if>
</c:if>
</body>