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
	private String BP_ALERM;
	private String BP_WARNING;
	private String BP_HEADER;
	private String BP_PH_OVER_TIME;
	private String BP_GLUCOSE_OVER_TIME;
	private String BP_LACTATE_OVER_TIME;
	private String BP_GROWTH_RATE_OVER_TIME;
	private String BP_CAMERA_VISION;
	private String BP_ORVER_VIEW;
	private String BP_IDENTIFICATION;
	private String BP_CULTURE_CONDITION;
	private String BP_DETAIL;
	private String BP_YOBI1;
	private String BP_YOBI2;
	private String BP_YOBI3;
	private String POB_ICP;
	private String POB_ICP_SUMMARY;
	private String POB_ICP_MICROBIOLOGICAL_STERILITY;
	private String POB_ICP_KARYOTYPE_RESULTS;
	private String POB_ICP_PTENCY;
	private String POB_ICP_MATERIAL_OVERVIEW;
	private String POB_ICP_MATERIAL_IDENTIFICATION;
	private String POB_ELECTRONIC_BATCH_RECORD;
	private String POB_CELL_GROWTH_VIDEO;
	private String POB_ICP_CULTURE_CONDITION;
	private String POB_YOBI1;
	private String POB_YOBI2;
	private String POB_YOBI3;
	private String PRB_ICP_MATERIAL_OVERVIEW;
	private String PRB_ICP_MATERIAL_IDENTIFICATION;
	private String PRB_ICP_CULTURE_CONDITION;
	private String PRB_ICP_ALERM;
	private String PRB_ICP_WARNINGS;
	private String PRB_YOBI1;
	private String PRB_YOBI2;
	private String PRB_YOBI3;
}
