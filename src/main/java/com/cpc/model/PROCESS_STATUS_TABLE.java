package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 工程別ステータステーブル Entity 
 */
@Data
public class PROCESS_STATUS_TABLE  implements Serializable{
	private String BATCH_ID;
	private String PROCESS_ID;
	private String STATUS;
}
