var alllist = [];
var map;
var lat_marker = [];
var lng_marker = [];
var addr_name = [];
var eventDetailJSON = {};
var marker_infoType;
var venueName;
var venueAddr;

function formatUnixToTime(tdate)
{
	var date = new Date(tdate);
	var hours = date.getHours();
	var minutes = "0" + date.getMinutes();
	var ampm = hours >= 12 ? 'PM' : 'AM';
	hours = hours % 12;
	return hours + ':' + minutes.substr(-2) + ' ' + ampm;
}

function renderEventList(tdata) {
	 var divRow = $('#placeholder');
	 $(divRow).html("");
	 if(tdata.Events.length == 0){
		$("<span class='control-label-nocolor'>There are no events</span>").appendTo($("#placeholder"));
		return;
	 }
	 for(var i=0; i < tdata.Events.length; i++)
		{
		 	var flaskEvent = tdata.Events[i];
		    var st = formatUnixToTime(flaskEvent.startTime);
		    var objTable = $('<table/>',{'class':'tblRow'});
		    var objTr = $('<tr/>');
		    $(objTr).appendTo($(objTable));
		    var objTd1 = $('<td/>',{'width':'70px'});
		    $(objTd1).appendTo($(objTr));
		    
		    fnShowEventLogo(flaskEvent.eventImageUUID, flaskEvent.eventImageGroupId, objTd1,false);		    
		    var eventName_lbl = $('<label/>',{'class':'control-label-color'});
		    $(eventName_lbl).html(flaskEvent.eventName);
		    var objTd2 = $('<td/>',{'data-id':flaskEvent.eventId,'data-venueId':flaskEvent.venueId});
		    
		    var venue_lbl = $('<label/>',{'class':'control-label-nocolor'});
		    $(venue_lbl).html(st + ' at ' + flaskEvent.venueName);
		    $(eventName_lbl).appendTo($(objTd2));
		    $(venue_lbl).appendTo($(objTd2));
		    $(objTd2).appendTo(objTr);
		    $(objTable).appendTo($(divRow));
		    var objTd3 = $('<td/>');
		    if(flaskEvent.userEvent == 1){
		    	var div_heart = $('<div/>',{'class':'heart-shape-userevent','data-eventId':flaskEvent.eventId,'data-userEvent':flaskEvent.userEvent});
		    }else{
		    	var div_heart = $('<div/>',{'class':'heart-shape','data-eventId':flaskEvent.eventId,'data-userEvent':flaskEvent.userEvent});
		    }
		    $(div_heart).appendTo($(objTd3));
		    $(objTd3).appendTo(objTr);
		    
		 	$(objTd2).click(function(){
		 		$("#spinningSquaresG").show();
		 		$('#one').hide();
		 		$("#weather-background").show();
		 		fnGetEventImages($(this).attr("data-id"),$(this).attr("data-venueId"));
		 		window.location.hash = '#Gallery';
		 	});
		 	if(Liferay.ThemeDisplay.isSignedIn()){
			 	$(div_heart).click(function(){
			 		setMyEvent($(this).attr("data-eventId"),$(this).attr("data-userEvent"));
			 	});
		 	}else{
		 		$(div_heart).attr("title", "You need to be signed in to save events.");
		 	}
	    }
	 	$(divRow).appendTo($("#placeholder"));
	 	
	 	$(function() {
		    function cb(start, end) {
		        $('#reportrange span').html('Today');//start.format('MMM D, YYYY') + ' - ' + end.format('MMM D, YYYY')
		    }
		    cb(moment().subtract(29, 'days'), moment());

		    $('#reportrange').daterangepicker({
		        ranges: {
		           'Today': [moment(), moment()],
		           'Next': [moment().add(1, 'days'), moment().subtract(1, 'days')],
		           'Next 7 days': [moment().add(6, 'days'), moment()],
		           'Next 30 days': [moment().startOf('month'), moment().endOf('month')],
		           'Next 60 days': [moment().subtract(1, 'days'), moment().subtract(1, 'days')]
		        },
		        "applyClass": "btn btn-info btn-calendar",
		        "cancelClass": "btn btn-info btn-calendar"
		    }, cb);
		});	 	
}

