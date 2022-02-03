package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * マテリアルチェックテーブル Entity 
 */
@Data
public class MATERIAL_CHECK_TABLE  implements Serializable{
	private String MATERIAL_NO;
	private String BATCH_ID;
	private String PROCESS_ID;
	private String WORK_GROUP;
	private String WORK_ID;
	private String CHECK_USERID;
	private String CHECK_USERNAME;
	private String CHECK_DATE;
}
