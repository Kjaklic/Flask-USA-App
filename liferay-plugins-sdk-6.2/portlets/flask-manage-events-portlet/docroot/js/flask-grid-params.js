var _repositoryId = $("#repositoryId").val();    
var GRID_PARAM = {};

var gridObj;
var rowMenuDivId;
var rowMenuColumnText;
var rowDetailDivArr;
var _dataModel;
var _contextMenuHandler;
GRID_PARAM.source = function(model, data){
	return {
			localdata: data,
			datafields: model,
			datatype: "json"
	};	
}
GRID_PARAM.updateGrid = function(data){
	var dataAdapter =  new $.jqx.dataAdapter(GRID_PARAM.source(_dataModel, data));
	gridObj.jqxGrid({ source: dataAdapter });
}
GRID_PARAM.toggleSelectionMode= function(){
	if(gridObj.jqxGrid('selectionmode') == 'checkbox'){
		gridObj.jqxGrid({selectionmode:'singlerow'});
	}else{
		gridObj.jqxGrid({selectionmode:'checkbox'});
	}
	
}
GRID_PARAM.toggleSearchBoxes = function(){
	gridObj.jqxGrid({
            showfilterrow: !(gridObj.jqxGrid('showfilterrow')),
            filterable: true,
            filterrowheight: 34
		});
		$(".jqx-grid-cell-filter-row-custom:last").hide();
}

GRID_PARAM.getCheckedIdList= function(idDataAttribute){
    var rows = gridObj.jqxGrid('selectedrowindexes');
    var dataList=[];
    $.each(rows, function(i, rowIndex){
    	var rowData = gridObj.jqxGrid('getrowdata', rowIndex);
    	dataList[i] = rowData.eventId;
    });
    var temp= dataList.toString();
    console.log(temp);
    return temp;
}

GRID_PARAM.getDeleteList = function(idDataAttribute){
	
}


GRID_PARAM.onContextMenuItemClick =function (event) 
{
	var args = event.args;
	var menuItemtext= $.trim($(args).text());
	var rowindex = gridObj.jqxGrid('getselectedrowindex');
	var rowData = gridObj.jqxGrid('getrowdata', rowindex);
	_contextMenuHandler(menuItemtext, rowData);
}
GRID_PARAM.onRowClick =function (event) 
{
	var grid = gridObj;
	var args = event.args;
	// row's bound index.
	var boundIndex = args.rowindex;
	// row's visible index.
	var visibleIndex = args.visibleindex;
	// right click.
	
	

	if (args.column.text == rowMenuColumnText) {
		var scrollTop = $(window).scrollTop();
		var scrollLeft = $(window).scrollLeft();
		editrow = event.args.rowindex;
		var rowsheight = grid.jqxGrid('rowsheight');
		var top = $(this).offset().top + (2 + editrow) * rowsheight;
		var left = ($(this).offset().left + parseInt($('#GridContainer').css('width'), 10)) - parseInt($('#' + rowMenuDivId).css('width'), 10) - 25;
		$('#' +rowMenuDivId).jqxMenu('open', left, top + 5 + scrollTop);
	} else {
		// original event.
		var ev = args.originalEvent;
		grid.jqxGrid('selectrow', boundIndex);
		var details = grid.jqxGrid('getrowdetails', boundIndex);
		if (details.rowdetailshidden == true) {
			grid.jqxGrid('showrowdetails', boundIndex);
		} else {
			grid.jqxGrid('hiderowdetails', boundIndex);
		}
	}
}




GRID_PARAM.rowDetailTemplate = function(tabs, height)  
{
	var rowDetailTemplate = "<div style='margin: 2px;'> <ul style='margin-left: 30px;'> "
		if($.isArray(tabs)){
			$.each(tabs, function(index, tab){
				rowDetailTemplate = rowDetailTemplate + "<li>" + tab + "</li>";
			});
			rowDetailTemplate = rowDetailTemplate + "</ul>";
			$.each(tabs, function(index, tab){
				rowDetailTemplate = rowDetailTemplate + "<div class='"+ tab.toLowerCase() +"'></div>";
			});
			rowDetailTemplate = rowDetailTemplate +   "</div>";
		}
	 return { rowdetails: rowDetailTemplate, rowdetailsheight: height };
}



GRID_PARAM.initrowdetails = function(index, parentElement, gridElement, datarecord){
	function formatUnixToTime(tdate)
	{
		var date = new Date(tdate);
		// hours part from the timestamp
		var hours = date.getHours();
		// minutes part from the timestamp
		var minutes = "0" + date.getMinutes();

		var ampm = hours >= 12 ? 'PM' : 'AM';
		hours = hours % 12;
		// will display time in 10:30 PM format
		return hours + ':' + minutes.substr(-2) + ' ' + ampm;
	}
	  var tabsdiv = null; 
	    tabsdiv = $($(parentElement).children()[0]);
	    if (tabsdiv != null) {
	  var eventDiv = tabsdiv.find('.event');
	  var container1 = $('<div class="row-fluid"></div>');
	  var leftcolumn = $('<div class="span3 GridLogo"></div>');
	  var rightcolumn = $('<div class="span9"></div>');
	  var d = new Date(datarecord.eventDate);
	  var d1 = formatUnixToTime(datarecord.startTime);
	  var d2 = formatUnixToTime(datarecord.endTime);
		container1.append(leftcolumn);
		container1.append(rightcolumn);
		console.log(datarecord);
		
		$(rightcolumn).append("<table>");		
		fnShowEventLogo(_repositoryId,datarecord.eventId,leftcolumn,false)
		var venueId = "<tr><td class='filledWidth1'><b>Venue:</b></td><td> "
				+ datarecord.venueId + "</td></tr>";
		var EventDate = "<tr><td class='filledWidth1'><b>Event Date:</b></td><td> "
			+ d + "</td></tr>";		
		var StartTime = "<tr><td class='filledWidth1'><b>Start Time:</b></td><td> "
			+ d1 + "</td></tr>";
		var EndTime = "<tr><td class='filledWidth1'><b>End Time:</b></td><td> "
			+ d2 + "</td></tr>";
		
		$(rightcolumn).append(venueId);
		$(rightcolumn).append(EventDate);
		$(rightcolumn).append(StartTime);
		$(rightcolumn).append(EndTime);
		$(rightcolumn).append("</table>");
		eventDiv.append(container1);

		$(tabsdiv).jqxTabs({
			width : '90%',
			height : 180
		});
    }
}