function fnShowEventLogo(imageUUID, imageGroupId,container ,editable){
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID+"&groupId="+imageGroupId;
	var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')'});
	$(objdiv).appendTo($(container));
	if(editable){
    	$(objdiv).click(function(){
	    	$(this).toggleClass("activeImage");
	    	if($(".activeImage").length>0){
	    		if(iSelected==false){
	    			var objDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
	    			$(objDel).appendTo($(container));
	    			iSelected = true;
	    			$(objDel).click(function(){
	    				$("#spinningSquaresG").show();
	    				$(".activeImage").each(function(){
	    					fnDeleteFileByEntryId($(this).attr("data-fileEntryId"),objDel);
	    					$(this).remove();
	    				});
	    				if($(".activeImage").length==0){
	    					$("#spinningSquaresG").hide();
	    					$(this).remove();
	    					iSelected = false;
	    				}
	    			});
	    		}
	    	}
	    	else{
	    		$(".cssDelImages").remove();
	    		iSelected = false;
	    	}
	    });	
    	
    }
}

function fnGetEventImages(eventId,venueId){
	getVenueData(venueId);
	var flaskRequest = new Request();
	params= {'eventId': eventId};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENTDETAIL_WITH_IMAGES , params, 
		function(data){
			var arrPreEvent = [];
			var arrDurEvent = [];
			var arrPosEvent = [];
			var objWeatherDiv = $("<div/>",{'class':'WeatherSlide'});
		    $(objWeatherDiv).html($("#weather-background"));
		    arrPreEvent.push(objWeatherDiv);	
			objEventDetails = data.EventDetails;
			eventDetailJSON = $.extend(true, {}, objEventDetails);
			$.each(objEventDetails, function(idx, obj) {
				objEventDetail = jQuery.parseJSON(obj.EventDetail);
				if(objEventDetail.latitude != "")
					{
						lat_marker.push([objEventDetail.latitude, objEventDetail.infoTypeId]);
						lng_marker.push(objEventDetail.longitude);
						addr_name.push(objEventDetail.infoTitle);
					}
				var imgURL = "";
				switch(parseInt(objEventDetail.infoTypeId)) {
				case  1: case 2:
			    	arrPreEvent = fnFillImageArray(obj.EventDetailImages,obj.EventDetail,arrPreEvent)
			        break;
			    case 3:
			    	arrDurEvent = fnFillImageArray(obj.EventDetailImages,obj.EventDetail,arrDurEvent)
			        break;
			    case 4:
			    	arrPosEvent = fnFillImageArray(obj.EventDetailImages,obj.EventDetail,arrPosEvent)
			        break;
				}				
			});				
			fnSlider(2,arrPreEvent,eventId,venueId);
			fnSlider(3,arrDurEvent,eventId,venueId);
			fnSlider(4,arrPosEvent,eventId,venueId);
			fnStopProgress();
		},
		function (data){
			console.log("Error in getting Folder: " + data );
			fnStopProgress();
		});	
}

