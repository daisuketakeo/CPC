package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 製造指図テーブル Entity 
 */
@Data
public class INSTRUCTIONS_TABLE  implements Serializable{
	private String BATCH_ID;
	private String IM_ID;
	private String NAME;
	private String COMMENT;
	private String CELL_TYPE;
	private String INPUT_AMOUNT;
	private String TARGET_AMOUNT_CELLS;
	private String TARGET_AMOUNT_BAGS;
	private String TOTAL_PASSAGE_TIMES;
	private String DURATION_EST;
	private String MEDIUM;
	private String ECM_COATING;
	private String DISSOCIATION_REAGENT;
	private String PRE_CULTURE_VESSEL;
	private String PRE_CULTURE_MATERIAL_NAME;
	private String PRE_CULTURE_VOLUME;
	private String PRE_CULTURE_INCUBATION_TIME;
	private String ICP1_VESSEL;
	private String ICP1_MATERIAL_NAME;
	private String ICP1_VOLUME;
	private String ICP1_INCUBATION_TIME;
	private String ICP2_VESSEL;
	private String ICP2_MATERIAL_NAME;
	private String ICP2_VOLUME;
	private String ICP2_INCUBATION_TIME;
	private String ICP3_VESSEL;
	private String ICP3_MATERIAL_NAME;
	private String ICP3_VOLUME;
	private String ICP3_INCUBATION_TIME;
	private String PROTOCOL;
	private String STARTING_TIME;
	private String FINISH_TIME;
	private String PRE_CULTURE_KIT_RT_LABEL;
	private String PRE_CULTURE_KIT_P4T_LABEL;
	private String PRE_CULTURE_KIT_M20T_LABEL;
	private String PRE_CULTURE_COUNT;
	private String EX_CULTURE_KIT_RT_LABEL;
	private String EX_CULTURE_KIT_P4T_LABEL;
	private String EX_CULTURE_KIT_M20T_LABEL;
	private String STATUS;
}
