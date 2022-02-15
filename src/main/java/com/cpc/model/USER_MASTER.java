package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * ユーザマスタ Entity 
 */
@Data
public class USER_MASTER  implements Serializable{
	private String USERID;
	private String USERNAME;
	private String PASSWORD;
	private String AUTHORITY;
}
