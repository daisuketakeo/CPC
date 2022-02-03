package com.cpc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import com.cpc.model.INSTRUCTIONS_MASTER;

/**
 * 製造指図マスタ repository
 */
@Mapper
@Component
public interface RInstructionsMst{
 
    @Insert("INSERT INTO INSTRUCTIONS_MASTER ( "
            + "  IM_ID "
            + ", NAME "
            + ", COMMENT "
            + ", CELL_TYPE "
            + ", INPUT_AMOUNT "
            + ", TARGET_AMOUNT_CELLS "
            + ", TARGET_AMOUNT_BAGS "
            + ", TOTAL_PASSAGE_TIMES "
            + ", DURATION_EST "
            + ", MEDIUM "
            + ", ECM_COATING "
            + ", DISSOCIATION_REAGENT "
            + ", PRE_CULTURE_VESSEL "
            + ", PRE_CULTURE_MATERIAL_NAME "
            + ", PRE_CULTURE_VOLUME "
            + ", PRE_CULTURE_INCUBATION_TIME "
            + ", ICP1_VESSEL "
            + ", ICP1_MATERIAL_NAME "
            + ", ICP1_VOLUME "
            + ", ICP1_INCUBATION_TIME "
            + ", ICP2_VESSEL "
            + ", ICP2_MATERIAL_NAME "
            + ", ICP2_VOLUME "
            + ", ICP2_INCUBATION_TIME "
            + ", ICP3_VESSEL "
            + ", ICP3_MATERIAL_NAME "
            + ", ICP3_VOLUME "
            + ", ICP3_INCUBATION_TIME "
            + ", MATERIAL_GORUP_ID "
            + ", PROTOCOL "
            + ", BP_ALERM "
            + ", BP_WARNING "
            + ", BP_HEADER "
            + ", BP_PH_OVER_TIME "
            + ", BP_GLUCOSE_OVER_TIME "
            + ", BP_LACTATE_OVER_TIME "
            + ", BP_GROWTH_RATE_OVER_TIME "
            + ", BP_CAMERA_VISION "
            + ", BP_ORVER_VIEW "
            + ", BP_IDENTIFICATION "
            + ", BP_CULTURE_CONDITION "
            + ", BP_DETAIL "
            + ", BP_YOBI1 "
            + ", BP_YOBI2 "
            + ", BP_YOBI3 "
            + ", POB_ICP "
            + ", POB_ICP_SUMMARY "
            + ", POB_ICP_MICROBIOLOGICAL_STERILITY "
            + ", POB_ICP_KARYOTYPE_RESULTS "
            + ", POB_ICP_PTENCY "
            + ", POB_ICP_MATERIAL_OVERVIEW "
            + ", POB_ICP_MATERIAL_IDENTIFICATION "
            + ", POB_ELECTRONIC_BATCH_RECORD "
            + ", POB_CELL_GROWTH_VIDEO "
            + ", POB_ICP_CULTURE_CONDITION "
            + ", POB_YOBI1 "
            + ", POB_YOBI2 "
            + ", POB_YOBI3 "
            + ", PRB_ICP_MATERIAL_OVERVIEW "
            + ", PRB_ICP_MATERIAL_IDENTIFICATION "
            + ", PRB_ICP_CULTURE_CONDITION "
            + ", PRB_ICP_ALERM_WARNINGS "
            + ", PRB_YOBI1 "
            + ", PRB_YOBI2 "
            + ", PRB_YOBI3 "
         +") VALUES ( "
            + "  #{IM_ID} "
            + ", #{NAME} "
            + ", #{COMMENT} "
            + ", #{CELL_TYPE} "
            + ", #{INPUT_AMOUNT} "
            + ", #{TARGET_AMOUNT_CELLS} "
            + ", #{TARGET_AMOUNT_BAGS} "
            + ", #{TOTAL_PASSAGE_TIMES} "
            + ", #{DURATION_EST} "
            + ", #{MEDIUM} "
            + ", #{ECM_COATING} "
            + ", #{DISSOCIATION_REAGENT} "
            + ", #{PRE_CULTURE_VESSEL} "
            + ", #{PRE_CULTURE_MATERIAL_NAME} "
            + ", #{PRE_CULTURE_VOLUME} "
            + ", #{PRE_CULTURE_INCUBATION_TIME} "
            + ", #{ICP1_VESSEL} "
            + ", #{ICP1_MATERIAL_NAME} "
            + ", #{ICP1_VOLUME} "
            + ", #{ICP1_INCUBATION_TIME} "
            + ", #{ICP2_VESSEL} "
            + ", #{ICP2_MATERIAL_NAME} "
            + ", #{ICP2_VOLUME} "
            + ", #{ICP2_INCUBATION_TIME} "
            + ", #{ICP3_VESSEL} "
            + ", #{ICP3_MATERIAL_NAME} "
            + ", #{ICP3_VOLUME} "
            + ", #{ICP3_INCUBATION_TIME} "
            + ", #{MATERIAL_GORUP_ID} "
            + ", #{PROTOCOL} "
            + ", #{BP_ALERM} "
            + ", #{BP_WARNING} "
            + ", #{BP_HEADER} "
            + ", #{BP_PH_OVER_TIME} "
            + ", #{BP_GLUCOSE_OVER_TIME} "
            + ", #{BP_LACTATE_OVER_TIME} "
            + ", #{BP_GROWTH_RATE_OVER_TIME} "
            + ", #{BP_CAMERA_VISION} "
            + ", #{BP_ORVER_VIEW} "
            + ", #{BP_IDENTIFICATION} "
            + ", #{BP_CULTURE_CONDITION} "
            + ", #{BP_DETAIL} "
            + ", #{BP_YOBI1} "
            + ", #{BP_YOBI2} "
            + ", #{BP_YOBI3} "
            + ", #{POB_ICP} "
            + ", #{POB_ICP_SUMMARY} "
            + ", #{POB_ICP_MICROBIOLOGICAL_STERILITY} "
            + ", #{POB_ICP_KARYOTYPE_RESULTS} "
            + ", #{POB_ICP_PTENCY} "
            + ", #{POB_ICP_MATERIAL_OVERVIEW} "
            + ", #{POB_ICP_MATERIAL_IDENTIFICATION} "
            + ", #{POB_ELECTRONIC_BATCH_RECORD} "
            + ", #{POB_CELL_GROWTH_VIDEO} "
            + ", #{POB_ICP_CULTURE_CONDITION} "
            + ", #{POB_YOBI1} "
            + ", #{POB_YOBI2} "
            + ", #{POB_YOBI3} "
            + ", #{PRB_ICP_MATERIAL_OVERVIEW} "
            + ", #{PRB_ICP_MATERIAL_IDENTIFICATION} "
            + ", #{PRB_ICP_CULTURE_CONDITION} "
            + ", #{PRB_ICP_ALERM_WARNINGS} "
            + ", #{PRB_YOBI1} "
            + ", #{PRB_YOBI2} "
            + ", #{PRB_YOBI3} "
         +")"
         )
    int insert(INSTRUCTIONS_MASTER model);
    
