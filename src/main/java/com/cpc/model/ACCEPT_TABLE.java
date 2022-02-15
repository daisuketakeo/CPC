package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 受入テーブル Entity 
 */
@Data
public class ACCEPT_TABLE  implements Serializable{
	private String MATERIAL_NO;
	private String MATERIAL_NAME;
	private String CATEGORY_NO;
	private String MANUFACTURER;
	private String QTY;
	private String STORAGE;
	private String LOT_NO;
	private String EXP_DATE;
	private String USER_LOT_NO;
	private String STORAGE_LOCATION;
	private String REQUIRED_AMOUNT;
	private String PREPARED_AMOUNT;
	private String QA_APP_STATUS;
	private String STATUS;
}
