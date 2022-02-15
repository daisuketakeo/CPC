package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 *画面パラメータ Entity 
 */
@Data
public class DisplayParameter  implements Serializable{
	
	public DisplayParameter() {
	}
	
	public DisplayParameter( 
			String WORK_GROUP,
			String DISPLAY_TYPE) {
		this.WORK_GROUP = WORK_GROUP;
		this.DISPLAY_TYPE = DISPLAY_TYPE;
	}
	
	String WORK_GROUP;
	String DISPLAY_TYPE;
}