    @Update({
        "<script>",
        "UPDATE INSTRUCTIONS_MASTER ",
        "  <set>",
        "    <if test='NAME != null'> , NAME = #{NAME} </if>",
        "    <if test='COMMENT != null'> , COMMENT = #{COMMENT} </if>",
        "    <if test='CELL_TYPE != null'> , CELL_TYPE = #{CELL_TYPE} </if>",
        "    <if test='INPUT_AMOUNT != null'> , INPUT_AMOUNT = #{INPUT_AMOUNT} </if>",
        "    <if test='TARGET_AMOUNT_CELLS != null'> , TARGET_AMOUNT_CELLS = #{TARGET_AMOUNT_CELLS} </if>",
        "    <if test='TARGET_AMOUNT_BAGS != null'> , TARGET_AMOUNT_BAGS = #{TARGET_AMOUNT_BAGS} </if>",
        "    <if test='TOTAL_PASSAGE_TIMES != null'> , TOTAL_PASSAGE_TIMES = #{TOTAL_PASSAGE_TIMES} </if>",
        "    <if test='DURATION_EST != null'> , DURATION_EST = #{DURATION_EST} </if>",
        "    <if test='MEDIUM != null'> , MEDIUM = #{MEDIUM} </if>",
        "    <if test='ECM_COATING != null'> , ECM_COATING = #{ECM_COATING} </if>",
        "    <if test='DISSOCIATION_REAGENT != null'> , DISSOCIATION_REAGENT = #{DISSOCIATION_REAGENT} </if>",
        "    <if test='PRE_CULTURE_VESSEL != null'> , PRE_CULTURE_VESSEL = #{PRE_CULTURE_VESSEL} </if>",
        "    <if test='PRE_CULTURE_MATERIAL_NAME != null'> , PRE_CULTURE_MATERIAL_NAME = #{PRE_CULTURE_MATERIAL_NAME} </if>",
        "    <if test='PRE_CULTURE_VOLUME != null'> , PRE_CULTURE_VOLUME = #{PRE_CULTURE_VOLUME} </if>",
        "    <if test='PRE_CULTURE_INCUBATION_TIME != null'> , PRE_CULTURE_INCUBATION_TIME = #{PRE_CULTURE_INCUBATION_TIME} </if>",
        "    <if test='ICP1_VESSEL != null'> , ICP1_VESSEL = #{ICP1_VESSEL} </if>",
        "    <if test='ICP1_MATERIAL_NAME != null'> , ICP1_MATERIAL_NAME = #{ICP1_MATERIAL_NAME} </if>",
        "    <if test='ICP1_VOLUME != null'> , ICP1_VOLUME = #{ICP1_VOLUME} </if>",
        "    <if test='ICP1_INCUBATION_TIME != null'> , ICP1_INCUBATION_TIME = #{ICP1_INCUBATION_TIME} </if>",
        "    <if test='ICP2_VESSEL != null'> , ICP2_VESSEL = #{ICP2_VESSEL} </if>",
        "    <if test='ICP2_MATERIAL_NAME != null'> , ICP2_MATERIAL_NAME = #{ICP2_MATERIAL_NAME} </if>",
        "    <if test='ICP2_VOLUME != null'> , ICP2_VOLUME = #{ICP2_VOLUME} </if>",
        "    <if test='ICP2_INCUBATION_TIME != null'> , ICP2_INCUBATION_TIME = #{ICP2_INCUBATION_TIME} </if>",
        "    <if test='ICP3_VESSEL != null'> , ICP3_VESSEL = #{ICP3_VESSEL} </if>",
        "    <if test='ICP3_MATERIAL_NAME != null'> , ICP3_MATERIAL_NAME = #{ICP3_MATERIAL_NAME} </if>",
        "    <if test='ICP3_VOLUME != null'> , ICP3_VOLUME = #{ICP3_VOLUME} </if>",
        "    <if test='ICP3_INCUBATION_TIME != null'> , ICP3_INCUBATION_TIME = #{ICP3_INCUBATION_TIME} </if>",
        "    <if test='MATERIAL_GORUP_ID != null'> , MATERIAL_GORUP_ID = #{MATERIAL_GORUP_ID} </if>",
        "    <if test='PROTOCOL != null'> , PROTOCOL = #{PROTOCOL} </if>",
        "    <if test='BP_ALERM != null'> , BP_ALERM = #{BP_ALERM} </if>",
        "    <if test='BP_WARNING != null'> , BP_WARNING = #{BP_WARNING} </if>",
        "    <if test='BP_HEADER != null'> , BP_HEADER = #{BP_HEADER} </if>",
        "    <if test='BP_PH_OVER_TIME != null'> , BP_PH_OVER_TIME = #{BP_PH_OVER_TIME} </if>",
        "    <if test='BP_GLUCOSE_OVER_TIME != null'> , BP_GLUCOSE_OVER_TIME = #{BP_GLUCOSE_OVER_TIME} </if>",
        "    <if test='BP_LACTATE_OVER_TIME != null'> , BP_LACTATE_OVER_TIME = #{BP_LACTATE_OVER_TIME} </if>",
        "    <if test='BP_GROWTH_RATE_OVER_TIME != null'> , BP_GROWTH_RATE_OVER_TIME = #{BP_GROWTH_RATE_OVER_TIME} </if>",
        "    <if test='BP_CAMERA_VISION != null'> , BP_CAMERA_VISION = #{BP_CAMERA_VISION} </if>",
        "    <if test='BP_ORVER_VIEW != null'> , BP_ORVER_VIEW = #{BP_ORVER_VIEW} </if>",
        "    <if test='BP_IDENTIFICATION != null'> , BP_IDENTIFICATION = #{BP_IDENTIFICATION} </if>",
        "    <if test='BP_CULTURE_CONDITION != null'> , BP_CULTURE_CONDITION = #{BP_CULTURE_CONDITION} </if>",
        "    <if test='BP_DETAIL != null'> , BP_DETAIL = #{BP_DETAIL} </if>",
        "    <if test='BP_YOBI1 != null'> , BP_YOBI1 = #{BP_YOBI1} </if>",
        "    <if test='BP_YOBI2 != null'> , BP_YOBI2 = #{BP_YOBI2} </if>",
        "    <if test='BP_YOBI3 != null'> , BP_YOBI3 = #{BP_YOBI3} </if>",
        "    <if test='POB_ICP != null'> , POB_ICP = #{POB_ICP} </if>",
        "    <if test='POB_ICP_SUMMARY != null'> , POB_ICP_SUMMARY = #{POB_ICP_SUMMARY} </if>",
        "    <if test='POB_ICP_MICROBIOLOGICAL_STERILITY != null'> , POB_ICP_MICROBIOLOGICAL_STERILITY = #{POB_ICP_MICROBIOLOGICAL_STERILITY} </if>",
        "    <if test='POB_ICP_KARYOTYPE_RESULTS != null'> , POB_ICP_KARYOTYPE_RESULTS = #{POB_ICP_KARYOTYPE_RESULTS} </if>",
        "    <if test='POB_ICP_PTENCY != null'> , POB_ICP_PTENCY = #{POB_ICP_PTENCY} </if>",
        "    <if test='POB_ICP_MATERIAL_OVERVIEW != null'> , POB_ICP_MATERIAL_OVERVIEW = #{POB_ICP_MATERIAL_OVERVIEW} </if>",
        "    <if test='POB_ICP_MATERIAL_IDENTIFICATION != null'> , POB_ICP_MATERIAL_IDENTIFICATION = #{POB_ICP_MATERIAL_IDENTIFICATION} </if>",
        "    <if test='POB_ELECTRONIC_BATCH_RECORD != null'> , POB_ELECTRONIC_BATCH_RECORD = #{POB_ELECTRONIC_BATCH_RECORD} </if>",
        "    <if test='POB_CELL_GROWTH_VIDEO != null'> , POB_CELL_GROWTH_VIDEO = #{POB_CELL_GROWTH_VIDEO} </if>",
        "    <if test='POB_ICP_CULTURE_CONDITION != null'> , POB_ICP_CULTURE_CONDITION = #{POB_ICP_CULTURE_CONDITION} </if>",
        "    <if test='POB_YOBI1 != null'> , POB_YOBI1 = #{POB_YOBI1} </if>",
        "    <if test='POB_YOBI2 != null'> , POB_YOBI2 = #{POB_YOBI2} </if>",
        "    <if test='POB_YOBI3 != null'> , POB_YOBI3 = #{POB_YOBI3} </if>",
        "    <if test='PRB_ICP_MATERIAL_OVERVIEW != null'> , PRB_ICP_MATERIAL_OVERVIEW = #{PRB_ICP_MATERIAL_OVERVIEW} </if>",
        "    <if test='PRB_ICP_MATERIAL_IDENTIFICATION != null'> , PRB_ICP_MATERIAL_IDENTIFICATION = #{PRB_ICP_MATERIAL_IDENTIFICATION} </if>",
        "    <if test='PRB_ICP_CULTURE_CONDITION != null'> , PRB_ICP_CULTURE_CONDITION = #{PRB_ICP_CULTURE_CONDITION} </if>",
        "    <if test='PRB_ICP_ALERM_WARNINGS != null'> , PRB_ICP_ALERM_WARNINGS = #{PRB_ICP_ALERM_WARNINGS} </if>",
        "    <if test='PRB_YOBI1 != null'> , PRB_YOBI1 = #{PRB_YOBI1} </if>",
        "    <if test='PRB_YOBI2 != null'> , PRB_YOBI2 = #{PRB_YOBI2} </if>",
        "    <if test='PRB_YOBI3 != null'> , PRB_YOBI3 = #{PRB_YOBI3} </if>",
        "  </set>",
        "  WHERE ",
        "       IM_ID = #{IM_ID}",
        "</script>",
    })
    int update(INSTRUCTIONS_MASTER model);
    
    @Delete("DELETE FROM INSTRUCTIONS_MASTER "
         +" WHERE "
            + "     IM_ID = #{IM_ID} "
         )
    int delete(INSTRUCTIONS_MASTER model);

    @Select({
     "<script>",
        "SELECT * FROM INSTRUCTIONS_MASTER ",
        "  <where>",
        "    <if test='IM_ID != &quot;&quot; and IM_ID != null'>",
        "      AND IM_ID = #{IM_ID}",
        "    </if>",
        "    <if test='NAME != &quot;&quot; and NAME != null'>",
        "      AND NAME = #{NAME}",
        "    </if>",
        "    <if test='MATERIAL_GORUP_ID != &quot;&quot; and MATERIAL_GORUP_ID != null'>",
        "      AND MATERIAL_GORUP_ID = #{MATERIAL_GORUP_ID}",
        "    </if>",
        "  </where>",
        "</script>",
    })
    List<INSTRUCTIONS_MASTER> select(INSTRUCTIONS_MASTER model);
    
}
