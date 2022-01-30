package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 工程別製造指図マスタ Entity 
 */
@Data
public class PROC_INSTRUCTIONS_MASTER  implements Serializable{
	private String IM_ID;
	private String INS_PROC_ID;
	private String RECIPE_NAME;
	private String CELL_TYPE;
	private String TARGET_AMOUNT;
	private String INCUBATION;
	private String END_POINT;
	private String COMMENT;
}
