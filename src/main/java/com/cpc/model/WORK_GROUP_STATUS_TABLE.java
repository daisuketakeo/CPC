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
}
