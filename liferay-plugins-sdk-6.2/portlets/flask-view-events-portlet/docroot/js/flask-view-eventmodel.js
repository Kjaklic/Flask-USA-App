var _eventModel = {};

_eventModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_EVENT 					:"/flask-rest-events-portlet.event/get-all-events",
	GET_USER_EVENT 				:"/flask-rest-events-portlet.event/get-user-selected-events",
	GET_EVENTDETAIL_WITH_IMAGES :"/flask-rest-events-portlet.event/get-event-details-with-images",
	GET_FOLDER					:"/dlapp/get-folder",
	GET_FOLDERS					:"/dlapp/get-folders",
	GET_FILES					:"/dlapp/get-file-entries",
	GET_FILE_BY_TITLE			:"/dlapp/get-file-entry",
	ADD_USER_EVENT				:"/flask-rest-events-portlet.event/add-user-event",
	REMOVE_USER_EVENT			:"/flask-rest-events-portlet.event/remove-user-event"		
};

_eventModel.DATA_MODEL= {
		EVENT: 
			[
			 	 { name: 'eventId', type: 'long' },
			 	 { name: 'eventName', type: 'string' },
			 	 { name: 'description', type: 'string' },
			 	 { name: 'eventDate', type: 'string' },
			 	 { name: 'startTime', type: 'string' },
			 	 { name: 'endTime', type: 'string' },
			 	 { name: 'eventTypeId', type: 'long' },
			 	 { name: 'eventTypeName', type: 'string' },
			 	 { name: 'venueId', type:'long' },
			 	 { name: 'venueName', type:'string' },
			 	 { name: 'eventImagePath', type:'string' }
			]
		};

_eventModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Event successfully added",
		SAVE: "Event successfully saved",
		ERROR: "There was an error in saving venue",
		DEL_SUCCESS: "Event successfully deleted",
		DEL_ERR: "Error in deleting Event",
 };

_eventModel.DETAIL_DATA_MODEL = {
		GENERAL:[{
                "infoTitle":"Title",
	        	"infoDesc":"Description"
				}],
		TRADITION:[{//TRADITION
                "infoTitle":"Name",
                "infoDesc":"Description",
                "Comment":"Comment"
            	}],
        WEATHER:[{//WEATHER
            	"infoTitle":"Name",
            	"infoDesc":"Description"
        		}],    		
        PARKING:[{//PARKING
	            "infoTitle":"Name",
	            "addrLine1":"Address",
	            "cost":"Cost",
	            "hoursOfOperation":"Is Available?",	            
            }],
        TRAFFIC:[{//TRAFFIC
                "infoTitle":"Name",
                "infoDesc":"Description",
            }],
        FOOD:[{//FOOD
            "infoTitle":"Name",
            "infoDesc":"Type of Establishment",
            "addrLine1":"Address",
            "phone":"Phone",
            "website":"Website",
            "infoDesc":"website",
            }]
}