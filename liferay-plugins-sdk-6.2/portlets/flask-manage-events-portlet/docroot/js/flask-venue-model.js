var _venueModel = {};

_venueModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_VENUE 					: "/flask-rest-events-portlet.venue/get-all-venues",
	ADD_VENUE 					: "/flask-rest-events-portlet.venue/add-venue",
	ADD_VENUE_IMAGE				: "/flask-rest-events-portlet.venue/add-venue-image",
	UPDATE_VENUE				: "/flask-rest-events-portlet.venue/update-venue",
	DELETE_VENUE				: "/flask-rest-events-portlet.venue/delete-venue",
	DELETE_VENUES				: "/flask-rest-events-portlet.venue/delete-venues",
	DELETE_FILES				: "/dlapp/delete-file-entry",
	DELETE_VENUE_IMAGE			: "/flask-rest-events-portlet.venue/delete-venue-image",
	GET_INFO_CATEGORY 			: "/flask-rest-events-portlet.infotypecategory/get-info-type-categories",
	ADD_VENUE_DETAILS			: "/flask-rest-events-portlet.venue/add-venue-detail",
	UPDATE_VENUE_DETAILS		: "/flask-rest-events-portlet.venue/update-venue-detail",
	GET_FILES					: "/dlapp/get-file-entries",
	GET_VENUE_IMAGES			: "/flask-rest-events-portlet.venue/get-venue-images",
	GET_ALL_EVENTS				: "/flask-rest-events-portlet.event/get-all-events",
	GET_FOLDER		 			: "/dlapp/get-folder",
	DELETE_FOLDER		 		: "/dlapp/delete-folder"
};

_venueModel.DATA_MODEL= {
	VENUE:
		[
			 { name: 'venueId', type: 'long' },
			 { name: 'venueName', type: 'string' },
			 { name: 'venueDescription', type: 'string' },
			 { name: 'addrLine1', type: 'string' },
			 { name: 'addrLine2', type: 'string' },
			 { name: 'venueCity', type: 'string' },
			 { name: 'venueStateId', type:'long' },
			 { name: 'venueStateName', type:'string' },
			 { name: 'venueCountryId', type:'long' },
			 { name: 'venueCountryName', type:'string' },
			 { name: 'venueZipCode', type:'string' },
			 { name: 'venueMetroArea', type:'string' },
			 { name: 'longitude', type:'string' },
			 { name: 'latitude', type:'string' },
			 { name: 'venueDetailsDistRange', type:'int' }
		]
	};

_venueModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Venue successfully added",
		SAVE: "Venue successfully saved",
		ERROR: "There was an error in saving venue",
		DEL_SUCCESS: "Venue successfully deleted",
		DEL_ERR: "Error in deleting venue",
		ADD_VENUE_FIRST_ERR: "Please save event first",
		CAN_NOT_DELETE: "Error deleting.. Because There is event containing this venue"
};

