package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 受入指図連携テーブル Entity 
 */
@Data
public class AI_RELATION_TABLE  implements Serializable{
	private String IM_ID;
	private String PROCESS_ID;
	private String MATERIAL_NO;
}
