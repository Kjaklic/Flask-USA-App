var eventDetailForm;
var dropZone;
var JsonObj;
var JsonEventDetails;
var iSelected;

function addDetailsClickHandlers(){
	eventDetailForm = $("#eventForm");
	/*	Initialize display elements*/
	$(".cssVdSave").click(function(){
		if(fnCheckDuplicateTitle($("#infoTitle").val())){
			_flaskLib.showWarningMessage('action-msg-warning', _eventDetailModel.MESSAGES.DETAIL_DUPLICATE);
		}
		if($('#eventDetailsForm').jqxValidator('validate'))
		saveEventDetails();
	});	
	
	$(".cssAddEventDetails").click(function(){
		$("#eventDetailId").val(0);
		_eventDetailModel.loadInfoType('infoTypeId',1);
		_eventDetailModel.loadContentType('infoTypeCategoryId',1);
		$("#eventDetailsForm").show();
		$("#eventDetailsDataTable").hide();
		$("#eventDetailGallery").html("");
		
	});	

	$(".cssVdCancel").click(function(){
		$("#eventDetailsForm").hide();
		$("#eventDetailsDataTable").show();
		$("#slides").html("");
		loadEventDetailsData($('#eventForm #eventId').val());
	});
}

function loadEventDetailsData(eventId){
	var flaskRequest = new Request();
	params = {'eventId':eventId};
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.GET_EVENT_DETAILS, params, 
	function(data){/*success handler*/
		JsonEventDetails = data;
		GRID_PARAM_DETAILS.updateGrid(data);
		iSelected = false;
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_eventDetailModel.MESSAGES.DETAIL_GET_ERROR);
		console.log("Error in getting data: " + error);
	});
	$("#action-msg-warning").hide();
}

function contextMenuHandlerDetails(menuItemText, rowData){
	var args = event.args;
	if (menuItemText  == "Edit") {
		editEventDetail(rowData);
		return false;
	}else if(menuItemText == "Delete"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteEventDetail(rowData.eventDetailId,rowData.eventId);
		}
		return false;			
	}
};
//

$(".infoTypeCat").click(function(){
	var InfoTypeCd = Number($(this).val());
	$("#infoTypeId").val(InfoTypeCd);
});

function initDetailsForm(){
	$("#eventDetailsContainer").hide();
}

/* Dynamic content type generation logic [Start]*/
function fnRenderContentType(InfoTypeID){
	$("#infoTypeId").val(InfoTypeID);
	$("#eventDetailsContainer").show();
	$("#formContainer").hide();
}

$(document).ready(function(){
    formArea = $("#contentTypeForm"); // Parent Div 
    $("#infoTypeCategoryId").change(function(){
        $(formArea).html("");
        var selectedContentType = $("option:selected", this).text().toUpperCase().replace(/ /g,'');
        fnRenderForm(selectedContentType);
		$('#eventDetailsForm').jqxValidator
	    ({
	        hintType: 'label',
	        animationDuration: 0,
	        rules: [
	                	{ input: '#infoTitle', message: 'Info Title is required!', action: 'keyup, blur', rule: 'required' }
	                	//,{ input: '#infoDesc', message: 'Info Description is required!', action: 'keyup, blur', rule: 'required' }
	               ]
	    });        
    });
});

function fnRenderForm(contentType){
	var Obj = eval("_eventDetailModel.FORM_DATA_MODEL."+contentType);
    fnBuildHtml(Obj);
    if($("#eventDetailId").val()>0){
    	//fnShowSlider();
    }
}

function fnBuildHtml(Obj){
    var items = Obj.filter(function(item) {
        switch(item.type) {
            case "text":
                return fnBuildInput(item.attr);
                break;
            case "select":
                return fnBuildSelect(item.attr);
                break;
            case "boolean":
                return fnBuildBoolean(item.attr);
                break;
            case "upload":
                return fnBuildUpload(item.attr);
                break;
            default:
                console.log("Nothing selected");
        }        
    });      
}

function fnBuildInput(Obj){
    var objFormGroup = $('<div/>',{'class':'form-group'}).appendTo($(formArea));
    var objControlLable = $('<label/>',{'class':'control-label','for':Obj[0].id}).appendTo(objFormGroup);
    $(objControlLable).html(Obj[0].caption);
    var objControls = $('<div/>',{'class':'controls'}).appendTo(objFormGroup);
    $('<input/>', {
        'type': 'Text',
        'id':Obj[0].id,
        'value':Obj[0].value,
        'placeholder':Obj[0].placeholder,   
        'maxlength':Obj[0].maxlength
    }).appendTo(objControls);
}