/*
 *  This method creates grid
 */


function createTable(data, model, grid, menuDivId, actionColText,contextMenuHandler, detailDivArr, Columns){
	
		if(typeof gridId == undefined){
			throw 'a valid grid div object must be provided';
		}
		if(typeof rowMenuColumnText == undefined){
			throw 'a columnheader needs to be provided to be used for click action';
		}
		if(typeof rowMenuDivId == undefined){
			throw 'a valid menu div needs to be provided to be used for click action';
		}
		if (typeof detailDivArr == undefined){
			throw 'a valid detailDivArr needs to be provided for row detail';
		}
		
		if (typeof model == undefined){
			throw 'a valid model needs to be provided';
		}
		
		_dataModel = model;
		rowMenuDivId = menuDivId;
		rowMenuColumnText =actionColText;
		gridObj = grid;
		rowDetailDivArr = detailDivArr
		
    grid.on('cellclick', GRID_PARAM.onRowClick);
    //set menu item click
    _contextMenuHandler = contextMenuHandler
	$('#' + rowMenuDivId).on('itemclick',GRID_PARAM.onContextMenuItemClick);
	// create context menu
	var contextMenu = $("#" + menuDivId).jqxMenu({
		width : 160,
		height : 60,
		autoOpenPopup : false,
		mode : 'popup'
	});
	
	grid.on('contextmenu', function() {
		return false;
	});

	var dataAdapter = new $.jqx.dataAdapter(GRID_PARAM.source(model, data));
    grid.jqxGrid(
            {
                width: '100%',
                source: dataAdapter,
                columnsheight : 40,
				columnsmenuwidth : 40,
				rowsheight : 34,
                theme:	'custom',
                autoheight: true,
             // Pageing config
                pageable : true,
                pagermode : 'default',
                rowdetails: true,
                showrowdetailscolumn:false,
                rowdetailstemplate: GRID_PARAM.rowDetailTemplate(rowDetailDivArr , 200),
                initrowdetails: GRID_PARAM.initrowdetails,
                columns: Columns
            });
    
	}

function fnShowEventLogo(_repositoryId,_eventId,_leftcolumn, _showUpload){
	///LOGO START
	var LogoURL = "";
	var flaskRequest = new Request();
	params= {'repositoryId': _repositoryId, 'parentFolderId': 0, 'name': 'Event'};
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
		function (data){
			folderName = 'Event-'+_eventId;
			var flaskRequestChild = new Request();
			paramsChild= {'repositoryId': _repositoryId, 'parentFolderId': data.folderId, 'name': folderName};
			flaskRequestChild.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild, 
				function (data){
					//data.folderId;
					var _folderId = data.folderId;
					var flaskRequestChild0 = new Request();
					paramsChild0= {'groupId': _repositoryId, 'folderId':data.folderId, 'title': 'EventLogo'};
					console.log(paramsChild0)
					console.log(_eventDetailModel.SERVICE_ENDPOINTS.GET_FILE_BY_TITLE);
					flaskRequestChild0.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.GET_FILE_BY_TITLE , paramsChild0, 
						function (data){
							LogoURL = "/documents/"+_repositoryId+"/"+_folderId+"/EventLogo";
						    var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+LogoURL+')','data-folderId':_folderId,'data-title':'EventLogo'});
							$(_leftcolumn).append(objdiv);
							$(objdiv).click(function(){
								var objDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
						    	$(this).toggleClass("activeImage");
						    	if($(this).hasClass("activeImage")){
					    			$(objDel).appendTo($(_leftcolumn));
					    			$(objDel).click(function(){
				    					fnDeleteFileByTitle(_repositoryId,$(objdiv).attr("data-folderId"),$(objdiv).attr("data-title"));
				    					$(this).remove();
				    					$(objdiv).remove();
				    					if(_showUpload){
											fnBuildEventUpload(_leftcolumn);
										}				    					
					    			});
						    	}
						    	else{
					    			$(objDel).remove();
						    	}
						    });					
						} ,
						function (data){
							if(_showUpload){
								fnBuildEventUpload(_leftcolumn);
							}
					});				
				} ,
				function (data){
					if(_showUpload){
						fnBuildEventUpload(_leftcolumn);
					}
			});
		} ,
		function (data){
			if(_showUpload){
				fnBuildEventUpload(_leftcolumn);
			}
	});
	//LOGO END
}
