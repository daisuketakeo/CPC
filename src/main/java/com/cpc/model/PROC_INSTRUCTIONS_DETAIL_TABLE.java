package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 工程別製造指図詳細テーブル Entity 
 */
@Data
public class PROC_INSTRUCTIONS_DETAIL_TABLE  implements Serializable{
	private String BATCH_ID;
	private String INS_PROC_ID;
	private String INS_PROC_DETAIL_ID;
	private String ITEM_CONDITION;
	private String MATERIAL_NO_NAME;
	private String REQUIRED_QUANTITY;
	private String USER_LOT_NO;
	private String CAPTURE;
}