function fnBuildBoolean(Obj){
    var strSelected = "";
    var objFormGroup = $('<div/>',{'class':'form-group'}).appendTo($(formArea));
    var objControlLable = $('<label/>',{'class':'control-label','for':Obj[0].id}).appendTo(objFormGroup);
    $(objControlLable).html(Obj[0].caption);
    var objControls = $('<div/>',{'class':'controls'}).appendTo(objFormGroup);
    for(var iCount=0;iCount<Obj[0].items.length;iCount++){
        if(Obj[0].items[0].value==Obj[0].value)
            strSelected = "selected"    
        else
            strSelected = ""                                            
            
         $('<input/>', {
            'type': 'Radio',
            'id':Obj[0].id,
            'name':Obj[0].name,
            'value':Obj[0].value,
            'Selected':strSelected
        }).appendTo(objControls);
        var objItemCaptionLable = $('<span/>',{'class':'control-label'}).appendTo(objControls);
        $(objItemCaptionLable).html(Obj[0].items[iCount]);
    }
}

function fnBuildUpload(Obj){
	  	var strSelected = "";
	  	dropZone = "";
	    var objFormGroup = $('<div/>',{'class':'form-group'}).appendTo($(formArea));
	    var objControlLable = $('<label/>',{'class':'control-label','for':Obj[0].caption}).appendTo(objFormGroup);
	    $(objControlLable).html(Obj[0].caption);
	    var objControls = $('<div/>',{'class':'controls'}).appendTo(objFormGroup);
	    var objForm = $('<form/>',{'class':'dropzone','id':'eventImages','action':Obj[0].action}).appendTo(objFormGroup);
	    $(objForm).appendTo(objControls);
	    //return false;
	    var objEventDetailId = $('<input/>',{'name':'_eventDetailId','id':'_eventDetailId','type':'hidden','value':'0'});
	    $(objEventDetailId).appendTo(objForm);
	    var objEventId = $('<input/>',{'name':'_eventId','id':'_eventId','type':'hidden','value':$("#eventId").val()});
	    $(objEventId).appendTo(objForm);
	    var objInfoTypeId = $('<input/>',{'name':'_infoTypeId','id':'_infoTypeId','type':'hidden','value':$("#infoTypeId").val()});
	    $(objInfoTypeId).appendTo(objForm);
	    var objInfoTypeCategoryId = $('<input/>',{'name':'_infoTypeCategoryId','id':'_infoTypeCategoryId','type':'hidden','value':$("#infoTypeCategoryId").val()});
	    $(objInfoTypeCategoryId).appendTo(objForm);
	    var objIsLogo = $('<input/>',{'name':'_isLogo','id':'_isLogo','type':'hidden','value':'N'});
	    $(objIsLogo).appendTo(objForm);
	    dropZone = new Dropzone($(objForm).get(0),{
	    	autoProcessQueue: false
	    });	
}
/* Dynamic content type generation logic [End]*/
function saveEventDetails(){
	params = _flaskLib.getFormData('eventDetailsForm',_eventDetailModel.DATA_MODEL.EVENTDETAILS,
			function(formId, model, formData){
				$.each(model, function(i, item) {
					var ele = $('#'+ formId + ' #'+item.name);
					var val = $.trim(ele.val());
					if(item.type == 'long' && val ==''){
						val = Number(val)
					}
					formData[item.name] = val;	
				});
				formData.eventId=$('#eventForm #eventId').val();
				return formData;
			});
	var flaskRequest = new Request();
	var url = ""
		if(params.eventDetailId == 0){
			url = _eventDetailModel.SERVICE_ENDPOINTS.ADD_EVENT_DETAILS;
		}else{
			url =_eventDetailModel.SERVICE_ENDPOINTS.UPDATE_EVENT_DETAILS;
		}
	flaskRequest.sendGETRequest(url, params, 
				function (data){
					if($('.dz-image').length > 0) {					
						fnSaveImages(data.eventDetailId,data.eventId);
					}
					else{
						$('#eventDetailsForm').hide();
						$('#eventDetailsDataTable').show();
			    		$("#eventDetailId").val(0);
			    		$("#infoTypeCategoryId").val(0);
			    		loadEventDetailsData(data.eventId);
			    		_flaskLib.showSuccessMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_SAVE);
					}
						
				} ,
				function (data){
					_flaskLib.showErrorMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_ERROR);
				});
	$("#slides").html("");
}

/* Delete Single Event */
function deleteEventDetail(eventDetailId,eventId) {
		var param = {'eventDetailId': eventDetailId};
		var request = new Request();
		var flaskRequest = new Request();
		flaskRequest.sendPOSTRequest(_eventDetailModel.SERVICE_ENDPOINTS.DELETE_EVENT_DETAIL , param, 
			function (data){
					_flaskLib.showSuccessMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_DEL_SUCCESS);
					loadEventDetailsData(eventId);
			} ,
			function (data){
					_flaskLib.showErrorMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_DEL_ERR);
			});
}

