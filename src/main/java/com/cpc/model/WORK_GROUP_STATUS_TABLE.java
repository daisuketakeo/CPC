package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 作業グループステータステーブル Entity 
 */
@Data
public class WORK_GROUP_STATUS_TABLE  implements Serializable{
	private String BATCH_ID;
	private String PROCESS_ID;
	private String WORK_GROUP;
	private String STATUS;
	private String DEVIATION_NO;
	private String DEVIATION_DATE;
	private String REPORTED_DATE;
	private String REPORTED_BY;
	private String OCCURRENT_DATE;
	private String CLOSING_DATE;
	private String REVIEWED_DATE;
	private String REVIEWED_BY;
	private String BATCH_RELEASE;
}
