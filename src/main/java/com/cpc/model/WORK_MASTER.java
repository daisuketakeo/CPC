package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 作業手順マスタ Entity 
 */
@Data
public class WORK_MASTER  implements Serializable{
	private String PROCESS_ID;
	private String WORK_GROUP;
	private String WORK_ID;
	private String WORK;
	private String CAPTURE1;
	private String CAPTURE2;
	private String CAPTURE3;
	private String CAPTURE4;
	private String CAPTURE5;
	private String CSV1;
	private String CSV2;
	private String CSV3;
	private String CSV4;
	private String CSV5;
}
