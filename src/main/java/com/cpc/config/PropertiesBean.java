package com.cpc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
@ConfigurationProperties(prefix = "")
public class PropertiesBean {
	private String SYSTEM_NAME;
	private String REST_URL;
	
	private String CONFIG_PATH;
	private String CAMERA_VISION_PATH;
	private String ICP_RESULT_PATH;
	private String PRE_BATCH_PATH;
	private String EBR_TEST_PATH;
	private String IST_PROC_DETAIL_PATH;
	
	private String USER_LOT_NO_FILE;
	private String STORAGE_FILE;
	private String SEQUENCE_FILE;
	private String MONITORING_DATA_FILE;
	
	private String CHECKLIST_MSG1;
	private String CHECKLIST_MSG2;
	
	private String KIT_LABEL_FIX_STRING;
	
}