function fnFillImageArray(eventDetailImages,eventDetails,objArray){
	var objEventDetails = jQuery.parseJSON(eventDetails);
	var infoTypeCategoryName = objEventDetails.infoTypeCategoryName.toUpperCase()
	var objFields = eval("_eventModel.DETAIL_DATA_MODEL."+infoTypeCategoryName);
	if(eventDetailImages.length>0){
		$.each(eventDetailImages, function(idx, objImg) {
			var objtbl = $("<table/>",{'cellpadding':'5px'});
			$.each(objFields, function(idx, obj){
				var objtrHead = $("<tr/>");
				$.each(obj,function(key,value){
					var objtr = $("<tr/>");
					var valueTd = $("<td/>",{'align':'left','width':'100%'});				
					var evalue = eval("objEventDetails."+key);
					var caption = value;
					$(valueTd).html(evalue);
					$(valueTd).appendTo($(objtr));
					$(objtr).appendTo($(objtbl));
				});
			});
			
			var imgURL = "";
			var objMainTable = $("<table/>",{'class':'eventDetailBoxWithImages'});
			var objMainTr = $("<tr/>");
			var imageTd = $("<td/>",{'align':'left','valign':'top'});
			var textDataTd = $("<td/>",{'align':'left','valign':'top'});
			var objContent = $("<div/>",{'width':'100%'});

			objImage = jQuery.parseJSON(objImg.EventDetailImage);
			imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+objImage.imageUUID+"&groupId="+objImage.imageGroupId;
			$(objContent).attr("style","background:url('"+imgURL+"');");
			$(objContent).addClass("slideImage");
			$(objContent).appendTo(imageTd);
			
			$(imageTd).appendTo($(objMainTr));
			$(objtbl).appendTo($(textDataTd));
			$(textDataTd).appendTo($(objMainTr));
			$(objMainTr).appendTo($(objMainTable));

			objArray.push($(objMainTable));
		});
	}
	else{
		$.each(objFields, function(idx, obj){
			var objContent = $("<div/>",{'class':'eventDetailBox'});
			var objtbl = $("<table/>",{'cellpadding':'5px'});
			var objtrHead = $("<tr/>");
			var objth = $("<th/>",{'colspan':'2'});
			$(objth).html(infoTypeCategoryName);
			$(objth).appendTo($(objtbl));
			$.each(obj,function(key,value){
				var objtr = $("<tr/>");
				var captionObj = $("<td/>",{'align':'left','width':'30%'});
				var valueObj = $("<td/>",{'align':'left','width':'70%'});				
				var evalue = eval("objEventDetails."+key);
				var caption = value;
				$(captionObj).html(caption);
				$(captionObj).appendTo($(objtr));
				$(valueObj).html(evalue);
				$(valueObj).appendTo($(objtr));
				$(objtr).appendTo($(objtbl));
				$(objtbl).appendTo($(objContent));
			});
			objArray.push(objContent);			
		});
	}
	return objArray;
}

function fnSlider(infoType,arrImage,eventId,venueId){
	var Slider = "#wowslider-container"+infoType;

	if($(Slider).hasClass("slick-initialized"))	{
		$(Slider).slick('unslick');
		$(Slider).html("");
	}
	
	$(Slider).attr('data-eventId',eventId);
	$(Slider).attr('data-venueId',venueId);
	$(Slider).slick({
		speed: 300,
	    variableWidth: true,
	    infinite: false,
	    dots: true,
		  responsive: [
			{
			  breakpoint: 3000,
			  settings: {
			        arrows:true,
				  	centerPadding: '20px',
				  	centerMode: true,
			        slidesToShow: 3,
			        slidesToScroll: 3,
			  },
			  breakpoint: 640,
			  settings: {
				  	centerPadding: '10px',
				  	centerMode: false,
			        slidesToShow: 1,
			        slidesToScroll: 1,
			  }
			}		
		  ]
	});	
	
	if(arrImage.length>0){
		$.each(arrImage, function( index, value ) {
			var objDiv = $("<div/>",{'class':'photo'});
			var objImg = value;
			$(objImg).appendTo(objDiv);
			$(Slider).slick('addSlide',	objDiv)		
		});
	}
	else{
		fnBlankSlide(Slider);
	}
	
	var click = new Date();
	var lastClick = new Date();
	var lastRow = -1;
	$(Slider).click(function(event){
		/*click = new Date();
	    if (click - lastClick < 300) {*/
	    	$("#spinningSquaresG").show();
	 		$('#one').hide();		 
	 		$('#two').hide();
	 		$('#three').show();
			marker_infoType = infoType;
			// map initialization
	 		initialize();
	 		initMenuList();	 		
	 		window.location.hash = '#Details';
	 		$("#spinningSquaresG").hide();
	    /*}
	    lastClick = new Date();*/
	});	
}

function fnBlankSlide(Slider){
  	var temp_html = '<font color="white"><h4>NO DATA FOUND</h4></font>';
	var imageUrl;
	imageUrl = "/flask-view-events-portlet/img/NoData.png";
	var objBlankSlide1 = $("<div/>",{'class':'photo'});
	var objBlankSlide = $("<div/>",{'class':'eventDetailBox', 'style':'padding-top: 25% !important;'});
	$(objBlankSlide).appendTo(objBlankSlide1);
	$(objBlankSlide).html(temp_html);
	$(Slider).slick('addSlide',	objBlankSlide1);			
}