/* Delete Multiple Events */
function deleteMultipleEventDetail(eventList) {
	var param = {'eventIds': eventList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_eventDetailModel.SERVICE_ENDPOINTS.DELETE_ALL_EVENT_DETAILS, param, 
		function (data){
				_flaskLib.showSuccessMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_DEL_SUCCESS);
				//loadEventDetailsData(eventId);
		} ,
		function (data){
				_flaskLib.showErrorMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_DEL_ERR);
		});
}

/* Edit Event */
function editEventDetail(rowData) {
		var container = $('#eventDetailGallery');
		container.html("");
		var repositoryId = $("#repositoryId").val();
		$('#eventDetailsForm #eventId').val($('#eventForm #eventId').val());
		$('#eventDetailId').val(rowData.eventDetailId);
		$('#_eventDetailId').val(rowData.eventDetailId);
		$('#eventDetailsForm').show();
		
		$('#eventDetailsDataTable').hide();
		_eventDetailModel.loadInfoType('infoTypeId',rowData.infoTypeId);
		_eventDetailModel.loadContentType('infoTypeCategoryId',rowData.infoTypeCategoryId);
		setTimeout(function(){
			_flaskLib.loadDataToForm("eventDetailsForm",_eventDetailModel.DATA_MODEL.EVENTDETAILS, rowData, function(){});
		}, 500);		
    	fnGetEventDetailImages(rowData.eventDetailId,container, true);
}

function formatUnixToTime(tdate){var date = new Date(tdate);
	var hours = date.getHours();
	var minutes = "0" + date.getMinutes();
	var seconds = "0" + date.getSeconds();
	return hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
}

function fnSaveImages(eventDetailId,eventId){
	$("#_eventDetailId").val(eventDetailId);
	dropZone.options.autoProcessQueue = true;
	dropZone.processQueue();
	dropZone.on("queuecomplete", function (file) {
    	wait(function(){
			$('#eventDetailsForm').hide();
			$('#eventDetailsDataTable').show();
    		$("#eventDetailId").val(0);
    		$("#infoTypeCategoryId").val(0);
    		loadEventDetailsData(eventId);		
    		_flaskLib.showSuccessMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_SAVE);    		
    	},1)					
    });	
}

var wait = function(callback, seconds) {
	return window.setTimeout(callback, seconds * 1000);
}

function fnDeleteFileByEntryId(fileEntryId,objDel){
	params= {'fileEntryId': fileEntryId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.DELETE_FILES , params, 
		function (data){
			if(typeof data=="object"){
				_flaskLib.showSuccessMessage('action-msg', _eventDetailModel.MESSAGES.DETAIL_IMAGE_DELETE);    		
			}		
		},
		function (data){$("#spinningSquaresG").hide();});	
}

$(document).ready(function(){
	$("#mcontents").click(function(){
		addDetailsClickHandlers();
		initDetailsForm();
		loadEventDetailsData($('#eventForm #eventId').val());
		var click = new Date();
		var lastClick = new Date();
		var lastRow = -1;
		$("#gridDetails").bind('rowclick', function (event) {
		    click = new Date();
		    if (click - lastClick < 300) {
		        if (lastRow == event.args.rowindex) {
		        	var row = event.args.rowindex;
	        	 	var datarow = $(this).jqxGrid('getrowdata', row);
	        	 	editEventDetail(datarow);
		        }
		    }
		    lastClick = new Date();
		    lastRow = event.args.rowindex;
		});
		$("#eventDetailsContainer").show();
	});
});

function fnCheckDuplicateTitle(_infoTitle){
	if(typeof JsonEventDetails=="object"){
		var Obj = JsonEventDetails;
		var iCount = 0;
	    var items = Obj.filter(function(item) {
	    	if(item.infoTitle==_infoTitle){
	    		iCount++;
	    	}
	    });
	    if(iCount>0)
	    	return true;
	    else
	    	return false;
	}
	else{
		return false;
	}
}

function fnDeleteEventDetailImage(eventDetailImageId){
	params= {'eventDetailImageId': eventDetailImageId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.DELETE_EVENTDETAIL_IMAGE , params, 
		function (data){
			console.log(data);
		},
		function (data){
			console.log(data);
		});	
}


function fnGetEventDetailImages(eventDetailId,container, editable){
	params= {'eventDetailId': eventDetailId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.GET_EVENTDETAIL_IMAGES , params, 
		function (data){
			$.each(data, function(idx, obj) {
				fnRenderImage(obj.imageUUID, obj.imageGroupId, data.fileEntryId, container, obj.eventDetailImageId, editable);
			});			
		},
		function (data){
			console.log(data);
		});	
}

function fnRenderImage(imageUUID, imageGroupId, fileEntryId, container, eventDetailImageId, editable){
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID+"&groupId="+imageGroupId;
	var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')','data-fileEntryId':fileEntryId});
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
	    					fnDeleteEventDetailImage(eventDetailImageId);
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