create table flaskevents_Event (
	eventId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventName VARCHAR(75) null,
	description VARCHAR(75) null,
	eventDate DATE null,
	startTime DATE null,
	endTime DATE null,
	eventTypeId LONG,
	eventTypeName VARCHAR(75) null,
	eventImagePath VARCHAR(75) null,
	venueId LONG,
	venueName VARCHAR(75) null
);

create table flaskevents_EventDetail (
	eventDetailId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventId LONG,
	infoTypeId LONG,
	infoTypeName VARCHAR(75) null,
	infoTypeCategoryId LONG,
	infoTypeCategoryName VARCHAR(75) null,
	infoTitle VARCHAR(75) null,
	infoDesc VARCHAR(75) null,
	addrLine1 VARCHAR(75) null,
	addrLine2 VARCHAR(75) null,
	city VARCHAR(75) null,
	zipCode VARCHAR(75) null,
	stateId LONG,
	stateName VARCHAR(75) null,
	countryId LONG,
	countryName VARCHAR(75) null,
	latitude VARCHAR(75) null,
	longitude VARCHAR(75) null,
	phone VARCHAR(75) null,
	website VARCHAR(75) null,
	cost DOUBLE,
	hoursOfOperation VARCHAR(75) null
);

create table flaskevents_EventDetailImage (
	eventDetailImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	eventDetailId LONG,
	imageTitle VARCHAR(75) null,
	imageDesc VARCHAR(75) null,
	imagePath VARCHAR(75) null
);

create table flaskevents_EventType (
	eventTypeId LONG not null primary key,
	eventTypeKey VARCHAR(75) null,
	eventTypeName VARCHAR(75) null
);

create table flaskevents_InfoType (
	infoTypeId LONG not null primary key,
	infoTypeName VARCHAR(75) null
);

create table flaskevents_InfoTypeCategory (
	infoTypeCategoryId LONG not null primary key,
	infoTypeCategoryName VARCHAR(75) null,
	displayTemplate VARCHAR(75) null
);

create table flaskevents_Venue (
	venueId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueName VARCHAR(75) null,
	venueDescription VARCHAR(75) null,
	venueZipCode VARCHAR(75) null,
	addrLine1 VARCHAR(75) null,
	addrLine2 VARCHAR(75) null,
	venueCity VARCHAR(75) null,
	venueStateId LONG,
	venueStateName VARCHAR(75) null,
	venueCountryId LONG,
	venueCountryName VARCHAR(75) null,
	venueMetroArea VARCHAR(75) null,
	longitude VARCHAR(75) null,
	latitude VARCHAR(75) null
);

create table flaskevents_VenueDetail (
	venueDetailId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueId LONG,
	infoTypeId LONG,
	infoTypeName VARCHAR(75) null,
	infoTypeCategoryId LONG,
	infoTitle VARCHAR(75) null,
	infoDesc VARCHAR(75) null,
	addrLine1 VARCHAR(75) null,
	addrLine2 VARCHAR(75) null,
	city VARCHAR(75) null,
	zipCode VARCHAR(75) null,
	stateId LONG,
	stateName VARCHAR(75) null,
	countryId LONG,
	countryName VARCHAR(75) null,
	latitude VARCHAR(75) null,
	longitude VARCHAR(75) null,
	phone VARCHAR(75) null,
	website VARCHAR(75) null,
	cost DOUBLE,
	hoursOfOperation VARCHAR(75) null
);

create table flaskevents_VenueDetailImage (
	venueDetailImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	venueDetailId LONG,
	imageTitle VARCHAR(75) null,
	imageDesc VARCHAR(75) null,
	imagePath VARCHAR(75) null
);

create table flaskevents_VenueImage (
	venueImageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	venueImagePath VARCHAR(75) null,
	venueId LONG
);