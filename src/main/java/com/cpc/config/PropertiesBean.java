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
	private String BATCH_PROGRESS_CSV_PATH;
	private String BATCH_PROGRESS_CAPTURE_PATH;
	private String POST_BATCH_OVERVIEW_PATH;
	private String PRE_BATCH_OVERVIEW_PATH;
	
	private String USER_LOT_NO_FILE;
	private String BATCH_ID_NO_FILE;
	private String STORAGE_FILE;
	private String SEQUENCE_FILE;
	private String MONITORING_DATA_FILE;
	
	private String BATCH_ID_FIX_STRING;
	
	private String CHECKLIST_MSG1;
	private String CHECKLIST_MSG2;
	
	private String KIT_LABEL_FIX_STRING;
	
	private String SEQUENCE_INTERVAL;
	
	private String CELLQUALIA_TOP_AUTOTRANS;
	private String CELLQUALIA_TOP_LOGO;
	private String CELLQUALIA_TOP_TOP;
	private String CELLQUALIA_TOP_FINISHED;
	private String CELLQUALIA_TOP_ALARMS;
	private String CELLQUALIA_TOP_MAINTENANCE;
	private String CELLQUALIA_TOP_PRE_BATCH;
	private String CELLQUALIA_TOP_BATCH_PROGRESS;
	private String CELLQUALIA_TOP_POST_BATCH_STANDALONE;
	private String CELLQUALIA_TOP_POST_BATCH_ENTERPRISE;
	private String CELLQUALIA_TOP_BATCH_LIST;
	private String CELLQUALIA_TOP_DELIVERY;
	private String CELLQUALIA_TOP_COSTS;
	private String CELLQUALIA_TOP_LOG_ANALYSIS;

}
