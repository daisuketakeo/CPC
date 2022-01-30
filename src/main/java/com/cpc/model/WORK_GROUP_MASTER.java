package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 作業グループマスタ Entity 
 */
@Data
public class WORK_GROUP_MASTER  implements Serializable{
	private String PROCESS_ID;
	private String WORK_GROUP;
	private String WORK_GROUP_NAME;
	private String BEFORE_WORK_GROUP;
	private String STATUS;
	private String DISPLAY_TYPE;
}