$(document).ready(function(){
	//fnLoadList();
	$(".cssback").click(function(){
		$('#one').show();
		$('#two').hide();
		$('.Carousel').each(function(){
			$(this).slick('unslick');
		});
	});
	//Search options
	jQuery.expr[':'].case_insensitive_contains = function(a, i, m) {
		return jQuery(a).text().toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
	};	
	
	$("#txtSearch").keyup(function(){
		$(".row-fluid .span9 .lbldiv:case_insensitive_contains("+$(this).val()+")").closest(".row-fluid").show(250, function() {});
		$(".row-fluid .span9 .lbldiv:not(:case_insensitive_contains("+$(this).val()+"))").closest(".row-fluid").hide(500, function() {});		
	});
	$("#sign-in").hide();
	window.location.hash = '#List';
	
	$(window).hashchange( function(){
		var hash = location.hash;
		switch(hash) {
	    case "#List":
			$('#one').show();
			$('#two').hide();
			$('#three').hide();
			break;
	    case "#Gallery":
			$('#one').hide();
			$('#two').show();
			$('#three').hide();
	        break;
	    case "#Details":
			$('#one').hide();
			$('#two').hide();
			$('#three').show();
	        break;	        
	    default:
	    	//alert("This is default");
		}		
	})
});

function fnStopProgress(){
	$("#spinningSquaresG").hide();	
 	$('#two').show();	
 	$(".ws_controls").hide();
}

function setMyEvent(_eventId,_userEvent){
	var eventId = parseInt(_eventId);
	var myEvent = parseInt(_userEvent);
	if(myEvent == 0 ){
		addUserEvent(eventId);
	}else{
		removeUserEvent(eventId);
	}
	
}
function initEventList(){
	var request = new Request();
	var param = {};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENT , param, 
		function (data){
			renderEventList(data);
		} ,
		function (data){
			console.log("Error ins getting event list" + data );
	});
}

function addUserEvent(eventId){
	var request = new Request();
	var param = {eventId: eventId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.ADD_USER_EVENT , param, 
					function (data){
						initEventList();
					} ,
					function (data){
						console.log("Error ins saving user event" + data );
					});
}
function removeUserEvent(eventId){
	var request = new Request();
	var param = {eventId: eventId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.REMOVE_USER_EVENT , param, 
		function (data){
			initEventList();
		} ,
		function (data){
			console.log("Error in removing user event" + data );
		});
}


function getVenueData(venueId){
	var flaskRequest = new Request();
	params = {venueId:venueId};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_VENUE, params, 
	function(data){
		venueName = data.venueName;
		venueAddr = data.addrLine1;
		callWeather(data.latitude, data.longitude);
	} , function(error){
		_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.GET_ERROR);
	});
}

function initMenuList(){
	console.log(eventDetailJSON);
	var objJqxTabs = $("#jqxTabs");
	var objMenuItems = $("<ul/>",{"class":"menustrip","style":"margin-left: 30px"});
	$(objJqxTabs).html("");
	$(objMenuItems).appendTo($(objJqxTabs));
	var arr = [], len;
	for(key in eventDetailJSON) {
		arr.push(key);
	}
	len = arr.length;
	console.log(len) //2
	for(var iCount=0;iCount<len;iCount++)
	{
			var objEventDetail = jQuery.parseJSON(eventDetailJSON[iCount].EventDetail);
			var objLi = $("<li/>");
			$(objLi).html(objEventDetail.infoTypeCategoryName);
			$(objLi).appendTo($(objMenuItems));
			var objDetailDiv = $("<div/>");
			var infoTypeCategoryName = objEventDetail.infoTypeCategoryName.toUpperCase()
			var objFields = eval("_eventModel.DETAIL_DATA_MODEL."+infoTypeCategoryName);
			var objtbl = $("<table/>",{'cellpadding':'5px'});
			$.each(objFields, function(idx, obj){
				console.log(obj);
				$.each(obj,function(key,value){
					var objtr = $("<tr/>");
					var valueTd = $("<td/>",{'align':'left','width':'100%'});				
					var evalue = eval("objEventDetail."+key);
					var caption = value;
					console.log(evalue );
					$(valueTd).html(evalue);
					$(valueTd).appendTo($(objtr));
					$(objtr).appendTo($(objtbl));
				});
			});		
			$(objtbl).appendTo($(objDetailDiv));
			$(objDetailDiv).appendTo($(objJqxTabs));
			
	}
	
	$('#jqxTabs').jqxTabs({ 
		width: '100%',
		height: '100%',
		scrollPosition: 'both'
	});
}
