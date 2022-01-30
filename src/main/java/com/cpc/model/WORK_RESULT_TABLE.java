package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 作業実績テーブル Entity 
 */
@Data
public class WORK_RESULT_TABLE  implements Serializable{
	private String WORK_RESULT_NO;
	private String PROCESS_ID;
	private String WORK_GROUP;
	private String WORK_ID;
	private String ID;
	private String CHECK_RESULT;
	private String CHECK_REASON;
	private String CHECK_COA;
	private String CHECK_COA_REASON;
	private String CHECK_FILE_NAME;
	private String CHECK_FILE_BASE64;
	private String LABEL;
	private String COUNT_RESULT;
	private String WORK_USERID;
	private String WORK_USERNAME;
	private String WORK_DATE;
}
