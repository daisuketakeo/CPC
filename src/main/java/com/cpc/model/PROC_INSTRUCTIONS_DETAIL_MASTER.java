package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 工程別製造指図詳細マスタ Entity 
 */
@Data
public class PROC_INSTRUCTIONS_DETAIL_MASTER  implements Serializable{
	private String IM_ID;
	private String INS_PROC_ID;
	private String INS_PROC_DETAIL_ID;
	private String ITEM_CONDITION;
	private String MATERIAL_NO_NAME;
	private String REQUIRED_QUANTITY;
	private String USER_LOT_NO;
	private String CAPTURE;
}
