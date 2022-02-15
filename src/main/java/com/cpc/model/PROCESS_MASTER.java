package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 工程マスタ Entity 
 */
@Data
public class PROCESS_MASTER  implements Serializable{
	private String PROCESS_ID;
	private String PROCESS_NAME;
}
