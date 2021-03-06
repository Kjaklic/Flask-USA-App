package com.rumbasolutions.flask.manageevent;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rumbasolutions.flask.model.VenueDetailImage;
import com.rumbasolutions.flask.service.VenueServiceUtil;



public class ManageVenuePortletAction extends MVCPortlet {
	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 10; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
	private static Log LOGGER = LogFactoryUtil.getLog(ManageVenuePortletAction.class);
	
	private final String VENUE_ID_QSTR = "_venueId";
	private final String VENUE_DETAIL_ID_QSTR= "_venueDetailId";
	private final String VENUE_ISLOGO_QSTR= "_isLogo";
	private final String VENUE_DEVICE_TYPE= "_deviceType";
	private final String VENUE_ASPECT_RATIO= "_aspectRatio";
	private long _venueId = 0;
	private long _venueDetailId = 0;
	private String _isLogo = "N";
	private String _deviceType = "";
	private String _aspectRatio = "";
	private ServiceContext _serviceContext;
	Folder _venueFolder = null;
	
public void addImages(ActionRequest actionRequest, ActionResponse actionResponse)throws IOException, PortletException {
		if (!PortletFileUpload.isMultipartContent( actionRequest)) {
			return;
		}
	
		_serviceContext = getServicContext(actionRequest);
		// configures some settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		
		PortletFileUpload upload = new PortletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(REQUEST_SIZE);
		
		// constructs the directory path to store upload file
		String uploadPath = getPortletContext().getRealPath("")
			+ File.separator + UPLOAD_DIRECTORY;
		
		
		try {
			// parses the request's content to extract file data
			List<FileItem> formItems = upload.parseRequest(actionRequest);
			_venueId = getEventId(formItems);
			_venueDetailId = getEventDetailId(formItems);
			_isLogo = getIsLogo(formItems);
			_deviceType = getDeviceType(formItems);
			_aspectRatio = getAspectRatio(formItems);
			createUploadFolder(uploadPath);
			
			for(FileItem item: formItems){
				if (!item.isFormField()) {
					String uuid = UUID.randomUUID().toString();
					String fileName = new File(_deviceType+"-"+uuid).getName();
					String fileTitle = fileName;
					String fileDesc = fileName; // Change is later for description 
					//boolean IsLogo =  _isLogo.equals("Y");
					/*if(IsLogo){
						fileTitle = "VenueLogo";
					}*/
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					// saves the file on disk
					item.write(storeFile);
					String mimeType = FlaskDocLibUtil.getMimeType(filePath);
					FileEntry fileEntry = FlaskDocLibUtil.addFileEntry(_venueFolder, fileName, fileTitle, fileDesc, storeFile, mimeType, _serviceContext);
					if(_venueDetailId > 0){
						if(!_deviceType.isEmpty() && !_aspectRatio.isEmpty()){
							List<VenueDetailImage> venueDetailImages = VenueServiceUtil.getVenueDetailImagesByVenueIdandDeviceType(_venueDetailId, _deviceType, _serviceContext);
							if(venueDetailImages.isEmpty()){
								VenueDetailImage venueDetailImage = VenueServiceUtil.addVenueDetailImage(_venueDetailId, fileTitle, fileDesc, fileEntry.getUuid(), fileEntry.getGroupId(), _serviceContext);
								VenueServiceUtil.addVenueDeviceImage(venueDetailImage.getVenueDetailImageId(),_venueId, _deviceType, fileEntry.getUuid(), _aspectRatio);
							}else{
								for(VenueDetailImage VenueDetailImage : venueDetailImages){
									VenueServiceUtil.deleteVenueDetailImage(VenueDetailImage.getVenueDetailImageId(), _serviceContext);
									VenueDetailImage venueDetailImage = VenueServiceUtil.addVenueDetailImage(_venueDetailId, fileTitle, fileDesc, fileEntry.getUuid(), fileEntry.getGroupId(), _serviceContext);
									VenueServiceUtil.addVenueDeviceImage(venueDetailImage.getVenueDetailImageId(),_venueId, _deviceType, fileEntry.getUuid(), _aspectRatio);
								}
							}
						}else{
							VenueServiceUtil.addVenueDetailImage(_venueDetailId, fileTitle, fileDesc, fileEntry.getUuid(), fileEntry.getGroupId(), _serviceContext);
						}
						
						
						_venueDetailId =0;
					}else{
						VenueServiceUtil.addVenueImage(_venueId, fileTitle, fileEntry.getUuid(), fileEntry.getGroupId(), _serviceContext);
					}
				}else{
					
				}
			}
			actionRequest.setAttribute("message", "Upload has been done successfully!");
		} catch (Exception ex) {
			actionRequest.setAttribute("message", "There was an error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private void createUploadFolder(String uploadPath)  {

		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {
			boolean IsLogo =  _isLogo.equals("Y");
			if(IsLogo)
				_venueFolder = FlaskDocLibUtil.createVenueFolder(_venueId,_serviceContext);
			else
				_venueFolder = FlaskDocLibUtil.createVenueContentTypeFolder(_venueId, _venueDetailId, _serviceContext);
		}
		catch (Exception e) {
			LOGGER.error("Error in creating venue folder in Document Media Library", e);
		}
	}

	private ServiceContext getServicContext(ActionRequest actionRequest){
		
		ServiceContext serviceContext=null;
		try {
			serviceContext = ServiceContextFactory.getInstance(actionRequest);
		}
		catch (PortalException e) {
			LOGGER.error(e);	
		}
		catch (SystemException e) {
			LOGGER.error(e);
		}
		return serviceContext;
	}

	/*private long getInfoTypeId(List<FileItem> formItems){
		long infoTypeId = 0;
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(INFO_TYPE_ID_QSTR)){
				infoTypeId =  Long.parseLong(item.getString());
				break;
			}
		}
		return infoTypeId;
	}
	
	private long getInfoTypeContentId(List<FileItem> formItems){
		long infoTypeContId = 0;
		 
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(INFO_TYPE_CON_ID_QSTR)){
				infoTypeContId =  Long.parseLong(item.getString());
				break;
			}
		}
		return infoTypeContId;
	}
	*/
	
	private long getEventId(List<FileItem> formItems){
		long eventId = 0;
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(VENUE_ID_QSTR)){
				eventId = Long.parseLong(item.getString());
				break;
			}
		}
		return eventId;
	}

	private long getEventDetailId(List<FileItem> formItems){
		long infoTypeContId = 0;
		 
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(VENUE_DETAIL_ID_QSTR)){
				infoTypeContId =  Long.parseLong(item.getString());
				break;
			}
		}
		return infoTypeContId;
	}

	private String getIsLogo(List<FileItem> formItems){
		String isLogo = "N";
		 
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(VENUE_ISLOGO_QSTR)){
				isLogo = item.getString();
				break;
			}
		}
		return isLogo;
	}	
	
	private String getDeviceType(List<FileItem> formItems){
		String deviceType = "";
		 
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(VENUE_DEVICE_TYPE)){
				deviceType = item.getString();
				break;
			}
		}
		return deviceType;
	}	
	
	private String getAspectRatio(List<FileItem> formItems){
		String aspectRatio = "";
		 
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(VENUE_ASPECT_RATIO)){
				aspectRatio = item.getString();
				break;
			}
		}
		return aspectRatio;
	}	
}
