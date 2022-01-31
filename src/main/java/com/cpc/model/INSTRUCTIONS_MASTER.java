package com.cpc.model;

import java.io.Serializable;
import lombok.Data;
/**
 * 製造指図マスタ Entity 
 */
@Data
public class INSTRUCTIONS_MASTER  implements Serializable{
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
	private String MATERIAL_GORUP_ID;
	private String PROTOCOL;
}
