package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * ステータスマスタ Entity 
 */
@Data
public class STATUS_MASTER  implements Serializable{
	private String TABLE_TYPE;
	private String STATUS_CODE;
	private String STATUS_NAME;
}
